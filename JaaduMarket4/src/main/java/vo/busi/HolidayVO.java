package vo.busi;

public class HolidayVO {
	
	
	private int holiday_seq;
	private String holiday_type;
	
	
	public HolidayVO() {
	}


	public HolidayVO(int holiday_seq, String holiday_type) {
		super();
		this.holiday_seq = holiday_seq;
		this.holiday_type = holiday_type;
	}


	public int getHoliday_seq() {
		return holiday_seq;
	}


	public void setHoliday_seq(int holiday_seq) {
		this.holiday_seq = holiday_seq;
	}


	public String getHoliday_type() {
		return holiday_type;
	}


	public void setHoliday_type(String holiday_type) {
		this.holiday_type = holiday_type;
	}


	
	
	
	
	
	
}
