package controller.used;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.swing.text.View;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import common.Paging;
import common.ViewPath;
import service.member.BankService;
import service.member.MannersService;
import service.member.MemberService;
import service.used.U_CateService;
import service.used.U_ImgService;
import service.used.UsedService;
import vo.addr.Addr1VO;
import vo.addr.Addr2VO;
import vo.member.Bank_AccountVO;
import vo.member.Key_SearchlistVO;
import vo.member.Manners_ListVO;
import vo.member.MemberVO;
import vo.used.Cate_CheckVO;
import vo.used.U_CateVO;
import vo.used.U_ChatVO;
import vo.used.U_FavVO;
import vo.used.U_ImgVO;
import vo.used.U_TradelistVO;
import vo.used.UsedVO;

@Controller
public class UsedController {
	
	private UsedService usedService;
	private U_CateService u_cateService;
	private MemberService memberService;
	private MannersService mannersService;
	private U_ImgService u_imgService;
	private BankService bankService;
	
	@Autowired
	private ServletContext application;
	
	public UsedController(UsedService usedService, MemberService memberService, 
			MannersService mannersService, U_CateService u_cateService,
			U_ImgService u_imgService, BankService bankService) {
		this.usedService = usedService;
		this.memberService = memberService;
		this.mannersService = mannersService;
		this.u_cateService = u_cateService;
		this.bankService = bankService;
		this.u_imgService = u_imgService;
	}
	
	@RequestMapping("/used")
	public String used(Model model, Integer page, HttpSession session,
			Integer addr1_no, Integer addr2_no) {
		if(page == null) {
			page = 1;
		}

		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Addr1VO> a1List = usedService.selectAddr1();
		
		if(a1List.isEmpty()) a1List = null;
		List<Addr2VO> a2List = null;
		
		if(addr1_no != null) {
			a2List = usedService.selectAddr2(addr1_no);
			
			if(a2List.isEmpty()) a2List = null;
			map.put("addr1", addr1_no);
			
			if (addr2_no != null) {
				map.put("addr2", addr2_no);
			}
		}
		
		int boardCount = usedService.someCount(map);
		if(addr1_no == null && addr2_no == null) {
			boardCount = usedService.allCount();
		}
		
		Paging paging = new Paging(page, boardCount);
		
		map.put("first", paging.getFirst());
		map.put("last", paging.getLast());
		
		List<UsedVO> list = null;
		list = usedService.selectList(map);
		if(list.isEmpty()) {
			list = null;
		}else {
			for(UsedVO vo : list) {
				String originalTitle=vo.getU_title();
				if(originalTitle.length() > 15) {
					String shortTitle = originalTitle.substring(0, 15) + " ... ";
					vo.setU_title(shortTitle );
				}
			}
		}
		
		model.addAttribute("list", list);
		model.addAttribute("url", "/used");	//페이지 이동을 위한 경로 설정용
		model.addAttribute("paging", paging);
		model.addAttribute("a1List", a1List);
		model.addAttribute("a2List", a2List);
		
		return ViewPath.USED + "list.jsp";
	}
	
	@RequestMapping("/used/{u_cate_seq}")
	public String usedCate(Model model, @PathVariable("u_cate_seq")int u_cate_seq , 
			Integer page, HttpSession session,
			Integer addr1_no, Integer addr2_no) {
		
		List<UsedVO> list = null;
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(u_cate_seq == 0) {	//인기 게시물 처리
			list = usedService.topSelect();
		}else {	// 나머지 카테고리 seq별 처리
			if(page == null) {
				page = 1;
			}
			
			map.put("type", "u.u_cate_seq");
			map.put("word", u_cate_seq);
			
			List<Addr1VO> a1List = usedService.selectAddr1();
			if(a1List.isEmpty()) a1List = null;
			
			List<Addr2VO> a2List = null;
			if(addr1_no != null) {
				a2List = usedService.selectAddr2(addr1_no);
				
				if(a2List.isEmpty()) a2List = null;
				map.put("addr1", addr1_no);
				
				if (addr2_no != null) {
					map.put("addr2", addr2_no);
				}
			}
			model.addAttribute("a1List", a1List);
			model.addAttribute("a2List", a2List);
			
			int boardCount = usedService.someCount(map);
			
			Paging paging = new Paging(page, boardCount);
			
			map.put("first", paging.getFirst());
			map.put("last", paging.getLast());
			
			list = usedService.selectList(map);
			
			model.addAttribute("paging", paging);
		}

		if(list.isEmpty()) {
			list = null;
		}else {
			for(UsedVO vo : list) {
				String originalTitle=vo.getU_title();
				if(originalTitle.length() > 15) {
					String shortTitle = originalTitle.substring(0, 15) + " ... ";
					vo.setU_title(shortTitle );
				}
			}
		}
		
		model.addAttribute("u_cate_seq", u_cate_seq);
		model.addAttribute("list",list);
		model.addAttribute("url","/used/"+u_cate_seq);

		return ViewPath.USED + "list.jsp";
	}
	
	@RequestMapping("/used/insertform")
	public String insertForm(Model model) {
		
		List<U_CateVO> clist = u_cateService.cateList();
		List<Cate_CheckVO> subList = u_cateService.subCate();
		
		model.addAttribute("clist", clist);
		model.addAttribute("subList", subList);
		
		return ViewPath.USED + "insertForm.jsp";
	}
	
	@RequestMapping("/used/insert")
	public String insert(Model model, UsedVO vo, HttpSession session) {
		Integer m_seq = (Integer) session.getAttribute("login");
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}
		
		vo.setM_seq(m_seq);
		vo.setU_content(vo.getU_content().replaceAll("\r\n", "<br>"));
		if(vo.getU_price()==0) vo.setU_share(1);
				
		// 작성 글 먼저 넣기
		int su = usedService.insert(vo);
		vo.setU_seq(usedService.maxSeq());

		if(su!= 0) {
			// 파일 명 받아오기
			List<String> filelist = this.insertPhoto(vo);
			U_ImgVO ivo = new U_ImgVO();
			// 파일 선택 했으면 img 데이터에 넣어주기
			if(filelist != null) {
				for(int i=0; i<filelist.size(); i++) {
				
				// 파일명이랑 위에 글 넣은 시퀀스 받아와서 넣어주기
				ivo.setU_img_name(filelist.get(i));
				ivo.setU_seq(usedService.maxSeq());
				su = u_imgService.insertPhoto(ivo);
				}
			}
		}
		model.addAttribute("su", su);
		model.addAttribute("msg", "중고거래 게시물 등록");
		model.addAttribute("url", "/used");
		return ViewPath.RESULT + "result.jsp";
	}
	
	// 파일 폴더에 저장하고 파일명 _1 식으로 해서 불러오기
	public List<String> insertPhoto(UsedVO vo) {
		String savePath=application.getRealPath("/resources/used/"+vo.getU_seq());
		List<String> filelist = new ArrayList<String>();
		
		MultipartFile[] photos = vo.getPhotos();
		for(int i=0; i<photos.length; i++) {
			MultipartFile photo = photos[i];
			
			if(!photo.getOriginalFilename().equals("")) {
				if(photo != null & !photo.isEmpty()) {
					String filename = photo.getOriginalFilename();
					File saveFile = new File(savePath, filename);
					
					if(!saveFile.exists()) {
						saveFile.mkdirs();
					}else {
						String firstName = filename.substring(0, filename.lastIndexOf("."));
						String extension = filename.substring(filename.lastIndexOf("."));
						int count = 1;
						
						while(saveFile.exists()) {
							filename = String.format("%s%d%s", firstName+"_", count, extension);
							saveFile = new File(savePath, filename);
							count++;
						}
					}
					
					try {
						photo.transferTo(saveFile);
					} catch (IllegalStateException | IOException e) {
						e.printStackTrace();
					}
					filelist.add(filename);
				}
			}
		}
		if(filelist.isEmpty()) filelist=null;
		return filelist;
	}
	
	@RequestMapping("/used/content")
	public String content(@RequestParam("u_seq")int u_seq, Model model, HttpSession session, String mode){
		Integer m_seq = (Integer)session.getAttribute("login");
		
		if(m_seq != null) {
			U_FavVO vo = new U_FavVO();
			vo.setM_seq(m_seq);
			vo.setU_seq(u_seq);
			
			boolean check = usedService.checkFav(vo);
			boolean checkBoost = usedService.checkBoost(u_seq);
			
			model.addAttribute("check", check);
			model.addAttribute("checkBoost", checkBoost);
		}
		
		// 게시물 클릭해서 들어가면 hit 증가(수정 후에는 after 붙일 예정)
		if(mode==null) {
			usedService.plusHit(u_seq);
		}
		
		UsedVO vo = usedService.selectOne(u_seq);
		
		int favCount = usedService.favCount(u_seq);
		int chat = usedService.oneCount(u_seq);
		
		List<String> filelist = u_imgService.selectPhotos(u_seq);
		if(filelist.isEmpty()) filelist = null;
		
		List<UsedVO> ulist = usedService.selectMine(vo.getM_seq());
		if(ulist.isEmpty()) ulist = null;		
		
		model.addAttribute("flist", filelist);
		model.addAttribute("vo",vo);
		model.addAttribute("favCount", favCount);
		model.addAttribute("ulist", ulist);
		model.addAttribute("chat", chat);
		
		return ViewPath.USED + "content.jsp";
	}
	
	@RequestMapping("/used/updateform")
	public String updateForm(int u_seq, Model model) {
		UsedVO uvo = usedService.getOne(u_seq);
		uvo.setU_content(uvo.getU_content().replaceAll("<br>", "\r\n"));
		uvo.setU_content(uvo.getU_content().replaceAll("<p>", ""));
		uvo.setU_content(uvo.getU_content().replaceAll("</p>", ""));
		
		List<String> flist = u_imgService.selectPhotos(u_seq);
		int size = flist.size();
		if(flist.isEmpty()) {
			flist = null;
			size=0;
		}
		
		List<U_CateVO> clist = u_cateService.cateList();
		List<Cate_CheckVO> subList = u_cateService.subCate();
		model.addAttribute("uvo", uvo);
		model.addAttribute("flist", flist);
		model.addAttribute("clist", clist);
		model.addAttribute("subList", subList);
		model.addAttribute("size", size);
		model.addAttribute("u_seq", u_seq);
		return ViewPath.USED + "updateForm.jsp";
	}
	
	@RequestMapping(value="/used/photo/del")
	@ResponseBody
	public boolean imgDelete(String u_img_name) {
		
		boolean check  = u_imgService.imgDelete(u_img_name);
		return check;
	}
	
	@RequestMapping("/used/update")
	public String update(UsedVO vo, Model model, @RequestParam("u_seq")int u_seq) {
		UsedVO ovo = usedService.getOne(u_seq);
		
		if(vo.getU_price()==0) vo.setU_share(1);
		
		ovo.setU_title(vo.getU_title());
		ovo.setU_price(vo.getU_price());
		ovo.setU_cate_seq(vo.getU_cate_seq());
		ovo.setCate_check_name(vo.getCate_check_name());
		ovo.setCate_input(vo.getCate_input());
		ovo.setU_content(vo.getU_content().replaceAll("\r\n", "<br>"));
		ovo.setU_share(vo.getU_share());
		ovo.setU_addr_main(vo.getU_addr_main());
		ovo.setU_addr_sub(vo.getU_addr_sub());
		
		int su = usedService.update(ovo);
		
		if(su!= 0) {
			// 파일 명 받아오기
			List<String> filelist = this.insertPhoto(vo);
			U_ImgVO ivo = new U_ImgVO();
			// 파일 선택 했으면 img 데이터에 넣어주기
			if(filelist != null) {
				for(int i=0; i<filelist.size(); i++) {
				
				// 파일명이랑 위에 글 넣은 시퀀스 받아와서 넣어주기
				ivo.setU_img_name(filelist.get(i));
				ivo.setU_seq(u_seq);
				su = u_imgService.insertPhoto(ivo);
				}
			}
		}
		model.addAttribute("su", su);
		model.addAttribute("msg", "중고거래 게시물 수정");
		model.addAttribute("url", "/used/content?u_seq="+u_seq+"&mode=after");
		return ViewPath.RESULT + "result.jsp";
	}
	
	@RequestMapping(value="/used/fav/add")
	@ResponseBody
	public boolean addFav(int u_seq, HttpSession session) {
		Integer m_seq = (Integer)session.getAttribute("login");
		U_FavVO vo = new U_FavVO();
		vo.setM_seq(m_seq);
		vo.setU_seq(u_seq);
		boolean check  = usedService.addFav(vo);
		return check;
	}
	
	@RequestMapping(value="/used/fav/del")
	@ResponseBody
	public boolean delFav(int u_seq, HttpSession session) {
		Integer m_seq = (Integer)session.getAttribute("login");
		U_FavVO vo = new U_FavVO();
		vo.setM_seq(m_seq);
		vo.setU_seq(u_seq);
		boolean check  = usedService.delFav(vo);
		return check;
	}
	
	@RequestMapping(value="/used/sell")
	@ResponseBody
	public boolean delFav(int u_seq) {
		boolean check = usedService.sell(u_seq);
		return check;
	}
	
	@RequestMapping(value="/used/delete/{u_seq}")
	public String delete(@PathVariable("u_seq")int u_seq, Model model) {
		int su = usedService.delete(u_seq);
		
		model.addAttribute("su", su);
		model.addAttribute("msg", "중고 게시물 삭제");
		model.addAttribute("url", "/used");
		return ViewPath.RESULT + "result.jsp";
	}
	
	@RequestMapping(value="/used/checksell")
	@ResponseBody
	public boolean checkSell(int u_seq) {
		boolean check = usedService.checkSell(u_seq);
		return check;
	}
	
	@RequestMapping(value="/used/fav/count")
	@ResponseBody
	public int favCount(int u_seq) {
		int cnt = usedService.favCount(u_seq);
		return cnt;
	}
	
	@RequestMapping(value="/used/boost/check")
	@ResponseBody
	public boolean checkBoost(int u_seq) {
		boolean check = usedService.checkBoost(u_seq);
		return check;
	}
	
	@RequestMapping(value="/used/boost")
	@ResponseBody
	public boolean boost(int u_seq) {
		boolean check = usedService.boost(u_seq);
		return check;
	}
	
	@RequestMapping("/used/keyranking")
	public String keyRanking(Model model) {
	  List<String> list = memberService.keyRanking();
	  if(list.isEmpty()) list = null;
	  
	  model.addAttribute("list", list);
	  return ViewPath.USED + "keyRanking.jsp";
	}
	 
	
	@RequestMapping("/used/search")
	public String findKey(String which, String word, Model model, HttpSession session, Integer page) {
		Integer m_seq = (Integer) session.getAttribute("login");
		
//		if(m_seq == null) {
//			m_seq = 0;
//		}
		
		if(which.equals("key")) {
			Key_SearchlistVO vo = new Key_SearchlistVO();
			if(m_seq != null) {
				vo.setM_seq(m_seq);
			}
			
//			if (!word.endsWith("!")) {
				vo.setKey_name(word);
				// 내가 기존에 검색한 적 없으면 테이블 등록! 
//				if (memberService.sameKey(vo)==0) {
					memberService.keyInsert(vo);
//				}else {
					// 검색한 적 있으면 검색일자만 변경!
//					memberService.keyDate(vo);
//				}
//			}else {
//				word = word.substring(0, word.length()-1);
//			}
		}
		
		if(page == null) {
			page = 1;
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		if(which.equals("key")) {
			map.put("type", "key");
		}else {
			map.put("type", "addr");
		}
		map.put("word", word);
		
		int boardCount = usedService.someCount(map);
		
		Paging paging = new Paging(page, boardCount);
		
		map.put("first", paging.getFirst());
		map.put("last", paging.getLast());

		
		List<UsedVO> list = usedService.selectList(map);
		if(list.isEmpty()) {
			list = null;
		}else {
			for(UsedVO vo : list) {
				String originalTitle=vo.getU_title();
				if(originalTitle.length() > 15) {
					String shortTitle = originalTitle.substring(0, 15) + " ... ";
					vo.setU_title(shortTitle );
				}
			}
		}
		
		model.addAttribute("which", which);
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
		model.addAttribute("word", word);
		model.addAttribute("url", "/used/search?which="+which+"&word="+word);
		
		return ViewPath.USED + "listAlpha.jsp";
	}
	
	@RequestMapping("/chat/{u_seq}")
	public String chat(@PathVariable("u_seq")int u_seq, Model model, HttpSession session, Integer m_seq) {
		UsedVO vo = usedService.selectOnly(u_seq);
		
		Integer my_seq = (Integer) session.getAttribute("login");
		
		if(vo.getU_trade_status()==1) {
			int buyer = usedService.whoBuy(u_seq);
			model.addAttribute("buyer", buyer);
		}

		List<Manners_ListVO> glist = null;
		List<Manners_ListVO> rlist = null;
		
		Manners_ListVO mvo = new Manners_ListVO();
		mvo.setU_seq(u_seq);
		
		if(m_seq==my_seq) {	// 내가 구매자인 경우
			int reserve = usedService.myReserve(new U_TradelistVO(m_seq, u_seq));
			
			mvo.setGive_seq(m_seq);
			mvo.setReceive_seq(m_seq);
			
			model.addAttribute("reserve", reserve);
			model.addAttribute("nickname", vo.getM_nickname());
		}else {
			mvo.setGive_seq(vo.getM_seq());
			mvo.setReceive_seq(vo.getM_seq());
		}
		int use = bankService.payUse(new Bank_AccountVO(m_seq, vo.getM_seq()));

		glist = mannersService.mannersGive(mvo);
		rlist = mannersService.mannersReceive(mvo);
		
		List<U_ChatVO> list = usedService.oneChat(new U_ChatVO(u_seq, m_seq));
		
		if(rlist.isEmpty()) rlist=null;
		if(glist.isEmpty()) glist = null;
		
		model.addAttribute("list", list);
		model.addAttribute("glist", glist);
		model.addAttribute("rlist", rlist);
		model.addAttribute("vo", vo);
		model.addAttribute("m_seq", m_seq);
		model.addAttribute("use", use);
		
		return ViewPath.USED + "chat.jsp";
	}
	
	@RequestMapping("/chat/insert/{chat_who}")
	public String chatInsert(U_ChatVO vo, @PathVariable("chat_who")int chat_who, HttpSession session) {
		vo.setChat_content(vo.getChat_content().replaceAll("\r\n", "<br>"));
		vo.setChat_who(chat_who);
		usedService.chatInsert(vo);
		
		return "redirect:/chat/"+vo.getU_seq() + "?m_seq=" + vo.getM_seq();
	}
	
	@RequestMapping("/chatList/{u_seq}")
	public String chatList(@PathVariable("u_seq")int u_seq, Model model) {
		List<MemberVO> list = memberService.sellerChatList(u_seq);
		
		if(list.isEmpty()) {
			list = null;
		}else {
			for(MemberVO vo : list) {
				String originalContent = vo.getChat_content().replaceAll("<br>",  "  ");;
				if(originalContent.length() > 40) {
					String shortContent = originalContent.substring(0, 40) + " ... ";
					vo.setChat_content(shortContent);
				}
			}
		}
		
		model.addAttribute("u_seq", u_seq);
		model.addAttribute("list", list);
		return ViewPath.USED + "chatList.jsp";
	}
	
	@RequestMapping("/chatList")
	public String myChat(Model model, HttpSession session) {
		Integer seq = (Integer) session.getAttribute("login");
		if(seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}
		
		List<MemberVO> list = memberService.buyerChatList(seq);
		if(list.isEmpty()) {
			list = null;
		}else {
			for(MemberVO vo : list) {
				String originalContent = vo.getChat_content().replaceAll("<br>",  "  ");
				if(originalContent.length() > 40) {
					String shortContent = originalContent.substring(0, 40) + " ... ";
					vo.setChat_content(shortContent);
				}
			}
		}
		
		model.addAttribute("list", list);
		model.addAttribute("seq", seq);
		return ViewPath.USED + "myChat.jsp";
	} 
	
	@RequestMapping("/used/trade")
	public String trade(int u_seq, int m_seq, HttpSession session, Model model) {
		Integer seller_seq = (Integer)session.getAttribute("login");
		if(seller_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}
		
		U_TradelistVO vo = new U_TradelistVO();
		vo.setBuyer_seq(m_seq);
		vo.setSeller_seq(seller_seq);
		vo.setU_seq(u_seq);
		vo.setFinish_status(1);
		vo.setTrade_type(0);
		
		int su = usedService.tradeInsert(vo);
		
		if(su != 0) {
			usedService.sell(u_seq);
			U_ChatVO cvo = new U_ChatVO();
			cvo.setM_seq(m_seq);
			cvo.setU_seq(u_seq);
			cvo.setChat_content("<b>거래가 완료되었습니다.<b><br>*서로 거래 후기(매너평가)를 남길 수 있습니다.");
			cvo.setChat_who(2);
			cvo.setSeller_seq(seller_seq);
			usedService.chatInsert(cvo);
		}
		
		model.addAttribute("su", su);
		model.addAttribute("msg", "중고거래");
		model.addAttribute("url", "/chat/"+vo.getU_seq() + "?m_seq=" + m_seq);
		
		return ViewPath.RESULT + "result.jsp";
	}
	
	@RequestMapping("/used/notrade")
	public String noTrade(int u_seq, int m_seq, HttpSession session, Model model) {
		Integer seller_seq = (Integer)session.getAttribute("login");
		if(seller_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}
		
		U_TradelistVO vo = new U_TradelistVO();
		vo.setBuyer_seq(m_seq);
		vo.setSeller_seq(seller_seq);
		vo.setU_seq(u_seq);
		vo.setFinish_status(0);
		vo.setTrade_type(1);
		
		int su = usedService.tradeInsert(vo);
		
		if(su != 0) {
			usedService.reserve(u_seq);
			U_ChatVO cvo = new U_ChatVO();
			cvo.setM_seq(m_seq);
			cvo.setU_seq(u_seq);
			cvo.setChat_content("<b>자두페이 거래 예약이 되었습니다.<br>거래를 원할 경우 <자두페이 결제>를 클릭하세요."
					+ "<b><br>*자두페이 결제를 원치 않을 경우 판매자와의 채팅을 통해 거래를 완료하시기 바랍니다.");
			cvo.setChat_who(2);
			cvo.setSeller_seq(seller_seq);
			usedService.chatInsert(cvo);
		}
		
		model.addAttribute("su", su);
		model.addAttribute("msg", "거래 예약");
		model.addAttribute("url", "/chat/"+vo.getU_seq() + "?m_seq=" + m_seq);
		
		return ViewPath.RESULT + "result.jsp";
	}
	
	@RequestMapping("/chat/pay")
	public String chatPay(int m_seq, int u_seq, Model model) {
		UsedVO vo = usedService.selectOnly(u_seq);
		
		String msg="";
		String url="";
		
		int price = vo.getU_price();
		int point = bankService.myPoint(m_seq);
		
		if(price > point) {
			msg="잔액이 부족합니다. 충전 페이지로 이동합니다.";
			url="/pay/chargeform";
		}else {
			Bank_AccountVO bvo = new Bank_AccountVO();
			bvo.setBank_point(point-price);
			bvo.setM_seq(m_seq);
			int su = bankService.paySome(bvo);
			
			if(su!=0) {
				bvo.setM_seq(vo.getM_seq());
				bvo.setBank_point(price);
				bankService.sellSome(bvo);
				
				usedService.sell(u_seq);
				usedService.sellFinish(u_seq);
				
				U_ChatVO cvo = new U_ChatVO();
				cvo.setM_seq(m_seq);
				cvo.setU_seq(u_seq);
				cvo.setChat_content("<b>자두페이 거래가 완료되었습니다.<b><br>*서로 거래 후기(매너평가)를 남길 수 있습니다.");
				cvo.setChat_who(2);
				cvo.setSeller_seq(vo.getM_seq());
				usedService.chatInsert(cvo);
				
				msg="거래가 완료되었습니다. 판매자에게 후기를 남길 수 있습니다.";
				url="/chat/"+u_seq+"?m_seq="+m_seq;
			}else {
				msg="송금 과정에 오류가 발생했습니다. 다시 시도해주시기 바랍니다.";
				url="/chat/"+u_seq+"?m_seq="+m_seq;
			}
		}

		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		return ViewPath.RESULT + "msgResult.jsp";
	}
	
	@RequestMapping("/chat/pay/noreserve")
	public String noReserve(int m_seq, int u_seq, Model model) {
		usedService.tradeDelete(u_seq);
		usedService.noSell(u_seq);
		
		U_ChatVO cvo = new U_ChatVO();
		cvo.setM_seq(m_seq);
		cvo.setU_seq(u_seq);
		cvo.setChat_content("<b>예약 취소되었습니다.<br>자세한 사항은 판매자를 통해 문의하세요.<b>");
		cvo.setChat_who(2);
		cvo.setSeller_seq(usedService.selectOnly(u_seq).getM_seq());
		usedService.chatInsert(cvo);
		
		return "redirect:/chat/"+u_seq + "?m_seq=" + m_seq;
	}
	
	@RequestMapping("/trade/delete")
	public String tradeDelete(int buyer, int u_seq, Model model) {
		int tradeType=usedService.tradeType(u_seq);
		UsedVO vo = usedService.selectOne(u_seq);
		int seller = vo.getM_seq();
		
		String msg="";
		String url="";
		
		if(tradeType==1) {
			int price = vo.getU_price();
			int point = bankService.myPoint(seller);	//판매자가 돌려줘야 함
			
			if(price > point) {
				msg = "잔액이 부족합니다. 충전 후 진행하세요.";
				url = "/pay/chargeform";
			}else {
				Bank_AccountVO bvo = new Bank_AccountVO();
				bvo.setBank_point(point-price);
				bvo.setM_seq(seller);
				int su = bankService.paySome(bvo);
				
				if(su!=0) {
					bvo.setM_seq(buyer);
					bvo.setBank_point(price);
					bankService.sellSome(bvo);
					usedService.tradeDelete(u_seq);
					usedService.noSell(u_seq);
					mannersService.deleteAll(u_seq);
					
					U_ChatVO cvo = new U_ChatVO();
					cvo.setM_seq(buyer);
					cvo.setU_seq(u_seq);
					cvo.setChat_content("<b>거래가 취소되었습니다.<b><br>");
					cvo.setChat_who(2);
					cvo.setSeller_seq(vo.getM_seq());
					usedService.chatInsert(cvo);
					
					msg="거래 취소가 완료되었습니다.";
				}else {
					msg="환불 과정에 오류가 발생했습니다. 다시 시도해주세요.";
				}
				url="/chat/"+u_seq+"?m_seq="+buyer;
			}
		}else {
			usedService.tradeDelete(u_seq);
			usedService.noSell(u_seq);
			mannersService.deleteAll(u_seq);
			
			U_ChatVO cvo = new U_ChatVO();
			cvo.setM_seq(buyer);
			cvo.setU_seq(u_seq);
			cvo.setChat_content("<b>거래가 취소되었습니다.<b><br>");
			cvo.setChat_who(2);
			cvo.setSeller_seq(vo.getM_seq());
			usedService.chatInsert(cvo);
			
			msg="거래 취소가 완료되었습니다.";
			url="/chat/"+u_seq+"?m_seq="+buyer;
		}
		
		mannersService.degreeUpdate(seller);
		mannersService.degreeUpdate(buyer);

		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		return ViewPath.RESULT + "msgResult.jsp";
	}
	
}
