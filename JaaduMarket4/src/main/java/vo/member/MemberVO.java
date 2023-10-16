package vo.member;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class MemberVO {

	private int m_seq;
	private String m_name;
	private String m_id;
	private String m_nickname;
	private String m_tel1;
	private String m_tel2;
	private String m_tel3;
	private String password;
	private String email1;
	private String email2;
	private int addr3_no;
	private String year;
	private String month;
	private String bdate;
	private int m_gender;
	private String m_img;
	private int m_busi_status;
	private int m_jobs_status;
	private int m_pay_status;
	private Date m_joindate;
	private int m_active_status;
	
	public MemberVO() {

	}
	
	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public int getM_seq() {
		return m_seq;
	}

	public void setM_seq(int m_seq) {
		this.m_seq = m_seq;
	}

	public String getM_nickname() {
		return m_nickname;
	}

	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}

	public String getM_tel1() {
		return m_tel1;
	}

	public void setM_tel1(String m_tel1) {
		this.m_tel1 = m_tel1;
	}

	public String getM_tel2() {
		return m_tel2;
	}

	public void setM_tel2(String m_tel2) {
		this.m_tel2 = m_tel2;
	}

	public String getM_tel3() {
		return m_tel3;
	}

	public void setM_tel3(String m_tel3) {
		this.m_tel3 = m_tel3;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public int getAddr3_no() {
		return addr3_no;
	}

	public void setAddr3_no(int addr3_no) {
		this.addr3_no = addr3_no;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public int getM_gender() {
		return m_gender;
	}

	public void setM_gender(int m_gender) {
		this.m_gender = m_gender;
	}

	public String getM_img() {
		return m_img;
	}

	public void setM_img(String m_img) {
		this.m_img = m_img;
	}

	public int getM_busi_status() {
		return m_busi_status;
	}

	public void setM_busi_status(int m_busi_status) {
		this.m_busi_status = m_busi_status;
	}

	public int getM_jobs_status() {
		return m_jobs_status;
	}

	public void setM_jobs_status(int m_jobs_status) {
		this.m_jobs_status = m_jobs_status;
	}

	public int getM_pay_status() {
		return m_pay_status;
	}

	public void setM_pay_status(int m_pay_status) {
		this.m_pay_status = m_pay_status;
	}

	public Date getM_joindate() {
		return m_joindate;
	}

	public void setM_joindate(Date m_joindate) {
		this.m_joindate = m_joindate;
	}

	public int getM_active_status() {
		return m_active_status;
	}

	public void setM_active_status(int m_active_status) {
		this.m_active_status = m_active_status;
	}
	
	/////////////////////////////////////////////
	
	private double manners_degree_sum;
	private String bank_point;

	public double getManners_degree_sum() {
		return manners_degree_sum;
	}

	public void setManners_degree_sum(double manners_degree_sum) {
		this.manners_degree_sum = manners_degree_sum;
	}

	public String getBank_point() {
		return bank_point;
	}

	public void setBank_point(String bank_point) {
		this.bank_point = bank_point;
	}
	
	// ���� �߰�
	
	private String chat_content;
	private Date chat_when;
	private String addr3_name;
	private int u_seq;
	private int buyer_seq;
	
	public String getChat_content() {
		return chat_content;
	}

	public void setChat_content(String chat_content) {
		this.chat_content = chat_content;
	}

	public Date getChat_when() {
		return chat_when;
	}

	public void setChat_when(Date chat_when) {
		this.chat_when = chat_when;
	}

	public String getAddr3_name() {
		return addr3_name;
	}

	public void setAddr3_name(String addr3_name) {
		this.addr3_name = addr3_name;
	}

	public int getU_seq() {
		return u_seq;
	}

	public void setU_seq(int u_seq) {
		this.u_seq = u_seq;
	}

	public int getBuyer_seq() {
		return buyer_seq;
	}

	public void setBuyer_seq(int buyer_seq) {
		this.buyer_seq = buyer_seq;
	}
	
	// �̹���
    private MultipartFile photo;
    
    public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	
	
	
	
	
	//현지 추가
	private Date regular_date;


	public Date getRegular_date() {
		return regular_date;
	}


	public void setRegular_date(Date regular_date) {
		this.regular_date = regular_date;
	}


	
}
