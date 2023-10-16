package controller.busi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import common.Paging;
import common.ViewPath;
import service.busi.BusiService;
import vo.addr.Addr3VO;
import vo.busi.BusiVO;
import vo.busi.Busi_CateVO;

@Controller
public class MakeBusiController {

	private BusiService busiService;
	@Autowired
	private ServletContext application;
	
	
	public MakeBusiController(BusiService busiService) {
		this.busiService = busiService;
	}
	
	
	@RequestMapping("/views/makeBusi")
	public String stores(HttpServletRequest request, Integer page) {
		Integer m_seq = (Integer)request.getSession().getAttribute("login");
		if(page == null) {
			page = 1;
		}
		
		List<Busi_CateVO> busi_cateList = busiService.selectBusiCateList();
		
		List<BusiVO> busiList = busiService.selectList().isEmpty() ? null : busiService.selectList();
		
		if(busiList != null) {
			for(int i = 0; i < busiList.size(); i++ ) {
				String information = "";
				if(busiList.get(i).getBusi_information() == null){
					information = "";
				}else {
					information = busiList.get(i).getBusi_information();
					if(busiList.get(i).getBusi_information().length() >= 32) {
						busiList.get(i).setBusi_information(information.substring(1, 32) + " ....");
					}
				}
			}
		}
		
		int busiCount = busiService.getTotal();
		Paging paging = new Paging(page, busiCount);
		
		request.setAttribute("paging", paging);
		request.setAttribute("busiList", busiList);
		request.setAttribute("busi_cateList", busi_cateList);
		request.setAttribute("m_seq", m_seq);
		return ViewPath.MAKEBUSI + "list.jsp";
	}
	
	
	@RequestMapping("/makeBusi/intro")
	public String intro() {
		return ViewPath.MAKEBUSI + "intro.jsp";
	}
	
	
	@RequestMapping("/makeBusi/makeBusiForm")
	public String makeBusi(HttpServletRequest request) {
		Integer m_seq = (Integer)request.getSession().getAttribute("login");
			
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}
		
		request.setAttribute("m_seq", m_seq);
		
		return ViewPath.MAKEBUSI + "makeBusiForm.jsp";
	}
	
	
	
	@RequestMapping("/views/makeBusi/makeBusiExplain")
	public String makeBusiExplain() {
		return ViewPath.MAKEBUSI + "makeBusiExplain.jsp";
	}
	
	@RequestMapping("/addr/search")
	public String search() {
		return ViewPath.MAKEBUSI + "addrSearch.jsp";
	}
	
	@RequestMapping("/makeBusi/searchCheck")
	public String searchCheck(@RequestParam("addr3_name") String addr3_name, HttpServletRequest request) {
		
		List<Addr3VO> addrlist = busiService.searchAddr3(addr3_name);
		
		request.setAttribute("addrlist", addrlist);
		request.setAttribute("addr3_name", addr3_name);
		return ViewPath.MAKEBUSI + "addrSearchResult.jsp";
	}
	
	

	@RequestMapping("/makebusi/myBusi")
	public String mystores(HttpServletRequest request, BusiVO vo, String addr3_name) {
		
		Integer m_seq = (Integer)request.getSession().getAttribute("login");
		if(m_seq == null) {
			return "redirect:/login/loginform";
		}
		
		
		String savePath = application.getRealPath("/resources/busiProfileImg");
		String busi_img = null;
		
		MultipartFile photo = vo.getPhoto();
		
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
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			vo.setBusi_img(busi_img);
			
		}else {
			vo.setBusi_img("no_file");
		}
		
		int start = addr3_name.lastIndexOf(" ");
		String addr3 = addr3_name.substring(start+1);
		
		int addr3_no = busiService.selectAddr3_No(addr3);
		
		vo.setM_seq(m_seq);
		vo.setBusi_name(vo.getBusi_name());
		vo.setBusi_cate_seq(vo.getBusi_cate_seq());
		vo.setBusi_tel1(vo.getBusi_tel1());
		vo.setBusi_tel2(vo.getBusi_tel2());
		vo.setBusi_tel3(vo.getBusi_tel3());
		vo.setAddr3_no(addr3_no);
		vo.setBusi_addr_detail(vo.getBusi_addr_detail());
		vo.setBusi_number(vo.getBusi_number());
		
		String msg = "";
		String url = "";
		
		try {
			int su = busiService.insert(vo);
			if(su != 0) {
				int busi_seq = busiService.maxSeq();
				msg = "환영합니다. 비즈계정이 생성되었습니다.:)";
				url = "/jaadu/busi/myBusi?busi_seq="+busi_seq;
				
			}else {
				msg = "비즈계정 생성에 실패하였습니다.:(";
				url = "history.back()";
			}
		}catch(Exception e) {
			msg = "비즈계정 생성에 실패하였습니다.:(";
			url = "history.back()";
			e.printStackTrace();
			
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			
			return ViewPath.INDEX + "result.jsp";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return ViewPath.INDEX + "result.jsp";
		
	}
	
	@RequestMapping("/makeBusi/myBusiList")
	public String myStoresList(HttpServletRequest request) {
		Integer m_seq = (Integer) request.getSession().getAttribute("login");
		if(m_seq ==  null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}
		
		List<BusiVO> busilist = busiService.selectMyBusiList(m_seq);
		
		if(busilist.isEmpty()) {
			busilist = null;
		}else {
			for(int i = 0; i < busilist.size(); i++) {
				
				busilist.get(i).setAddr3_name(busiService.selectAddr3_Name(busilist.get(i).getAddr3_no()));
			}
		}
		
		request.setAttribute("busilist", busilist);
		
		return ViewPath.MAKEBUSI + "myBusiList.jsp";
	}
	
	

	
	
	
	
	
	
}
