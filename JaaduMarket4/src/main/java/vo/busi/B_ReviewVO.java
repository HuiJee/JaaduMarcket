package vo.busi;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class B_ReviewVO {

	private int b_review_seq;
	private int busi_seq;
	private int m_seq;
	private String b_review_key_seq;
	private String b_review_content;
	private Date b_review_date;
	
	private List<MultipartFile> files;
	
	
	private String m_img;
	private String m_nickname;
	private int addr3_no;
	private String b_review_img_name;
	private String addr3_name;
	
	
	public B_ReviewVO() {
	}


	public B_ReviewVO(int b_review_seq, int busi_seq, int m_seq, String b_review_key_seq, String b_review_content,
			Date b_review_date) {
		this.b_review_seq = b_review_seq;
		this.busi_seq = busi_seq;
		this.m_seq = m_seq;
		this.b_review_key_seq = b_review_key_seq;
		this.b_review_content = b_review_content;
		this.b_review_date = b_review_date;
	}


	public int getB_review_seq() {
		return b_review_seq;
	}


	public void setB_review_seq(int b_review_seq) {
		this.b_review_seq = b_review_seq;
	}


	public int getBusi_seq() {
		return busi_seq;
	}


	public void setBusi_seq(int busi_seq) {
		this.busi_seq = busi_seq;
	}


	public int getM_seq() {
		return m_seq;
	}


	public void setM_seq(int m_seq) {
		this.m_seq = m_seq;
	}


	public String getB_review_key_seq() {
		return b_review_key_seq;
	}


	public void setB_review_key_seq(String b_review_key_seq) {
		this.b_review_key_seq = b_review_key_seq;
	}


	public String getB_review_content() {
		return b_review_content;
	}


	public void setB_review_content(String b_review_content) {
		this.b_review_content = b_review_content;
	}


	public Date getB_review_date() {
		return b_review_date;
	}


	public void setB_review_date(Date b_review_date) {
		this.b_review_date = b_review_date;
	}


	public List<MultipartFile> getFiles() {
		return files;
	}


	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}


	public String getM_img() {
		return m_img;
	}


	public void setM_img(String m_img) {
		this.m_img = m_img;
	}


	public String getM_nickname() {
		return m_nickname;
	}


	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}


	public int getAddr3_no() {
		return addr3_no;
	}


	public void setAddr3_no(int addr3_no) {
		this.addr3_no = addr3_no;
	}


	public String getB_review_img_name() {
		return b_review_img_name;
	}


	public void setB_review_img_name(String b_review_img_name) {
		this.b_review_img_name = b_review_img_name;
	}


	public String getAddr3_name() {
		return addr3_name;
	}


	public void setAddr3_name(String addr3_name) {
		this.addr3_name = addr3_name;
	}


	


	


	
	
	
	
	
}
