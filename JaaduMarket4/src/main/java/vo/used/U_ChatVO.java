package vo.used;

import java.sql.Date;

public class U_ChatVO {
	
	private int u_chat_seq;
	private int m_seq;
	private int seller_seq;
	private int chat_who;
	private String chat_content;
	private Date chat_when;
	private int u_seq;
	
	public U_ChatVO() {
		
	}

	public U_ChatVO(int u_seq, int m_seq) {
		this.u_seq = u_seq;
		this.m_seq = m_seq;
	}
	
	public int getU_chat_seq() {
		return u_chat_seq;
	}

	public void setU_chat_seq(int u_chat_seq) {
		this.u_chat_seq = u_chat_seq;
	}

	public int getM_seq() {
		return m_seq;
	}

	public void setM_seq(int m_seq) {
		this.m_seq = m_seq;
	}

	public int getSeller_seq() {
		return seller_seq;
	}

	public void setSeller_seq(int seller_seq) {
		this.seller_seq = seller_seq;
	}

	public int getChat_who() {
		return chat_who;
	}

	public void setChat_who(int chat_who) {
		this.chat_who = chat_who;
	}

	public String getChat_content() {
		return chat_content;
	}

	public void setChat_content(String chat_content) {
		this.chat_content = chat_content;
	}

	public Date getChat_when() {
		return chat_when;
	}

	public void setChat_when(Date chat_when) {
		this.chat_when = chat_when;
	}

	public int getU_seq() {
		return u_seq;
	}

	public void setU_seq(int u_seq) {
		this.u_seq = u_seq;
	}
	
	


	
	
}
