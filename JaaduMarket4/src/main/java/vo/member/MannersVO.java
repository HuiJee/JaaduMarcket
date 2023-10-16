package vo.member;

public class MannersVO {

	private int manners_seq;
	private double manners_point;
	private String manners_key;
	private int manners_why;
	
	public MannersVO() {
		
	}

	public int getManners_seq() {
		return manners_seq;
	}

	public void setManners_seq(int manners_seq) {
		this.manners_seq = manners_seq;
	}

	public double getManners_point() {
		return manners_point;
	}

	public void setManners_point(double manners_point) {
		this.manners_point = manners_point;
	}

	public String getManners_key() {
		return manners_key;
	}

	public void setManners_key(String manners_key) {
		this.manners_key = manners_key;
	}

	public int getManners_why() {
		return manners_why;
	}

	public void setManners_why(int manners_why) {
		this.manners_why = manners_why;
	}
	
	/////////////////////////////////////////////////////
	
	private int cnt;

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
	
	
}
