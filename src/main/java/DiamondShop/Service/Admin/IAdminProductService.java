package DiamondShop.Service.Admin;

import java.util.List;

import org.springframework.stereotype.Service;

import DiamondShop.Entity.Product;

@Service
public interface IAdminProductService {

	public List<Product> listProducts();
	public List<Product> getProductWithPagination(int firstProduct, int limit);
	public boolean saveProduct(Product product);
	public boolean deleteProduct(long id);
	public Product findProductById(long id);
}
