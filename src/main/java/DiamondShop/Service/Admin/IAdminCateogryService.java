package DiamondShop.Service.Admin;

import java.util.List;

import org.springframework.stereotype.Service;

import DiamondShop.Entity.Categories;

@Service
public interface IAdminCateogryService {
	
	public List<Categories> listCategories();
	public List<Categories> getCategoryWithPagination(int firstCategory, int limit);
	public boolean saveCategory(Categories Categories);
	public boolean deleteCategory(long id);
	public Categories findCategoryById(long id);
}
