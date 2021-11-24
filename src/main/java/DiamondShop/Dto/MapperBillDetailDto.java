package DiamondShop.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperBillDetailDto implements RowMapper<BillDetailDto> {
	
	@Override
	public BillDetailDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		BillDetailDto billDetails = new BillDetailDto();
		billDetails.setProductName(rs.getString("product_name"));
		billDetails.setPrice(rs.getDouble("price"));
		billDetails.setQty(rs.getInt("qty"));
		billDetails.setTotal(rs.getDouble("total"));
		return billDetails;
	}
}
