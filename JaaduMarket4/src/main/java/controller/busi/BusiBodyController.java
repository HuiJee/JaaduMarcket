package controller.busi;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
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

import common.Paging;
import common.ViewPath;
import service.busi.BusiService;
import vo.addr.Addr3VO;
import vo.busi.B_ImgVO;
import vo.busi.B_ReviewVO;
import vo.busi.B_Review_ImgVO;
import vo.busi.BusiVO;
import vo.busi.CouponVO;
import vo.busi.Coupon_DownVO;
import vo.busi.DayVO;
import vo.busi.HolidayVO;
import vo.busi.HoursVO;
import vo.busi.NoticeVO;
import vo.busi.Notice_CmtVO;
import vo.busi.Notice_ImgVO;
import vo.busi.ProductVO;
import vo.busi.RuntypeVO;
import vo.member.MemberVO;

@Controller
public class BusiBodyController {

	private BusiService busiService;
	@Autowired
	private ServletContext application;
	
	
	public BusiBodyController(BusiService busiService) {
		this.busiService = busiService;
	}
	
	
	@RequestMapping("/busi/notice/notice")
	public String notice(@RequestParam("busi_seq") int busi_seq, HttpServletRequest request, Integer page) {
		
		Integer m_seq = (Integer)request.getSession().getAttribute("login");
		if(m_seq == null) {
			return ViewPath.RESULT+"goLogin.jsp";
		}

		boolean check;
		int bm_seq = busiService.selectM_seqInBusi(busi_seq);

		if(m_seq == bm_seq) {
			check = true;
		}else {
			check = false;
		}
		request.setAttribute("check", check);
		
		
		
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
		
//		int busiCount = busiService.getTotal();
//		Paging paging = new Paging(page, busiCount);
//		
//		request.setAttribute("paging", paging);
		
		
		
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("busi_seq", busi_seq);
		
		return ViewPath.BUSI + "notice/noticeList.jsp";
	}
	
	
	@RequestMapping("/busi/notice/noticeForm")
	public String nociteForm(@RequestParam("busi_seq") int busi_seq, Model model) {
		
		
		model.addAttribute("busi_seq", busi_seq);
		return ViewPath.BUSI + "notice/noticeForm.jsp";
	}
	
	@RequestMapping("/busi/notice/noticeInsert")
	public String noticeInsert(@RequestParam("busi_seq") int busi_seq, NoticeVO vo, HttpServletRequest request) {
		
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
			url = "/jaadu/busi/notice/selectNotice?busi_seq="+busi_seq+"&notice_seq="+notice_seq;
		}else {
			msg = "소식 업로드에 실패하였습니다.";
		}
		
		request.setAttribute("su", su);
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return ViewPath.INDEX + "result.jsp";
	}
	
	
	@RequestMapping("/busi/notice/selectNotice")
	public String selectNotice(@RequestParam("busi_seq") int busi_seq, HttpServletRequest request, @RequestParam("notice_seq") int notice_seq) {
		
		Integer m_seq = (Integer)request.getSession().getAttribute("login");
		if(m_seq == null) {
			return ViewPath.RESULT+"goLogin.jsp";
		}
		if(request.getParameter("coupon_seq") != null) {
			Integer coupon_seq = Integer.parseInt(request.getParameter("coupon_seq"));
			CouponVO cvo = busiService.selectOneCoupon(coupon_seq);
			request.setAttribute("cvo", cvo);
		}
		
		if(request.getParameter("coupon_seq") != null) {
			Coupon_DownVO ckvo = new Coupon_DownVO();
			ckvo.setCoupon_seq(Integer.parseInt(request.getParameter("coupon_seq")));
			ckvo.setM_seq(m_seq);
			Coupon_DownVO cdvo = busiService.selectOneCouponDown(ckvo);
			request.setAttribute("cdvo", cdvo);
		}
		
		
		boolean check;
		int bm_seq = busiService.selectM_seqInBusi(busi_seq);

		if(m_seq == bm_seq) {
			check = true;
		}else {
			check = false;
		}
		request.setAttribute("check", check);
		
		NoticeVO vo = busiService.selectNotice(notice_seq);
		vo.setNotice_content(vo.getNotice_content().replaceAll("\r\n", "<br>"));
		
		BusiVO bvo = busiService.selectOneBusi(busi_seq);
		
		List<String> imgList = busiService.selectNotice_Img_List(notice_seq).isEmpty() ? null : busiService.selectNotice_Img_List(notice_seq);
		String addr3_name = busiService.selectAddr3_Name(bvo.getAddr3_no());
		
		String busi_cate_name = busiService.selectBusi_Cate_Name(bvo.getBusi_cate_seq());
		List<String> b_ImgList = busiService.selectImgList(busi_seq).isEmpty() ? null : busiService.selectImgList(busi_seq);
		
		MemberVO mvo = busiService.selectOneM(m_seq);
		
		List<Notice_CmtVO> cmtList = busiService.selectCmtList(notice_seq).isEmpty() ? null : busiService.selectCmtList(notice_seq);
		
		request.setAttribute("cmtList", cmtList);
		request.setAttribute("mvo", mvo);
		request.setAttribute("b_ImgList", b_ImgList);
		request.setAttribute("busi_cate_name", busi_cate_name);
		request.setAttribute("addr3_name", addr3_name);
		request.setAttribute("imgList", imgList);
		request.setAttribute("bvo", bvo);
		request.setAttribute("vo", vo);
		request.setAttribute("busi_seq", busi_seq);
		return ViewPath.BUSI + "notice/selectNotice.jsp";
	}
	
	
	@RequestMapping("/busi/notice/noticeUpdate")
	public String noticeUpdate(@RequestParam("busi_seq") int busi_seq, @RequestParam("notice_seq") int notice_seq, HttpServletRequest request) {
		
		List<String> imgList = busiService.selectNotice_Img_List(notice_seq).isEmpty() ? null : busiService.selectNotice_Img_List(notice_seq);
		
		NoticeVO vo = busiService.selectOneForUpdate(notice_seq);
		
		request.setAttribute("imgList", imgList);
		request.setAttribute("vo", vo);
		request.setAttribute("busi_seq", busi_seq);
		request.setAttribute("notice_seq", notice_seq);
		return ViewPath.BUSI + "notice/noticeUpdateForm.jsp";
	}
	
	
	@RequestMapping("/busi/notice/noticeUpdateCheck")
	public String noticeUpdateCheck(HttpServletRequest request, NoticeVO vo) {
		
		int notice_seq = Integer.parseInt(request.getParameter("notice_seq"));
		int busi_seq = Integer.parseInt(request.getParameter("busi_seq"));
		
		
		NoticeVO nvo = busiService.selectOneForUpdate(notice_seq);
		nvo.setNotice_title(vo.getNotice_title());
		nvo.setNotice_content(vo.getNotice_content());
		nvo.setNotice_seq(notice_seq);
		int su = busiService.update(nvo);
		
		
		String msg = "";
		String url = "";
		

		if(su != 0) {
			
			String savePath = application.getRealPath("/resources/notice_img/" + notice_seq);
			List<MultipartFile> list = vo.getFiles();
			String filename = null;
			
			if(!list.isEmpty()) {
				
				File folder = new File(savePath);
				
				if(folder != null) {
					for(File f : folder.listFiles()) {
						f.delete();
					}
				}
				
				List<Notice_ImgVO> n_imgs = new ArrayList<Notice_ImgVO>();
				for(MultipartFile file : list) {
					filename = file.getOriginalFilename();
						
					File saveFile = new File(savePath, filename);
					if(!saveFile.exists()) {
						int dsu = busiService.deleteNotice_Img(notice_seq);
						saveFile.mkdirs();
					}else {
						long time = System.currentTimeMillis();
						
						filename = String.format("%s%d%s", filename.substring(0, filename.lastIndexOf(".")), time, filename.substring(filename.lastIndexOf(".")));
						
						saveFile = new File(savePath, filename);
					}
					try {
						file.transferTo(saveFile);
						n_imgs.add(new Notice_ImgVO(notice_seq, filename));
					} catch (IllegalStateException | IOException e) {
						e.printStackTrace();
					}
				}
				busiService.insertNotice_Img(n_imgs);
			}
			msg = "소식이 수정되었습니다.";
			url = "/jaadu/busi/notice/selectNotice?busi_seq="+busi_seq+"&notice_seq="+notice_seq;
		}else {
			msg = "소식 수정에 실패하였습니다.";
			url = "history.back()";
		}
		
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return ViewPath.INDEX + "result.jsp";
	}
	
	
	@RequestMapping("/busi/notice/notice_cmt")
	public String notice_cmt(@RequestParam("notice_seq") int notice_seq, HttpServletRequest request, Model model) {
		
		Integer m_seq = (Integer)request.getSession().getAttribute("login");
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}
		int busi_seq = Integer.parseInt(request.getParameter("busi_seq"));
		
		String cmt = request.getParameter("cmt");
		
		
		Notice_CmtVO ncvo = new Notice_CmtVO();
		ncvo.setNotice_seq(notice_seq);
		ncvo.setM_seq(m_seq);
		ncvo.setCmt(cmt);
		
		int su = busiService.insert(ncvo);
		
		String msg = "";
		String url = "";
		
		if(su != 0) {
			
			msg = "댓글이 등록되었습니다.";
			url = "/jaadu/busi/notice/selectNotice?busi_seq="+busi_seq + "&notice_seq="+notice_seq;

		}else {
			msg = "댓글 등록에 실패하였습니다.";
			
		}
		
		
		request.setAttribute("su", su);
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return ViewPath.INDEX + "result.jsp";
	}
	
	
	
	
	@RequestMapping("/busi/notice/noticeDelete")
	public String noticeDelete(@RequestParam("busi_seq") int busi_seq, @RequestParam("notice_seq") int notice_seq, HttpServletRequest request) {
		
		String msg = "";
		String url = "";
		int su = 0;
		
		List<Notice_CmtVO> clist = busiService.selectCmtList(notice_seq);
		
		if(clist.isEmpty()) {
			List<Notice_ImgVO> ilist = busiService.selectNotice_Img(notice_seq);
			
			if(ilist.isEmpty()) {
				su = busiService.deleteNotice(notice_seq);
				
				if(su != 0) {
					msg = "소식이 삭제되었습니다.";
					url = "/jaadu/busi/notice/notice?busi_seq=" + busi_seq;
				}else {
					msg = "소식 삭제에 실패하였습니다.";
				}
			}else {
				String savePath = application.getRealPath("/resources/notice_img/" + notice_seq);
				
				File folder = new File(savePath);
				
				if(folder != null) {
					if(folder.listFiles() != null) {
						for(File f : folder.listFiles()) {
							f.delete();
						}
						folder.delete();
					}
				}
				
				int isu = busiService.deleteNotice_Img(notice_seq);
				
				if(isu != 0) {
					
					su = busiService.deleteNotice(notice_seq);
					
					if(su != 0) {
						msg = "소식이 삭제되었습니다.";
						url = "/jaadu/busi/notice/notice?busi_seq=" + busi_seq;
					}else {
						msg = "소식 삭제에 실패하였습니다.";
					}
				}
			}
		}else {
			int csu = busiService.deleteNoticeCmtAll(notice_seq);
			
			if(csu != 0) {
				
				List<Notice_ImgVO> ilist = busiService.selectNotice_Img(notice_seq);
				if(ilist.isEmpty()) {
					su = busiService.deleteNotice(notice_seq);
					
					if(su != 0) {
						msg = "소식이 삭제되었습니다.";
						url = "/jaadu/busi/notice/notice?busi_seq=" + busi_seq;
					}else {
						msg = "소식 삭제에 실패하였습니다.";
					}
					
				}else {
					
					String savePath = application.getRealPath("/resources/notice_img/" + notice_seq);
					
					File folder = new File(savePath);
					
					if(folder != null) {
						for(File f : folder.listFiles()) {
							f.delete();
						}
						folder.delete();
					}
					
					int isu = busiService.deleteNotice_Img(notice_seq);
					
					if(isu != 0) {
						
						su = busiService.deleteNotice(notice_seq);
						
						if(su != 0) {
							msg = "소식이 삭제되었습니다.";
							url = "/jaadu/busi/notice/notice?busi_seq=" + busi_seq;
						}else {
							msg = "소식 삭제에 실패하였습니다.";
						}
					}
				}
			}
		}
		
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		request.setAttribute("su", su);
		return ViewPath.INDEX + "result.jsp";
	}
	
	
	
	@RequestMapping("/busi/home/info")
	public String info(@RequestParam("busi_seq") int busi_seq, HttpServletRequest request) {
		
		Addr3VO addr = busiService.selectAddrThroughBusi_seq(busi_seq);
		BusiVO vo = busiService.selectOneBusi(busi_seq);
		
		List<HolidayVO> holidayList = busiService.selectHoliday();
		
		List<HoursVO> hoursList = busiService.selectHours(busi_seq);
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
			
		List<DayVO> dayList = busiService.selectDayList();
		List<RuntypeVO> runtypeList = busiService.selectRuntype();
		
		request.setAttribute("time", time);
		request.setAttribute("runtypeList", runtypeList);
		request.setAttribute("dayList", dayList);
		request.setAttribute("hoursList", hoursList);
		request.setAttribute("holidayList", holidayList);
		request.setAttribute("busi_seq", busi_seq);
		request.setAttribute("vo", vo);
		request.setAttribute("addr", addr);
		return ViewPath.BUSI + "home/info.jsp";
	}
	
	
	@RequestMapping("/busi/home/hours")
	public String hours(@RequestParam("busi_seq") int busi_seq, HttpServletRequest request) {
		
		List<DayVO> dayList = busiService.selectDayList();		
		
		List<RuntypeVO> runtype = busiService.selectRuntype();
		
		request.setAttribute("runtype", runtype);
		request.setAttribute("dayList", dayList);
		request.setAttribute("busi_seq", busi_seq);
		return ViewPath.BUSI + "home/hours.jsp";
	}
	
	
	@RequestMapping("/busi/home/insertHours")
	public String insertHours(HttpServletRequest request) {
		
		
		String[] time1 = request.getParameterValues("time1");
		String[] time2 = request.getParameterValues("time2");
		//String[] run_status = request.getParameterValues("run_status");
		String run_status1 = request.getParameter("run_status1");
		String run_status2 = request.getParameter("run_status2");
		String run_status3 = request.getParameter("run_status3");
		String run_status4 = request.getParameter("run_status4");
		String run_status5 = request.getParameter("run_status5");
		String run_status6 = request.getParameter("run_status6");
		String run_status7 = request.getParameter("run_status7");
		
		String[] run = new String[] {run_status1,run_status2,run_status3,run_status4,run_status5,run_status6,run_status7};
		
		
		int busi_seq = Integer.parseInt(request.getParameter("busi_seq"));
		
		
		List<DayVO> dayList = busiService.selectDayList();
		
		String msg = "";
		String url = "";
		
		int cnt = 0;
		for(int i = 0; i < dayList.size(); i++) {
			HoursVO vo = new HoursVO();
			
			vo.setDay_seq(i+1);
			
			
			for(int j = 1; j <= 2; j++) {
				List<HoursVO> hoursList = busiService.selectHours(busi_seq);	
				if(!hoursList.isEmpty()) {
					int hours_seq = busiService.selectHours_maxSeq() - 14 + 2*i + j;
					vo.setHours_seq(hours_seq);
				}
				
				vo.setBusi_seq(busi_seq);
				vo.setRuntype_seq(j);
					if(run[i] != null) {
						vo.setTime1(null);
						vo.setTime2(null);
						vo.setRun_status(0);
					}else {
						vo.setTime1(time1[cnt]);
						vo.setTime2(time2[cnt]);
						vo.setRun_status(1);
						cnt++;
					}
					
				
					if(hoursList.size() != 14) {
						int su = busiService.insert(vo);
						msg = "영업시간이 설정되었습니다.";
						url = "/jaadu/busi/home/hoursResult?busi_seq=" + busi_seq;
					}else {
						busiService.update(vo);
						msg = "영업시간이 수정되었습니다.";
						url = "/jaadu/busi/home/hoursResult?busi_seq=" + busi_seq;
					}
			}
		}
		
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return ViewPath.INDEX + "result.jsp";
	}
	
	
	@RequestMapping("/busi/home/hoursResult")
	public String hoursResult(@RequestParam("busi_seq") int busi_seq, HttpServletRequest request) {
		
		request.setAttribute("busi_seq", busi_seq);
		return ViewPath.BUSI + "home/hoursResult.jsp";
	}
	
	
	
	@RequestMapping("/busi/home/inputInfo")
	public String updateInfo(HttpServletRequest request) {

		String addr = request.getParameter("addr");
		int start = addr.lastIndexOf(" ");
		String addr3 = addr.substring(start+1);
		int addr3_no = busiService.selectAddr3_No(addr3);
		
		int busi_seq = Integer.parseInt(request.getParameter("busi_seq"));
		String busi_information = request.getParameter("busi_information");
		String busi_addr_detail = request.getParameter("busi_addr_detail");
		String busi_tel1 = request.getParameter("busi_tel1");
		String busi_tel2 = request.getParameter("busi_tel2");
		String busi_tel3 = request.getParameter("busi_tel3");
		int holiday_seq = Integer.parseInt(request.getParameter("holiday_seq"));
		String busi_details = request.getParameter("busi_details");
		String busi_website = request.getParameter("busi_website");
		
		BusiVO vo = busiService.selectOneBusi(busi_seq);
		vo.setBusi_information(busi_information);
		vo.setAddr3_no(addr3_no);
		vo.setBusi_addr_detail(busi_addr_detail);
		vo.setBusi_tel1(busi_tel1);
		vo.setBusi_tel2(busi_tel2);
		vo.setBusi_tel3(busi_tel3);
		vo.setHoliday_seq(holiday_seq);
		vo.setBusi_details(busi_details);
		vo.setBusi_website(busi_website);
		vo.setBusi_seq(busi_seq);
		
		int su = busiService.update(vo);
		
		String msg = "";
		String url = "";
		
		if(su != 0) {
			msg = "정보가 업데이트 되었습니다.";
			url = "/jaadu/busi/home/info?busi_seq=" + busi_seq;
		}else {
			msg = "정보 업데이트에 실패했습니다.";
			url = "history.back()";
		}

		if(vo != null) {
			request.setAttribute("vo", vo);
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return ViewPath.INDEX + "result.jsp";
	}
	
	
	
	@RequestMapping("/busi/product/product")
	public String product(@RequestParam("busi_seq") int busi_seq, HttpServletRequest request) {
		
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
		List<String> b_ImgList = busiService.selectImgList(busi_seq).isEmpty() ? null : busiService.selectImgList(busi_seq);
		String busi_cate_name = busiService.selectBusi_Cate_Name(vo.getBusi_cate_seq());
		String addr3_name = busiService.selectAddr3_Name(vo.getAddr3_no());
		
		List<ProductVO> productList = busiService.selectProductList(busi_seq).isEmpty() ? null : busiService.selectProductList(busi_seq);
		
		
		request.setAttribute("productList", productList);
		request.setAttribute("addr3_name", addr3_name);
		request.setAttribute("busi_cate_name", busi_cate_name);
		request.setAttribute("b_ImgList", b_ImgList);
		request.setAttribute("vo", vo);
		request.setAttribute("busi_seq", busi_seq);
		return ViewPath.BUSI + "product/productList.jsp";
	}
	
	
	
	@RequestMapping("/busi/product/productIntro")
	public String productIntro(@RequestParam("busi_seq") int busi_seq, HttpServletRequest request) {
		
		List<String> b_ImgList = busiService.selectImgList(busi_seq) == null? null : busiService.selectImgList(busi_seq);
		BusiVO vo = busiService.selectOneBusi(busi_seq);
		
		
		request.setAttribute("busi_seq", busi_seq);
		request.setAttribute("vo", vo);
		request.setAttribute("b_ImgList", b_ImgList);
		return ViewPath.BUSI + "product/productIntro.jsp";
	}
	
	
	@RequestMapping("/busi/product/startProduct")
	public String product(HttpServletRequest request) {
		
		int busi_seq = Integer.parseInt(request.getParameter("busi_seq"));
		
		request.setAttribute("busi_seq", busi_seq);
		return ViewPath.BUSI + "product/startProduct.jsp";
	}
	
	
	@RequestMapping("/busi/product/busi_numberCheck")
	public String busi_numberCheck(HttpServletRequest request) {
		
		int busi_seq = Integer.parseInt(request.getParameter("busi_seq"));
		String busi_number = request.getParameter("busi_number");
		BusiVO vo = busiService.selectOneBusi(busi_seq);
		
		String msg = "";
		String url = "";
		
		if(busi_number.equals(vo.getBusi_number())) {
			msg = "인증되었습니다.";
			url = "/jaadu/busi/product/productForm?busi_seq="+busi_seq;
		}else {
			msg = "사업자등록번호를 확인해주세요.";
			url = "history.back()";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return ViewPath.INDEX + "result.jsp";
	}
	
	
	@RequestMapping("/busi/product/productForm")
	public String productForm(@RequestParam("busi_seq") int busi_seq, HttpServletRequest request) {
		
		request.setAttribute("busi_seq", busi_seq);
		return ViewPath.BUSI + "product/productForm.jsp";
	}
	
	
	@RequestMapping("/busi/product/productInsert")
	public String productInsert(@RequestParam("busi_seq") int busi_seq, MultipartFile[] file,HttpServletRequest request) {
		
		String[] product_name = request.getParameterValues("product_name");
		String[] product_price = request.getParameterValues("product_price");
		String[] product_info = request.getParameterValues("product_info");
		
		
		
		
		String savePath = application.getRealPath("/resources/busi/product");
		String product_img = null;
		
		String msg = "";
		String url = "";
		
		for(int i = 0; i < file.length; i++) {
			ProductVO vo = new ProductVO();
			
			if(file.length != 0) {
				product_img = file[i].getOriginalFilename();
				
				File saveFile = new File(savePath, product_img);
				
				if(!saveFile.exists()) {
					saveFile.mkdirs();
				}else {
					long time = System.currentTimeMillis();
					
					product_img = String.format("%s%d%s", product_img.substring(0, product_img.lastIndexOf(".")), time, product_img.substring(product_img.lastIndexOf(".")));
					saveFile = new File(savePath, product_img);
				}
				try {
					file[i].transferTo(saveFile);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				vo.setProduct_img(product_img);
			}else {
				vo.setProduct_img("no_file");
			}
			
			DecimalFormat df = new DecimalFormat("#,###");
			
			vo.setBusi_seq(busi_seq);
			vo.setProduct_name(product_name[i]);
			vo.setProduct_price(df.format(Integer.parseInt(product_price[i])));
			vo.setProduct_info(product_info[i]);
			
			
			int su = busiService.insert(vo);
			
			if(su != 0) {
				msg = "상품등록이 완료되었습니다.";
				url = "/jaadu/busi/product/product?busi_seq="+busi_seq;
			}else {
				msg = "상품등록에 실패하였습니다.";
				url = "history.back()";
			}
			
			
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return ViewPath.INDEX + "result.jsp";
	}
	
	
	@RequestMapping("/busi/product/selectProduct")
	public String selectProduct(@RequestParam("product_seq") int product_seq, @RequestParam("busi_seq") int busi_seq, HttpServletRequest request) {
		

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
		
		
		ProductVO pvo = busiService.selectProduct(product_seq);
		
		request.setAttribute("pvo", pvo);
		request.setAttribute("busi_seq", busi_seq);
		request.setAttribute("vo", vo);
		request.setAttribute("b_ImgList", b_ImgList);
		request.setAttribute("busi_cate_name", busi_cate_name);
		request.setAttribute("addr3_name", addr3_name);
		return ViewPath.BUSI + "product/selectProduct.jsp";
	}
	
	
	@RequestMapping("/busi/product/updateProduct")
	public String updateProduct(@RequestParam("busi_seq") int busi_seq, @RequestParam("product_seq") int product_seq, HttpServletRequest request) {
		
		ProductVO pvo = busiService.selectProduct(product_seq);
		
		request.setAttribute("busi_seq", busi_seq);
		request.setAttribute("pvo", pvo);
		return ViewPath.BUSI + "product/updateProductForm.jsp";
	}
	
	
	@RequestMapping("/busi/product/productUpdateCheck")
	public String productUpdateCheck(HttpServletRequest request, MultipartFile file, @RequestParam("product_seq") int product_seq, ProductVO vo) {
		ProductVO pvo = busiService.selectProduct(product_seq);
		
		int busi_seq = Integer.parseInt(request.getParameter("busi_seq"));
		
		DecimalFormat df = new DecimalFormat("#,###");
		pvo.setProduct_price(df.format(Integer.parseInt(vo.getProduct_price())));
		
		pvo.setProduct_name(vo.getProduct_name());
		pvo.setProduct_info(vo.getProduct_info());
		
		String savePath = application.getRealPath("/resources/busi/product");
		String product_img = null;
		
		String url = "";
		String msg = "";
		
		if(!file.isEmpty()) {
			File folder = new File(savePath);
			
			if(folder != null) {
				if(folder.listFiles() != null) {
					for(File f : folder.listFiles()) {
						if(f.getName().equals(pvo.getProduct_img())) {
							f.delete();
						}
					}
				}
			}
		}
		if(file != null && !file.isEmpty()) {
			product_img = file.getOriginalFilename();
			
			File saveFile = new File(savePath, product_img);
			
			if(!saveFile.exists()) {
				saveFile.mkdirs();
			}else {
				long time = System.currentTimeMillis();
				
				product_img = String.format("%s%d%s", product_img.substring(0, product_img.lastIndexOf(".")), time, product_img.substring(product_img.lastIndexOf(".")));
				saveFile = new File(savePath, product_img);
			}
			try {
				file.transferTo(saveFile);
				pvo.setProduct_img(product_img);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		int su = busiService.update(pvo);
		
		if(su != 0) {
			url = "/jaadu/busi/product/selectProduct?busi_seq="+busi_seq+"&product_seq="+product_seq;
			msg = "상품이 수정되었습니다.";
		}else {
			msg = "상품 수정에 실패하였습니다.";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		request.setAttribute("su", su);
		return ViewPath.INDEX + "result.jsp";
	}
	
	
	@RequestMapping("/busi/product/deleteProduct")
	public String deleteProduct(@RequestParam("busi_seq") int busi_seq, @RequestParam("product_seq") int product_seq, HttpServletRequest request) {
		
		ProductVO pvo = busiService.selectProduct(product_seq);
		
		String savePath = application.getRealPath("/resources/busi/product");
		
		File folder = new File(savePath);
		
		if(folder != null) {
			if(folder.listFiles() != null) {
				for(File f : folder.listFiles()) {
					if(f.getName().equals(pvo.getProduct_img())) {
						f.delete();
					}
				}
			}
		}
			
		String msg = "";
		String url = "";
			
		int su = busiService.deleteProduct(product_seq);
		
		if(su != 0) {
			msg = "상품이 삭제되었습니다.";
			url = "/jaadu/busi/product/product?busi_seq=" + busi_seq;
		}else {
			msg = "상품 삭제에 실패하였습니다.";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		request.setAttribute("su", su);
		
		return ViewPath.INDEX + "result.jsp";
	}
	
	
	
	@RequestMapping("/busi/review")
	public String review(@RequestParam("busi_seq") int busi_seq, HttpServletRequest request) {
		
		Integer m_seq = (Integer)request.getSession().getAttribute("login");

		boolean check;
		int bm_seq = busiService.selectM_seqInBusi(busi_seq);

		if(m_seq == bm_seq) {
			check = true;
		}else {
			check = false;
		}
		request.setAttribute("check", check);

		
		List<B_ReviewVO> rlist = busiService.selectB_Review_List(busi_seq).isEmpty() ? null : busiService.selectB_Review_List(busi_seq);
		
		
		request.setAttribute("rlist", rlist);
		request.setAttribute("busi_seq", busi_seq);
		return ViewPath.BUSI + "review/reviewList.jsp";
	}
	
	
	@RequestMapping("/busi/review/reviewDelete")
	public String reviewDelete(@RequestParam("b_review_seq") int b_review_seq, @RequestParam("busi_seq") int busi_seq, HttpServletRequest request) {
		

		String msg = "";
		String url = "";
		int su = 0;
		
		List<B_Review_ImgVO> ilist = busiService.selectB_ReviewImg_List(b_review_seq);
		if(ilist.isEmpty()) {
			su = busiService.deleteB_Review(b_review_seq);
			
			if(su != 0) {
				msg="후기가 삭제되었습니다.";
				url = "/jaadu/busi/review?busi_seq=" + busi_seq;
			}else {
				msg = "후기 삭제에 실패하였습니다.";
				
			}
		}else {
			String savePath = application.getRealPath("/resources/b_review_img/" + b_review_seq);
			File folder = new File(savePath);
			
			if(folder != null) {
				if(folder.listFiles() != null) {
					for(File f : folder.listFiles()) {
						f.delete();
					}
					folder.delete();
				}
			}
			int dsu = busiService.deleteB_ReviewImg(b_review_seq);
			
			if(dsu != 0) {
				su = busiService.deleteB_Review(b_review_seq);
				if(su != 0) {
					msg = "후기가 삭제되었습니다.";
					url = "/jaadu/busi/review?busi_seq=" + busi_seq;
				}else {
					msg = "후기 삭제에 실패하였습니다.";
				}
			}
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		request.setAttribute("su", su);
		
		
		return ViewPath.INDEX + "result.jsp";
	}
	
	
	
}
