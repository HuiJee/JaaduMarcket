package vo.busi;

public class RuntypeVO {
	
	private int runtype_seq;
	private String runtype_name;
	
	
	public RuntypeVO() {
	}


	public RuntypeVO(int runtype_seq, String runtype_name) {
		this.runtype_seq = runtype_seq;
		this.runtype_name = runtype_name;
	}


	public int getRuntype_seq() {
		return runtype_seq;
	}


	public void setRuntype_seq(int runtype_seq) {
		this.runtype_seq = runtype_seq;
	}


	public String getRuntype_name() {
		return runtype_name;
	}


	public void setRuntype_name(String runtype_name) {
		this.runtype_name = runtype_name;
	}


	
	
	
	
	
}
