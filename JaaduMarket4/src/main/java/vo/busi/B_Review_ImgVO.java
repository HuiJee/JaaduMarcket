package vo.busi;

public class B_Review_ImgVO {
	
	private int b_review_img_seq;
	private int b_review_seq;
	private String b_review_img_name;
	
	public B_Review_ImgVO() {
	}

	public B_Review_ImgVO(int b_review_seq, String b_review_img_name) {
		this.b_review_seq = b_review_seq;
		this.b_review_img_name = b_review_img_name;
	}
	
	public B_Review_ImgVO(int b_review_img_seq, int b_review_seq, String b_review_img_name) {
		this.b_review_img_seq = b_review_img_seq;
		this.b_review_seq = b_review_seq;
		this.b_review_img_name = b_review_img_name;
	}

	public int getB_review_img_seq() {
		return b_review_img_seq;
	}

	public void setB_review_img_seq(int b_review_img_seq) {
		this.b_review_img_seq = b_review_img_seq;
	}

	public int getB_review_seq() {
		return b_review_seq;
	}

	public void setB_review_seq(int b_review_seq) {
		this.b_review_seq = b_review_seq;
	}

	public String getB_review_img_name() {
		return b_review_img_name;
	}

	public void setB_review_img_name(String b_review_img_name) {
		this.b_review_img_name = b_review_img_name;
	}

	
	
	
	
}
