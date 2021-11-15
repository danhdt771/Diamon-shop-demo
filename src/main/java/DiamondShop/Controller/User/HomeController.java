package DiamondShop.Controller.User;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController {
	public static final String FEATURED_PRODUCT = "FEATURED_PRODUCT";
	public static final String NEW_PRODUCT = "NEW_PRODUCT";

	@RequestMapping(value = { "/", "home-page" }, method = RequestMethod.GET)
	public ModelAndView index(Principal principal, HttpSession session) {
		if(principal != null) {
			session.setAttribute("userName", principal.getName());
		}
		
		_mavShare.addObject("slides", _iHomeService.getDataSlide());
		_mavShare.addObject("featuredProducts", _iHomeService.getProducts(FEATURED_PRODUCT));
		_mavShare.addObject("newProducts", _iHomeService.getProducts(NEW_PRODUCT));
		_mavShare.setViewName("user/index");
		return _mavShare;
	}

//	@RequestMapping("/403")
//	public String accessDenied() {
//		return "/403";
//	}
}
