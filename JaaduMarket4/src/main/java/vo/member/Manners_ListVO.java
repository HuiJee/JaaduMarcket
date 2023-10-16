package vo.member;

public class Manners_ListVO {

	private int manners_list_seq;
	private int receive_seq;
	private int manners_seq;
	private int give_seq;
	private int u_seq;
	
	public Manners_ListVO() {
		
	}
	
	public Manners_ListVO(int give_seq, int u_seq) {
		this.give_seq = give_seq;
		this.u_seq = u_seq;
	}

	public int getManners_list_seq() {
		return manners_list_seq;
	}

	public void setManners_list_seq(int manners_list_seq) {
		this.manners_list_seq = manners_list_seq;
	}

	public int getReceive_seq() {
		return receive_seq;
	}

	public void setReceive_seq(int receive_seq) {
		this.receive_seq = receive_seq;
	}

	public int getManners_seq() {
		return manners_seq;
	}

	public void setManners_seq(int manners_seq) {
		this.manners_seq = manners_seq;
	}

	public int getGive_seq() {
		return give_seq;
	}

	public void setGive_seq(int give_seq) {
		this.give_seq = give_seq;
	}

	public int getU_seq() {
		return u_seq;
	}

	public void setU_seq(int u_seq) {
		this.u_seq = u_seq;
	}
	
	
}
	
