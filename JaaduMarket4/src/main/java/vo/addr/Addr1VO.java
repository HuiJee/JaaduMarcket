package vo.addr;

public class Addr1VO {
	
	private int addr1_no;
	private String addr1_name;

	public Addr1VO() {
		
	}
	
	public Addr1VO(int addr1_no, String addr1_name) {
		this.addr1_no = addr1_no;
		this.addr1_name = addr1_name;
		
	}
	
	public int getAddr1_no() {
		return addr1_no;
	}

	public void setAddr1_no(int addr1_no) {
		this.addr1_no = addr1_no;
	}

	public String getAddr1_name() {
		return addr1_name;
	}

	public void setAddr1_name(String addr1_name) {
		this.addr1_name = addr1_name;
	}
	

}
