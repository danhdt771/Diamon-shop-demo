package DiamondShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperBills implements RowMapper<Bills> {

	@Override
	public Bills mapRow(ResultSet rs, int rowNum) throws SQLException {
		Bills bill = new Bills();
		bill.setId(rs.getInt("id"));
		bill.setUser_name(rs.getString("user_name"));    
		bill.setPhone(rs.getString("phone"));        
		bill.setDisplay_name(rs.getString("display_name")); 
		bill.setAddress(rs.getString("address"));      
		bill.setTotal(rs.getDouble("total"));        
		bill.setTotal_qty(rs.getInt("total_qty"));        
		bill.setNote(rs.getString("note"));        
		return bill;
	}

}
