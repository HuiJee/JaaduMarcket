package vo.busi;

public class Product_ImgVO {
	
	private int product_img_seq;
	private int product_seq;
	private String product_img_name;
	
	
	
	public Product_ImgVO() {
	}


	public Product_ImgVO(int product_img_seq, int product_seq, String product_img_name) {
		this.product_img_seq = product_img_seq;
		this.product_seq = product_seq;
		this.product_img_name = product_img_name;
		
	}


	public int getProduct_img_seq() {
		return product_img_seq;
	}


	public void setProduct_img_seq(int product_img_seq) {
		this.product_img_seq = product_img_seq;
	}


	public int getProduct_seq() {
		return product_seq;
	}


	public void setProduct_seq(int product_seq) {
		this.product_seq = product_seq;
	}


	public String getProduct_img_name() {
		return product_img_name;
	}


	public void setProduct_img_name(String product_img_name) {
		this.product_img_name = product_img_name;
	}



	
	
	
	
	
	
}
