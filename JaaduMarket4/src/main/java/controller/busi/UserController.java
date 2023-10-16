package controller.busi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import common.ViewPath;
import service.busi.BusiService;
import vo.addr.Addr3VO;
import vo.busi.B_RegularVO;
import vo.busi.B_ReviewVO;
import vo.busi.B_Review_ImgVO;
import vo.busi.B_Review_KeyVO;
import vo.busi.BusiVO;
import vo.busi.CouponVO;
import vo.busi.Coupon_DownVO;
import vo.busi.Notice_ImgVO;
import vo.member.MemberVO;

@Controller
public class UserController {

	private BusiService busiService;
	@Autowired
	private ServletContext application;
	
	public UserController(BusiService busiService) {
		this.busiService = busiService;
	}
	
	
	
	@RequestMapping("/busi/beRegular")
	public String beRegular(@RequestParam("busi_seq") int busi_seq, HttpServletRequest request) {
		
		Integer m_seq = (Integer)request.getSession().getAttribute("login");
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}
		
		int bm_seq = busiService.selectM_seqInBusi(busi_seq);
		boolean check;
		
		if(m_seq == bm_seq) {
			check = true;
		}else {
			check = false;
		}
		request.setAttribute("check", check);
		
		
		B_RegularVO rvo = new B_RegularVO();
		rvo.setBusi_seq(busi_seq);
		rvo.setM_seq(m_seq);
		
		int su = busiService.insert(rvo);
		
		String msg = "";
		String url = "";
		
		if(su != 0) {
			msg = "단골 등록되었습니다.";
			url = "/jaadu/busi/myBusi?busi_seq=" + busi_seq;
//			url = request.getRequestURI()+"?busi_seq=" + busi_seq;
			
		}else {
			msg = "단골 등록에 실패하였습니다.";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		request.setAttribute("su", su);
		
		return ViewPath.INDEX + "result.jsp";
	}
	
	
	
	@RequestMapping("/busi/beRegular2")
	public String beRegular2(@RequestParam("busi_seq") int busi_seq, @RequestParam("coupon_seq") int coupon_seq, HttpServletRequest request) {
		
		Integer m_seq = (Integer)request.getSession().getAttribute("login");
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}
		
		B_RegularVO rvo = new B_RegularVO();
		rvo.setBusi_seq(busi_seq);
		rvo.setM_seq(m_seq);
		
		int su = busiService.insert(rvo);
		
		String msg = "";
		String url = "";
		
		if(su != 0) {
			msg = "단골 등록되었습니다.";
			url = "/jaadu/busi/coupon/detailCoupon?busi_seq=" + busi_seq + "&coupon_seq=" + coupon_seq;
			
			int isRegular;
			
			B_RegularVO brvo = busiService.isRegular(m_seq) == null ? null : busiService.isRegular(m_seq);
			
			if(m_seq == brvo.getM_seq()) {
				isRegular = 1;
			}else {
				isRegular = 2;
			}
			
			request.setAttribute("isRegular", isRegular);
			
		}else {
			msg = "단골 등록에 실패하였습니다.";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		request.setAttribute("su", su);
		
		return ViewPath.INDEX + "result.jsp";
	}
	
	
	@RequestMapping("/busi/coupon/detailCoupon")
	public String detailCoupon(@RequestParam("busi_seq") int busi_seq, @RequestParam("coupon_seq") int coupon_seq, HttpServletRequest request) {
		
		Integer m_seq = (Integer)request.getSession().getAttribute("login");
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}
		
		
		
		BusiVO bvo = busiService.selectOneBusi(busi_seq);
		CouponVO cvo = busiService.selectOneCoupon(coupon_seq);
		
		String addr3_name = busiService.selectAddr3_Name(bvo.getAddr3_no());
		int countRegular = busiService.countRegular(busi_seq);
		
		Addr3VO avo = busiService.selectAddr(bvo.getAddr3_no());
		String addr = avo.getAddr1_name() + " " +  avo.getAddr2_name() + " " + avo.getAddr3_name();
		
		int isRegular;
		
		B_RegularVO brvo = busiService.isRegular(m_seq) == null ? null : busiService.isRegular(m_seq);
		
		try {
			if(m_seq == brvo.getM_seq()) {
				isRegular = 1;
			}else {
				isRegular = 2;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			isRegular = -1;
		}
		
		request.setAttribute("isRegular", isRegular);
		request.setAttribute("addr", addr);
		request.setAttribute("countRegular", countRegular);
		request.setAttribute("addr3_name", addr3_name);
		request.setAttribute("bvo", bvo);
		request.setAttribute("cvo", cvo);
		
		return ViewPath.USER + "detailCoupon.jsp";
	}
	
	
	@RequestMapping("/busi/quitRegular")
	public String quitRegular(@RequestParam("busi_seq") int busi_seq, HttpServletRequest request) {
		
		Integer m_seq = (Integer)request.getSession().getAttribute("login");
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}
		
		B_RegularVO vo = new B_RegularVO();
		vo.setBusi_seq(busi_seq);
		vo.setM_seq(m_seq);
		
		int su = busiService.deleteRegular(vo);
		
		String msg = "";
		String url = "";
		
		if(su != 0) {
			msg = "해당 비즈와 단골을 끊었습니다.";
			url = "/jaadu/busi/myBusi?busi_seq=" + busi_seq;
		}else {
			msg = "단골 끊기에 실패하였습니다.";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		request.setAttribute("su", su);
		
		return ViewPath.INDEX + "result.jsp";
	}
	
	
	@RequestMapping("/busi/quitRegular2")
	public String quitRegular2(@RequestParam("busi_seq") int busi_seq, @RequestParam("coupon_seq") int coupon_seq, HttpServletRequest request) {
		
		Integer m_seq = (Integer)request.getSession().getAttribute("login");
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}
		
		B_RegularVO vo = new B_RegularVO();
		vo.setBusi_seq(busi_seq);
		vo.setM_seq(m_seq);
		
		int su = busiService.deleteRegular(vo);
		
		String msg = "";
		String url = "";
		
		if(su != 0) {
			msg = "해당 비즈와 단골을 끊었습니다.";
			url = "/jaadu/busi/coupon/detailCoupon?busi_seq=" + busi_seq +"&coupon_seq=" + coupon_seq;
		}else {
			msg = "단골 끊기에 실패하였습니다.";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		request.setAttribute("su", su);
		
		return ViewPath.INDEX + "result.jsp";
	}
	
	
	@RequestMapping("/busi/coupon/couponDown")
	public String couponDown(@RequestParam("busi_seq") int busi_seq, @RequestParam("coupon_seq") int coupon_seq, HttpServletRequest request) {

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

		Coupon_DownVO cdvo = new Coupon_DownVO();
		cdvo.setM_seq(m_seq);
		cdvo.setCoupon_seq(coupon_seq);
		
		int su = busiService.insert(cdvo);
		
		String msg = "";
		String url = "";
		
		if(su != 0) {
			
			msg = "쿠폰 발급 완료.";
			url = "/jaadu/busi/myBusi?busi_seq=" + busi_seq + "&coupon_seq=" + coupon_seq;
		}else {
			msg = "쿠폰 발급에 실패하였습니다.";
		}
		
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		request.setAttribute("su", su);
		
		return ViewPath.INDEX + "result.jsp";
	}
	
	
	@RequestMapping("/busi/reviewForm")
	public String reviewForm(@RequestParam("busi_seq") int busi_seq, HttpServletRequest request) {
		Integer m_seq = (Integer)request.getSession().getAttribute("login");
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}
		
		MemberVO vo = busiService.selectOneM(m_seq);
		BusiVO bvo = busiService.selectOneBusi(busi_seq);

		List<B_Review_KeyVO> klist = busiService.selectB_ReviewKeyList();
		
		
		request.setAttribute("klist", klist);
		request.setAttribute("bvo", bvo);
		request.setAttribute("vo", vo);
		return ViewPath.BUSI + "review/reviewForm.jsp";
	}
	
	
	@RequestMapping("/busi/review/reviewInsert")
	public String reviewInsert(@RequestParam("busi_seq") int busi_seq, HttpServletRequest request, B_ReviewVO vo, @RequestParam("b_review_key_seq") String[] keys) {
		
		Integer m_seq = (Integer)request.getSession().getAttribute("login");
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}
		
		StringBuilder seqs = new StringBuilder();
		for(String b_review_key_seq : keys) {
			seqs.append(b_review_key_seq).append(", ");
		}
		
		
		B_ReviewVO rvo = new B_ReviewVO();
		
		rvo.setB_review_content(vo.getB_review_content());
		rvo.setB_review_key_seq(seqs.toString());
		rvo.setBusi_seq(busi_seq);
		rvo.setM_seq(m_seq);
		
		int su = busiService.insert(rvo);
		int b_review_seq = busiService.maxReview_seq();
		
		String msg = null;
		String url = null;
		
		if(su != 0) {
			List<MultipartFile> list = vo.getFiles();
			
			String savePath = application.getRealPath("/resources/b_review_img/" + b_review_seq);
			
			if(list != null && list.size() != 0) {
				List<B_Review_ImgVO> r_imgs = new ArrayList<B_Review_ImgVO>();
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
						r_imgs.add(new B_Review_ImgVO(b_review_seq, filename));
					}
				}
				busiService.insertReview_Img(r_imgs);
			}
			msg = "후기가 등록되었습니다.";
			url = "/jaadu/busi/review/selectReview?busi_seq=" + busi_seq + "&b_review_seq=" + b_review_seq;
		}else {
			msg = "후기 등록에 실패하였습니다.";
		}
		
		request.setAttribute("su", su);
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return ViewPath.INDEX + "result.jsp";
	}
	
	
	@RequestMapping("/busi/review/selectReview")
	public String selectReview(@RequestParam("busi_seq") int busi_seq, @RequestParam("b_review_seq") int b_review_seq, HttpServletRequest request) {
		
		Integer m_seq = (Integer)request.getSession().getAttribute("login");
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}
		
		B_ReviewVO rvo = busiService.selectB_Review_One(b_review_seq);
		List<B_Review_ImgVO> imgList = busiService.selectB_ReviewImg_List(b_review_seq).isEmpty() ? null : busiService.selectB_ReviewImg_List(b_review_seq);
		String addr3_name = busiService.selectAddr3_Name(rvo.getAddr3_no());
		
		String str = rvo.getB_review_key_seq();
		String[] nums = str.split(",\\s*");
		int[] seqs = new int[nums.length];
		for(int i = 0; i<nums.length; i++) {
			try {
				int b_review_keq_seq = Integer.parseInt(nums[i]);
				seqs[i] = b_review_keq_seq;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		String[] b_review_key_name = new String[seqs.length];
		for(int i = 0; i < b_review_key_name.length; i++) {
			b_review_key_name[i] = busiService.selectB_Review_Key_Name(seqs[i]);
		}
		
		String msg = "";
		B_RegularVO reg = busiService.isRegular(m_seq) == null ? null : busiService.isRegular(m_seq);
		if(reg != null) {
			msg = "단골";
		}
		
		
		request.setAttribute("msg", msg);
		request.setAttribute("b_review_key_name", b_review_key_name);
		request.setAttribute("addr3_name", addr3_name);
		request.setAttribute("b_review_seq", b_review_seq);
		request.setAttribute("imgList", imgList);
		request.setAttribute("rvo", rvo);
		request.setAttribute("busi_seq", busi_seq);
		return ViewPath.BUSI + "review/selectReview.jsp";
	}
	
}
