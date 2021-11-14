package DiamondShop.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamondShop.Entity.Categories;
import DiamondShop.Entity.MapperCategories;

@Repository
public class CategoriesDAO extends BaseDAO {
	
	public List<Categories> getCategories() {
		List<Categories> categories = new ArrayList<Categories>();
		String query = "Select * from categories";
		categories = _jdbcTemplate.query(query, new MapperCategories());
		return categories;
	}
}
