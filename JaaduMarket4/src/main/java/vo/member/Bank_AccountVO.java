package vo.member;

public class Bank_AccountVO {

	private int bank_account_seq;
	private int m_seq;
	private int bank_seq;
	private String bank_account_num;
	private int bank_point;
	
	public Bank_AccountVO() {
		
	}
	
	public Bank_AccountVO(int m_seq, int seller_seq) {
		this.m_seq = m_seq;
		this.seller_seq = seller_seq;
	}

	public int getBank_account_seq() {
		return bank_account_seq;
	}

	public void setBank_account_seq(int bank_account_seq) {
		this.bank_account_seq = bank_account_seq;
	}

	public int getM_seq() {
		return m_seq;
	}

	public void setM_seq(int m_seq) {
		this.m_seq = m_seq;
	}

	public int getBank_seq() {
		return bank_seq;
	}

	public void setBank_seq(int bank_seq) {
		this.bank_seq = bank_seq;
	}

	public String getBank_account_num() {
		return bank_account_num;
	}

	public void setBank_account_num(String bank_account_num) {
		this.bank_account_num = bank_account_num;
	}

	public int getBank_point() {
		return bank_point;
	}

	public void setBank_point(int bank_point) {
		this.bank_point = bank_point;
	}

	///////////////////////////////////////////////////////
	
	private String bank_name;

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	
	///////////////////////////////////////////////////////
	
	private int seller_seq;

	public int getSeller_seq() {
		return seller_seq;
	}

	public void setSeller_seq(int seller_seq) {
		this.seller_seq = seller_seq;
	}
	
	
	
	
	
	
	
	
}
