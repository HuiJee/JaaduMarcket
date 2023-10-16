package vo.member;

import java.sql.Date;

public class Key_SearchlistVO {

	private int key_searchlist_seq;
	private Integer m_seq;
	private String key_name;
	private Date search_date;
	
	
	public Key_SearchlistVO() {
		
	}


	public int getKey_searchlist_seq() {
		return key_searchlist_seq;
	}


	public void setKey_searchlist_seq(int key_searchlist_seq) {
		this.key_searchlist_seq = key_searchlist_seq;
	}


	public Integer getM_seq() {
		return m_seq;
	}


	public void setM_seq(Integer m_seq) {
		this.m_seq = m_seq;
	}


	public String getKey_name() {
		return key_name;
	}


	public void setKey_name(String key_name) {
		this.key_name = key_name;
	}


	public Date getSearch_date() {
		return search_date;
	}


	public void setSearch_date(Date search_date) {
		this.search_date = search_date;
	}
	
	

	
	///////////////////////////////////////////

	
	
	
}
