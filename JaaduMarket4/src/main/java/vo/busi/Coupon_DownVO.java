package vo.busi;

import java.sql.Date;

public class Coupon_DownVO {

	private int coupon_down_seq;
	private int m_seq;
	private int coupon_seq;
	private int coupon_status;
	private Date coupon_complete_date;
	
	private String m_img;
	private String m_nickname;
	private String coupon_effect;
	private int regular_status;
	private Date coupon_use_date;
	private Date coupon_date;
	
	
	public Coupon_DownVO() {
	}


	public Coupon_DownVO(int coupon_down_seq, int m_seq, int coupon_seq, int coupon_status, Date coupon_complete_date) {
		this.coupon_down_seq = coupon_down_seq;
		this.m_seq = m_seq;
		this.coupon_seq = coupon_seq;
		this.coupon_status = coupon_status;
		this.coupon_complete_date = coupon_complete_date;
	}


	public int getCoupon_down_seq() {
		return coupon_down_seq;
	}


	public void setCoupon_down_seq(int coupon_down_seq) {
		this.coupon_down_seq = coupon_down_seq;
	}


	public int getM_seq() {
		return m_seq;
	}


	public void setM_seq(int m_seq) {
		this.m_seq = m_seq;
	}


	public int getCoupon_seq() {
		return coupon_seq;
	}


	public void setCoupon_seq(int coupon_seq) {
		this.coupon_seq = coupon_seq;
	}


	public int getCoupon_status() {
		return coupon_status;
	}


	public void setCoupon_status(int coupon_status) {
		this.coupon_status = coupon_status;
	}


	public Date getCoupon_complete_date() {
		return coupon_complete_date;
	}


	public void setCoupon_complete_date(Date coupon_complete_date) {
		this.coupon_complete_date = coupon_complete_date;
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


	public String getCoupon_effect() {
		return coupon_effect;
	}


	public void setCoupon_effect(String coupon_effect) {
		this.coupon_effect = coupon_effect;
	}


	public int getRegular_status() {
		return regular_status;
	}


	public void setRegular_status(int regular_status) {
		this.regular_status = regular_status;
	}


	public Date getCoupon_use_date() {
		return coupon_use_date;
	}


	public void setCoupon_use_date(Date coupon_use_date) {
		this.coupon_use_date = coupon_use_date;
	}


	public Date getCoupon_date() {
		return coupon_date;
	}


	public void setCoupon_date(Date coupon_date) {
		this.coupon_date = coupon_date;
	}


	
	
	
	
	
}
