package controller.member;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import service.member.MannersService;
import service.member.MemberService;
import service.used.UsedService;
import vo.addr.Addr3VO;
import vo.member.BlockVO;
import vo.member.CollectionVO;
import vo.member.MannersVO;
import vo.member.Manners_DefaultVO;
import vo.member.Manners_DegreeVO;
import vo.member.Manners_ListVO;
import vo.member.MemberVO;
import vo.used.UsedVO;

@Controller
public class MemberController {

	private MemberService memberService;
	private UsedService usedService;
	private MannersService mannersService;

	@Autowired
	private ServletContext application;

	public MemberController(MannersService mannersService, MemberService memberService, UsedService usedService) {
		this.memberService = memberService;
		this.usedService = usedService;
		this.mannersService = mannersService;
	}

	// 새미
	@RequestMapping("member/insertform")
	public String insertForm(HttpSession session) {
		session.setAttribute("retrunPage", "memberInsertForm");
		return ViewPath.MEMBER + "insertform.jsp";
	}

	@RequestMapping("member/insertCheckPohto")
	public String insertCheckPhoto(HttpServletRequest request, MemberVO mvo, Model model) {

		String savePath = application.getRealPath("/resources/member/");

		String m_img = null;
		MultipartFile photo = mvo.getPhoto();

		if (photo != null && !photo.isEmpty()) {
			m_img = photo.getOriginalFilename();// 업로드된 파일명(실제 파일명)

			// file객체 생성
			File saveFile = new File(savePath, m_img);
			if (!saveFile.exists()) {
				saveFile.mkdirs();
			} else {// 파일이 존재하면
				long time = System.currentTimeMillis();

				m_img = String.format("%s%d%s", m_img.substring(0, m_img.lastIndexOf(".")), time,
						m_img.substring(m_img.lastIndexOf(".")));

				saveFile = new File(savePath, m_img);
			}

			try {
				photo.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mvo.setM_img(m_img);
		} else {
			mvo.setM_img("기본이미지.jpg");
		}

		String addr3_name = request.getParameter("addr3_name");
		int addr3_no = memberService.selectAddr3_No(addr3_name);

		mvo.setAddr3_no(addr3_no);

		int m_seq = memberService.getSeq();
		mvo.setM_seq(m_seq);
		int su = memberService.insertMember(mvo);
		if (su != 0) {
			Manners_DegreeVO mdvo = new Manners_DegreeVO();
			mdvo.setM_seq(m_seq);
			mannersService.InsertDegree(mdvo);
		}

		model.addAttribute("msg", "회원가입");
		model.addAttribute("url", "/login/loginform");
		model.addAttribute("su", su);

		return ViewPath.RESULT + "result.jsp";
	}

	@RequestMapping("member/addr3Search")
	public String searchCheck(@RequestParam("addr3_name") String addr3_name, HttpServletRequest request) {

		List<Addr3VO> addrlist = memberService.searchAddr3(addr3_name);

		request.setAttribute("addrlist", addrlist);
		request.setAttribute("addr3_name", addr3_name);
		return ViewPath.MEMBER + "addrForm.jsp";
	}
	
	@RequestMapping("member/addrCheck")
	public String addrCheck(@RequestParam("addr3_name") String addr3_name, Model model) {

		int addr3_no = memberService.selectAddr3_No(addr3_name);
		Addr3VO advo = memberService.selectAddr(addr3_no);

		model.addAttribute("advo", advo);

		return ViewPath.MEMBER + "insertform.jsp";
	}

//	@RequestMapping("member/updateForm")
//	public String updateForm(Model model, HttpSession session, MemberVO mvo) {
//
//		Integer m_seq = (Integer) session.getAttribute("login");
//		
//		if(m_seq == null) {
//			return ViewPath.RESULT + "goLogin.jsp";
//		}
//
//		session.setAttribute("returnPage", "memberUpdate"); // 리턴페이지 설정
//
//		mvo = memberService.selectOne(m_seq);
//
//		model.addAttribute("mvo", mvo);
//
//		return ViewPath.MEMBER + "updateForm.jsp";
//	}

	@RequestMapping("member/updateCheck")
	public String updateMember(int m_seq, MemberVO mvo, Model model, HttpServletRequest request, HttpSession session) {

		String savePath = application.getRealPath("/resources/member/");

		String m_img = null;
		MultipartFile photo = mvo.getPhoto();

		if (photo != null && !photo.isEmpty()) {
			m_img = photo.getOriginalFilename();// 업로드된 파일명(실제 파일명)

			// file객체 생성
			File saveFile = new File(savePath, m_img);
			if (!saveFile.exists()) {
				saveFile.mkdirs();
			} else {// 파일이 존재하면
				long time = System.currentTimeMillis();

				m_img = String.format("%s%d%s", m_img.substring(0, m_img.lastIndexOf(".")), time,
						m_img.substring(m_img.lastIndexOf(".")));

				saveFile = new File(savePath, m_img);
			}

			try {
				photo.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mvo.setM_img(m_img);
		} else {
			mvo.setM_img(mvo.getM_img());
		}

		mvo.setM_seq(m_seq);

		int su = memberService.Memberupdate(mvo);

		model.addAttribute("msg", "정보 수정");
		model.addAttribute("url", "/member/mypage");
		model.addAttribute("su", su);

		return ViewPath.RESULT + "result.jsp";
	}

	// 당근알바여부 업데이트
	@RequestMapping(value = "/member/checkStatus", produces = "application/text;charset=utf8")
	@ResponseBody
	public String updateJobsStatus(int m_seq, HttpSession session) {

		MemberVO member = memberService.selectOne(m_seq);
		member.setM_seq(m_seq);
		member.setM_jobs_status(1);
		int su = memberService.updateStatus(member);
		
		if (su != 0) {
			return "등록완료";
		} else {
			return "이미 등록된 계정입니다.";
		}
	}

	@RequestMapping("member/jobsStatus")
	public String updateJobsStatus1(int m_seq, HttpSession session, Model model) {
		MemberVO member = memberService.selectOne(m_seq);
		member.setM_seq(m_seq);
		member.setM_jobs_status(1);
		int su = memberService.updateStatus(member);

		model.addAttribute("msg", "자두 알바 계정");
		model.addAttribute("url", "/jobs/mypage?m_seq=" + m_seq);
		model.addAttribute("su", su);

		return ViewPath.RESULT + "result.jsp";
	}

	// 아이디중복체크
	@RequestMapping(value = "/member/checkId", produces = "application/text;charset=utf8")
	@ResponseBody
	public String checkId(String m_id) {
		if (memberService.checkId(m_id)) {
			return "이미 사용중인 ID입니다.";
		} else {
			return "사용 가능한 ID입니다.";
		}
	}

	// 희지
	@RequestMapping("/member/mypage")
	public String mypage(Model model, HttpSession session) {
		Integer m_seq = (Integer) session.getAttribute("login");
		if (m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}
		MemberVO vo = memberService.selectOne(m_seq);

		List<MemberVO> list = memberService.myBlock(m_seq);
		if (list.isEmpty())
			list = null;

		model.addAttribute("list", list);
		model.addAttribute("vo", vo);
		return ViewPath.MEMBER + "mypage.jsp";
	}
	
	@RequestMapping("/member/deleteform")
	public String deleteForm(HttpSession session, Model model) {
		Integer m_seq = (Integer)session.getAttribute("login");
		
		if (m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}
		
		MemberVO vo = memberService.selectOne(m_seq);
		model.addAttribute("nick", vo.getM_nickname());
		
		return ViewPath.MEMBER + "deleteForm.jsp";
	}

	@RequestMapping("/member/delete")
	public String delete(String password, HttpServletRequest request, HttpServletResponse response) {
		Integer m_seq = (Integer)request.getSession().getAttribute("login");
		
		MemberVO vo = new MemberVO();
		vo.setM_seq(m_seq);
		vo.setPassword(password);
		System.out.println("비밀번호?: " + password);
		int su = memberService.pwRight(vo);
		String msg="";
		String url="";
		
		if(su == 0) {
			msg="비밀번호가 일치하지 않습니다.";
			url="/member/deleteform";
		}else {
			su = memberService.delete(m_seq);
			
			if(su!=0) {
				msg="탈퇴에 성공했습니다. 다음에 다시 만나요!";
				url="/";
				
				Cookie[] cks = request.getCookies();
				
				if(cks != null) {
					for(Cookie ck:cks) {
						if(ck.getName().equals("ckid")) {
							if(ck.getValue().equals(m_seq)) {
								ck.setMaxAge(0);
								ck.setPath("/");
								response.addCookie(ck);
								break;
							}
						}
					}
				}
				
				request.getSession().invalidate();
				
			}else {
				url="/member/deleteform";
				msg="탈퇴에 실패했습니다.";
			}
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return ViewPath.RESULT + "msgResult.jsp";
	}
	
	
	@RequestMapping("/seller/page")
	public String mypage(Model model, @RequestParam("seller") int seller, HttpSession session) {
		MemberVO vo = memberService.selectOne(seller);
		Integer m_seq = (Integer) session.getAttribute("login");
		
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}

		List<Manners_DefaultVO> mlist = mannersService.defaultList(new Manners_DefaultVO(m_seq, seller));
		if (mlist.isEmpty())
			mlist = null;

		CollectionVO cvo = new CollectionVO();
		cvo.setM_seq(m_seq);
		cvo.setSeller_seq(seller);
		boolean collection = memberService.checkCollec(cvo);

		BlockVO bvo = new BlockVO();
		bvo.setBuyer_seq(m_seq);
		bvo.setSeller_seq(seller);
		boolean block = memberService.checkBlock(bvo);

		List<UsedVO> ulist = usedService.selectMine(seller);
		if (ulist.isEmpty())
			ulist = null;

		model.addAttribute("collection", collection);
		model.addAttribute("block", block);
		model.addAttribute("vo", vo);
		model.addAttribute("ulist", ulist);
		model.addAttribute("mlist", mlist);

		return ViewPath.MEMBER + "sellerpage.jsp";
	}

	@RequestMapping("/member/fav")
	public String myFav(Model model, HttpSession session, Integer page) {
		Integer m_seq = (Integer) session.getAttribute("login");
		
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}

		if (page == null) {
			page = 1;
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", "f.m_seq");
		map.put("word", m_seq);
		map.put("what", "fav");

		int boardCount = usedService.someCount(map);

		Paging paging = new Paging(page, boardCount);

		map.put("first", paging.getFirst());
		map.put("last", paging.getLast());

		List<UsedVO> list = usedService.selectList(map);
		if (list.isEmpty())
			list = null;

		model.addAttribute("msg", "♡ 나의 관심목록");
		model.addAttribute("url", "/member/fav");
		model.addAttribute("ulist", list);
		model.addAttribute("paging", paging);
		
		return ViewPath.MEMBER + "mytrade.jsp";
	}

	@RequestMapping("/member/sell")
	public String mySell(Model model, HttpSession session, Integer page) {
		Integer m_seq = (Integer) session.getAttribute("login");
		
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}

		if (page == null) {
			page = 1;
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", "u.m_seq");
		map.put("word", m_seq);

		int boardCount = usedService.someCount(map);

		Paging paging = new Paging(page, boardCount);

		map.put("first", paging.getFirst());
		map.put("last", paging.getLast());

		List<UsedVO> list = usedService.selectList(map);
		if (list.isEmpty())
			list = null;

		model.addAttribute("msg", "▷ 나의 판매내역");
		model.addAttribute("mode", "sell");
		model.addAttribute("ulist", list);
		model.addAttribute("url", "/member/sell");
		model.addAttribute("paging", paging);
		
		return ViewPath.MEMBER + "mytrade.jsp";
	}

	@RequestMapping("/seller/sell/{m_seq}")
	public String sellerSell(Model model,HttpSession session, @PathVariable("m_seq") int m_seq, Integer page) {
		Integer login = (Integer)session.getAttribute("login");
		if(login == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}
		
		
		if (page == null) {
			page = 1;
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", "u.m_seq");
		map.put("word", m_seq);

		int boardCount = usedService.someCount(map);

		Paging paging = new Paging(page, boardCount);

		map.put("first", paging.getFirst());
		map.put("last", paging.getLast());

		List<UsedVO> list = usedService.selectList(map);
		if (list.isEmpty())
			list = null;

		String nickname = memberService.nickname(m_seq);

		model.addAttribute("msg", "▷ " + nickname + "님의 판매내역");
		model.addAttribute("ulist", list);
		model.addAttribute("paging", paging);
		model.addAttribute("seller", m_seq);
		
		return ViewPath.MEMBER + "sellertrade.jsp";
	}

	@RequestMapping("/member/buy")
	public String myBuy(Model model, HttpSession session, Integer page) {
		Integer m_seq = (Integer) session.getAttribute("login");
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}

		if (page == null) {
			page = 1;
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("word", m_seq);

		int boardCount = usedService.myBuyCount(m_seq);

		Paging paging = new Paging(page, boardCount);

		map.put("first", paging.getFirst());
		map.put("last", paging.getLast());

		List<UsedVO> list = usedService.myBuy(map);
		if (list.isEmpty())
			list = null;

		model.addAttribute("paging", paging);
		model.addAttribute("msg", "◁ 나의 구매내역");
		model.addAttribute("ulist", list);
		return ViewPath.MEMBER + "mytrade.jsp";
	}

	@RequestMapping("/member/collection")
	public String mySelect(Model model, HttpSession session, Integer page) {
		Integer m_seq = (Integer) session.getAttribute("login");
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}

		List<MemberVO> mlist = memberService.myCollection(m_seq);
		List<UsedVO> list = null;
		if (mlist.isEmpty()) {
			mlist = null;
		} else {

			if (page == null) {
				page = 1;
			}

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("type", "c.m_seq");
			map.put("word", m_seq);
			map.put("what", "collect");

			int boardCount = usedService.someCount(map);

			Paging paging = new Paging(page, boardCount);

			map.put("first", paging.getFirst());
			map.put("last", paging.getLast());

			list = usedService.selectList(map);
			if (list.isEmpty())
				list = null;

			model.addAttribute("paging", paging);
		}

		model.addAttribute("msg", "▣ 모아보기");
		model.addAttribute("mlist", mlist);
		model.addAttribute("ulist", list);
		model.addAttribute("mode", "collection");
		model.addAttribute("url", "/member/collection");
		return ViewPath.MEMBER + "mytrade.jsp";
	}
	
	@RequestMapping(value = "/member/myKey")
	@ResponseBody
	public List<String> myKey(int m_seq, HttpSession session) {
		System.out.println(m_seq);
		List<String> list = memberService.myKey(m_seq);
		if(list.isEmpty()) {
			list = null;
		}
		return list;
	}

	@RequestMapping(value = "/member/collection/add")
	@ResponseBody
	public boolean collectionAdd(int seller, HttpSession session) {
		Integer m_seq = (Integer) session.getAttribute("login");
		CollectionVO vo = new CollectionVO();
		vo.setM_seq(m_seq);
		vo.setSeller_seq(seller);
		boolean check = memberService.collectionAdd(vo);
		return check;
	}

	@RequestMapping(value = "/member/collection/del")
	@ResponseBody
	public boolean collectionDel(int seller, HttpSession session) {
		Integer m_seq = (Integer) session.getAttribute("login");
		CollectionVO vo = new CollectionVO();
		vo.setM_seq(m_seq);
		vo.setSeller_seq(seller);
		boolean check = memberService.collectionDel(vo);
		return check;
	}

	@RequestMapping(value = "/member/block/add")
	@ResponseBody
	public boolean blockAdd(int seller, HttpSession session) {
		Integer m_seq = (Integer) session.getAttribute("login");
		BlockVO vo = new BlockVO();
		vo.setBuyer_seq(m_seq);
		vo.setSeller_seq(seller);
		boolean check = memberService.blockAdd(vo);
		return check;
	}

	@RequestMapping(value = "/member/block/del")
	@ResponseBody
	public boolean blockDel(int seller, HttpSession session) {
		Integer m_seq = (Integer) session.getAttribute("login");
		BlockVO vo = new BlockVO();
		vo.setBuyer_seq(m_seq);
		vo.setSeller_seq(seller);
		boolean check = memberService.blockDel(vo);
		return check;
	}

	@RequestMapping("/manner/default")
	public String mannerForm(Model model, @RequestParam("seller") int seller) {
		MemberVO vo = memberService.selectOne(seller);

		List<MannersVO> list = mannersService.selectDefault();
		if (list.isEmpty())
			list = null;

		model.addAttribute("vo", vo);
		model.addAttribute("list", list);

		return ViewPath.MEMBER + "manner.jsp";
	}

	// 사용자가 판매자 페이지 들어가서 평가
	@RequestMapping("/manner/default/insert")
	public String mannerInsert(int seller_seq, int[] manners_seq, Model model, HttpSession session) {
		Integer m_seq = (Integer) session.getAttribute("login");
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}

		Manners_DefaultVO vo = new Manners_DefaultVO(m_seq, seller_seq);

		int su = 0;
		for (int i : manners_seq) {
			vo.setManners_seq(i);
			su = mannersService.defaultInsert(vo);
			
			if(su != 0) {
				mannersService.degreeUpdate(seller_seq);
			}
		}

		model.addAttribute("su", su);
		model.addAttribute("msg", "매너 평가");
		model.addAttribute("url", "/seller/page?seller=" + seller_seq);
		return ViewPath.RESULT + "popResult.jsp";
	}

	@RequestMapping("/manner/default/updateform")
	public String mannerUpdateForm(Model model, @RequestParam("seller") int seller, HttpSession session) {
		Integer m_seq = (Integer) session.getAttribute("login");
		
		if(m_seq == null) {
			return ViewPath.RESULT+ "goLogin.jsp";
		}
		
		MemberVO vo = memberService.selectOne(seller);

		List<MannersVO> list = mannersService.selectDefault();
		if (list.isEmpty())
			list = null;

		List<Manners_DefaultVO> mlist = mannersService.defaultList(new Manners_DefaultVO(m_seq, seller));

		model.addAttribute("vo", vo);
		model.addAttribute("list", list);
		model.addAttribute("mlist", mlist);

		return ViewPath.MEMBER + "mannerUpdate.jsp";
	}

	@RequestMapping("/manner/default/update")
	public String mannerUpdate(int seller_seq, int[] manners_seq, Model model, HttpSession session) {
		Integer m_seq = (Integer) session.getAttribute("login");
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}

		int su = mannersService.defaultDelete(new Manners_DefaultVO(m_seq, seller_seq));

		Manners_DefaultVO vo = new Manners_DefaultVO(m_seq, seller_seq);

		if (su != 0) {
			for (int i : manners_seq) {
				vo.setManners_seq(i);
				su = mannersService.defaultInsert(vo);
				
				if(su != 0) {
					mannersService.degreeUpdate(seller_seq);
				}
			}
		}

		model.addAttribute("su", su);
		model.addAttribute("msg", "매너 평가 수정");
		model.addAttribute("url", "/seller/page?seller=" + seller_seq);

		return ViewPath.RESULT + "popResult.jsp";
	}

	@RequestMapping("/manner/default/delete")
	public String mannerDelete(Model model, @RequestParam("seller") int seller, HttpSession session) {
		Integer m_seq = (Integer) session.getAttribute("login");
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}

		int su = mannersService.defaultDelete(new Manners_DefaultVO(m_seq, seller));

		mannersService.degreeUpdate(seller);

		model.addAttribute("su", su);
		model.addAttribute("msg", "매너 평가 삭제");
		model.addAttribute("url", "/seller/page?seller=" + seller);
		return ViewPath.RESULT + "popResult.jsp";
	}

	@RequestMapping("/manners")
	public String manners(Integer receive, int u_seq, Model model, HttpSession session) {
		Integer m_seq = (Integer) session.getAttribute("login");
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}

		if (receive == null) {	// 내가 구매자라는 의미
			UsedVO rvo = usedService.selectOnly(u_seq);
			MemberVO gvo = memberService.selectOne(m_seq);
			model.addAttribute("rvo", rvo);
			model.addAttribute("gvo", gvo);
		} else {
			MemberVO rvo = memberService.selectOne(receive);
			UsedVO gvo = usedService.selectOnly(u_seq);
			model.addAttribute("rvo", rvo);
			model.addAttribute("gvo", gvo);
		}

		List<MannersVO> list = mannersService.selectList();
		model.addAttribute("list", list);
		model.addAttribute("u_seq", u_seq);
		return ViewPath.MEMBER + "mannerAfter.jsp";
	}

	@RequestMapping("/manners/insert/{u_seq}")
	public String mannersInsert(Model model, @PathVariable("u_seq") int u_seq, Integer receive, int[] manners_seq,
			HttpSession session) {
		Integer m_seq = (Integer) session.getAttribute("login");
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}

		Manners_ListVO vo = new Manners_ListVO();
		vo.setGive_seq(m_seq);
		vo.setReceive_seq(receive);
		vo.setU_seq(u_seq);

		int su = 0;

		for (int m : manners_seq) {
			vo.setManners_seq(m);
			su = mannersService.mannersInsert(vo);
		}

		mannersService.degreeUpdate(receive);

		model.addAttribute("su", su);
		model.addAttribute("msg", "매너평가");
		model.addAttribute("url", "/chatList/");
		return ViewPath.RESULT + "result.jsp";
	}

	@RequestMapping("/manners/give")
	public String mannersGive(Integer receive, int u_seq, Model model, HttpSession session) {
		Integer m_seq = (Integer) session.getAttribute("login");
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}

		String nickname = null;

		if (receive == null) {// 구매자 입장
			UsedVO uvo = usedService.selectOnly(u_seq);
			nickname = uvo.getM_nickname();
			receive = uvo.getM_seq();
		} else {
			MemberVO mvo = memberService.selectOne(receive);
			nickname = mvo.getM_nickname();
		}

		List<String> list = mannersService.mannersList(new Manners_ListVO(m_seq, u_seq));
		model.addAttribute("list", list);
		model.addAttribute("nickname", nickname);
		model.addAttribute("receive", receive);
		model.addAttribute("u_seq", u_seq);
		return ViewPath.MEMBER + "mannersGive.jsp";
	}

	@RequestMapping("/manners/receive")
	public String mannersReceive(Integer give, int u_seq, Model model, HttpSession session) {
		Integer m_seq = (Integer) session.getAttribute("login");
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}
		
		String nickname = "";

		if (give == null) {// 구매자 입장
			UsedVO uvo = usedService.selectOnly(u_seq);
			MemberVO mvo = memberService.selectOne(m_seq);
			give = uvo.getM_seq();
			nickname = uvo.getM_nickname();

		} else {
			MemberVO mvo = memberService.selectOne(give);
			UsedVO uvo = usedService.selectOne(u_seq);
			nickname = mvo.getM_nickname();
		}

		Manners_ListVO vo = new Manners_ListVO();
		vo.setU_seq(u_seq);
		vo.setGive_seq(give);

		List<String> list = mannersService.mannersList(new Manners_ListVO(give, u_seq));
		model.addAttribute("list", list);
		model.addAttribute("nickname", nickname);
		return ViewPath.MEMBER + "mannersReceive.jsp";
	}

	@RequestMapping("/manners/delete")
	public String mannersDelete(int u_seq, int receive, HttpSession session, Model model) {
		Integer m_seq = (Integer) session.getAttribute("login");
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}

		int su = mannersService.mannersDelete(new Manners_ListVO(m_seq, u_seq));

		mannersService.degreeUpdate(receive);

		model.addAttribute("su", su);
		model.addAttribute("msg", "후가 삭제");
		model.addAttribute("url", "/chatList/");

		return ViewPath.RESULT + "result.jsp";
	}

	@RequestMapping("/manners/mymanner")
	public String myManner(HttpSession session, Model model) {
		Integer	m_seq = (Integer) session.getAttribute("login");
		if (m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}
		
		List<MannersVO> good = mannersService.myMannersGood(m_seq);
		List<MannersVO> bad = mannersService.myMannersBad(m_seq);

		if (good.isEmpty())
			good = null;
		if (bad.isEmpty())
			bad = null;

		model.addAttribute("m_seq", m_seq);
		model.addAttribute("good", good);
		model.addAttribute("bad", bad);
		return ViewPath.MEMBER + "myManner.jsp";
	}
	
	@RequestMapping("/manners/sellermanner")
	public String sellerManner(int seller, HttpSession session, Model model) {
		List<MannersVO> good = mannersService.myMannersGood(seller);
		List<MannersVO> bad = mannersService.myMannersBad(seller);
		
		if (good.isEmpty())
			good = null;
		if (bad.isEmpty())
			bad = null;
		
		model.addAttribute("m_seq", seller);
		model.addAttribute("good", good);
		model.addAttribute("bad", bad);
		return ViewPath.MEMBER + "myManner.jsp";
	}
	
	
	
	

}
