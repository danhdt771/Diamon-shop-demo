package DiamondShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.DAO.ProductsDAO;
import DiamondShop.Dto.ProductsDto;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ProductsDAO _productsDAO;
	
	@Override
	public List<ProductsDto> getAllProductByCategoryId(int id) {
		return _productsDAO.getDataProductsByCategoryId(id);
	}

	@Override
	public List<ProductsDto> getProductPaginate(int id, int firstProduct, int limit) {
		return _productsDAO.getDataProductsPaginate(id, firstProduct, limit);
	}

}
