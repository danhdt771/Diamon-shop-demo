package DiamondShop.Service.Admin;

import java.util.List;

import org.springframework.stereotype.Service;

import DiamondShop.Entity.Menus;

@Service
public interface IAdminMenuService {

	public List<Menus> listMenus();
	public List<Menus> getMenuWithPagination(int firstMenu, int limit);
	public boolean saveMenu(Menus Menus);
	public boolean deleteMenu(int id);
	public Menus findMenuById(int id);
}
