package vo.jobs;


public class ApplicationVO {
	 
	
	private int app_seq;
	  private int apply_seq;
	  private int j_seq;
	  private int m_seq;
	  private String apply_date;
	  private int app_status;
	  
	  
	  //--------------------------------
	  private String j_img;
	  private String j_title;
	  private String j_name;
	  
	  
	  
	  public int getApp_status() {
			return app_status;
		}


		public void setApp_status(int app_status) {
			this.app_status = app_status;
		}
	  
	  public String getJ_img() {
		return j_img;
	}


	public void setJ_img(String j_img) {
		this.j_img = j_img;
	}


	public String getJ_title() {
		return j_title;
	}


	public void setJ_title(String j_title) {
		this.j_title = j_title;
	}


	public String getJ_name() {
		return j_name;
	}


	public void setJ_name(String j_name) {
		this.j_name = j_name;
	}


	public ApplicationVO() {
		// TODO Auto-generated constructor stub
	}

	 
	public int getApp_seq() {
		return app_seq;
	}
	public void setApp_seq(int app_seq) {
		this.app_seq = app_seq;
	}
	public int getApply_seq() {
		return apply_seq;
	}
	public void setApply_seq(int apply_seq) {
		this.apply_seq = apply_seq;
	}
	public int getJ_seq() {
		return j_seq;
	}
	public void setJ_seq(int j_seq) {
		this.j_seq = j_seq;
	}
	public int getM_seq() {
		return m_seq;
	}
	public void setM_seq(int m_seq) {
		this.m_seq = m_seq;
	}
	public String getApply_date() {
		return apply_date;
	}
	public void setApply_date(String apply_date) {
		this.apply_date = apply_date;
	}
	  

}