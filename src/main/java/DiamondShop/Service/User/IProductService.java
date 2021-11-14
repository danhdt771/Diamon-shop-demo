package DiamondShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import DiamondShop.Dto.ProductsDto;

@Service
public interface IProductService {

	public ProductsDto getProductById(int id);
	public List<ProductsDto> getRelatedProduct(int idCategory, int limit);
}
