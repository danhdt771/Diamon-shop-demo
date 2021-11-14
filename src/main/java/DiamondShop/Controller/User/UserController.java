package DiamondShop.Controller.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamondShop.Entity.Account;
import DiamondShop.Service.User.IAccountService;

@Controller
public class UserController extends BaseController {

	@Autowired
	private IAccountService _iUserService;
	
	@RequestMapping(value = { "/register" })
	public ModelAndView register() {
		_mavShare.setViewName("user/account/register");
		return _mavShare;
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public ModelAndView createAcc(@ModelAttribute("user") Account user) {
		user.setUserRole("USER");
		int result = _iUserService.addAcc(user);
		if(result > 0) {
			_mavShare.addObject("statusRegister", "Success!");
		} else {
			_mavShare.addObject("statusRegister", "Fail!");
		}
		_mavShare.setViewName("user/account/register");
		return _mavShare;
	}
	
//	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
//	public ModelAndView login(HttpSession session, @ModelAttribute("user") Account user) {
//		user = _iUserService.checkAcc(user);
//		if(user != null) {
//			session.setAttribute("LoginInfo", user);
//			_mavShare.setViewName("redirect:home-page");
//		} else {
//			_mavShare.addObject("statusLogin", "Login Fail!");
//		}
//		return _mavShare;
//	}
	
	@RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
	public String logout(HttpServletRequest request, HttpSession session) {
		session.removeAttribute("LoginInfo");
		return "redirect:"+request.getHeader("Referer");
	}
}
