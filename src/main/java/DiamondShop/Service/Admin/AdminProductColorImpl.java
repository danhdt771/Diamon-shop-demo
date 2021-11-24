package DiamondShop.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.DAO.ProductColorDAO;
import DiamondShop.Entity.ProductColor;

@Service
public class AdminProductColorImpl implements IAdminProductColorService {
	
	@Autowired
	private ProductColorDAO _productColorDAO;

	@Override
	public List<ProductColor> listProductColors() {
		return _productColorDAO.listProductColors();
	}

	@Override
	public List<ProductColor> getProductColorWithPagination(int firstProductColor, int limit) {
		return _productColorDAO.getProductColorPagination(firstProductColor, limit);
	}

	@Override
	public boolean saveProductColor(ProductColor productColor) {
		if (_productColorDAO.checkProductColorExists(productColor.getId()) == 0) {
			return _productColorDAO.createProductColor(productColor);
		}
		return _productColorDAO.updateProductColor(productColor);
	}

	@Override
	public boolean deleteProductColor(long id) {
		return _productColorDAO.deleteProductColor(id);
	}

	@Override
	public ProductColor findProductColorById(long id) {
		return _productColorDAO.findProductColorById(id);
	}

}
