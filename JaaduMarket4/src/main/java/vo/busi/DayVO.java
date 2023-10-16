package vo.busi;

public class DayVO {
	
	private int day_seq;
	private String day_name;
	
	
	public DayVO() {
	}


	public DayVO(int day_seq, String day_name) {
		this.day_seq = day_seq;
		this.day_name = day_name;
	}


	public int getDay_seq() {
		return day_seq;
	}


	public void setDay_seq(int day_seq) {
		this.day_seq = day_seq;
	}


	public String getDay_name() {
		return day_name;
	}


	public void setDay_name(String day_name) {
		this.day_name = day_name;
	}

	
	
	
	
	
}
