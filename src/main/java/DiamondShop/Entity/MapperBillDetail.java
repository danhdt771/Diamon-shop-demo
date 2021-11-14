package DiamondShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperBillDetail implements RowMapper<BillDetail> {

	@Override
	public BillDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		BillDetail billDetail = new BillDetail();
		billDetail.setId(rs.getInt("id"));
		billDetail.setId_bill(rs.getInt("id_bill"));
		billDetail.setId_product(rs.getInt("id_product"));
		billDetail.setQty(rs.getInt("qty"));
		billDetail.setTotal(rs.getDouble("total"));
		return null;
	}

}
