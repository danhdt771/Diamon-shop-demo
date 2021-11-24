package DiamondShop.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import DiamondShop.Entity.MapperMenus;
import DiamondShop.Entity.Menus;

@Repository
public class MenuDAO extends BaseDAO {

	private final String SQL_GET_ALL_MENU = "select * from menus ";
	private final String SQL_FIND_MENU = "select * from menus where id = ?";
	private final String SQL_CHECK_EXISTS_MENU = "select count(*) from menus where id = ?";
	private final String SQL_DELETE_MENU = "delete from menus where id = ?";
	private final String SQL_UPDATE_MENU = "update menus " + "set name = ?, url = ? " + "where id = ?";
	private final String SQL_INSERT_MENU = "insert into menus" + "(name, url) " + "values(?,?)";

	// GET PRODUCT COLOR WITH PAGINATION
	private String sqlMenuPagination(int firstMenus, int limit) {
		StringBuilder sql = new StringBuilder();
		sql.append(SQL_GET_ALL_MENU);
		sql.append("ORDER BY id asc ");
		sql.append("OFFSET " + (firstMenus - 1) + " ROWS ");
		sql.append("FETCH NEXT " + limit + " ROWS ONLY ");

		return sql.toString();
	}

	// GET ALL PRODUCTS.
	public List<Menus> listMenus() {
		return _jdbcTemplate.query(SQL_GET_ALL_MENU, new MapperMenus());
	}

	// GET PRODUCT COLOR WITH PAGINATION.
	public List<Menus> getMenuPagination(int firstMenus, int limit) {
		String sql = sqlMenuPagination(firstMenus, limit);
		return _jdbcTemplate.query(sql, new MapperMenus());
	}

	public boolean deleteMenu(int id) {
		return _jdbcTemplate.update(SQL_DELETE_MENU, id) > 0;
	}

	public boolean updateMenu(Menus menus) {
		return _jdbcTemplate.update(SQL_UPDATE_MENU, 
				menus.getName(), 
				menus.getUrl(),
				menus.getId()) > 0;
	}

	public boolean createMenu(Menus menus) {
		return _jdbcTemplate.update(SQL_INSERT_MENU, 
				menus.getName(), 
				menus.getUrl()) > 0;
	}

	public Menus findMenuById(int id) {
		return _jdbcTemplate.queryForObject(SQL_FIND_MENU, new MapperMenus(), id);
	}

	public Integer checkMenuExists(int id) {
		return _jdbcTemplate.queryForObject(SQL_CHECK_EXISTS_MENU, Integer.class, id);
	}
}
