package DiamondShop.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserAccountController extends BaseController {

	@RequestMapping("/customer/account")
	public String index() {
		return "/user/account/myAccount";
	}
}
