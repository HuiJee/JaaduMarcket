package controller.board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import common.Paging;
import common.ViewPath;
import service.board.BoardService;
import vo.board.BoardVO;
import vo.board.Board_ImgVO;

@Controller
public class BoardController {

	private BoardService boardService;
	//private Board_ImgService board_ImgService;
	
	@Autowired
	private ServletContext application;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
		//this.board_ImgService = board_imgService;
	}

	
	@RequestMapping("/board/list")
	public String list(Model model, Integer page, String type, String word) {
		
		if(page == null) {
			page = 1;
		}
		
		if(type != null && type.equals("")) {
			type = null;
			word = null;
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("type", type);
		map.put("word", word);
		
		int boardCount = boardService.getTotal(map);
		
		Paging paging = new Paging(page, boardCount);
		
		map.put("first", paging.getFirst()); 
		map.put("last", paging.getLast());
		
		List<BoardVO> list = boardService.selectList(map);		
		
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
		
		
		
		return ViewPath.BOARD + "list.jsp";
		
	}
	
	@RequestMapping("/board/writeform")
	public String writeForm() {
		return ViewPath.BOARD + "write.jsp";
	}
	
//	@RequestMapping("/board/write")
//	public String wirte(Model model, HttpSession session, BoardVO vo) {
//		Integer m_seq = (Integer)session.getAttribute("login");
//		
//		if(m_seq == null) {
//			return "redirect:/login/loginform";
//		}
//			vo.getBoard_title();
//			vo.getBoard_content();
//			
//			BoardVO bvo = new BoardVO();
//			bvo.setM_seq(m_seq);
//			bvo.setBoard_content(vo.getBoard_content());
//			int su = boardService.insert(bvo);
//			
//			model.addAttribute("su" , su);
//			model.addAttribute("status", "write");
//			model.addAttribute("url", "/jaadu/board/list");
//			
//		return ViewPath.BOARD + "result.jsp";
//	}
	

	@RequestMapping("/board/content")
	public String content(Model model, @RequestParam("board_seq") int board_seq) {
		
		//BoardVO map = boardService.selectOne(seq);
		Map<String, Object> map = boardService.getContent(board_seq);
		List<Board_ImgVO> ilist= boardService.selectBoard_ImgList(board_seq);
		
		model.addAttribute("ilist", ilist);
		model.addAttribute("vo", map);
		
		
		return ViewPath.BOARD + "content.jsp";
	}
	
	@RequestMapping("/board/updateForm")
	public String updateForm(Model model,int board_seq) {
		BoardVO vo = boardService.selectOne(board_seq);
		
		String content = vo.getBoard_content();
		
		vo.setBoard_content(content.replaceAll("<br>", "\r\n"));
		
		model.addAttribute("vo", vo);
		
		return ViewPath.BOARD + "update.jsp";
	}
	
	@RequestMapping("/board/update")
	public String update(Model model,BoardVO vo) {
		
		String content = vo.getBoard_content();
		
		vo.setBoard_content(content.replaceAll("\r\n", "<br>"));
		
		int su = boardService.update(vo);
		
		
		model.addAttribute("su", su);
		model.addAttribute("status", "update");
		model.addAttribute("url", "/jaadu/board/content?board_seq=" + vo.getBoard_seq());
		
		return ViewPath.BOARD + "result.jsp";
		
	}
	
	@RequestMapping("/board/delete")
	public String delete(Model model,int board_seq) {
		
		
		int su = boardService.delete(board_seq);
		
		model.addAttribute("su", su);
		model.addAttribute("status", "delete");
		model.addAttribute("url", "/jaadu/board/list");
		
		return ViewPath.BOARD + "result.jsp";
	}
	
//	@Autowired
//	private ServletContext application;
//	
//	
//	@RequestMapping("/board/File")
//	public String upload(Model model, Board_ImgVO vo) {
//		
//		String savePath = application.getRealPath("/resours/Board_img/");
//		
//		String Board_img_name = null;
//		
//		MultipartFile photo = vo.getPhoto();
//		
//		if(photo != null && !photo.isEmpty()) {
//			
//			Board_img_name = photo.getOriginalFilename();
//			
//			File saveFile = new File(savePath, Board_img_name);
//			
//			if(!saveFile.exists()) {
//				saveFile.mkdir();
//			}else {
//				long time = System.currentTimeMillis();
//				
//				Board_img_name = String.format("%s%d%s", Board_img_name.substring(0, Board_img_name.lastIndexOf(".")),time,Board_img_name.substring(Board_img_name.lastIndexOf(".")));
//			
//				saveFile = new File(savePath,Board_img_name);
//			}
//			
//			//업로드된 파일은 MultipartResolver라는 클래스가 지정한 임시 저장소에 저장되어 있다...
//			//파일이 일정한 시간이 지나면 사라지기 때문에 내가 지정한 경로로 복사해주면 된다...
//			
//			try {
//				photo.transferTo(saveFile);
//			} catch (IllegalStateException | IOException e) {
//				e.printStackTrace();
//			}
//			
//			vo.setBoard_img_name(Board_img_name);
//		}else {
//			vo.setBoard_img_name("no_board_img_seq");
//		}
//		
//		//DB에 저장...insert...
//		
//		
//		model.addAttribute("vo", vo);
//		
//		return ViewPath.BOARD + "write.jsp";
//	}
	
	@RequestMapping("/board/write")
	public String mystores(HttpServletRequest request, Board_ImgVO vo, BoardVO ovo) {
		
		
		Integer m_seq = (Integer)request.getSession().getAttribute("login");
		if(m_seq == null) {
			return ViewPath.RESULT + "goLogin.jsp";
		}
		BoardVO bvo = new BoardVO();
		
		bvo.setBoard_title(ovo.getBoard_title());
		bvo.setBoard_content(ovo.getBoard_content());
		bvo.setM_seq(m_seq);
		
		int su = boardService.insert(bvo);
		
		int board_seq = boardService.maxBoard_Seq();
		
		String msg ="";
		String url ="";
		System.out.println("글 인서트 돼?: " + su);
		System.out.println("방금 쓴 게시글 시퀀스?: " + board_seq);
		if(su != 0) {
			List<MultipartFile> list = vo.getFiles();
			System.out.println("사진 가져와?: " + list);
			String savePath = application.getRealPath("/resources/Board_img/" + board_seq);
			System.out.println("경로는?: " + savePath);
			if(list != null && !list.isEmpty()) {
				List<Board_ImgVO> blist = new ArrayList<Board_ImgVO>();
				
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
						} catch (IllegalStateException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
						blist.add(new Board_ImgVO(board_seq, filename));
					}
				}
				boardService.insertBoard_Img(blist);
			}
				msg="게시판 업로드 성공";
				url="/jaadu/board/list";
		}else {
			msg="업로드 실패";
		}
			
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		request.setAttribute("su", su);
		
		return ViewPath.BOARD + "result.jsp";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	

