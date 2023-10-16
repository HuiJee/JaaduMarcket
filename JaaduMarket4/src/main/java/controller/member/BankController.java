package controller.member;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.swing.text.View;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import common.ViewPath;
import service.member.BankService;
import vo.member.BankVO;
import vo.member.Bank_AccountVO;
import vo.member.MemberVO;

@Controller
public class BankController {

	private BankService bankService;
	
	public BankController(BankService bankService) {
		this.bankService = bankService;
	}
	
	@RequestMapping("/pay/identity/{mode}")
	public String identity(@PathVariable("mode")String mode, Model model) {
		model.addAttribute(mode);
		return ViewPath.MEMBER + "identity.jsp";
	}
	
	@RequestMapping("/pay/check/{mode}")
	public String check(MemberVO vo, Model model, HttpSession session, @PathVariable("mode")String mode){
		Integer m_seq = (Integer)session.getAttribute("login");
		
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}
		
		int su = bankService.payIdentity(vo);
		
		String url = "/pay/insertform";
		
		if(mode.equals("update")) {
			url = "/pay/updateform";
		}
		model.addAttribute("su", su);
		model.addAttribute("url", url);
		model.addAttribute("msg", "본인인증");
		
		return ViewPath.RESULT + "result.jsp";
	}
	
	@RequestMapping("/pay/insertform")
	public String insertForm(Model model) {
		List<BankVO> list = bankService.selectList();
		
		model.addAttribute("list", list);
		return ViewPath.MEMBER + "payInsert.jsp";
	}
	
	@RequestMapping("/pay/updateform")
	public String updateForm(Model model, HttpSession session) {
		Integer m_seq = (Integer)session.getAttribute("login");
		
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}
		
		Bank_AccountVO bvo = bankService.accountOne(m_seq);
		
		List<BankVO> list = bankService.selectList();
		
		model.addAttribute("bvo", bvo);
		model.addAttribute("list", list);
		return ViewPath.MEMBER + "payUpdate.jsp";
	}
	
	@RequestMapping("/pay/insert")
	public String insert(HttpSession session, Bank_AccountVO vo, Model model) {
		Integer m_seq = (Integer) session.getAttribute("login");
		
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}
		
		vo.setM_seq(m_seq);
		
		int su = bankService.accountInsert(vo);
		
		if(su!=0) {
			su = bankService.payStatus(m_seq);
		}
		
		model.addAttribute("su", su);
		model.addAttribute("url","/member/mypage");
		model.addAttribute("msg", "자두페이 등록");
		return ViewPath.RESULT + "popResult.jsp";
	}
	
	@RequestMapping("/pay/update")
	public String update(HttpSession session, Bank_AccountVO vo, Model model) {
		Integer m_seq = (Integer) session.getAttribute("login");
		
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}
		
		Bank_AccountVO bvo = bankService.accountOne(m_seq);
		bvo.setBank_seq(vo.getBank_seq());
		bvo.setBank_account_num(vo.getBank_account_num());
		
		int su = bankService.accountUpdate(bvo);
		
		model.addAttribute("su", su);
		model.addAttribute("url","/member/mypage");
		model.addAttribute("msg", "자두페이 수정");
		return ViewPath.RESULT + "popResult.jsp";
	}
	
	@RequestMapping("/pay/chargeform")
	public String chargeForm(HttpSession session, Model model) {
		Integer m_seq = (Integer)session.getAttribute("login");
		
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}
		
		Bank_AccountVO bvo = bankService.accountOne(m_seq);
		
		model.addAttribute("bvo", bvo);
		return ViewPath.MEMBER + "charge.jsp";
	}
	
	@RequestMapping("/pay/charge")
	public String chargePoint(Bank_AccountVO vo, HttpSession session, Model model) {
		Integer m_seq = (Integer)session.getAttribute("login");
		
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}
		
		vo.setM_seq(m_seq);
		
		int su = bankService.chargePoint(vo);
		
		model.addAttribute("su", su);
		model.addAttribute("url", "/member/mypage");
		model.addAttribute("msg", "자두페이 충전");
		return ViewPath.RESULT + "popResult.jsp";
	}
	
}
