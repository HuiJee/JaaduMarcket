package vo.busi;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class B_ImgVO {

	private int b_img_seq;
	private int busi_seq;
	private String b_img_name;
	
	private List<MultipartFile> files;
	
	public B_ImgVO() {
	}

	public B_ImgVO(int busi_seq, String b_img_name) {
		this.busi_seq = busi_seq;
		this.b_img_name = b_img_name;
	}
	
	public B_ImgVO(int b_img_seq, int busi_seq, String b_img_name) {
		this.b_img_seq = b_img_seq;
		this.busi_seq = busi_seq;
		this.b_img_name = b_img_name;
	}

	public int getB_img_seq() {
		return b_img_seq;
	}

	public void setB_img_seq(int b_img_seq) {
		this.b_img_seq = b_img_seq;
	}

	public int getBusi_seq() {
		return busi_seq;
	}

	public void setBusi_seq(int busi_seq) {
		this.busi_seq = busi_seq;
	}

	public String getB_img_name() {
		return b_img_name;
	}

	public void setB_img_name(String b_img_name) {
		this.b_img_name = b_img_name;
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	

	
	
	

	
	
	
}
