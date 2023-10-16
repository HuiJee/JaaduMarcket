package vo.used;

public class U_TradelistVO {

	private int u_tradelist_seq;
	private int u_seq;
	private int buyer_seq;
	private int seller_seq;
	private int finish_status;
	private int trade_type;
	
	public U_TradelistVO() {
		
	}
	
	public U_TradelistVO(int buyer_seq, int u_seq) {
		this.buyer_seq = buyer_seq;
		this.u_seq = u_seq;
	}

	public int getU_tradelist_seq() {
		return u_tradelist_seq;
	}

	public void setU_tradelist_seq(int u_tradelist_seq) {
		this.u_tradelist_seq = u_tradelist_seq;
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

	public int getSeller_seq() {
		return seller_seq;
	}

	public void setSeller_seq(int seller_seq) {
		this.seller_seq = seller_seq;
	}

	public int getFinish_status() {
		return finish_status;
	}

	public void setFinish_status(int finish_status) {
		this.finish_status = finish_status;
	}

	public int getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(int trade_type) {
		this.trade_type = trade_type;
	}
	
	
	////////////////////////////////////////////
	
	private String u_title;
	private int u_price;
	private String addr3_name;

	public String getU_title() {
		return u_title;
	}

	public void setU_title(String u_title) {
		this.u_title = u_title;
	}

	public int getU_price() {
		return u_price;
	}

	public void setU_price(int u_price) {
		this.u_price = u_price;
	}

	public String getAddr3_name() {
		return addr3_name;
	}

	public void setAddr3_name(String addr3_name) {
		this.addr3_name = addr3_name;
	}
	
	
}
