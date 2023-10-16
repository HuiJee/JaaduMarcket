package vo.board;

import java.sql.Date;
import vo.board.Board_ImgVO;

public class BoardVO {
	
	private int board_seq;			// 게시판 번호
	private int m_seq;				// 작성자 
	private String board_title;		// 제목
	private String board_content;	// 내용
	private int board_hit;			// 조회수
	private Date board_date;		// 게시 시간
	
	private String m_id;
	
	public BoardVO() {
		
	}
	
	public BoardVO(int board_seq, int m_seq, String board_title, String board_content, int board_hit, Date board_date, String m_id) {
		this.board_seq = board_seq;
		this.m_seq = m_seq;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_hit = board_hit;
		this.board_date = board_date;	
		this.m_id = m_id;
	}

	public int getBoard_seq() {
		return board_seq;
	}

	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}

	public int getM_seq() {
		return m_seq;
	}

	public void setM_seq(int m_seq) {
		this.m_seq = m_seq;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public int getBoard_hit() {
		return board_hit;
	}

	public void setBoard_hit(int board_hit) {
		this.board_hit = board_hit;
	}

	public Date getBoard_date() {
		return board_date;
	}

	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}


	
	
	
}
