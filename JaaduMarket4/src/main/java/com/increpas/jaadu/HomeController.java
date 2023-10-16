package com.increpas.jaadu;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import common.ViewPath;
import service.member.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private MemberService memberService;
	
	public HomeController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping({"/", "/home"})
	public String home(Model model) {
		List<String> list = memberService.topKey();
		model.addAttribute("list", list);
		return ViewPath.MAIN + "index.jsp";
	}
	@RequestMapping("/intro")
	public String intro() {
		
		return ViewPath.ADMIN + "intro.jsp";
	}
	
}
