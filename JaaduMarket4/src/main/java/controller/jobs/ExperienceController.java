package controller.jobs;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import common.ViewPath;
import service.jobs.ExperienceService;
import service.jobs.J_PeriodService;
import vo.jobs.ExperienceVO;
import vo.jobs.J_PeriodVO;

@Controller
public class ExperienceController {

	private ExperienceService experienceService;
	private J_PeriodService jperiodService;

	public ExperienceController(ExperienceService experienceService,J_PeriodService jperiodService) {
		this.experienceService = experienceService;
		this.jperiodService = jperiodService;
		
	}

	@RequestMapping("/jobs/careercheck")
	public String insert(Model model, ExperienceVO vo, HttpSession session) {
		int m_seq = (Integer) session.getAttribute("login");

		vo.setM_seq(m_seq);
		// 내용란 설정
		String content = vo.getJ_details();
		vo.setJ_details(content.replaceAll("\r\n", "<br>"));

		int su = experienceService.insert(vo);

		String url = null;
		String msg = null;

		String returnPage = (String) session.getAttribute("returnPage");// 서버에 저장해둔 returnPage(applyform/updateform) 가져옴

		if (su != 0) {
			msg = "경험 등록 완료!";
			if (returnPage.equals("applyform")) {
				url = "/jobs/applyform?m_seq=" + m_seq;// 등록 완료 후 지원작성 중이던 페이지로 가게 되면 m_seq로 경험 추가한 정보 넘겨야함
			} else if (returnPage.equals("updateform")) {
				url = "/jobs/updateform?m_seq=" + m_seq;// 등록완료 후 returnPage가 updateform(수정페이지)로 이동됨
			}
		} else {
			msg = "경험 등록 실패! 이전 페이지로..";
			//url = "history.back()";
		}

		model.addAttribute("url", url);
		model.addAttribute("msg", msg);

		return ViewPath.RESULT + "result.jsp";

	}

	@RequestMapping("/jobs/careeDelete")
	public String delete(@RequestParam("experience_seq")Integer experience_seq, Model model, HttpSession session) {
		int m_seq = (Integer) session.getAttribute("login");
		int su = experienceService.deleteOne(experience_seq);

		String returnPage = (String) session.getAttribute("returnPage");

		String url = null;
		String msg = null;

		if (su != 0) {
			msg = "삭제 성공!";
			if (returnPage.equals("applyform")) {
				url = "/jobs/applyform?m_seq=" + m_seq;
			}else if(returnPage.equals("updateform")) {
				url = "/jobs/updateform?m_seq=" + m_seq;
			}
		} else {
			msg = "삭제 실패!";
			url = "history.back()";
		}

		model.addAttribute("url", url);
		model.addAttribute("msg", msg);

		return ViewPath.RESULT + "result.jsp";

	}
	
	@RequestMapping("jobs/careerUpdateForm")
	public String updateForm(@RequestParam("experience_seq") Integer experience_seq, Model model, ExperienceVO evo) {
		
		evo = experienceService.expOne(experience_seq);
		
		List<J_PeriodVO> plist = jperiodService.getList();
		
		model.addAttribute("evo", evo);
		model.addAttribute("plist", plist);
		
		return ViewPath.JOBS + "careerUpdate.jsp";
	}
	
	@RequestMapping("jobs/careerUpdate")
	public String update(@RequestParam("experience_seq")Integer experience_seq, ExperienceVO evo, HttpServletRequest request,Model model) {
		
		HttpSession session = request.getSession();
		
		int m_seq= (Integer)session.getAttribute("login");
		
		evo = experienceService.expOne(experience_seq);
		
		String url = null;
		String msg = null;

		String returnPage = (String) session.getAttribute("returnPage");
		
		evo.setJ_place(request.getParameter("j_place"));
		evo.setJ_year(request.getParameter("j_year"));
		evo.setJ_period(request.getParameter("j_period"));
		evo.setJ_details(request.getParameter("j_details"));
		
		System.out.println("변경 장소 " + evo.getJ_place() );
		System.out.println("변경 년도 " + evo.getJ_year() );
		System.out.println("변경 기간 " + evo.getJ_period() );
		System.out.println("변경 내용 " + evo.getJ_details() );
		
		int su = experienceService.updateOne(evo);
		if (su != 0) {
			msg = "수정 성공!";
			if (returnPage.equals("applyform")) {
				url = "/jobs/applyform?m_seq=" + m_seq;
			}else if(returnPage.equals("updateform")) {
				url = "/jobs/updateform?m_seq=" + m_seq;
			}
		} else {
			msg = "수정 실패!";
			url = "history.back()";
		}
		
		model.addAttribute("url",url);
		model.addAttribute("msg",msg);
		
		return ViewPath.RESULT + "result.jsp";
	}
	
	

}
