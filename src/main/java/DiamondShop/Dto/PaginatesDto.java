package DiamondShop.Dto;

public class PaginatesDto {
	
	private int currentPage, limit, firstProduct, totalPage;
	
	public PaginatesDto() {
		// TODO Auto-generated constructor stub
	}
	
	public PaginatesDto(int currentPage, int limit, int start, int end, int totalPage) {
		super();
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getLimit() {
		return limit;
	}

	public int getFirstProduct() {
		return firstProduct;
	}

	public void setFirstProduct(int firstProduct) {
		this.firstProduct = firstProduct;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	
}
