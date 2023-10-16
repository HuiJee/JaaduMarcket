package vo.busi;

public class Alert_RegularVO {

	
	private int alert_regular_seq;
	private int m_seq;
	private int busi_seq;
	private String alert_content;
	private int alert_check;
	
	public Alert_RegularVO() {
	}

	public Alert_RegularVO(int alert_regular_seq, int m_seq, int busi_seq, String alert_content, int alert_check) {
		this.alert_regular_seq = alert_regular_seq;
		this.m_seq = m_seq;
		this.busi_seq = busi_seq;
		this.alert_content = alert_content;
		this.alert_check = alert_check;
	}

	public int getAlert_regular_seq() {
		return alert_regular_seq;
	}

	public void setAlert_regular_seq(int alert_regular_seq) {
		this.alert_regular_seq = alert_regular_seq;
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

	public String getAlert_content() {
		return alert_content;
	}

	public void setAlert_content(String alert_content) {
		this.alert_content = alert_content;
	}

	public int getAlert_check() {
		return alert_check;
	}

	public void setAlert_check(int alert_check) {
		this.alert_check = alert_check;
	}

	
	
	
	
	
	
}
