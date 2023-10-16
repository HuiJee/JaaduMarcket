package service.board;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.AbstractMultipartHttpServletRequest;

import dao.board.BoardDAO;
import dao.board.Board_ImgDAO;
import vo.board.BoardVO;
import vo.board.Board_ImgVO;

public class BoardService {

	private BoardDAO boardDao;
	private Board_ImgDAO board_imgDao;

	public BoardService(BoardDAO boardDao, 
						Board_ImgDAO board_imgDao) {
		this.boardDao = boardDao;
		this.board_imgDao = board_imgDao;
	}

	public List<BoardVO> selectList(Map<String, Object> map) {
		
		List<BoardVO> list = boardDao.selectList(map);
		
		if(list.isEmpty()) {
			list = null;
		}
		
		return list;
	}
	
	public BoardVO selectOne(int seq) {
		return boardDao.selectOne(seq);
	}
	
	public int getTotal(Map<String, Object> map) {
		return boardDao.getTotal(map);
	}

	public Map<String, Object> getContent(int board_seq){
		boardDao.readCount(board_seq);
		
		Map<String, Object> map = boardDao.getContent(board_seq);
			
		return map;
	}
	
	public int delete(int seq) {
		return boardDao.delete(seq);
	}
	
	public int update(BoardVO vo) {
		return boardDao.update(vo);
	}

	
	public int insert(BoardVO vo) {
		return boardDao.insert(vo);
	}
	
	public int maxBoard_Seq() {
		return boardDao.maxBoard_Seq();
	}
	
	

	public void insertBoard_Img(List<Board_ImgVO> files) {
		for(Board_ImgVO vo : files) {
			board_imgDao.insert(vo);
		}
	}


	public void updateBoard_Img(List<Board_ImgVO> files) {
		for(Board_ImgVO vo : files) {
			board_imgDao.update(vo);
		}
	}
	
	public int deleteBoard_Img(int board_img_seq) {
		return board_imgDao.delete(board_img_seq);
	}
	
	
	public List<Board_ImgVO> selectBoard_ImgList(int board_seq){
		return board_imgDao.selectBoard_ImgList(board_seq);
	}
	
	
}



