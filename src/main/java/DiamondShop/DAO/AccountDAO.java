package DiamondShop.DAO;

import org.springframework.stereotype.Repository;

import DiamondShop.Entity.Account;
import DiamondShop.Entity.MapperAccount;

@Repository
public class AccountDAO extends BaseDAO {
	
	public int addAccount(Account user) {
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT INTO users ( ");
		sql.append("user_name, ");
		sql.append("password, ");
		sql.append("display_name, ");
		sql.append("address ");
		sql.append(") VALUES ");
		sql.append("( ");
		sql.append("'"+user.getUserName()+"', ");
		sql.append("'"+user.getPassword()+"', ");
		sql.append("'"+user.getDisplayName()+"', ");
		sql.append("'"+user.getAddress()+"' ");
		sql.append(");");
		
		int insert = _jdbcTemplate.update(sql.toString());
		
		return insert;
	}
	
	public Account findUserByUserName(String username) {
		String sql = "Select * from Users Where user_name ='"+username+"'";
		Account _user = _jdbcTemplate.queryForObject(sql, new MapperAccount());
		return _user;
	}
}
