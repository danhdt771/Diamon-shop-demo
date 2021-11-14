package DiamondShop.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperProductsDto implements RowMapper<ProductsDto> {

	@Override
	public ProductsDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductsDto products = new ProductsDto();
	
		products.setId(rs.getLong("id"));
		products.setId_categories(rs.getInt("id_categories"));
		products.setSizes(rs.getString("sizes"));
		products.setProduct_name(rs.getString("product_name"));
		products.setSale(rs.getInt("sale"));
		products.setTitle(rs.getString("title"));
		products.setDetail(rs.getString("detail"));
		products.setColor_name(rs.getString("color_name"));
		products.setCode_color(rs.getString("code_color"));
		products.setImg(rs.getString("img"));
		products.setCreated_at(rs.getDate("created_at"));
		products.setUpdated_at(rs.getDate("updated_at"));
		products.setPrice(rs.getDouble("price"));
		products.setId_color(rs.getInt("id_color"));
		products.setFeatured_product(rs.getBoolean("featured_product"));
		products.setNew_product(rs.getBoolean("new_product"));
		return products;
	}

}
