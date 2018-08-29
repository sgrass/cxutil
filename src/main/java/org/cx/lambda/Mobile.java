package org.cx.lambda;

public class Mobile {
	private String mobileBrand;
	
	private Integer price;

	public Mobile() {

	}
	
	public Mobile(String mobileBrand, Integer price) {
		this.mobileBrand = mobileBrand;
		this.price = price;
	}

	public String getMobileBrand() {
		return mobileBrand;
	}

	public void setMobileBrand(String mobileBrand) {
		this.mobileBrand = mobileBrand;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Mobile [mobileBrand=" + mobileBrand + ", price=" + price + "]";
	}
}
