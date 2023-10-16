package vo.busi;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class BusiVO {
	
	private int busi_seq;
	private int m_seq;
	private String busi_name;
	private int busi_cate_seq;
	private String busi_information;
	private String busi_tel1;
	private String busi_tel2;
	private String busi_tel3;
	private String busi_img;
	private int addr3_no;
	private String busi_addr_detail;
	private int holiday_seq;
	private String busi_details;
	private String busi_website;
	private String busi_number;
	private Date busi_joindate;
	private int busi_views;
	private Date busi_update;
	
	private MultipartFile photo;
	private String addr3_name;
	private String busi_cate_name;
	
	//private MultipartFile[] b_img;
	//private MultipartFile[] notice_img;
	
	public BusiVO() {
	}


	public BusiVO(int busi_seq, int m_seq, String busi_name, int busi_cate_seq, String busi_information,
			String busi_tel1, String busi_tel2, String busi_tel3, String busi_img, int addr3_no,
			String busi_addr_detail, int holiday_seq, String busi_details, String busi_website, String busi_number,
			Date busi_joindate, int busi_views, Date busi_update) {
		super();
		this.busi_seq = busi_seq;
		this.m_seq = m_seq;
		this.busi_name = busi_name;
		this.busi_cate_seq = busi_cate_seq;
		this.busi_information = busi_information;
		this.busi_tel1 = busi_tel1;
		this.busi_tel2 = busi_tel2;
		this.busi_tel3 = busi_tel3;
		this.busi_img = busi_img;
		this.addr3_no = addr3_no;
		this.busi_addr_detail = busi_addr_detail;
		this.holiday_seq = holiday_seq;
		this.busi_details = busi_details;
		this.busi_website = busi_website;
		this.busi_number = busi_number;
		this.busi_joindate = busi_joindate;
		this.busi_views = busi_views;
		this.busi_update = busi_update;
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


	public String getBusi_name() {
		return busi_name;
	}


	public void setBusi_name(String busi_name) {
		this.busi_name = busi_name;
	}


	public int getBusi_cate_seq() {
		return busi_cate_seq;
	}


	public void setBusi_cate_seq(int busi_cate_seq) {
		this.busi_cate_seq = busi_cate_seq;
	}


	public String getBusi_information() {
		return busi_information;
	}


	public void setBusi_information(String busi_information) {
		this.busi_information = busi_information;
	}


	public String getBusi_tel1() {
		return busi_tel1;
	}


	public void setBusi_tel1(String busi_tel1) {
		this.busi_tel1 = busi_tel1;
	}


	public String getBusi_tel2() {
		return busi_tel2;
	}


	public void setBusi_tel2(String busi_tel2) {
		this.busi_tel2 = busi_tel2;
	}


	public String getBusi_tel3() {
		return busi_tel3;
	}


	public void setBusi_tel3(String busi_tel3) {
		this.busi_tel3 = busi_tel3;
	}


	public String getBusi_img() {
		return busi_img;
	}


	public void setBusi_img(String busi_img) {
		this.busi_img = busi_img;
	}


	public int getAddr3_no() {
		return addr3_no;
	}


	public void setAddr3_no(int addr3_no) {
		this.addr3_no = addr3_no;
	}


	public String getBusi_addr_detail() {
		return busi_addr_detail;
	}


	public void setBusi_addr_detail(String busi_addr_detail) {
		this.busi_addr_detail = busi_addr_detail;
	}


	public int getHoliday_seq() {
		return holiday_seq;
	}


	public void setHoliday_seq(int holiday_seq) {
		this.holiday_seq = holiday_seq;
	}


	public String getBusi_details() {
		return busi_details;
	}


	public void setBusi_details(String busi_details) {
		this.busi_details = busi_details;
	}


	public String getBusi_website() {
		return busi_website;
	}


	public void setBusi_website(String busi_website) {
		this.busi_website = busi_website;
	}


	public String getBusi_number() {
		return busi_number;
	}


	public void setBusi_number(String busi_number) {
		this.busi_number = busi_number;
	}


	public Date getBusi_joindate() {
		return busi_joindate;
	}


	public void setBusi_joindate(Date busi_joindate) {
		this.busi_joindate = busi_joindate;
	}


	public int getBusi_views() {
		return busi_views;
	}


	public void setBusi_views(int busi_views) {
		this.busi_views = busi_views;
	}


	public Date getBusi_update() {
		return busi_update;
	}


	public void setBusi_update(Date busi_update) {
		this.busi_update = busi_update;
	}


	public MultipartFile getPhoto() {
		return photo;
	}


	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	
	
	public void setAddr3_name(String addr3_name) {
		this.addr3_name = addr3_name;
	}
	
	public String getAddr3_name() {
		return addr3_name;
	}


	public String getBusi_cate_name() {
		return busi_cate_name;
	}


	public void setBusi_cate_name(String busi_cate_name) {
		this.busi_cate_name = busi_cate_name;
	}


	
	


}