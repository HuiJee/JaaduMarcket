package vo.busi;

import java.sql.Date;

public class B_RegularVO {

	private int s_regular_seq;
	private int m_seq;
	private int busi_seq;
	private int notice_status;
	private Date regular_date;
	
	public B_RegularVO() {
	}

	public B_RegularVO(int s_regular_seq, int m_seq, int busi_seq, int notice_status, Date regular_date) {
		this.s_regular_seq = s_regular_seq;
		this.m_seq = m_seq;
		this.busi_seq = busi_seq;
		this.notice_status = notice_status;
		this.regular_date = regular_date;
	}

	public int getS_regular_seq() {
		return s_regular_seq;
	}

	public void setS_regular_seq(int s_regular_seq) {
		this.s_regular_seq = s_regular_seq;
	}

	public int getM_seq() {
		return m_seq;
	}

	public void setM_seq(int m_seq) {
		this.m_seq = m_seq;
	}

	public int getBusi_seq() {
		return busi_seq;
	}

	public void setBusi_seq(int busi_seq) {
		this.busi_seq = busi_seq;
	}

	public int getNotice_status() {
		return notice_status;
	}

	public void setNotice_status(int notice_status) {
		this.notice_status = notice_status;
	}

	public Date getRegular_date() {
		return regular_date;
	}

	public void setRegular_date(Date regular_date) {
		this.regular_date = regular_date;
	}

	
	
	
	
}
