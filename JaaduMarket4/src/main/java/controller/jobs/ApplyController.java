package controller.jobs;

import java.time.Year;
import java.util.List;

//import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import common.ViewPath;
import service.jobs.ApplyService;
import service.jobs.ExperienceService;
import service.jobs.J_PeriodService;
import service.member.MemberService;
import vo.jobs.ApplyVO;
import vo.jobs.ExperienceVO;
import vo.jobs.J_PeriodVO;
import vo.member.MemberVO;

@Controller
public class ApplyController {
	private ApplyService applyService;
	private MemberService memberService;
	private J_PeriodService jperiodService;
	private ExperienceService experienceService;

	public ApplyController(ApplyService applyServic, MemberService memberService, J_PeriodService jperiodService,
			ExperienceService experienceService) {
		this.applyService = applyServic;
		this.memberService = memberService;
		this.jperiodService = jperiodService;
		this.experienceService = experienceService;
	}

	@RequestMapping("/jobs/mypage")
	public String myJobPage(Model model, HttpSession session) {
		Integer no = (Integer) session.getAttribute("login");

		if (no == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}

		MemberVO vo = memberService.selectOne(no);

		model.addAttribute("vo", vo);
		Double degree = memberService.getDegree(no);

		model.addAttribute("degree", degree);

		return ViewPath.JOBS + "mypage.jsp";
	}

	@RequestMapping("/jobs/applyform") // @RequestParam : 뷰페이지에서 서버로 전달한 값을 받는 어노테이션
	public String applyForm(Model model, HttpSession session) {

		int no = (Integer) session.getAttribute("login");

		session.setAttribute("returnPage", "applyform"); // returnPage 값을 "applyform"으로 설정(경험등록 후 returnPage로 이동시키기 위해!)

		MemberVO mvo = memberService.selectOne(no);

		ApplyVO avo = applyService.getApply(no);

		List<ExperienceVO> elist = experienceService.selectOne(no);

		model.addAttribute("mvo", mvo);

		model.addAttribute("elist", elist);
		model.addAttribute("avo", avo);

		return ViewPath.JOBS + "apply.jsp";
	}

	@RequestMapping("/jobs/careerform")
	public String careerForm(Model model) {

		List<J_PeriodVO> list = jperiodService.getList();

		int currentYear = Year.now().getValue();
		model.addAttribute("list", list);
		model.addAttribute("currentYear", currentYear);
		return ViewPath.JOBS + "career.jsp";

	}

	@RequestMapping("/jobs/applycheck")
	public String applyCheck(Model model, HttpSession session, /* MemberVO mvo */ ApplyVO avo,
			HttpServletRequest request) {
		int m_seq = (Integer) session.getAttribute("login");

		String msg = null;
		String url = null;

		avo.setM_seq(m_seq);

		// avo 객체의 PROFILE 필드 값이 null인 경우 처리
		if (avo.getProfile() == null) {
			avo.setProfile(""); // 빈 문자열로 설정하거나 원하는 기본값으로 설정
		}
		// avo 객체의 PROFILE_URL 필드 값이 null인 경우 처리
		if (avo.getProfile_url() == null) {
			avo.setProfile_url(""); // 빈 문자열로 설정하거나 원하는 기본값으로 설정
		}

		int asu = applyService.insert(avo);
		
		model.addAttribute("msg", "자두 알바 지원서 작성");
		model.addAttribute("url", "/jobs/mypage?m_seq="+m_seq);
		model.addAttribute("su", asu);

		return ViewPath.RESULT + "result.jsp";

	}

	@RequestMapping("/jobs/content")
	public String content(Model model, HttpSession session) {
		Integer no = (Integer) session.getAttribute("login");

		if (no == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}

		int excount = experienceService.getCount(no);

		MemberVO mvo = memberService.selectOne(no);

		model.addAttribute("mvo", mvo);
		Double degree = memberService.getDegree(no);

		List<ExperienceVO> elist = experienceService.selectOne(no);

		ApplyVO avo = applyService.getApply(no);

		model.addAttribute("degree", degree);
		model.addAttribute("elist", elist);
		model.addAttribute("avo", avo);
		model.addAttribute("excount", excount);

		return ViewPath.JOBS + "content.jsp";
	}

	@RequestMapping("jobs/updateform")
	public String updateForm(Model model, @RequestParam("m_seq") int m_seq, HttpSession session) {

		session.setAttribute("returnPage", "updateform"); // returnPage 값을 "updateform"으로 설정(경험등록 후 returnPage로 이동시키기
															// 위해!)
		MemberVO mvo = memberService.selectOne(m_seq);

		ApplyVO avo = applyService.getApply(m_seq);

		List<ExperienceVO> elist = experienceService.selectOne(m_seq);

		model.addAttribute("mvo", mvo);
		model.addAttribute("avo", avo);
		model.addAttribute("elist", elist);

		return ViewPath.JOBS + "updateForm.jsp";
	}

	@RequestMapping("jobs/update")
	public String update(Model model, HttpSession session, MemberVO mvo, ApplyVO avo, HttpServletRequest request) {
		int m_seq = (Integer) session.getAttribute("login");
		
		avo = applyService.getSelect(m_seq);

		String msg = null;
		String url = null;

			avo.setM_seq(m_seq);
			avo.setM_name(request.getParameter("m_name"));
			avo.setProfile(request.getParameter("profile"));
			avo.setProfile_url(request.getParameter("profile_url"));
			avo.setMy_info(request.getParameter("my_info"));

			// Apply 데이터 null값 처리
			if (avo.getProfile() == null) {
				avo.setProfile("");// 빈 문자열로 설정

			}
			if (avo.getProfile_url() == null) {
				avo.setProfile_url("");
			}

			int asu = applyService.update(avo);
	
		model.addAttribute("msg","자두 알바 지원서 수정");
		model.addAttribute("url", "/jobs/content?m_seq?"+m_seq);
		model.addAttribute("su", asu);

		return ViewPath.RESULT + "result.jsp";
	}

	@RequestMapping("jobs/delete")
	public String deleteForm(Integer m_seq, HttpSession session, Model model,ApplyVO apvo) {
		// int m_seq로 작성할시 에러 남 >>Integer로 바꿔줘야함
		// int는 원시 데이터 타입(primitive data type)이고, Integer는 객체 래퍼 클래스(wrapper class)타입
		// null 값을 가질 수 있는 객체 타입을 사용하는 것이 유연성과 안정성을 높일 수 있음
		
		m_seq = (Integer) session.getAttribute("login");
		apvo.setM_seq(m_seq);
		
		String url = null;
		String msg = null;
		
		
		int su = applyService.delete(apvo);

		if (su != 0) {

			 experienceService.delete(m_seq);
		}
		
		model.addAttribute("msg", "자두 알바 지원서 삭제");
		model.addAttribute("url", "/jobs/content?m_seq"+m_seq);
		model.addAttribute("su", su);
		
		return ViewPath.RESULT + "result.jsp";
	}
	
}










