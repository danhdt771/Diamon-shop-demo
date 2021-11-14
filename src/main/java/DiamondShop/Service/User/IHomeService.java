package DiamondShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import DiamondShop.Dto.ProductsDto;
import DiamondShop.Entity.Categories;
import DiamondShop.Entity.Menus;
import DiamondShop.Entity.Slides;

@Service
public interface IHomeService {
	
	public List<Slides> getDataSlide();
	public List<Categories> getCategories();
	public List<Menus> getMenus();
	public List<ProductsDto> getProducts(String typeProduct);
}
