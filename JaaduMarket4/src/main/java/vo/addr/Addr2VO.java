package vo.addr;

public class Addr2VO {
	
	private int addr2_no;
	private int addr1_no;
	private String addr2_name;

	public Addr2VO() {
		
	}
	
	public Addr2VO(int addr2_no, int addr1_no, String addr2_name) {
		this.addr2_no = addr2_no;
		this.addr1_no = addr1_no;
		this.addr2_name = addr2_name;
	}

	public int getAddr2_no() {
		return addr2_no;
	}

	public void setAddr2_no(int addr2_no) {
		this.addr2_no = addr2_no;
	}

	public int getAddr1_no() {
		return addr1_no;
	}

	public void setAddr1_no(int addr1_no) {
		this.addr1_no = addr1_no;
	}

	public String getAddr2_name() {
		return addr2_name;
	}

	public void setAddr2_name(String addr2_name) {
		this.addr2_name = addr2_name;
	}
	
	

}
