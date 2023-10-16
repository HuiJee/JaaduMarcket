package vo.jobs;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class JobsVO {
private int j_seq;
private int m_seq;
private String j_title;
private int j_cate_seq1;
private int j_cate_seq2;
private int j_cate_seq3;
private String j_name;
private String j_tel;
private int j_tel_status;
private int addr3_no;
private String addr_details;
private int j_long;//0장기, 1단기에 따라 날짜 또는 요일이 들어감
private String j_start; 
private String j_finish;
private int j_pay;
private String j_details;
private int j_done; //구인중 0아니면 1
private int j_time_nego;  //협의가능이면 0,아니면1
private Date j_date;
private String j_boost;
private int j_boost_count;
private String j_img;
private int j_hit;

//---------------------

public String j_cate_name;

public String getJ_cate_name() {
	return j_cate_name;
}
public void setJ_cate_name(String j_cate_name) {
	this.j_cate_name = j_cate_name;
}
public int getJ_hit() {
	return j_hit;
}
public void setJ_hit(int j_hit) {
	this.j_hit = j_hit;
}

private String addr3_name;
private String addr2_name;
private String addr1_name;


private String j_time_type;


public String getJ_start() {
	return j_start;
}
public void setJ_start(String j_start) {
	this.j_start = j_start;
}
public String getJ_finish() {
	return j_finish;
}
public void setJ_finish(String j_finish) {
	this.j_finish = j_finish;
}
public String getJ_time_type() {
	return j_time_type;
}
public void setJ_time_type(String j_time_type) {
	this.j_time_type = j_time_type;
}
public String getAddr3_name() {
	return addr3_name;
}
public void setAddr3_name(String addr3_name) {
	this.addr3_name = addr3_name;
}
public String getAddr2_name() {
	return addr2_name;
}
public void setAddr2_name(String addr2_name) {
	this.addr2_name = addr2_name;
}
public String getAddr1_name() {
	return addr1_name;
}
public void setAddr1_name(String addr1_name) {
	this.addr1_name = addr1_name;
}

private MultipartFile photo;


public MultipartFile getPhoto() {
	return photo;
}
public void setPhoto(MultipartFile photo) {
	this.photo = photo;
}
public String getJ_boost() {
	return j_boost;
}
public void setJ_boost(String j_boost) {
	this.j_boost = j_boost;
}
public String getJ_img() {
	return j_img;
}
public void setJ_img(String j_img) {
	this.j_img = j_img;
}
public int getJ_done() {
	return j_done;
}

public void setJ_done(int j_done) {
	this.j_done = j_done;
}

public int getJ_time_nego() {
	return j_time_nego;
}

public void setJ_time_nego(int j_time_nego) {
	this.j_time_nego = j_time_nego;
}

public Date getJ_date() {
	return j_date;
}

public void setJ_date(Date j_date) {
	this.j_date = j_date;
}

public String getJ_Boost() {
	return j_boost;
}

public void setJ_Boost(String j_Boost) {
	this.j_boost = j_Boost;
}

public int getJ_boost_count() {
	return j_boost_count;
}

public void setJ_boost_count(int j_boost_count) {
	this.j_boost_count = j_boost_count;
}




public JobsVO() {
	// TODO Auto-generated constructor stub
}

public int getJ_seq() {
	return j_seq;
}

public void setJ_seq(int j_seq) {
	this.j_seq = j_seq;
}

public int getM_seq() {
	return m_seq;
}

public void setM_seq(int m_seq) {
	this.m_seq = m_seq;
}



public String getJ_title() {
	return j_title;
}

public void setJ_title(String j_title) {
	this.j_title = j_title;
}



public String getJ_name() {
	return j_name;
}

public void setJ_name(String j_name) {
	this.j_name = j_name;
}

public String getJ_tel() {
	return j_tel;
}

public void setJ_tel(String j_tel) {
	this.j_tel = j_tel;
}

public int getJ_tel_status() {
	return j_tel_status;
}

public void setJ_tel_status(int j_tel_status) {
	this.j_tel_status = j_tel_status;
}

public int getAddr3_no() {
	return addr3_no;
}

public void setAddr3_no(int addr3_no) {
	this.addr3_no = addr3_no;
}

public String getAddr_details() {
	return addr_details;
}

public void setAddr_details(String addr_details) {
	this.addr_details = addr_details;
}

public int getJ_long() {
	return j_long;
}

public void setJ_long(int j_long) {
	this.j_long = j_long;
}

public int getJ_pay() {
	return j_pay;
}

public void setJ_pay(int j_pay) {
	this.j_pay = j_pay;
}

public String getJ_details() {
	return j_details;
}

public void setJ_details(String j_details) {
	this.j_details = j_details;
}

public int getJ_cate_seq1() {
	return j_cate_seq1;
}

public void setJ_cate_seq1(int j_cate_seq1) {
	this.j_cate_seq1 = j_cate_seq1;
}

public int getJ_cate_seq2() {
	return j_cate_seq2;
}

public void setJ_cate_seq2(int j_cate_seq2) {
	this.j_cate_seq2 = j_cate_seq2;
}

public int getJ_cate_seq3() {
	return j_cate_seq3;
}

public void setJ_cate_seq3(int j_cate_seq3) {
	this.j_cate_seq3 = j_cate_seq3;
}


}











