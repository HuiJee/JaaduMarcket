package vo.busi;

public class HoursVO {

	private int hours_seq;
	private int busi_seq;
	private int day_seq;
	private int runtype_seq;
	private String time1;
	private String time2;
	private int run_status;
	
	
	public HoursVO() {
		
	}


	public HoursVO(int hours_seq, int busi_seq, int day_seq, int runtype_seq, String time1, String time2,
			int run_status) {
		this.hours_seq = hours_seq;
		this.busi_seq = busi_seq;
		this.day_seq = day_seq;
		this.runtype_seq = runtype_seq;
		this.time1 = time1;
		this.time2 = time2;
		this.run_status = run_status;
	}


	public int getHours_seq() {
		return hours_seq;
	}


	public void setHours_seq(int hours_seq) {
		this.hours_seq = hours_seq;
	}


	public int getBusi_seq() {
		return busi_seq;
	}


	public void setBusi_seq(int busi_seq) {
		this.busi_seq = busi_seq;
	}


	public int getDay_seq() {
		return day_seq;
	}


	public void setDay_seq(int day_seq) {
		this.day_seq = day_seq;
	}


	public int getRuntype_seq() {
		return runtype_seq;
	}


	public void setRuntype_seq(int runtype_seq) {
		this.runtype_seq = runtype_seq;
	}


	public String getTime1() {
		return time1;
	}


	public void setTime1(String time1) {
		this.time1 = time1;
	}


	public String getTime2() {
		return time2;
	}


	public void setTime2(String time2) {
		this.time2 = time2;
	}


	public int getRun_status() {
		return run_status;
	}


	public void setRun_status(int run_status) {
		this.run_status = run_status;
	}
	
	

	
	
	
	
	
	
	
	
	
	
}
