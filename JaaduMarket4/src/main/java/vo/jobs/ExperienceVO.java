package vo.jobs;

public class ExperienceVO {

	private int experience_seq;
	private int m_seq;
	private String j_place;
	private String j_year;
	private String j_period;//j_period테이블 데이터
	private String j_details;
	

	public ExperienceVO() {
		// TODO Auto-generated constructor stub
	}


	public int getExperience_seq() {
		return experience_seq;
	}


	public void setExperience_seq(int experience_seq) {
		this.experience_seq = experience_seq;
	}


	public int getM_seq() {
		return m_seq;
	}


	public void setM_seq(int m_seq) {
		this.m_seq = m_seq;
	}


	public String getJ_place() {
		return j_place;
	}


	public void setJ_place(String j_place) {
		this.j_place = j_place;
	}


	public String getJ_year() {
		return j_year;
	}


	public void setJ_year(String j_year) {
		this.j_year = j_year;
	}


	public String getJ_period() {
		return j_period;
	}


	public void setJ_period(String j_period) {
		this.j_period = j_period;
	}


	public String getJ_details() {
		return j_details;
	}


	public void setJ_details(String j_details) {
		this.j_details = j_details;
	}
	
	
	

}
