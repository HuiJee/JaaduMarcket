package vo.busi;

import org.springframework.web.multipart.MultipartFile;

public class ProductVO {

	
	private int product_seq;
	private int busi_seq;
	private String product_img;
	private String product_name;
	private String product_price;
	private String product_info;
	
	private MultipartFile file;
	
	
	public ProductVO() {
	}


	public ProductVO(int product_seq, int busi_seq, String product_img, String product_name, String product_price,
			String product_info, MultipartFile file) {
		this.product_seq = product_seq;
		this.busi_seq = busi_seq;
		this.product_img = product_img;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_info = product_info;
		this.file = file;
	}


	public int getProduct_seq() {
		return product_seq;
	}


	public void setProduct_seq(int product_seq) {
		this.product_seq = product_seq;
	}


	public int getBusi_seq() {
		return busi_seq;
	}


	public void setBusi_seq(int busi_seq) {
		this.busi_seq = busi_seq;
	}


	public String getProduct_img() {
		return product_img;
	}


	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}


	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public String getProduct_price() {
		return product_price;
	}


	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}


	public String getProduct_info() {
		return product_info;
	}


	public void setProduct_info(String product_info) {
		this.product_info = product_info;
	}


	public MultipartFile getFile() {
		return file;
	}


	public void setFile(MultipartFile file) {
		this.file = file;
	}


	


	
	
	
	
	
	
	
}
