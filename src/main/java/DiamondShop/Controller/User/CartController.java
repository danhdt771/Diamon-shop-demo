package DiamondShop.Controller.User;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import DiamondShop.Dto.CartDto;
import DiamondShop.Entity.Account;
import DiamondShop.Entity.Bills;
import DiamondShop.Service.User.IAccountService;
import DiamondShop.Service.User.ICartService;
import DiamondShop.Service.User.ICheckoutService;

@Controller
public class CartController extends BaseController {

	@Autowired
	private ICartService _iCartService;
	
	@Autowired
	private ICheckoutService _iCheckoutService;
	
	@Autowired
	private IAccountService _iUserService;
	
	@RequestMapping(value= {"shopping-cart"})
	public ModelAndView index() {
		_mavShare.setViewName("user/cart/list_cart");
		return _mavShare;
	}
	
	@RequestMapping(value= {"checkout"})
	public ModelAndView indexCheckOut(HttpSession session) {
		_mavShare.setViewName("user/cart/checkout");
		Bills bill = new Bills();
		String userName = (String) session.getAttribute("customerName_");
		Account customer = _iUserService.findByUserName(userName);
		
		if (customer != null) {
			bill.setUser_name(customer.getUserName());
			bill.setDisplay_name(customer.getDisplayName());
			bill.setAddress(customer.getAddress());
		}
		_mavShare.addObject("Bill", bill);
		return _mavShare;
	}
	
	@RequestMapping(value= {"checkout"}, method = RequestMethod.POST)
	public String checkOut(HttpSession session, HttpServletRequest request, @ModelAttribute Bills bill) {
		bill.setTotal((Double.valueOf((Integer)session.getAttribute("TotalPriceCart"))));
		bill.setTotal_qty((Integer)session.getAttribute("TotalQtyCart"));
		if (_iCheckoutService.addBills(bill) > 0) {
			HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>) session.getAttribute("Cart");
			_iCheckoutService.addBillDetail(cart);
		}
		session.removeAttribute("Cart");
		session.removeAttribute("TotalQtyCart");
		session.removeAttribute("TotalPriceCart");
		return "redirect:shopping-cart";
	}
	
	@RequestMapping(value = {"addCartWithQty/{id}"})
	public String addCartWithQty(HttpServletRequest request, HttpSession session, @PathVariable int id,
			@RequestParam("qty") int qty) {
		HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>)session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Integer, CartDto>();
		}
		cart = _iCartService.addCart(id, cart, qty);
//		session.setAttribute("Cart", cart);
//		session.setAttribute("TotalQtyCart", _iCartService.totalQty(cart));
//		session.setAttribute("TotalPriceCart", _iCartService.totalPrice(cart));
		storeCartInSession(session, cart, _iCartService.totalQty(cart), _iCartService.totalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value = {"addCart/{id}"})
	public String addCart(HttpServletRequest request, HttpSession session, @PathVariable int id) {
		HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>)session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Integer, CartDto>();
		}
		int qty = 1;
		cart = _iCartService.addCart(id, cart, qty);
//		session.setAttribute("Cart", cart);
//		session.setAttribute("TotalQtyCart", _iCartService.totalQty(cart));
//		session.setAttribute("TotalPriceCart", _iCartService.totalPrice(cart));
		storeCartInSession(session, cart, _iCartService.totalQty(cart), _iCartService.totalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value = {"editCart/{id}/{qty}"})
	public String editCart(HttpServletRequest request, HttpSession session, @PathVariable int id, @PathVariable int qty) {
		HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>)session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Integer, CartDto>();
		}
		cart = _iCartService.editCart(id, qty, cart);
//		session.setAttribute("Cart", cart);
//		session.setAttribute("TotalQtyCart", _iCartService.totalQty(cart));
//		session.setAttribute("TotalPriceCart", _iCartService.totalPrice(cart));
		storeCartInSession(session, cart, _iCartService.totalQty(cart), _iCartService.totalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value = {"deleteCart/{id}"})
	public String deleteCart(HttpServletRequest request, HttpSession session, @PathVariable int id) {
		HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>)session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Integer, CartDto>();
		}
		cart = _iCartService.deleteCart(id, cart);
//		session.setAttribute("Cart", cart);
//		session.setAttribute("TotalQtyCart", _iCartService.totalQty(cart));
//		session.setAttribute("TotalPriceCart", _iCartService.totalPrice(cart));
		storeCartInSession(session, cart, _iCartService.totalQty(cart), _iCartService.totalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	
	public void storeCartInSession(HttpSession session, HashMap<Integer, CartDto> cart, 
			int totalQtyCart, int totalPriceCart) {
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQtyCart", _iCartService.totalQty(cart));
		session.setAttribute("TotalPriceCart", _iCartService.totalPrice(cart));
	}
}
