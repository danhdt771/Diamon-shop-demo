package DiamondShop.Controller.User;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import DiamondShop.Entity.Account;
import DiamondShop.Service.User.IHomeService;

@Controller
public class BaseController {

	@Autowired
	IHomeService _iHomeService;
	public ModelAndView _mavShare = new ModelAndView();
	
	@PostConstruct
	public ModelAndView init() {
		_mavShare.addObject("menus",_iHomeService.getMenus());
		_mavShare.addObject("user", new Account());
		return _mavShare;
	}
}
