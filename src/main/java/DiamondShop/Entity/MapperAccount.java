package DiamondShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperAccount implements RowMapper<Account> {

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Account user = new Account();
		user.setId(rs.getInt("id"));
		user.setUserName(rs.getString("user_name"));
		user.setPassword(rs.getString("password"));
		user.setDisplayName(rs.getString("display_name"));
		user.setAddress(rs.getString("address"));
		user.setUserRole(rs.getString("user_role"));
		return user;
	}

}
