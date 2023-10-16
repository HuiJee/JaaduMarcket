package vo.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Board_ImgVO { //자유게시판_이미지 
	
	private List<MultipartFile> files;
	
	private int board_img_seq;
	private int board_seq;	
	private String board_img_name;
	
	public Board_ImgVO() {
		
	}
	
	public Board_ImgVO(int board_seq, String board_img_name) {
		this.board_seq = board_seq;
		this.board_img_name = board_img_name;
	}
	
	
	public Board_ImgVO(int board_img_seq, int board_seq, String board_img_name) {
		this.board_img_seq = board_img_seq;
		this.board_seq = board_seq;
		this.board_img_name = board_img_name;
	}


	
	
	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	public int getBoard_img_seq() {
		return board_img_seq;
	}

	public void setBoard_img_seq(int board_img_seq) {
		this.board_img_seq = board_img_seq;
	}

	public int getBoard_seq() {
		return board_seq;
	}

	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}

	public String getBoard_img_name() {
		return board_img_name;
	}

	public void setBoard_img_name(String board_img_name) {
		this.board_img_name = board_img_name;
	}



	
	
	
}
