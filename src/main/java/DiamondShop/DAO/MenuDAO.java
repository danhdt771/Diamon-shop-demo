package DiamondShop.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamondShop.Entity.MapperMenus;
import DiamondShop.Entity.Menus;

@Repository
public class MenuDAO extends BaseDAO {

	public List<Menus> getMenus() {
		List<Menus> menus = new ArrayList<Menus>();
		String query = "Select * from menus";
		menus = _jdbcTemplate.query(query, new MapperMenus());
		return menus;
	}
}
