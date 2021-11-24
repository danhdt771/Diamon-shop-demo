package DiamondShop.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.DAO.ProductsDAO;
import DiamondShop.Entity.Product;

@Service
public class AdminProductImpl implements IAdminProductService {

	@Autowired
	private ProductsDAO _productDAO;

	@Override
	public List<Product> getProductWithPagination(int firstProduct, int limit) {
		return _productDAO.getProductPagination(firstProduct, limit);
	}

	@Override
	public List<Product> listProducts() {
		return _productDAO.listProducts();
	}


	@Override
	public boolean deleteProduct(long id) {
		return _productDAO.deleteProduct(id);
	}

	@Override
	public boolean saveProduct(Product product) {
		if (_productDAO.checkProductExists(product.getID()) == 0) {
			return _productDAO.createProduct(product);
		}
		return _productDAO.updateProduct(product);
	}
	
	@Override
	public Product findProductById(long id) {
		return _productDAO.findProductById(id);
	}
}
