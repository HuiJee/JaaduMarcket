package vo.busi;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class NoticeVO {

	private int notice_seq;
	private int busi_seq;
	private String notice_title;
	private String notice_content;
	private Date notice_date;
	private int notice_views;
	
	private String busi_img;
	private String busi_name;
	private int addr3_no;
	private String addr3_name;
	private String notice_img_name;
	
	private List<MultipartFile> files;

	public NoticeVO() {
	}


	public NoticeVO(int notice_seq, int busi_seq, String notice_title, String notice_content, Date notice_date,
			int notice_views) {
		this.notice_seq = notice_seq;
		this.busi_seq = busi_seq;
		this.notice_title = notice_title;
		this.notice_content = notice_content;
		this.notice_date = notice_date;
		this.notice_views = notice_views;
	}


	public int getNotice_seq() {
		return notice_seq;
	}


	public void setNotice_seq(int notice_seq) {
		this.notice_seq = notice_seq;
	}


	public int getBusi_seq() {
		return busi_seq;
	}


	public void setBusi_seq(int busi_seq) {
		this.busi_seq = busi_seq;
	}


	public String getNotice_title() {
		return notice_title;
	}


	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}


	public String getNotice_content() {
		return notice_content;
	}


	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}


	public Date getNotice_date() {
		return notice_date;
	}


	public void setNotice_date(Date notice_date) {
		this.notice_date = notice_date;
	}


	public int getNotice_views() {
		return notice_views;
	}


	public void setNotice_views(int notice_views) {
		this.notice_views = notice_views;
	}


	public String getBusi_img() {
		return busi_img;
	}


	public void setBusi_img(String busi_img) {
		this.busi_img = busi_img;
	}


	public String getBusi_name() {
		return busi_name;
	}


	public void setBusi_name(String busi_name) {
		this.busi_name = busi_name;
	}


	public int getAddr3_no() {
		return addr3_no;
	}


	public void setAddr3_no(int addr3_no) {
		this.addr3_no = addr3_no;
	}


	public String getNotice_img_name() {
		return notice_img_name;
	}


	public void setNotice_img_name(String notice_img_name) {
		this.notice_img_name = notice_img_name;
	}


	public List<MultipartFile> getFiles() {
		return files;
	}


	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}


	public String getAddr3_name() {
		return addr3_name;
	}


	public void setAddr3_name(String addr3_name) {
		this.addr3_name = addr3_name;
	}


	
	
	
	
	
	
}
