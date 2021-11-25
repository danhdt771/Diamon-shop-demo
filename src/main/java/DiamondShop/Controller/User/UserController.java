package DiamondShop.Controller.User;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import DiamondShop.Entity.Account;
import DiamondShop.Service.User.IAccountService;

@Controller
public class UserController extends BaseController {
	
	private static final String process_success_template = "/user/account/processSuccess";
	
	@Autowired
	private IAccountService _iUserService;
	
	public void setToSession(HttpServletRequest request, Account account){
		request.getSession().setAttribute("customerName_", account.getUserName());
        request.getSession().setAttribute("customerId_", account.getId());
//        request.getSession().setAttribute("cartId_", customer.getCart().getCartId());
	}
	
	@RequestMapping(value ="/register")
	public ModelAndView register(HttpServletRequest request) {
		HttpSession session = request.getSession();
		// if user already login, then redirect to home page.
		if(session.getAttribute("customerName_") != null){
			_mavShare.setViewName("redirect:/");
			return _mavShare;
		}
		
        Account user = new Account();
        _mavShare.addObject("user", user);
		_mavShare.setViewName("user/account/register");
		return _mavShare;
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public ModelAndView createAcc(@ModelAttribute("user") Account user, HttpServletRequest request) {
		HttpSession session = request.getSession();
		// if user already login, then redirect to home page.
		if(session.getAttribute("customerName_") != null){
			_mavShare.setViewName("/");
			return _mavShare;
		}
		
		if(_iUserService.checkUserExists(user.getUserName()) > 0){ 
			_mavShare.addObject("email_exists", "Email already exist!");
			_mavShare.setViewName("user/account/register");
			return _mavShare;
        }
		
		int result = _iUserService.addAcc(user);
		if(result > 0) {
			_mavShare.addObject("title", "Register Successful!");
			_mavShare.addObject("targetUrl", "/customer/account");
		}
		Account customer = _iUserService.findByUserName(user.getUserName());
        
		String role = customer.getUserRole();

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

        // EMPLOYEE, MANAGER, USER
        GrantedAuthority authority = new SimpleGrantedAuthority(role);
		
        grantList.add(authority);
        
        Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword(), grantList);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        setToSession(request, customer);
        
		_mavShare.setViewName(process_success_template);
		return _mavShare;
	}
	
	@RequestMapping(value = { "/login" })
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			HttpServletRequest request) {
		_mavShare.addObject("error", null); 
		HttpSession session = request.getSession();
		session.setAttribute("previousUrl", request.getHeader("Referer"));
		// if user already login, then redirect to home page.
		if(session.getAttribute("customerName_") != null){
			_mavShare.setViewName("redirect:/");
			return _mavShare;
		}
    	if (error != null) {
			_mavShare.addObject("error", "* Invalid username or password");
		}
    	_mavShare.setViewName("user/account/register");
    	return _mavShare;
	}
	
	@RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login";
	}
}
