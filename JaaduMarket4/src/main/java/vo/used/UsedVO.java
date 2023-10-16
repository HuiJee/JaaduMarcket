package vo.used;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class UsedVO {

	private int u_seq;
	private int m_seq;
	private String u_title;
	private int u_cate_seq;
	private String cate_check_name;
	private String cate_input;
	private String u_content;
	private int u_price;
	private int u_nego_status;
	private int u_share;
	private int u_trade_status;
	private int u_views;
	private Date u_date;
	private Date u_boost;
	private int u_boost_count;
	private String u_addr_main;
	private String u_addr_sub;
	
	
	public UsedVO() {

	}

	public int getU_seq() {
		return u_seq;
	}

	public void setU_seq(int u_seq) {
		this.u_seq = u_seq;
	}

	public int getM_seq() {
		return m_seq;
	}

	public void setM_seq(int m_seq) {
		this.m_seq = m_seq;
	}

	public String getU_title() {
		return u_title;
	}

	public void setU_title(String u_title) {
		this.u_title = u_title;
	}

	public int getU_cate_seq() {
		return u_cate_seq;
	}

	public void setU_cate_seq(int u_cate_seq) {
		this.u_cate_seq = u_cate_seq;
	}

	public String getCate_check_name() {
		return cate_check_name;
	}

	public void setCate_check_name(String cate_check_name) {
		this.cate_check_name = cate_check_name;
	}

	public String getCate_input() {
		return cate_input;
	}

	public void setCate_input(String cate_input) {
		this.cate_input = cate_input;
	}

	public String getU_content() {
		return u_content;
	}

	public void setU_content(String u_content) {
		this.u_content = u_content;
	}

	public int getU_price() {
		return u_price;
	}

	public void setU_price(int u_price) {
		this.u_price = u_price;
	}

	public int getU_nego_status() {
		return u_nego_status;
	}

	public void setU_nego_status(int u_nego_status) {
		this.u_nego_status = u_nego_status;
	}

	public int getU_share() {
		return u_share;
	}

	public void setU_share(int u_share) {
		this.u_share = u_share;
	}

	public int getU_trade_status() {
		return u_trade_status;
	}

	public void setU_trade_status(int u_trade_status) {
		this.u_trade_status = u_trade_status;
	}

	public int getU_views() {
		return u_views;
	}

	public void setU_views(int u_views) {
		this.u_views = u_views;
	}

	public Date getU_date() {
		return u_date;
	}

	public void setU_date(Date u_date) {
		this.u_date = u_date;
	}

	public Date getU_boost() {
		return u_boost;
	}

	public void setU_boost(Date u_boost) {
		this.u_boost = u_boost;
	}

	public int getU_boost_count() {
		return u_boost_count;
	}

	public void setU_boost_count(int u_boost_count) {
		this.u_boost_count = u_boost_count;
	}
	
	
	public String getU_addr_main() {
		return u_addr_main;
	}

	public void setU_addr_main(String u_addr_main) {
		this.u_addr_main = u_addr_main;
	}

	public String getU_addr_sub() {
		return u_addr_sub;
	}

	public void setU_addr_sub(String u_addr_sub) {
		this.u_addr_sub = u_addr_sub;
	}


	////////////////////////////////////////////
	
	private String addr3_name;
	private double manners_degree_sum;
	private String m_nickname;
	private String u_cate_name;
	private String u_img_name;
	private String addr1_name;
	private String addr2_name;
	private int fav_count;
	private int chat;
	private String m_img;

	public String getAddr3_name() {
		return addr3_name;
	}

	public void setAddr3_name(String addr3_name) {
		this.addr3_name = addr3_name;
	}

	public double getManners_degree_sum() {
		return manners_degree_sum;
	}

	public void setManners_degree_sum(double manners_degree_sum) {
		this.manners_degree_sum = manners_degree_sum;
	}

	public String getM_nickname() {
		return m_nickname;
	}

	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}

	public String getU_cate_name() {
		return u_cate_name;
	}

	public void setU_cate_name(String u_cate_name) {
		this.u_cate_name = u_cate_name;
	}
	
	public String getU_img_name() {
		return u_img_name;
	}

	public void setU_img_name(String u_img_name) {
		this.u_img_name = u_img_name;
	}

	public String getAddr1_name() {
		return addr1_name;
	}

	public void setAddr1_name(String addr1_name) {
		this.addr1_name = addr1_name;
	}

	public String getAddr2_name() {
		return addr2_name;
	}

	public void setAddr2_name(String addr2_name) {
		this.addr2_name = addr2_name;
	}
	
	public int getFav_count() {
		return fav_count;
	}

	public void setFav_count(int fav_count) {
		this.fav_count = fav_count;
	}

	public int getChat() {
		return chat;
	}

	public void setChat(int chat) {
		this.chat = chat;
	}
	

	public String getM_img() {
		return m_img;
	}

	public void setM_img(String m_img) {
		this.m_img = m_img;
	}
	
		
	///////////////////////////////////////////////
	

	private MultipartFile[] photos;

	public MultipartFile[] getPhotos() {
		return photos;
	}

	public void setPhotos(MultipartFile[] photos) {
		this.photos = photos;
	}
	
	
}
