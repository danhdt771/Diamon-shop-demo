package DiamondShop.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import DiamondShop.Entity.MapperProductColor;
import DiamondShop.Entity.ProductColor;

@Repository
public class ProductColorDAO extends BaseDAO {

	private final String SQL_GET_ALL_PRODUCT_COLOR = "select * from product_colors ";
	private final String SQL_FIND_PRODUCT_COLOR = "select * from product_colors where id = ?";
	private final String SQL_CHECK_EXISTS_PRODUCT_COLOR = "select count(*) from product_colors where id = ?";
	private final String SQL_DELETE_PRODUCT_COLOR = "delete from product_colors where id = ?";
	private final String SQL_UPDATE_PRODUCT_COLOR = "update product_colors "
			+ "set id_product = ?, color_name = ?, code = ?, img = ? " + "where id = ?";
	private final String SQL_INSERT_PRODUCT_COLOR = "insert into product_colors"
			+ "(id_product, color_name, code, img) " + "values(?,?,?,?)";

	// GET PRODUCT COLOR WITH PAGINATION
	private String sqlProductColorPagination(int firstProductColor, int limit) {
		StringBuilder sql = new StringBuilder();
		sql.append(SQL_GET_ALL_PRODUCT_COLOR);
		sql.append("ORDER BY id asc ");
		sql.append("OFFSET " + (firstProductColor - 1) + " ROWS ");
		sql.append("FETCH NEXT " + limit + " ROWS ONLY ");

		return sql.toString();
	}

	// GET ALL PRODUCTS.
	public List<ProductColor> listProductColors() {
		return _jdbcTemplate.query(SQL_GET_ALL_PRODUCT_COLOR, new MapperProductColor());
	}

	// GET PRODUCT COLOR WITH PAGINATION.
	public List<ProductColor> getProductColorPagination(int firstProduct, int limit) {
		String sql = sqlProductColorPagination(firstProduct, limit);
		return _jdbcTemplate.query(sql, new MapperProductColor());
	}

	public boolean deleteProductColor(long id) {
		return _jdbcTemplate.update(SQL_DELETE_PRODUCT_COLOR, id) > 0;
	}

	public boolean updateProductColor(ProductColor productColor) {
		return _jdbcTemplate.update(SQL_UPDATE_PRODUCT_COLOR, 
				productColor.getIdProduct(), 
				productColor.getColorName(),
				productColor.getCode(), 
				productColor.getImg(),
				productColor.getId()) > 0;
	}

	public boolean createProductColor(ProductColor productColor) {
		return _jdbcTemplate.update(SQL_INSERT_PRODUCT_COLOR, 
				productColor.getIdProduct(), 
				productColor.getColorName(),
				productColor.getCode(), 
				productColor.getImg()) > 0;
	}

	public ProductColor findProductColorById(long id) {
		return _jdbcTemplate.queryForObject(SQL_FIND_PRODUCT_COLOR, new MapperProductColor(), id);
	}

	public Integer checkProductColorExists(long id) {
		return _jdbcTemplate.queryForObject(SQL_CHECK_EXISTS_PRODUCT_COLOR, Integer.class, id);
	}
}
