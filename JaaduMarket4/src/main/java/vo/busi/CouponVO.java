package vo.busi;

import java.sql.Date;

public class CouponVO {
	
	private int coupon_seq;
	private int busi_seq;
	private int regular_status;
	private String coupon_effect;
	private String coupon_use_date;
	private int coupon_limit_num;
	private String coupon_info;
	private int coupon_act;
	private Date coupon_date;
	
	
	public CouponVO() {
	}


	public CouponVO(int coupon_seq, int busi_seq, int regular_status, String coupon_effect, String coupon_use_date,
			int coupon_limit_num, String coupon_info, int coupon_act, Date coupon_date) {
		this.coupon_seq = coupon_seq;
		this.busi_seq = busi_seq;
		this.regular_status = regular_status;
		this.coupon_effect = coupon_effect;
		this.coupon_use_date = coupon_use_date;
		this.coupon_limit_num = coupon_limit_num;
		this.coupon_info = coupon_info;
		this.coupon_act = coupon_act;
		this.coupon_date = coupon_date;
	}


	public int getCoupon_seq() {
		return coupon_seq;
	}


	public void setCoupon_seq(int coupon_seq) {
		this.coupon_seq = coupon_seq;
	}


	public int getBusi_seq() {
		return busi_seq;
	}


	public void setBusi_seq(int busi_seq) {
		this.busi_seq = busi_seq;
	}


	public int getRegular_status() {
		return regular_status;
	}


	public void setRegular_status(int regular_status) {
		this.regular_status = regular_status;
	}


	public String getCoupon_effect() {
		return coupon_effect;
	}


	public void setCoupon_effect(String coupon_effect) {
		this.coupon_effect = coupon_effect;
	}


	public String getCoupon_use_date() {
		return coupon_use_date;
	}


	public void setCoupon_use_date(String coupon_use_date) {
		this.coupon_use_date = coupon_use_date;
	}


	public int getCoupon_limit_num() {
		return coupon_limit_num;
	}


	public void setCoupon_limit_num(int coupon_limit_num) {
		this.coupon_limit_num = coupon_limit_num;
	}


	public String getCoupon_info() {
		return coupon_info;
	}


	public void setCoupon_info(String coupon_info) {
		this.coupon_info = coupon_info;
	}


	public int getCoupon_act() {
		return coupon_act;
	}


	public void setCoupon_act(int coupon_act) {
		this.coupon_act = coupon_act;
	}


	public Date getCoupon_date() {
		return coupon_date;
	}


	public void setCoupon_date(Date coupon_date) {
		this.coupon_date = coupon_date;
	}


	
	
	
	
}
