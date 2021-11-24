package DiamondShop.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.DAO.CategoriesDAO;
import DiamondShop.Entity.Categories;

@Service
public class AdminCategoryImpl implements IAdminCateogryService {

	@Autowired
	private CategoriesDAO _categoriesDAO;

	@Override
	public List<Categories> listCategories() {
		return _categoriesDAO.getCategories();
	}

	@Override
	public boolean deleteCategory(long id) {
		return _categoriesDAO.deleteCategory(id);
	}

	@Override
	public Categories findCategoryById(long id) {
		return _categoriesDAO.findCategoryById(id);
	} 

	@Override
	public List<Categories> getCategoryWithPagination(int firstCategory, int limit) {
		return _categoriesDAO.getCategoryPagination(firstCategory, limit);
	}

	@Override
	public boolean saveCategory(Categories categories) {
		if (_categoriesDAO.checkCategoryExists(categories.getId()) == 0) {
			return _categoriesDAO.createCategory(categories);
		}
		return _categoriesDAO.updateCategory(categories);
	}
}
