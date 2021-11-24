package DiamondShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperProduct implements RowMapper<Product>  {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setID(rs.getLong("id"));
		product.setID_CATEGORIES(rs.getInt("id_categories"));
		product.setSIZES(rs.getString("sizes"));
		product.setPRODUCT_NAME(rs.getString("product_name"));
		product.setPRICE(rs.getDouble("price"));
		product.setSALE(rs.getInt("sale"));
		product.setTITLE(rs.getString("title"));
		product.setFEATURED_PRODUCT(rs.getInt("featured_product"));
		product.setNEW_PRODUCT(rs.getInt("new_product"));
		product.setDETAIL(rs.getString("detail"));
		product.setCREATED_AT(rs.getDate("created_at"));
		product.setUPDATED_AT(rs.getDate("updated_at"));
		return product;
	}

}
