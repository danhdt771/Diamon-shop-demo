package DiamondShop.Dto;

public class CartDto {
	
	private int qty;
	private double totalPrice;
	private ProductsDto product;
	
	public CartDto() {
	}

	public CartDto(int qty, double totalPrice, ProductsDto product) {
		this.qty = qty;
		this.totalPrice = totalPrice;
		this.product = product;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public ProductsDto getProduct() {
		return product;
	}

	public void setProduct(ProductsDto product) {
		this.product = product;
	}
	
	
}
