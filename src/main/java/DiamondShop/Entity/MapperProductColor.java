package DiamondShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperProductColor implements RowMapper<ProductColor> {
	
	@Override
	public ProductColor mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductColor productColor = new ProductColor();
		productColor.setId(rs.getInt("id"));
		productColor.setIdProduct(rs.getLong("id_product"));
		productColor.setColorName(rs.getString("color_name"));
		productColor.setCode(rs.getString("code"));
		productColor.setImg(rs.getString("img"));
		return productColor;
	}
}
