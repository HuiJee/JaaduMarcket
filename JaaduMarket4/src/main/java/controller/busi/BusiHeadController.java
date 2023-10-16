package controller.busi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.View;

import common.ViewPath;
import service.busi.BusiService;
import vo.addr.Addr3VO;
import vo.busi.B_ImgVO;
import vo.busi.B_RegularVO;
import vo.busi.BusiVO;
import vo.busi.CouponVO;
import vo.busi.Coupon_DownVO;
import vo.busi.DayVO;
import vo.busi.HoursVO;
import vo.busi.NoticeVO;
import vo.busi.Notice_ImgVO;
import vo.busi.ProductVO;
import vo.busi.RuntypeVO;
import vo.member.MemberVO;

@Controller
public class BusiHeadController {
	
	
	private BusiService busiService;
	@Autowired
	private ServletContext application;
	
	
	public BusiHeadController(BusiService busiService) {
		this.busiService = busiService;
	}
	
	
	
	
	

	
	@RequestMapping("/busi/myBusi")
	public String myStores(HttpServletRequest request, @RequestParam("busi_seq") int busi_seq) {
		
		Integer m_seq = (Integer)request.getSession().getAttribute("login");
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}
		
		boolean check;
		int bm_seq = busiService.selectM_seqInBusi(busi_seq);
		
		if(m_seq == bm_seq) {
			check = true;
		}else {
			check = false;
		}
		request.setAttribute("check", check);
		
		
		BusiVO vo = busiService.selectOneBusi(busi_seq);
		
		String addr3_name = busiService.selectAddr3_Name(vo.getAddr3_no());
		
		String busi_cate_name = busiService.selectBusi_Cate_Name(vo.getBusi_cate_seq());
		
			
		List<String> b_ImgList = busiService.selectImgList(busi_seq).isEmpty() ? null : busiService.selectImgList(busi_seq);
		String url = busiService.selectImgList(busi_seq).isEmpty() ? "busi/backImgForm?busi_seq="+busi_seq : "busi/backImgUpdate?busi_seq="+busi_seq;
		
		
		Addr3VO avo = busiService.selectAddrThroughBusi_seq(busi_seq);
		String addr = avo.getAddr1_name() + " " + avo.getAddr2_name() + " " + avo.getAddr3_name();
		
		List<HoursVO> hoursList = busiService.selectHours(busi_seq);
		List<DayVO> dayList = busiService.selectDayList();
		List<RuntypeVO> runtypeList = busiService.selectRuntype();
		
		List<String> time = new ArrayList<String>();

		if(!hoursList.isEmpty()) {
			for(int i = 0; i < hoursList.size(); i++) {
				if(hoursList.get(i).getRun_status() == 0) {
					time.add(i,	"휴무");
				}else {
					time.add(hoursList.get(i).getTime1() + " ~ " + hoursList.get(i).getTime2());
				}
			}
		}else {
			hoursList = null;
		}
		
		
		List<NoticeVO> noticeList = busiService.selectNoticeFour(busi_seq);
		if(noticeList.isEmpty()) {
			noticeList = null;
		}else {
			for(int i = 0; i < noticeList.size(); i++) {
				noticeList.get(i).setAddr3_name(busiService.selectAddr3_Name(noticeList.get(i).getAddr3_no()));
				String content = noticeList.get(i).getNotice_content();
				if(noticeList.get(i).getNotice_content().length() >= 80) {
					noticeList.get(i).setNotice_content(content.substring(1, 80) + ".....");
				}
			}
		}
		
		
		List<ProductVO> productList = busiService.selectProductsFour(busi_seq).isEmpty() ? null : busiService.selectProductsFour(busi_seq);
		
		int countRegular = busiService.countRegular(busi_seq);
		
		List<CouponVO> availableCouponList = busiService.selectAvailableCouponFour(busi_seq).isEmpty() ? null : busiService.selectAvailableCouponFour(busi_seq);
		
		
		int isRegular;
		
		B_RegularVO brvo = busiService.isRegular(m_seq) == null ? null : busiService.isRegular(m_seq);
		
		if(busiService.isRegular(m_seq) == null) {
			isRegular = -1;
		}else {
			brvo = busiService.isRegular(m_seq);
			
			if(m_seq == brvo.getM_seq()) {
				
				isRegular = 1;
			}else {
				isRegular = 2;
			}
			
		}
		
		
//		try {
//			if(m_seq == brvo.getM_seq()) {
//				
//				isRegular = 1;
//			}else {
//				isRegular = 2;
//			}
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//			isRegular = -1;
//		}
		
		
		if(request.getParameter("coupon_seq") != null) {
			Integer coupon_seq = Integer.parseInt(request.getParameter("coupon_seq"));
			
			Coupon_DownVO cdvo = new Coupon_DownVO();
			cdvo.setCoupon_seq(coupon_seq);
			cdvo.setM_seq(m_seq);
			
			Coupon_DownVO cdvo2 = busiService.selectOneCouponDown(cdvo);
			
			
			request.setAttribute("cdvo2", cdvo2);
		}
		
		
		request.setAttribute("m_seq", m_seq);
		
		request.setAttribute("isRegular", isRegular);
		request.setAttribute("availableCouponList", availableCouponList);
		request.setAttribute("countRegular", countRegular);
		request.setAttribute("productList", productList);
		//request.setAttribute("m_seq", m_seq);
		request.setAttribute("noticeList", noticeList);
		
		request.setAttribute("time", time);
		request.setAttribute("runtypeList", runtypeList);
		request.setAttribute("dayList", dayList);
		request.setAttribute("hoursList", hoursList);
		request.setAttribute("addr", addr);
		request.setAttribute("busi_seq", busi_seq);
		request.setAttribute("b_ImgList", b_ImgList);
		request.setAttribute("url", url);
		request.setAttribute("addr3_name", addr3_name);
		request.setAttribute("busi_cate_name", busi_cate_name);
		request.setAttribute("vo", vo);
		return ViewPath.BUSI + "home/busi_home.jsp";
	}
	
	
	@RequestMapping("/busi/home/map")
	public String map(@RequestParam("busi_name") String busi_name, @RequestParam("addr") String addr, HttpServletRequest request) {
		
		request.setAttribute("addr", addr);
		request.setAttribute("busi_name", busi_name);
		return ViewPath.BUSI + "home/map.jsp";
	}
	
	
	
	@RequestMapping("/busi/backImgForm")
	public String backImg(@RequestParam("busi_seq") int busi_seq, Model model) {
		model.addAttribute("busi_seq", busi_seq);
		return ViewPath.BUSI + "backImgForm.jsp";
	}
	
	
	
	@RequestMapping("/busi/insertBackImg")
	public String insertBackImg(HttpServletRequest request, B_ImgVO vo, @RequestParam("busi_seq") int busi_seq) {
		
		vo.setBusi_seq(busi_seq);
		
		String msg = null;
		String url = null;
		
		List<MultipartFile> list = vo.getFiles();
		
		String savePath = application.getRealPath("/resources/busiBack/" + busi_seq);
		
		if(list != null && list.size() != 0) {
			List<B_ImgVO> b_imgs = new ArrayList<B_ImgVO>();
			for(MultipartFile file : list) {
				String filename = file.getOriginalFilename();
				if(!filename.equals("")) {
					File saveFile = new File(savePath, filename);
					
					if(!saveFile.exists()) {
						saveFile.mkdirs();
					}else {
						long time = System.currentTimeMillis();
						
						filename = String.format("%s%d%s", filename.substring(0, filename.lastIndexOf(".")), time, filename.substring(filename.lastIndexOf(".")));
						
						saveFile = new File(savePath, filename);
					}
					
					try {
						file.transferTo(saveFile);
					} catch (IllegalStateException | IOException e) {
						e.printStackTrace();
					}
					b_imgs.add(new B_ImgVO(busi_seq, filename));
				}
			}
			busiService.insert(b_imgs);
			msg = "배경 사진이 등록되었습니다.";
			url = "/jaadu/busi/myBusi?busi_seq="+busi_seq;
		}else {
			msg = "배경 사진 등록에 실패하였습니다.";
			url = "history.back()";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return ViewPath.INDEX + "result.jsp";
		
	}
	
	
	@RequestMapping("/busi/backImgUpdate")
	public String backImgUpdate(@RequestParam("busi_seq") int busi_seq, Model model) {
		
		List<String> b_ImgList = busiService.selectImgList(busi_seq);
		
		model.addAttribute("b_ImgList", b_ImgList);
		model.addAttribute("busi_seq", busi_seq);
		
		return ViewPath.BUSI + "backImgUpdate.jsp";
	}
	
	
	@RequestMapping("/busi/updateBackImgCheck")
	public String updateBackImgCheck(@RequestParam("busi_seq") int busi_seq, HttpServletRequest request, B_ImgVO vo) {
		
		String savePath = application.getRealPath("/resources/busiBack/" + busi_seq);
		List<MultipartFile> list = vo.getFiles();
		
		String filename = null;
		
		String msg = "";
		String url = "";
		
		
		
		if(!list.isEmpty()) {
			File folder = new File(savePath);
			
			if(folder != null) {
				if(folder.listFiles() != null) {
					for(File f : folder.listFiles()) {
						f.delete();
					}
				}
			}
			
			List<B_ImgVO> b_imgs = new ArrayList<B_ImgVO>();
			for(MultipartFile file : list) {
				filename = file.getOriginalFilename();
				
				File saveFile = new File(savePath, filename);
				if(!saveFile.exists()) {
					int su = busiService.deleteB_Img(busi_seq);
					saveFile.mkdirs();
				}else {
					long time = System.currentTimeMillis();
					
					filename = String.format("%s%d%s", filename.substring(0, filename.lastIndexOf(".")), time, filename.substring(filename.lastIndexOf(".")));
					saveFile = new File(savePath, filename);
				}
				try {
					file.transferTo(saveFile);
					b_imgs.add(new B_ImgVO(busi_seq, filename));
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
			busiService.insert(b_imgs);
		}
		msg = "배경사진이 수정되었습니다.";
		url = "/jaadu/busi/myBusi?busi_seq=" + busi_seq;
		
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return ViewPath.INDEX + "result.jsp";
	}
	
	@RequestMapping("/busi/updateMyBusi")
	public String updateMy_Busi(@RequestParam("busi_seq") int busi_seq, HttpServletRequest request) {
		
		BusiVO vo = busiService.selectOneBusi(busi_seq);
		Addr3VO addr = busiService.selectAddrThroughBusi_seq(busi_seq);
		String addr_name = addr.getAddr1_name() + " " + addr.getAddr2_name() + " " + addr.getAddr3_name();
		
		request.setAttribute("addr_name", addr_name);
		request.setAttribute("addr", addr);
		request.setAttribute("vo", vo);
		return ViewPath.BUSI + "myBusiUpdateForm.jsp";
	}
	
	
	@RequestMapping("/busi/myBusiUpdateCheck")
	public String myBusiUpdateCheck(@RequestParam("busi_seq") int busi_seq, HttpServletRequest request, MultipartFile photo) {
		
		BusiVO bvo = busiService.selectOneBusi(busi_seq);
		
		String addr = request.getParameter("addr_name");
		int start = addr.lastIndexOf(" ");
		String addr3 = addr.substring(start+1);
		int addr3_no = busiService.selectAddr3_No(addr3);
		
		bvo.setBusi_name(request.getParameter("busi_name"));
		bvo.setAddr3_no(addr3_no);
		bvo.setBusi_cate_seq(Integer.parseInt(request.getParameter("busi_cate_seq")));
		bvo.setBusi_seq(busi_seq);
		
		String savePath = application.getRealPath("/resources/busiProfileImg");
		String busi_img = null;
		
		String url = "";
		String msg = "";
		
		if(!photo.isEmpty()) {
			File folder = new File(savePath);
			System.out.println(folder);
			if(folder != null) {
				if(folder.listFiles() != null) {
					for(File f : folder.listFiles()) {
						if(f.getName().equals(bvo.getBusi_img())){
							f.delete();
						}
					}	
				}
				
				
			}
		}
		
		if(photo != null && !photo.isEmpty()) {
			busi_img = photo.getOriginalFilename();
			
			File saveFile = new File(savePath, busi_img);
			
			if(!saveFile.exists()) {
				saveFile.mkdirs();
			}else {
				long time = System.currentTimeMillis();
				
				busi_img = String.format("%s%d%s", busi_img.substring(0, busi_img.lastIndexOf(".")), time, busi_img.substring(busi_img.lastIndexOf(".")));
				saveFile = new File(savePath, busi_img);
			}
			try {
				photo.transferTo(saveFile);
				bvo.setBusi_img(busi_img);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		int su = busiService.updateBusiProfile(bvo);
		
		if(su != 0) {
			url = "/jaadu/busi/myBusi?busi_seq=" + busi_seq;
			msg = "비즈 프로필이 수정되었습니다.";
		}else {
			msg = "비즈 프로필 수정에 실패하였습니다.";
		}
		
		
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		request.setAttribute("su", su);
		return ViewPath.INDEX + "result.jsp";
		
	}
	
	
	
	@RequestMapping("/busi/regular")
	public String regular(@RequestParam("busi_seq") int busi_seq, HttpServletRequest request) {
		
		List<MemberVO> rlist = busiService.selectRegular_MList(busi_seq);
		List<String> addr3_name = new ArrayList<String>();
		for(int i = 0; i < rlist.size(); i++) {
			addr3_name.add(busiService.selectAddr3_Name(rlist.get(i).getAddr3_no()));
		}
		
		
		BusiVO vo = busiService.selectOneBusi(busi_seq);
		int countRegular = busiService.countRegular(busi_seq);
		
		request.setAttribute("addr3_name", addr3_name);
		request.setAttribute("countRegular", countRegular);
		request.setAttribute("vo", vo);
		request.setAttribute("busi_seq", busi_seq);
		request.setAttribute("rlist", rlist);
		return ViewPath.BUSI + "manageRegular.jsp";
	}
	
	
	
	@RequestMapping("/busi/makeAd")
	public String makeAd() {
		
		return ViewPath.BUSI + "makeAd.jsp";
	}
	
	
	
	@RequestMapping("/busi/makeNotice")
	public String makeNotice() {
		
		return ViewPath.BUSI + "makeNotice.jsp";
	}

	
	@RequestMapping("/busi/coupon/coupon")
	public String coupon(@RequestParam("busi_seq") int busi_seq, HttpServletRequest request) {
		
		Integer m_seq = (Integer)request.getSession().getAttribute("login");
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}

		boolean check;
		int bm_seq = busiService.selectM_seqInBusi(busi_seq);

		if(m_seq == bm_seq) {
			check = true;
			List<CouponVO> clist = busiService.selectCouponList(busi_seq).isEmpty() ?  null : busiService.selectCouponList(busi_seq);
			request.setAttribute("clist", clist);
		}else {
			check = false;
			List<CouponVO> clist = busiService.selectAvailableCoupon(busi_seq).isEmpty() ? null : busiService.selectAvailableCoupon(busi_seq);
			request.setAttribute("clist", clist);
		}

		request.setAttribute("check", check);
		
		
		
		request.setAttribute("busi_seq", busi_seq);
		return ViewPath.BUSI + "coupon/couponList.jsp";
	}
	
	
	@RequestMapping("/busi/coupon/couponTip")
	public String couponTip() {
		
		return ViewPath.BUSI + "coupon/couponTip.jsp";
	}
	
	@RequestMapping("/busi/coupon/makeCoupon")
	public String makeCoupon(@RequestParam("busi_seq") int busi_seq, HttpServletRequest request) {
		
		
		request.setAttribute("busi_seq", busi_seq);
		return ViewPath.BUSI + "coupon/couponForm.jsp";
	}
	
	
	@RequestMapping("/busi/coupon/couponForm")
	public String couponForm(@RequestParam("busi_seq") int busi_seq, HttpServletRequest request) {
		
		int regular_status = Integer.parseInt(request.getParameter("regular_status"));
		
		return ViewPath.BUSI + "coupon/couponForm.jsp";
	}
	
	
	@RequestMapping("/busi/coupon/insertCoupon")
	public String insertCoupon(@RequestParam("busi_seq") int busi_seq, HttpServletRequest request, CouponVO vo) {
		
		CouponVO cvo = new CouponVO();
		
		if(vo.getCoupon_limit_num() == 1) {
			cvo.setCoupon_limit_num(Integer.parseInt(request.getParameter("limit_num")));
		}
		
		
		cvo.setBusi_seq(vo.getBusi_seq());
		cvo.setRegular_status(vo.getRegular_status());
		cvo.setCoupon_effect(vo.getCoupon_effect());
		cvo.setCoupon_use_date(vo.getCoupon_use_date());
		cvo.setCoupon_info(vo.getCoupon_info());
		
		int su = busiService.insert(cvo);
		
		String msg = "";
		String url = "";
		
		if(su != 0) {
			msg = "쿠폰을 생성했습니다.";
			url = "/jaadu/busi/coupon/coupon?busi_seq=" + busi_seq;
		}else {
			msg = "쿠폰 생성에 실패하였습니다.";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		request.setAttribute("su", su);
		
		return ViewPath.INDEX + "result.jsp";
		
	}
	
	
	@RequestMapping("/busi/coupon/couponUpdate")
	public String couponUpdate(@RequestParam("busi_seq") int busi_seq, @RequestParam("coupon_seq") int coupon_seq, HttpServletRequest request) {
		
		CouponVO vo = busiService.selectOneCoupon(coupon_seq);
		
		request.setAttribute("vo", vo);
		request.setAttribute("busi_seq", busi_seq);
		request.setAttribute("coupon_seq", coupon_seq);
		return ViewPath.BUSI + "coupon/couponUpdateForm.jsp";
	}
	
	
	@RequestMapping("/busi/coupon/couponUpdateCheck")
	public String couponUpdateCheck(@RequestParam("busi_seq") int busi_seq, CouponVO vo, HttpServletRequest request) {
		
		CouponVO cvo = new CouponVO();
		
		if(vo.getCoupon_limit_num() == 1) {
			cvo.setCoupon_limit_num(Integer.parseInt(request.getParameter("limit_num")));
		}
		
		cvo.setCoupon_seq(vo.getCoupon_seq());
		cvo.setBusi_seq(vo.getBusi_seq());
		cvo.setRegular_status(vo.getRegular_status());
		cvo.setCoupon_effect(vo.getCoupon_effect());
		cvo.setCoupon_use_date(vo.getCoupon_use_date());
		cvo.setCoupon_info(vo.getCoupon_info());
		
		int su = busiService.update(cvo);
		
		String msg = "";
		String url = "";
		
		if(su != 0) {
			msg = "쿠폰 수정에 성공하였습니다.";
			url = "/jaadu/busi/coupon/coupon?busi_seq=" + busi_seq;
		}else {
			msg = "쿠폰 수정에 실패하였습니다.";
		}
		
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		request.setAttribute("su", su);
		
		return ViewPath.INDEX + "result.jsp";
	}
	
	
	@RequestMapping("/busi/coupon/selectCoupon")
	public String selectCoupon(@RequestParam("coupon_seq") int coupon_seq, HttpServletRequest request) {
		CouponVO vo = busiService.selectOneCoupon(coupon_seq);
		
		request.setAttribute("vo", vo);
		return ViewPath.BUSI + "coupon/selectCoupon.jsp";
	}
	
	
	@RequestMapping("/busi/coupon/couponAct")
	public String couponAct(@RequestParam("busi_seq") int busi_seq, @RequestParam("coupon_seq") int coupon_seq, HttpServletRequest request) {
		
		CouponVO vo = busiService.selectOneCoupon(coupon_seq);
		
		if(vo.getCoupon_act() == 0) {
			vo.setCoupon_act(1);
		}else {
			vo.setCoupon_act(0);
		}
		vo.setCoupon_seq(coupon_seq);
		
		int su = busiService.updateAct(vo);
		
		String msg = "";
		String url = "";
		
		if(su != 0) {
			msg = "쿠폰 발급 상태가 수정되었습니다.";
			url = "/jaadu/busi/coupon/coupon?busi_seq=" + busi_seq;
		}else {
			msg = "쿠폰 발급 상태 수정에 실패하였습니다.";
			
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		request.setAttribute("su", su);
		
		return ViewPath.INDEX + "result.jsp";
	}
	
	
	@RequestMapping("/busi/coupon/attachCoupon")
	public String attachCoupon(@RequestParam("busi_seq") int busi_seq, @RequestParam("coupon_seq") int coupon_seq, HttpServletRequest request) {
		
		List<NoticeVO> noticeList = busiService.selectNoticeList(busi_seq);
		if(noticeList.isEmpty()) {
			noticeList = null;
		}else {
			for(int i = 0; i < noticeList.size(); i++) {
				noticeList.get(i).setAddr3_name(busiService.selectAddr3_Name(noticeList.get(i).getAddr3_no()));
				String content = noticeList.get(i).getNotice_content();
				if(noticeList.get(i).getNotice_content().length() >= 80) {
					noticeList.get(i).setNotice_content(content.substring(1, 80) + ".....");
				}
			}
		}
		
		request.setAttribute("coupon_seq", coupon_seq);
		request.setAttribute("busi_seq", busi_seq);
		request.setAttribute("noticeList", noticeList);
		return ViewPath.BUSI + "coupon/attachCoupon.jsp";
	}
	
	
	@RequestMapping("/busi/notice/noticeFormCoupon")
	public String noticeFormCoupon(@RequestParam("busi_seq") int busi_seq, @RequestParam("coupon_seq") int coupon_seq, HttpServletRequest request) {
		
		CouponVO cvo = busiService.selectOneCoupon(coupon_seq);
		
		
		request.setAttribute("cvo", cvo);
		request.setAttribute("busi_seq", busi_seq);
		return ViewPath.BUSI + "notice/noticeFormCoupon.jsp";
	}
	
	
	@RequestMapping("/busi/notice/noticeInsertCoupon")
	public String noticeInsert(@RequestParam("busi_seq") int busi_seq, @RequestParam("coupon_seq") int coupon_seq, NoticeVO vo, HttpServletRequest request) {
		
		CouponVO cvo = busiService.selectOneCoupon(coupon_seq);
		
		NoticeVO nvo = new NoticeVO();
		
		nvo.setBusi_seq(busi_seq);
		nvo.setNotice_title(vo.getNotice_title());
		nvo.setNotice_content(vo.getNotice_content());
		
		int su = busiService.insert(nvo);
		
		int notice_seq = busiService.maxNotice_Seq();
		
		//------------------------------------------------------------
		String msg = null;
		String url = null;
		
		if(su != 0) {
			
			List<MultipartFile> list = vo.getFiles();
			
			String savePath = application.getRealPath("/resources/notice_img/" + notice_seq);
			
			if(list != null && list.size() != 0) {
				List<Notice_ImgVO> n_imgs = new ArrayList<Notice_ImgVO>();
				for(MultipartFile file : list) {
					String filename = file.getOriginalFilename();
					if(!filename.equals("")) {
						File saveFile = new File(savePath, filename);
						
						if(!saveFile.exists()) {
							saveFile.mkdirs();
						}else {
							long time = System.currentTimeMillis();
							
							filename = String.format("%s%d%s", filename.substring(0, filename.lastIndexOf(".")), time, filename.substring(filename.lastIndexOf(".")));
							
							saveFile = new File(savePath, filename);
						}
						
						try {
							file.transferTo(saveFile);
						} catch (IllegalStateException | IOException e) {
							e.printStackTrace();
						}
						n_imgs.add(new Notice_ImgVO(notice_seq, filename));
					}
				}
				busiService.insertNotice_Img(n_imgs);
			}
			msg = "소식이 업로드되었습니다.";
			url = "/jaadu/busi/notice/selectNotice?busi_seq="+busi_seq+"&notice_seq="+notice_seq+"&coupon_seq="+coupon_seq;
		}else {
			msg = "소식 업로드에 실패하였습니다.";
			url = "history.back()";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return ViewPath.INDEX + "result.jsp";
	}
	
	
	
	
	
}
