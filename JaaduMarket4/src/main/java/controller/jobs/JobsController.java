package controller.jobs;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import common.Paging;
import common.ViewPath;
import service.jobs.ApplyService;
import service.jobs.ExperienceService;
import service.jobs.J_CateService;
import service.jobs.JobsService;
import service.member.MemberService;
import vo.addr.Addr3VO;
import vo.jobs.ApplicationVO;
import vo.jobs.ApplyVO;
import vo.busi.DayVO;
import vo.jobs.ExperienceVO;
import vo.jobs.J_CateVO;
//import vo.jobs.J_FavVO;
import vo.jobs.J_TimeVO;

import vo.jobs.JobsVO;

import vo.jobs.TermsVO;
import vo.member.MemberVO;

@Controller
public class JobsController {

	@Autowired
	private ServletContext application;

	private JobsService jobsService;
	private J_CateService jcateService;
	private MemberService memberService;
	private ExperienceService experienceService;
	private ApplyService applyService;

	public JobsController(JobsService jobsService, J_CateService jcateService, MemberService memberService,
			ExperienceService experienceService, ApplyService applyService) {
		this.jobsService = jobsService;
		this.jcateService = jcateService;
		this.memberService = memberService;
		this.experienceService = experienceService;
		this.applyService = applyService;
	}
	
	@RequestMapping("/jobs/jobInsertform3")
	public String jobInsertForm(Model model, HttpSession session) {

		Integer m_seq = (Integer) session.getAttribute("login");

		if (m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
			

		}

		MemberVO mvo = memberService.selectOne(m_seq);

		List<J_CateVO> jclist = jcateService.selectAll();

		List<TermsVO> tlist = jobsService.selectTermsList();

		for (TermsVO terms : tlist) {
			System.out.println(terms.getTerms_title());
		}

		for (J_CateVO jcate : jclist) {
			System.out.println("하는일번호?" + jcate.getJ_cate_seq());
		}

		List<DayVO> dlist = jobsService.selectDayNameList();

		for (DayVO day : dlist) {
			System.out.println("day : " + day.getDay_name());
		}

		model.addAttribute("jclist", jclist);
		model.addAttribute("dlist", dlist);
		model.addAttribute("mvo", mvo);
		model.addAttribute("tlist", tlist);

		return ViewPath.JOBS + "jobInsertform3.jsp";
	}

	@RequestMapping("jobs/addr3Search")
	public String searchCheck(@RequestParam("addr3_name") String addr3_name, HttpServletRequest request) {

		

		List<Addr3VO> addrlist = memberService.searchAddr3(addr3_name);
		

		request.setAttribute("addrlist", addrlist);
		request.setAttribute("addr3_name", addr3_name);
		return ViewPath.JOBS + "addrForm.jsp";
	}

	@RequestMapping("jobs/addr3Search2")
	public String searchCheck2(@RequestParam("addr3_name") String addr3_name, HttpServletRequest request, int j_seq) {

		

		List<Addr3VO> addrlist = memberService.searchAddr3(addr3_name);
	

		request.setAttribute("addrlist", addrlist);
		request.setAttribute("addr3_name", addr3_name);
		request.setAttribute("j_seq", j_seq);
		return ViewPath.JOBS + "addrForm2.jsp";
	}

	@RequestMapping("jobs/addrCheck")
	public String addrCheck(@RequestParam("addr3_name") String addr3_name, Model model, HttpSession session) {

		

		int m_seq = (Integer) session.getAttribute("login");
		MemberVO mvo = memberService.selectOne(m_seq);

		List<J_CateVO> jclist = jcateService.selectAll();

		List<TermsVO> tlist = jobsService.selectTermsList();
		List<DayVO> dlist = jobsService.selectDayNameList();

		int addr3_no = memberService.selectAddr3_No(addr3_name);
		Addr3VO advo = memberService.selectAddr(addr3_no);

		model.addAttribute("advo", advo);
		model.addAttribute("jclist", jclist);
		model.addAttribute("dlist", dlist);
		model.addAttribute("mvo", mvo);
		model.addAttribute("tlist", tlist);

		

		return ViewPath.JOBS + "jobInsertform3.jsp";
	}

	@RequestMapping("jobs/addrCheck2")
	public String addrCheck2(@RequestParam("addr3_name") String addr3_name, Model model, HttpSession session, int j_seq,
			JobsVO jvo) {

		jvo = jobsService.AllJobsOne(j_seq);
		List<J_CateVO> jclist = jcateService.selectAll();
		List<J_TimeVO> jtlist = jobsService.getTimeType(j_seq);// 단기 장기 요일 날짜
		List<DayVO> dlist = jobsService.selectDayNameList(); // 요일테이블 목록

		List<JobsVO> jcnlist = jobsService.CateName(j_seq);
		model.addAttribute("jvo", jvo);
		model.addAttribute("jclist", jclist);
		model.addAttribute("jcnlist", jcnlist);
		model.addAttribute("jtlist", jtlist);
		model.addAttribute("dlist", dlist);

		// System.out.println("addr3_name :" + addr3_name); // 잠실2동

		int m_seq = (Integer) session.getAttribute("login");
		MemberVO mvo = memberService.selectOne(m_seq);
		List<TermsVO> tlist = jobsService.selectTermsList();

		int addr3_no = memberService.selectAddr3_No(addr3_name);
		Addr3VO advo = memberService.selectAddr(addr3_no);

		model.addAttribute("advo", advo);
		model.addAttribute("jclist", jclist);
		model.addAttribute("dlist", dlist);
		model.addAttribute("mvo", mvo);
		model.addAttribute("tlist", tlist);

		// System.out.println("addr2_no : " + addr3_no);

		return ViewPath.JOBS + "jobUpdateForm.jsp";
	}

	// @SuppressWarnings("unused")
	@RequestMapping("jobs/jobInsertCheck")
	public String JobCheck(@RequestParam("j_name") String j_name, @RequestParam("addr3_name") String addr3_name,
			@RequestParam("addr_details") String addr_details, JobsVO jvo, Model model, HttpServletRequest request,
			@RequestParam("j_cate_seq") List<Integer> j_cate_seq) {

		// 사진 업로드
		String savePath = application.getRealPath("/resources/jobs/");

		String j_img = null;
		MultipartFile photo = jvo.getPhoto();
		System.out.println("photo: " + photo.getOriginalFilename());

		if (photo != null && !photo.isEmpty()) {
			j_img = photo.getOriginalFilename();// 업로드된 파일명(실제 파일명)

			// file객체 생성
			File saveFile = new File(savePath, j_img);
			if (!saveFile.exists()) {
				saveFile.mkdirs();
			} else {// 파일이 존재하면
				long time = System.currentTimeMillis();

				j_img = String.format("%s%d%s", j_img.substring(0, j_img.lastIndexOf(".")), time,
						j_img.substring(j_img.lastIndexOf(".")));

				saveFile = new File(savePath, j_img);
			}
			// 업로드된 파일은 MultipartResover라는 클래스가 지정한 임시 저장소에 저장되어 있다
			// 파일이 일정한 시간이 지나면 사라지기 때문에 내가 지정한 경로로 복사해주면 된다

			try {
				photo.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			jvo.setJ_img(j_img);
		} else {
			jvo.setJ_img("기본이미지.jpg");
		}

		String msg = null;
		String url = null;

		int j_seq = jobsService.getJSeq();
		int m_seq = (Integer) request.getSession().getAttribute("login");

		if (j_cate_seq.size() == 3) {
			jvo.setJ_cate_seq1(j_cate_seq.get(0));
			jvo.setJ_cate_seq2(j_cate_seq.get(1));
			jvo.setJ_cate_seq3(j_cate_seq.get(2));
		} else if (j_cate_seq.size() == 2) {
			jvo.setJ_cate_seq1(j_cate_seq.get(0));
			jvo.setJ_cate_seq2(j_cate_seq.get(1));
			jvo.setJ_cate_seq3(0);
		} else if (j_cate_seq.size() == 1) {
			jvo.setJ_cate_seq1(j_cate_seq.get(0));
			jvo.setJ_cate_seq2(0);
			jvo.setJ_cate_seq3(0);
		}

		jvo.setJ_seq(j_seq);
		jvo.setM_seq(m_seq);

		String j_details = jvo.getJ_details();

		jvo.setJ_details(j_details.replaceAll("\r\n", "<br>"));
		
		int addr3_no = memberService.selectAddr3_No(addr3_name);
		jvo.setAddr3_no(addr3_no);

		String[] j_time_type1 = request.getParameterValues("j_time_type1"); // 단기
		String[] j_time_type2 = request.getParameterValues("j_time_type2"); // 장기

		J_TimeVO jtvo = new J_TimeVO();
		int su = jobsService.insertJob(jvo);
		if (su != 0) {
			int lo = jvo.getJ_long();
			if (lo != 0) { // 단기

				if (j_time_type1 != null) {

					for (String time : j_time_type1) { // 단기
						System.out.println("전달된 단기 요일 :" + time);
						jtvo = new J_TimeVO();
						jtvo.setJ_seq(j_seq);
						jtvo.setJ_time_type(time);

						jobsService.JTimeInsert(jtvo);

					}
				} else {
					jtvo.setJ_time_type(null);
				}

			} else {

				if (j_time_type2 != null) {

					for (String time : j_time_type2) { // 장기
						System.out.println(time);
						jtvo = new J_TimeVO();
						jtvo.setJ_seq(j_seq);
						jtvo.setJ_time_type(time);
						jobsService.JTimeInsert(jtvo);

					}
				}

			}
		}

		model.addAttribute("msg", "공고 등록");
		model.addAttribute("url", "/jobs/list?j_seq=" + j_seq);
		model.addAttribute("su", su);

		return ViewPath.RESULT + "result.jsp";
	}

	@RequestMapping("jobs/list")
	public String list(Model model, JobsVO jvo, HttpSession session, Integer page, String word, String type) {
		Integer m_seq = (Integer) session.getAttribute("login");
		
		if (m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}

		 MemberVO mvo = memberService.selectOne(m_seq);
		
		if (page == null) {
			page = 1;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("word", word);
		map.put("m_seq", m_seq);


		int boardCount = jobsService.getTotal(map);

		Paging paging = new Paging(page, boardCount);

		map.put("first", paging.getFirst());
		map.put("last", paging.getLast());

		List<JobsVO> jlist = jobsService.outOFMember(map);

		int login = (Integer)session.getAttribute("login");
		model.addAttribute("jlist", jlist);
		model.addAttribute("paging", paging);
		model.addAttribute("m_seq", m_seq);
		model.addAttribute("login", login);
		model.addAttribute("mvo", mvo);

		return ViewPath.JOBS + "list.jsp";
	}

	@RequestMapping("jobs/shortList")
	public String shortList(Model model, JobsVO jvo, HttpSession session, Integer page, String word, String type) {
		Integer m_seq = (Integer) session.getAttribute("login");
		
		if (m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}

		if (page == null) {
			page = 1;
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("word", word);
		map.put("m_seq", m_seq);

		int boardCount = jobsService.getTotalShort(map);

		Paging paging = new Paging(page, boardCount);
		
		map.put("first", paging.getFirst());
		map.put("last", paging.getLast());

		List<JobsVO> jlist = jobsService.outOFMemberShort(map);
		model.addAttribute("jlist", jlist);
		model.addAttribute("paging", paging);
		model.addAttribute("m_seq", m_seq);
		
		return ViewPath.JOBS + "shortList.jsp";
	}

	@RequestMapping("jobs/jobsContent")
	public String jobContent(Model model, int j_seq, HttpSession session) {

		int login = (Integer) session.getAttribute("login");
		System.out.println("login" + login);

		Integer m_seq = (Integer) session.getAttribute("login");

		int appCount = jobsService.AppCount(j_seq);

		JobsVO jvo = jobsService.AllJobsOne(j_seq);
		List<J_TimeVO> jtlist = jobsService.getTimeType(j_seq);// 단기 장기 요일 날짜

		String j_details = jvo.getJ_details();

		jvo.setJ_details(j_details.replaceAll("\r\n", "<br>"));

		List<JobsVO> jcnlist = jobsService.CateName(j_seq);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("j_seq", j_seq);
		map.put("m_seq", m_seq);

		ApplicationVO apvo = jobsService.checkDupli(j_seq, m_seq); //해당 게시물에 구인중인 지원자는 여러명임
	
		ApplyVO aplvo = applyService.getApply(login);
		
		//int favCount = jobsService.FavCount(j_seq);

		model.addAttribute("jvo", jvo);
		model.addAttribute("jtlist", jtlist);
		model.addAttribute("appCount", appCount);
		model.addAttribute("login", login);
		model.addAttribute("jcnlist", jcnlist);
		model.addAttribute("apvo", apvo);
		//model.addAttribute("favCount", favCount);
		model.addAttribute("aplvo", aplvo);

		return ViewPath.JOBS + "jobsContent.jsp";
	}
	
//	@RequestMapping(value="jobs/fav/add")
//	@ResponseBody
//	public boolean addFav(int j_seq, HttpSession session) {
//		Integer m_seq = (Integer)session.getAttribute("login");
//		J_FavVO jfvo = new J_FavVO();
//		jfvo.setJ_seq(j_seq);
//		jfvo.setM_seq(m_seq);
//		
//		int check = jobsService.insertFav(jfvo);
//		if(check!=0) {
//			return true;
//		}else {
//			return false;
//		}
//	}
	
//	@RequestMapping(value="jobs/fav/del")
//	@ResponseBody
//	public boolean delFav(int j_seq, HttpSession session) {
//		Integer m_seq = (Integer)session.getAttribute("login");
//		J_FavVO jfvo = new J_FavVO();
//		jfvo.setJ_seq(j_seq);
//		jfvo.setM_seq(m_seq);
//		
//		int check = jobsService.deleteFav(j_seq);
//		if(check!=0) {
//			return true;
//		}else {
//			return false;
//		}
//	}
	
	
//	@RequestMapping(value="jobs/fav/count")
//	@ResponseBody
//	public int favFav(int j_seq, HttpSession session) {
//		
//		int cnt = jobsService.FavCount(j_seq);
//		return cnt;
//	}
	

	// 지원하기 버튼 > 지원내역 insert
	@RequestMapping("/jobs/enter")
	public String jobEnter(HttpSession session, ApplicationVO apcvo, JobsVO jvo, Model model, int j_seq,int m_seq) {
		int apply_seq = jobsService.getApplySeq(m_seq);

		apcvo.setM_seq(m_seq);

		apcvo.setJ_seq(j_seq);
		apcvo.setApply_seq(apply_seq);

		int su = jobsService.insertApp(apcvo);

		String url = null;
		String msg = null;

		model.addAttribute("msg", "지원");
		model.addAttribute("url", "/jobs/list?m_seq=" + m_seq);
		model.addAttribute("su",su);

		return ViewPath.RESULT + "result.jsp";

	}

	@RequestMapping("jobs/applyList")
	public String applyList(int m_seq, Model model) {

		List<ApplicationVO> apclist = jobsService.getApply(m_seq);

		List<ApplicationVO> apclist0 = jobsService.waiting(m_seq);
		List<ApplicationVO> apclist1 = jobsService.doneRecruit(m_seq);
		List<ApplicationVO> apclist3 = jobsService.Rejected(m_seq);

		int allCount = jobsService.appCount(m_seq);
		int appCount0 = jobsService.appCount0(m_seq);
		int appCount1 = jobsService.appCount1(m_seq);
		int appCount3 = jobsService.appCount3(m_seq);

		model.addAttribute("apclist", apclist);
		model.addAttribute("apclist0", apclist0);
		model.addAttribute("apclist1", apclist1);
		model.addAttribute("apclist3", apclist3);
		model.addAttribute("m_seq", m_seq);
		model.addAttribute("allCount", allCount);
		model.addAttribute("appCount0", appCount0);
		model.addAttribute("appCount1", appCount1);
		model.addAttribute("appCount3", appCount3);

		return ViewPath.JOBS + "applyList.jsp";
	}

	@RequestMapping("jobs/deleteApp")
	public String deleteApp(Model model, int j_seq, ApplicationVO apvo, HttpSession session, Integer app_seq) {

		int m_seq = (Integer) session.getAttribute("login");

		String msg = null;
		String url = null;

		apvo.setJ_seq(j_seq);
		apvo.setApp_seq(app_seq);
		apvo.setApp_status(2);

		int su = jobsService.appStatus(apvo);
		
		model.addAttribute("msg", "삭제");
		model.addAttribute("url", "/jobs/applyList?m_seq=" + m_seq);
		model.addAttribute("su", su);

		return ViewPath.RESULT + "result.jsp";
	}

	@RequestMapping("jobs/myjobsform")
	public String myjobsform(Model model, HttpSession session) {

		int m_seq = (Integer) session.getAttribute("login");
		System.out.println("나의 공고관리 회원 시퀀스 : " + m_seq);
		MemberVO mvo = memberService.selectOne(m_seq);

		List<JobsVO> mjlist = jobsService.getJobMember(m_seq);

		model.addAttribute("mjlist", mjlist);
		model.addAttribute("m_seq", m_seq);
		model.addAttribute("mvo",  mvo);

		return ViewPath.JOBS + "myjobsform.jsp";
	}

	@RequestMapping("jobs/jobApplist")
	public String jobApplist() {

		return ViewPath.JOBS + "jobApplist.jsp";
	}

	@RequestMapping("jobs/jobUpdateForm")
	public String jobUpdateForm(JobsVO vo, int j_seq, Model model) {

		JobsVO jvo = jobsService.AllJobsOne(j_seq);
		List<J_CateVO> jclist = jcateService.selectAll();
		List<J_TimeVO> jtlist = jobsService.getTimeType(j_seq);// 단기 장기 요일 날짜
		List<DayVO> dlist = jobsService.selectDayNameList(); // 요일테이블 목록
		
		String j_details = jvo.getJ_details();

		jvo.setJ_details(j_details.replaceAll("\r\n", "<br>"));
		
		List<TermsVO> tlist = jobsService.selectTermsList();

		List<JobsVO> jcnlist = jobsService.CateName(j_seq);
		model.addAttribute("jvo", jvo);
		model.addAttribute("jclist", jclist);
		model.addAttribute("jcnlist", jcnlist);
		model.addAttribute("jtlist", jtlist);
		model.addAttribute("dlist", dlist);
		model.addAttribute("tlist",  tlist);

		return ViewPath.JOBS + "jobUpdateForm.jsp";
	}

	@RequestMapping("jobs/jobUpdateCheck")
	public String jobUpdateCheck(String j_name, String addr_details, JobsVO jvo, Model model, int j_seq, int m_seq,
			HttpServletRequest request, @RequestParam("j_cate_seq") List<Integer> j_cate_seq, String addr3_name) {

		// --------------------------------------------------------------------------------------------------------
		// 사진 업로드
		String savePath = application.getRealPath("/resources/jobs/");

		String j_img = null;
		MultipartFile photo = jvo.getPhoto();

		if (photo != null && !photo.isEmpty()) {
			j_img = photo.getOriginalFilename();// 업로드된 파일명(실제 파일명)

			// file객체 생성
			File saveFile = new File(savePath, j_img);
			if (!saveFile.exists()) {
				saveFile.mkdirs();
			} else {// 파일이 존재하면
				long time = System.currentTimeMillis();

				j_img = String.format("%s%d%s", j_img.substring(0, j_img.lastIndexOf(".")), time,
						j_img.substring(j_img.lastIndexOf(".")));

				saveFile = new File(savePath, j_img);
			}

			try {
				photo.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			jvo.setJ_img(j_img);
		} else {
			jvo.setJ_img(jvo.getJ_img());
		}

		System.out.println("j_img : " + jvo.getJ_img());

		String msg = null;
		String url = null;

		if (j_cate_seq.size() == 3) {
			jvo.setJ_cate_seq1(j_cate_seq.get(0));
			jvo.setJ_cate_seq2(j_cate_seq.get(1));
			jvo.setJ_cate_seq3(j_cate_seq.get(2));
		} else if (j_cate_seq.size() == 2) {
			jvo.setJ_cate_seq1(j_cate_seq.get(0));
			jvo.setJ_cate_seq2(j_cate_seq.get(1));
			jvo.setJ_cate_seq3(0);
		} else if (j_cate_seq.size() == 1) {
			jvo.setJ_cate_seq1(j_cate_seq.get(0));
			jvo.setJ_cate_seq2(0);
			jvo.setJ_cate_seq3(0);
		}
		
		jvo.setJ_seq(j_seq);
		jvo.setM_seq(m_seq);

		int addr3_no = memberService.selectAddr3_No(addr3_name);
		jvo.setAddr3_no(addr3_no);

		String[] j_time_type1 = request.getParameterValues("j_time_type1"); // 단기
		String[] j_time_type2 = request.getParameterValues("j_time_type2"); // 장기

		J_TimeVO jtvo = new J_TimeVO();
		String j_details = jvo.getJ_details();

		jvo.setJ_details(j_details.replaceAll("\r\n", "<br>"));
		
		int su = jobsService.updateJob(jvo);
		if (su != 0) {
			int lo = jvo.getJ_long();
			if (lo != 0) { // 단기

				if (j_time_type1 != null) {

					jobsService.JTimeDelete(j_seq);

					for (String time : j_time_type1) { // 단기
						System.out.println("전달된 단기 요일 :" + time);
						jtvo = new J_TimeVO();
						jtvo.setJ_seq(j_seq);
						jtvo.setJ_time_type(time);

						jobsService.JTimeInsert(jtvo);

					}
				} else {
					jtvo.setJ_time_type(null);
				}

			} else {

				if (j_time_type2 != null) {
					jobsService.JTimeDelete(j_seq);

					for (String time : j_time_type2) { // 장기
						System.out.println(time);
						jtvo = new J_TimeVO();
						jtvo.setJ_seq(j_seq);
						jtvo.setJ_time_type(time);
						jobsService.JTimeInsert(jtvo);

					}
				}

			}
		} 

		model.addAttribute("msg","공고 수정");
		model.addAttribute("url", "/jobs/mypage?j_seq=" + j_seq +"&m_seq=" + m_seq);
		model.addAttribute("su", su);

		return ViewPath.RESULT + "result.jsp";
		// -------------------------------------------------------------------------------------------------------

	}

	// 공고게시물 삭제
	@RequestMapping("jobs/jobDelete")
	public String jobDelete(int j_seq, JobsVO jvo, Model model,HttpSession session) {
		int m_seq= (Integer)session.getAttribute("login");

		jvo.setJ_seq(j_seq);
		jvo.setJ_done(2);

		int su = jobsService.statusChange(jvo);
		String msg = null;
		String url = null;

		model.addAttribute("msg","삭제");
		model.addAttribute("url", "/jobs/myjobsform?m_seq="+m_seq);
		model.addAttribute("su", su);
		return ViewPath.RESULT + "result.jsp";

	}

	@RequestMapping("jobs/applicants")
	public String Applicants(int j_seq, Model model,HttpSession session) {
		int m_seq= (Integer)session.getAttribute("login");

		List<ApplyVO> aplist = jobsService.ApplicantInfo(j_seq);
		List<ApplyVO> aplist1 = jobsService.ApplicantInfo1(j_seq);
		List<ApplyVO> aplist2 = jobsService.ApplicantInfo2(j_seq);
		List<ApplyVO> aplist3 = jobsService.ApplicantInfo3(j_seq);

		model.addAttribute("aplist", aplist);
		model.addAttribute("aplist1", aplist1);
		model.addAttribute("aplist2", aplist2);
		model.addAttribute("aplist3", aplist3);
		return ViewPath.JOBS + "applicants.jsp";

	}

	@RequestMapping("jobs/reject")
	public String jobReject(Integer j_seq, JobsVO jvo, Model model, ApplicationVO apvo, Integer app_seq,HttpSession session) {
		// 공고 게시물에 지원한 지원내역 거절함
		// 지원서 상태도 업데이트 3으로 해줘야함 --거절됨
		System.out.println("app_seq : " + app_seq);
		
		int m_seq= (Integer)session.getAttribute("login");

		jvo.setJ_seq(j_seq);
		jvo.setJ_done(3);

		apvo.setJ_seq(j_seq);
		apvo.setApp_seq(app_seq);
		apvo.setApp_status(3);

		String msg = null;
		String url = null;

		int su = jobsService.statusChange(jvo);
	
		if (su != 0) {
			int asu = jobsService.appStatus(apvo);
		
		}
		
		model.addAttribute("msg", "거절");
		model.addAttribute("url", "/jobs/applicants?j_seq=" + j_seq+"& m_seq="+m_seq);
		model.addAttribute("su",su);

		return ViewPath.RESULT + "result.jsp";
	}

	@RequestMapping("jobs/resume")
	public String resumeConfirm(Model model, int m_seq) {

		int excount = experienceService.getCount(m_seq);
		MemberVO mvo = memberService.selectOne(m_seq);

		model.addAttribute("mvo", mvo);
		Double degree = memberService.getDegree(m_seq);

		List<ExperienceVO> elist = experienceService.selectOne(m_seq);

		ApplyVO avo = applyService.getApply(m_seq);

		model.addAttribute("degree", degree);
		model.addAttribute("elist", elist);
		model.addAttribute("avo", avo);
		model.addAttribute("excount", excount);

		return ViewPath.JOBS + "resume.jsp";
	}

	@RequestMapping("jobs/recruit")
	public String recruit(int j_seq, Integer app_seq, ApplicationVO apvo, Model model) {

		apvo.setJ_seq(j_seq);
		apvo.setApp_seq(app_seq);
		apvo.setApp_status(1);

		String msg = null;
		String url = null;

		int asu = jobsService.appStatus(apvo);

		model.addAttribute("msg","채용");
		model.addAttribute("url", "/jobs/applicants?j_seq=" + j_seq);
		model.addAttribute("su", asu);

		return ViewPath.RESULT + "result.jsp";

	}

//공고 게시물 채용완료
	@RequestMapping("jobs/doneJob")
	public String doneJob(int j_seq, JobsVO jvo, Model model) {
		jvo.setJ_seq(j_seq);
		jvo.setJ_done(1);

		String msg = null;
		String url = null;

		int su = jobsService.statusChange(jvo);
	
		model.addAttribute("msg","채용");
		model.addAttribute("url", "/jobs/myjobsform?j_seq=" + j_seq);
		model.addAttribute("su", su);

		return ViewPath.RESULT + "result.jsp";

	}
//	@RequestMapping("jobs/fav")
//	public String Fav(Integer m_seq,Integer j_seq, J_FavVO jfvo,Model model) {
//		
//		jfvo.setJ_seq(j_seq);
//		jfvo.setM_seq(m_seq);
//		
//		int su = jobsService.insertFav(jfvo);
//		
//		String msg = null;
//		String url = null;
//	
//		model.addAttribute("url","/jobs/jobsContent?j_seq=" + j_seq+"&m_seq="+m_seq);
//		model.addAttribute("url", "관심 내역에 추가");
//		model.addAttribute("su", su);
//		return ViewPath.RESULT + "result.jsp";
//
//	}
	
}
