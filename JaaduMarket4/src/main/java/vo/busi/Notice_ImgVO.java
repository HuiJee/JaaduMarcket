package vo.busi;


public class Notice_ImgVO {

	
	private int notice_img_seq;
	private int notice_seq;
	private String notice_img_name;
	private int notice_img_main;
	
	
	
	public Notice_ImgVO() {
	}


	public Notice_ImgVO(int notice_seq, String notice_img_name) {
		this.notice_seq = notice_seq;
		this.notice_img_name = notice_img_name;
	}
	
	public Notice_ImgVO(int notice_img_seq, int notice_seq, String notice_img_name) {
		this.notice_img_seq = notice_img_seq;
		this.notice_seq = notice_seq;
		this.notice_img_name = notice_img_name;
	}


	public int getNotice_img_seq() {
		return notice_img_seq;
	}


	public void setNotice_img_seq(int notice_img_seq) {
		this.notice_img_seq = notice_img_seq;
	}


	public int getNotice_seq() {
		return notice_seq;
	}


	public void setNotice_seq(int notice_seq) {
		this.notice_seq = notice_seq;
	}


	public String getNotice_img_name() {
		return notice_img_name;
	}


	public void setNotice_img_name(String notice_img_name) {
		this.notice_img_name = notice_img_name;
	}


	public int getNotice_img_main() {
		return notice_img_main;
	}


	public void setNotice_img_main(int notice_img_main) {
		this.notice_img_main = notice_img_main;
	}


	

	
	
	
	
}
