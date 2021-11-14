package DiamondShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import DiamondShop.Dto.ProductsDto;

@Service
public interface ICategoryService {

	public List<ProductsDto> getAllProductById(int id);
	public List<ProductsDto> getProductPaginate(int id, int firstProduct, int limit);
}
