package DiamondShop.Controller.Admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DiamondShop.Dto.PaginatesDto;
import DiamondShop.Entity.Account;
import DiamondShop.Service.Admin.IAdminAccountService;
import DiamondShop.Service.User.IPaginateService;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController extends AdminBaseController {

	@Autowired
	private IAdminAccountService _iAdminAccountService;
	
	@Autowired
	private IPaginateService _iPaginateService;
	
	private int totalProductsPage = 10;
	private String add_edit_template="/admin/user/user";
    private String list_template="/admin/user/list-user";
    private String list_redirect="redirect:/admin/user/list";
    
    @GetMapping(value = {"/list"})
	public ModelAndView index() {
		int totalData = _iAdminAccountService.listAccount().size();
		PaginatesDto paginateInfo = _iPaginateService.getInfoPaginates(1, totalProductsPage, totalData);
		_view.addObject("paginateInfo", paginateInfo);
		
		//Method getProductWithPagination used to get all product without category id => default id = 0
		_view.addObject("accountPaginate", _iAdminAccountService.getAccountWithPagination( 
				paginateInfo.getFirstProduct(), paginateInfo.getLimit()));
		_view.setViewName(list_template);
		return _view;
	}
	
	@GetMapping(value = {"/list/{currentPage}"})
	public ModelAndView Category(@PathVariable int currentPage) {
		_view.setViewName(list_template);
		int totalData = _iAdminAccountService.listAccount().size();
		PaginatesDto paginateInfo = _iPaginateService.getInfoPaginates(currentPage, totalProductsPage, totalData);
		_view.addObject("paginateInfo", paginateInfo);
		_view.addObject("accountPaginate", _iAdminAccountService.getAccountWithPagination( 
				paginateInfo.getFirstProduct(), paginateInfo.getLimit()));
		return _view;
	} 
	 
	@GetMapping("/edit/{id}")
    public ModelAndView editProduct(@PathVariable("id") int id){
		_view.setViewName(add_edit_template);
		_view.addObject("Account", _iAdminAccountService.findAccountById(id));
        return _view;
    }
	
	@GetMapping("/add")
    public ModelAndView addProduct(){
		_view.setViewName(add_edit_template); 
		_view.addObject("Account", new Account());
        return _view;
    }
	
	@PostMapping("/save")
    public String saveProduct(@ModelAttribute Account account, HttpServletRequest request){
        boolean result = _iAdminAccountService.saveAccount(account);
        if(!result){
            return "redirect:"+request.getHeader("Referer");
        }
        return list_redirect+"?success";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
    	_iAdminAccountService.deleteAccount(id);
        return list_redirect+"?deleted";
    }
}
