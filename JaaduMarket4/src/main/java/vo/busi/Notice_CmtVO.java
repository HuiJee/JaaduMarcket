package vo.busi;

import java.sql.Date;

public class Notice_CmtVO {

	private int notice_cmt_seq;
	private int notice_seq;
	private int m_seq;
	private String cmt;
	private Date cmt_date;
	
	private String m_img;
	private String m_nickname;
	
	
	public Notice_CmtVO() {
	}


	public Notice_CmtVO(int notice_cmt_seq, int notice_seq, int m_seq, String cmt, Date cmt_date) {
		this.notice_cmt_seq = notice_cmt_seq;
		this.notice_seq = notice_seq;
		this.m_seq = m_seq;
		this.cmt = cmt;
		this.cmt_date = cmt_date;
	}


	public int getNotice_cmt_seq() {
		return notice_cmt_seq;
	}


	public void setNotice_cmt_seq(int notice_cmt_seq) {
		this.notice_cmt_seq = notice_cmt_seq;
	}


	public int getNotice_seq() {
		return notice_seq;
	}


	public void setNotice_seq(int notice_seq) {
		this.notice_seq = notice_seq;
	}


	public int getM_seq() {
		return m_seq;
	}


	public void setM_seq(int m_seq) {
		this.m_seq = m_seq;
	}


	public String getCmt() {
		return cmt;
	}


	public void setCmt(String cmt) {
		this.cmt = cmt;
	}


	public Date getCmt_date() {
		return cmt_date;
	}


	public void setCmt_date(Date cmt_date) {
		this.cmt_date = cmt_date;
	}


	public String getM_img() {
		return m_img;
	}


	public void setM_img(String m_img) {
		this.m_img = m_img;
	}


	public String getM_nickname() {
		return m_nickname;
	}


	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}

	
	

	
	
	
	
	
	
}
