package DiamondShop.Service.Admin;

import java.util.List;

import org.springframework.stereotype.Service;

import DiamondShop.Entity.ProductColor;

@Service
public interface IAdminProductColorService {

	public List<ProductColor> listProductColors();
	public List<ProductColor> getProductColorWithPagination(int firstProductColor, int limit);
	public boolean saveProductColor(ProductColor productColor);
	public boolean deleteProductColor(long id);
	public ProductColor findProductColorById(long id);
}
