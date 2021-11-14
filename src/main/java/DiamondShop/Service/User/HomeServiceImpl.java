package DiamondShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.DAO.CategoriesDAO;
import DiamondShop.DAO.MenuDAO;
import DiamondShop.DAO.ProductsDAO;
import DiamondShop.DAO.SlidesDAO;
import DiamondShop.Dto.ProductsDto;
import DiamondShop.Entity.Categories;
import DiamondShop.Entity.Menus;
import DiamondShop.Entity.Slides;

@Service
public class HomeServiceImpl implements IHomeService {

	@Autowired
	private SlidesDAO slidesDAO;
	
	@Autowired
	private CategoriesDAO categoriesDAO;
	
	@Autowired
	private MenuDAO menuDAO;
	
	@Autowired
	private ProductsDAO productsDAO;
	
	@Override
	public List<Slides> getDataSlide() {
		return slidesDAO.getDataSlide();
	}

	@Override
	public List<Categories> getCategories() {
		return categoriesDAO.getCategories();
	}

	@Override
	public List<Menus> getMenus() {
		return menuDAO.getMenus();
	}

	@Override
	public List<ProductsDto> getProducts(String typeProduct) {
		List<ProductsDto> listProducts = productsDAO.getDataProducts(typeProduct);
		return listProducts;
	}

}
