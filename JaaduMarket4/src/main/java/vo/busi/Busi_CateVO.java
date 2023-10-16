package vo.busi;

public class Busi_CateVO {
	
	private int busi_cate_seq;
	private String busi_cate_name;
	
	
	public Busi_CateVO() {
	}


	public Busi_CateVO(int busi_cate_seq, String busi_cate_name) {
		super();
		this.busi_cate_seq = busi_cate_seq;
		this.busi_cate_name = busi_cate_name;
	}


	public int getBusi_cate_seq() {
		return busi_cate_seq;
	}


	public void setBusi_cate_seq(int busi_cate_seq) {
		this.busi_cate_seq = busi_cate_seq;
	}


	public String getBusi_cate_name() {
		return busi_cate_name;
	}


	public void setBusi_cate_name(String busi_cate_name) {
		this.busi_cate_name = busi_cate_name;
	}

	
	
	
	
}
