package DiamondShop.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import DiamondShop.Entity.Account;
import DiamondShop.Entity.MapperAccount;

@Repository
public class AccountDAO extends BaseDAO {

	private final String SQL_GET_ALL_ACCOUNT = "select * from users ";
	private final String SQL_FIND_ACCOUNT_BY_ID = "select * from users where id = ?";
	private final String SQL_CHECK_EXISTS_ACCOUNT = "select count(*) from users where id = ?";
	private final String SQL_CHECK_EXISTS_ACCOUNT_BY_USERNAME = "select count(*) from users where user_name = ?";
	private final String SQL_FIND_ACCOUNT_BY_USERNAME = "select * from users where user_name = ?";
	private final String SQL_DELETE_ACCOUNT = "delete from users where id = ?";
	private final String SQL_UPDATE_ACCOUNT = "update users "
			+ "set user_name = ?, password = ?, display_name = ?, user_role = ?, address = ? " + "where id = ?";
	private final String SQL_INSERT_ACCOUNT = "insert into users" + "(user_name, password,display_name,user_role,address) "
			+ "values(?,?,?,?,?)";

	public int addAccount(Account user) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO users ( ");
		sql.append("user_name, ");
		sql.append("password, ");
		sql.append("display_name, ");
		sql.append("user_role, ");
		sql.append("address ");
		sql.append(") VALUES ");
		sql.append("( ");
		sql.append("'" + user.getUserName() + "', ");
		sql.append("'" + user.getPassword() + "', ");
		sql.append("'" + user.getDisplayName() + "', ");
		sql.append("'" + user.getUserRole() + "', ");
		sql.append("'" + user.getAddress() + "' ");
		sql.append(");");

		int insert = _jdbcTemplate.update(sql.toString());

		return insert;
	}

	public Account findUserByUserName(String username) {
		Account user = _jdbcTemplate.queryForObject(SQL_FIND_ACCOUNT_BY_USERNAME, new MapperAccount(), username);
		return user;
	}

	// GET USER WITH PAGINATION
	private String sqlAccountPagination(int firstAccount, int limit) {
		StringBuilder sql = new StringBuilder();
		sql.append(SQL_GET_ALL_ACCOUNT);
		sql.append("ORDER BY id asc ");
		sql.append("OFFSET " + (firstAccount - 1) + " ROWS ");
		sql.append("FETCH NEXT " + limit + " ROWS ONLY ");

		return sql.toString();
	}

	// GET ALL USER.
	public List<Account> listUser() {
		return _jdbcTemplate.query(SQL_GET_ALL_ACCOUNT, new MapperAccount());
	}

	// GET USER WITH PAGINATION.
	public List<Account> getUserPagination(int firstAccount, int limit) {
		String sql = sqlAccountPagination(firstAccount, limit);
		return _jdbcTemplate.query(sql, new MapperAccount());
	}

	public boolean deleteUser(int id) {
		return _jdbcTemplate.update(SQL_DELETE_ACCOUNT, id) > 0;
	}

	public boolean updateUser(Account account) {
		return _jdbcTemplate.update(SQL_UPDATE_ACCOUNT, 
				account.getUserName(), 
				account.getPassword(), 
				account.getDisplayName(), 
				account.getUserRole(), 
				account.getAddress(), 
				account.getId()) > 0;
	}

	public boolean createUser(Account account) {
		return _jdbcTemplate.update(SQL_INSERT_ACCOUNT, 
				account.getUserName(), 
				account.getPassword(), 
				account.getDisplayName(), 
				account.getUserRole(), 
				account.getAddress()) > 0;
	}

	public Account findUserById(int id) {
		return _jdbcTemplate.queryForObject(SQL_FIND_ACCOUNT_BY_ID, new MapperAccount(), id);
	}

	public Integer checkUserExists(int id) {
		return _jdbcTemplate.queryForObject(SQL_CHECK_EXISTS_ACCOUNT, Integer.class, id);
	}
	
	public Integer checkUserExistsByUserName(String userName) {
		return _jdbcTemplate.queryForObject(SQL_CHECK_EXISTS_ACCOUNT_BY_USERNAME, Integer.class, userName);
	}
}
