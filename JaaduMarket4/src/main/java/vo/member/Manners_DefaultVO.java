package vo.member;

public class Manners_DefaultVO {

	private int manners_list_seq;
	private int m_seq;
	private int seller_seq;
	private int manners_seq;
	
	public Manners_DefaultVO() {
		
	}
	
	public Manners_DefaultVO( int m_seq, int seller_seq) {
		this.seller_seq = seller_seq;
		this.m_seq = m_seq;
	}

	public int getManners_list_seq() {
		return manners_list_seq;
	}

	public void setManners_list_seq(int manners_list_seq) {
		this.manners_list_seq = manners_list_seq;
	}

	public int getSeller_seq() {
		return seller_seq;
	}

	public void setSeller_seq(int seller_seq) {
		this.seller_seq = seller_seq;
	}

	public int getManners_seq() {
		return manners_seq;
	}

	public void setManners_seq(int manners_seq) {
		this.manners_seq = manners_seq;
	}

	public int getM_seq() {
		return m_seq;
	}

	public void setM_seq(int m_seq) {
		this.m_seq = m_seq;
	}
	
	

}

