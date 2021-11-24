package DiamondShop.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import DiamondShop.Entity.Categories;
import DiamondShop.Entity.MapperCategories;

@Repository
public class CategoriesDAO extends BaseDAO {

	private final String SQL_GET_ALL_CATEGORY = "select * from categories ";
	private final String SQL_FIND_CATEGORY = "select * from categories where id = ?";
	private final String SQL_CHECK_EXISTS_CATEGORY = "select count(*) from categories where id = ?";
	private final String SQL_DELETE_CATEGORY = "delete from categories where id = ?";
	private final String SQL_UPDATE_CATEGORY = "update categories " + "set name = ?, description = ? "
			+ "where id = ?";
	private final String SQL_INSERT_CATEGORY = "insert into categories" + "(name, description) " + "values(?,?)";

	public List<Categories> getCategories() {
		return _jdbcTemplate.query(SQL_GET_ALL_CATEGORY, new MapperCategories());
	}

	// GET PRODUCT COLOR WITH PAGINATION
	private String sqlCategoryPagination(int firstCategories, int limit) {
		StringBuilder sql = new StringBuilder();
		sql.append(SQL_GET_ALL_CATEGORY);
		sql.append("ORDER BY id asc ");
		sql.append("OFFSET " + (firstCategories - 1) + " ROWS ");
		sql.append("FETCH NEXT " + limit + " ROWS ONLY ");

		return sql.toString();
	}

	// GET ALL PRODUCTS.
	public List<Categories> listCategoriess() {
		return _jdbcTemplate.query(SQL_GET_ALL_CATEGORY, new MapperCategories());
	}

	// GET PRODUCT COLOR WITH PAGINATION.
	public List<Categories> getCategoryPagination(int firstCategory, int limit) {
		String sql = sqlCategoryPagination(firstCategory, limit);
		return _jdbcTemplate.query(sql, new MapperCategories());
	}

	public boolean deleteCategory(long id) {
		return _jdbcTemplate.update(SQL_DELETE_CATEGORY, id) > 0;
	}

	public boolean updateCategory(Categories categories) {
		return _jdbcTemplate.update(SQL_UPDATE_CATEGORY, 
				categories.getName(), 
				categories.getDescription(),
				categories.getId()) > 0;
	}

	public boolean createCategory(Categories Categories) {
		return _jdbcTemplate.update(SQL_INSERT_CATEGORY, 
				Categories.getName(), 
				Categories.getDescription()) > 0;
	}

	public Categories findCategoryById(long id) {
		return _jdbcTemplate.queryForObject(SQL_FIND_CATEGORY, new MapperCategories(), id);
	}

	public Integer checkCategoryExists(long id) {
		return _jdbcTemplate.queryForObject(SQL_CHECK_EXISTS_CATEGORY, Integer.class, id);
	}
}
