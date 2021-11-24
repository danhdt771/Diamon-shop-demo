package DiamondShop.Controller.Admin;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminBaseController {

	public ModelAndView _view = new ModelAndView();
	
	@PostConstruct
	public ModelAndView init() {
		return _view;
	}
}
