package vo.jobs;

public class J_TimeVO {

	private int j_time_seq;
	private int j_seq;
	private String j_time_type; //장기이일때 요일, 단기일때 날짜
	//private String j_time_day; 
	private String j_start;
	private String j_finish;
	
	public J_TimeVO() {
		// TODO Auto-generated constructor stub
	}

	public int getJ_time_seq() {
		return j_time_seq;
	}

	public void setJ_time_seq(int j_time_seq) {
		this.j_time_seq = j_time_seq;
	}

	public int getJ_seq() {
		return j_seq;
	}

	public void setJ_seq(int j_seq) {
		this.j_seq = j_seq;
	}


	public String getJ_time_type() {
		return j_time_type;
	}

	public void setJ_time_type(String j_time_type) {
		this.j_time_type = j_time_type;
	}

	public String getJ_start() {
		return j_start;
	}

	public void setJ_start(String j_start) {
		this.j_start = j_start;
	}

	public String getJ_finish() {
		return j_finish;
	}

	public void setJ_finish(String j_finish) {
		this.j_finish = j_finish;
	}
	
	

}
