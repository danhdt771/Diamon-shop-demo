package DiamondShop.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.DAO.MenuDAO;
import DiamondShop.Entity.Menus;

@Service
public class AdminMenuImpl implements IAdminMenuService {

	@Autowired
	private MenuDAO _menuDAO;
	
	@Override
	public List<Menus> listMenus() {
		return _menuDAO.listMenus();
	}

	@Override
	public List<Menus> getMenuWithPagination(int firstMenu, int limit) {
		return _menuDAO.getMenuPagination(firstMenu, limit);
	}

	@Override
	public boolean saveMenu(Menus menus) {
		if (_menuDAO.checkMenuExists(menus.getId()) == 0) {
			return _menuDAO.createMenu(menus);
		}
		return _menuDAO.updateMenu(menus);
	}
 
	@Override
	public boolean deleteMenu(int id) {
		return _menuDAO.deleteMenu(id);
	}

	@Override
	public Menus findMenuById(int id) {
		return _menuDAO.findMenuById(id);
	}

}
