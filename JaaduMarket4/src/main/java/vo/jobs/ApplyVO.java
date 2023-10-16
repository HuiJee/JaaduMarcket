package vo.jobs;

import org.springframework.web.multipart.MultipartFile;

public class ApplyVO {
	private int apply_seq;
	private int m_seq;
	private String m_name;
	private String profile; // 업로드된 파일명을 저장하기 위해 (데이터베이스 저장되는 값)
	private String profile_url; //
	private String my_info;
	

	
	//------------------------
	
	
//--------------------------
	
private int app_seq;
private String place;
private String jyear;
private String period;
private String details;
private String apply_date; 
private int j_seq;

	public int getJ_seq() {
	return j_seq;
}

public void setJ_seq(int j_seq) {
	this.j_seq = j_seq;
}

	public String getApply_date() {
	return apply_date;
}

public void setApply_date(String apply_date) {
	this.apply_date = apply_date;
}

	// --------------------
	// member 데이터
	private String m_nickname;
	private String m_tel1;
	private String m_tel2;
	private String m_tel3;
	private String email1;
	
	
	
	public String getM_nickname() {
		return m_nickname;
	}

	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	private String email2;
	private String year;
	private int m_gender;

	public ApplyVO() {
		// TODO Auto-generated constructor stub
	}

	public String getM_tel1() {
		return m_tel1;
	}

	public void setM_tel1(String m_tel1) {
		this.m_tel1 = m_tel1;
	}

	public String getM_tel2() {
		return m_tel2;
	}

	public void setM_tel2(String m_tel2) {
		this.m_tel2 = m_tel2;
	}

	public String getM_tel3() {
		return m_tel3;
	}

	public void setM_tel3(String m_tel3) {
		this.m_tel3 = m_tel3;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getM_gender() {
		return m_gender;
	}

	public void setM_gender(int m_gender) {
		this.m_gender = m_gender;
	}

	public int getApply_seq() {
		return apply_seq;
	}

	public void setApply_seq(int apply_seq) {
		this.apply_seq = apply_seq;
	}

	public int getM_seq() {
		return m_seq;
	}

	public void setM_seq(int m_seq) {
		this.m_seq = m_seq;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getProfile_url() {
		return profile_url;
	}

	public void setProfile_url(String profile_url) {
		this.profile_url = profile_url;
	}

	public String getMy_info() {
		return my_info;
	}

	public void setMy_info(String my_info) {
		this.my_info = my_info;
	}
	
	public int getApp_seq() {
	return app_seq;
}

public void setApp_seq(int app_seq) {
	this.app_seq = app_seq;
}

public String getPlace() {
	return place;
}

public void setPlace(String place) {
	this.place = place;
}

public String getJyear() {
	return jyear;
}

public void setJyear(String jyear) {
	this.jyear = jyear;
}

public String getPeriod() {
	return period;
}

public void setPeriod(String period) {
	this.period = period;
}

public String getDetails() {
	return details;
}

public void setDetails(String details) {
	this.details = details;
}

}
