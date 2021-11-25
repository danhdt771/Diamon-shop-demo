package DiamondShop.Controller.User;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DiamondShop.Dto.PaginatesDto;
import DiamondShop.Entity.Account;
import DiamondShop.Service.User.IAccountService;
import DiamondShop.Service.User.IPaginateService;

@Controller
public class UserAccountController extends BaseController {

	private static final String process_success_template = "/user/account/processSuccess";

	@Autowired
	private IAccountService _iUserService;
	
	@Autowired
	private IPaginateService _iPaginateService;
	
	private int totalProductsPage = 10;

	public void setToSession(HttpServletRequest request, Account account){
		request.getSession().setAttribute("customerName_", account.getUserName());
        request.getSession().setAttribute("customerId_", account.getId());
//        request.getSession().setAttribute("cartId_", customer.getCart().getCartId());
	}
	
	@RequestMapping("/customer/account")
	public ModelAndView account(HttpSession session) {
		_mavShare.setViewName("/user/account/myAccount");
		String userName = (String) session.getAttribute("customerName_");
		Account user = _iUserService.findByUserName(userName);
		_mavShare.addObject("user", user);
		_mavShare.addObject("msg", "");
		return _mavShare;
	}

	@PostMapping("/customer/changeProfile")
	public ModelAndView changeProfile(HttpSession session, @ModelAttribute("user") Account user) {
		_mavShare.setViewName("/user/account/myAccount");
		boolean result = _iUserService.updateMyAccount(user);
		if (result) {
			_mavShare.addObject("msg", "Successfully changed information!");
		} else {
			_mavShare.addObject("msg", "Change information failed!");
		}
		_mavShare.addObject("user", user);
		return _mavShare;
	}

	@GetMapping("/customer/changePassword")
	public ModelAndView changePassword(HttpSession session) {
		_mavShare.setViewName("/user/account/changePassword");
		String userName = (String) session.getAttribute("customerName_");
		Account user = _iUserService.findByUserName(userName);
		_mavShare.addObject("userInfo", user);
		_mavShare.addObject("user", new Account());
		return _mavShare;
	}

	@PostMapping("/customer/changePassword")
	public ModelAndView changePasswordPost(@ModelAttribute("user") Account user, HttpServletRequest request) {
		_mavShare.setViewName(process_success_template);
		boolean result = _iUserService.resetPassword(user);
		if (result) {
			_mavShare.addObject("title", "Your password has been reset!");
			_mavShare.addObject("targetUrl", "/customer/account");
		}
		
		Account customer = _iUserService.findByUserName(user.getUserName());

		String role = customer.getUserRole();

		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

		// EMPLOYEE, MANAGER, USER
		GrantedAuthority authority = new SimpleGrantedAuthority(role);

		grantList.add(authority);

		Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword(),
				grantList);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		setToSession(request, customer);
		
		return _mavShare;
	}
	
	@GetMapping("customer/myOrder")
	public ModelAndView myOrder(HttpSession session) {
		String userName = (String) session.getAttribute("customerName_");
		int totalData = _iUserService.getBillByUserName(userName).size();
		PaginatesDto paginateInfo = _iPaginateService.getInfoPaginates(1, totalProductsPage, totalData);
		_mavShare.addObject("paginateInfo", paginateInfo);
		_mavShare.addObject("billPaginate", _iUserService.getBillWithPaginationByUserName( 
				paginateInfo.getFirstProduct(), paginateInfo.getLimit(), userName));
		_mavShare.setViewName("/user/account/myOrder");
		return _mavShare;
	}
	
	@GetMapping(value = {"/customer/myOrder/{currentPage}"})
	public ModelAndView myOrder(HttpSession session, @PathVariable int currentPage) {
		String userName = (String) session.getAttribute("customerName_");
		int totalData = _iUserService.getBillByUserName(userName).size();
		PaginatesDto paginateInfo = _iPaginateService.getInfoPaginates(currentPage, totalProductsPage, totalData);
		_mavShare.addObject("paginateInfo", paginateInfo);
		_mavShare.addObject("billPaginate", _iUserService.getBillWithPaginationByUserName( 
				paginateInfo.getFirstProduct(), paginateInfo.getLimit(), userName));
		_mavShare.setViewName("/user/account/myOrder");
		return _mavShare;
	} 
	
	@GetMapping("/customer/myOrder/view//{id}")
    public ModelAndView editProduct(@PathVariable("id") int id){
		_mavShare.setViewName("/user/account/myOrderDetail");
		_mavShare.addObject("Bill", _iUserService.findBillById(id));
		_mavShare.addObject("BillDetail", _iUserService.getBillDeatail(id));
        return _mavShare;
    }
}
