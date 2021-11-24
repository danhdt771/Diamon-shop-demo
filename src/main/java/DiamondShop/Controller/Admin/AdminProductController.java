package DiamondShop.Controller.Admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import DiamondShop.Dto.PaginatesDto;
import DiamondShop.Entity.Product;
import DiamondShop.Service.Admin.IAdminCateogryService;
import DiamondShop.Service.Admin.IAdminProductService;
import DiamondShop.Service.User.IPaginateService;

@Controller
public class AdminProductController extends AdminBaseController {
	
	@Autowired
	private IAdminProductService _iAdProductService;
	
	@Autowired
	private IPaginateService _iPaginateService;
	
	@Autowired
	private IAdminCateogryService _iAdminCateogryService;
	
	private int totalProductsPage = 10;
	private String add_edit_template="/admin/product/product-details";
    private String list_template="/admin/product/list-product";
    private String list_redirect="redirect:/admin/list-product";
	
	@GetMapping(value = {"/admin", "/admin/list-product"})
	public ModelAndView index() {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.print("username: ");
		if (principal instanceof UserDetails) {
		  String username = ((UserDetails)principal).getUsername();
		  System.out.print(username);
		} 
		
		int totalData = _iAdProductService.listProducts().size();
		PaginatesDto paginateInfo = _iPaginateService.getInfoPaginates(1, totalProductsPage, totalData);
		
		_view.addObject("listCategories", _iAdminCateogryService.listCategories());
		_view.addObject("paginateInfo", paginateInfo);
		
		//Method getProductWithPagination used to get all product without category id => default id = 0
		_view.addObject("productsPaginate", _iAdProductService.getProductWithPagination( 
				paginateInfo.getFirstProduct(), paginateInfo.getLimit()));
		_view.setViewName(list_template);
		return _view;
	}
	
	@GetMapping(value = {"/admin/list/{currentPage}"})
	public ModelAndView product(@PathVariable int currentPage) {
		_view.setViewName(list_template);
		int totalData = _iAdProductService.listProducts().size();
		PaginatesDto paginateInfo = _iPaginateService.getInfoPaginates(currentPage, totalProductsPage, totalData);
		
		_view.addObject("listCategories", _iAdminCateogryService.listCategories());
		_view.addObject("paginateInfo", paginateInfo);
		_view.addObject("productsPaginate", _iAdProductService.getProductWithPagination( 
				paginateInfo.getFirstProduct(), paginateInfo.getLimit()));
		return _view;
	}
	
	@GetMapping("/admin/edit/{id}")
    public ModelAndView editProduct(@PathVariable("id") long id){
		_view.setViewName(add_edit_template);
		_view.addObject("Product", _iAdProductService.findProductById(id));
		_view.addObject("listCategories", _iAdminCateogryService.listCategories());
        return _view;
    }
	
	@GetMapping("/admin/add")
    public ModelAndView addProduct(){
		_view.setViewName(add_edit_template);
		_view.addObject("Product", new Product());
		_view.addObject("listCategories", _iAdminCateogryService.listCategories());
        return _view;
    }
	
	@PostMapping("/admin/save")
    public String saveProduct(@ModelAttribute Product product, HttpServletRequest request){
        boolean result = _iAdProductService.saveProduct(product);
        if(!result){
            return "redirect:"+request.getHeader("Referer");
        }
        return list_redirect+"?success";
    }

    @GetMapping("/admin/delete/{id}")
    public String deleteProduct(@PathVariable("id") long id) {
    	_iAdProductService.deleteProduct(id);
        return list_redirect+"?deleted";
    }
}
