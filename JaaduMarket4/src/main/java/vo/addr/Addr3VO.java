package vo.addr;

public class Addr3VO {
	
	private int addr3_no;
	private int addr1_no;
	private int addr2_no;
	private String addr3_name;
	private String code;
	
	private String addr1_name;
	private String addr2_name;
	
	
	

	public Addr3VO() {
		
	}
	
	public Addr3VO(int addr3_no, int addr1_no, int addr2_no, String addr3_name, String code) {
		this.addr3_no = addr3_no;
		this.addr1_no = addr1_no;
		this.addr2_no = addr2_no;
		this.addr3_name = addr3_name;
		this.code = code;
	}

	public int getAddr3_no() {
		return addr3_no;
	}

	public void setAddr3_no(int addr3_no) {
		this.addr3_no = addr3_no;
	}

	public int getAddr1_no() {
		return addr1_no;
	}

	public void setAddr1_no(int addr1_no) {
		this.addr1_no = addr1_no;
	}

	public int getAddr2_no() {
		return addr2_no;
	}

	public void setAddr2_no(int addr2_no) {
		this.addr2_no = addr2_no;
	}

	public String getAddr3_name() {
		return addr3_name;
	}

	public void setAddr3_name(String addr3_name) {
		this.addr3_name = addr3_name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	
	
	
	public String getAddr1_name() {
		return addr1_name;
	}

	public void setAddr1_name(String addr1_name) {
		this.addr1_name = addr1_name;
	}

	public String getAddr2_name() {
		return addr2_name;
	}

	public void setAddr2_name(String addr2_name) {
		this.addr2_name = addr2_name;
	}
	
	

}
