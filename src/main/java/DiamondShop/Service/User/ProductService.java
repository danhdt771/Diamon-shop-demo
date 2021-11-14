package DiamondShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.DAO.ProductsDAO;
import DiamondShop.Dto.ProductsDto;

@Service
public class ProductService implements IProductService {

	@Autowired
	ProductsDAO _productsDAO;
	
	@Override
	public ProductsDto getProductById(int id) {
		ProductsDto product = _productsDAO.findProductById(id);
		return product;
	}

	@Override
	public List<ProductsDto> getRelatedProduct(int idCategory, int limit) {
		//Get product from id = 1, limit 5
		return _productsDAO.getDataProductsPaginate(idCategory, 1, limit);
	}

}
