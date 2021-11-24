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
import DiamondShop.Entity.ProductColor;
import DiamondShop.Service.Admin.IAdminProductColorService;
import DiamondShop.Service.User.IPaginateService;

@Controller
@RequestMapping("/admin/product-color")
public class AdminProductColorController extends AdminBaseController {

	@Autowired
	private IAdminProductColorService _iAdProductColorService;
	
	@Autowired
	private IPaginateService _iPaginateService;
	
	private int totalProductsPage = 10;
	private String add_edit_template="/admin/product-color/product-color-details";
    private String list_template="/admin/product-color/list-product-color";
    private String list_redirect="redirect:/admin/product-color/list";
	
	@GetMapping(value = {"/list"})
	public ModelAndView index() {
		int totalData = _iAdProductColorService.listProductColors().size();
		PaginatesDto paginateInfo = _iPaginateService.getInfoPaginates(1, totalProductsPage, totalData);
		_view.addObject("paginateInfo", paginateInfo);
		
		//Method getProductWithPagination used to get all product without category id => default id = 0
		_view.addObject("productColorPaginate", _iAdProductColorService.getProductColorWithPagination( 
				paginateInfo.getFirstProduct(), paginateInfo.getLimit()));
		_view.setViewName(list_template);
		return _view;
	}
	
	@GetMapping(value = {"/list/{currentPage}"})
	public ModelAndView productColor(@PathVariable int currentPage) {
		_view.setViewName(list_template);
		int totalData = _iAdProductColorService.listProductColors().size();
		PaginatesDto paginateInfo = _iPaginateService.getInfoPaginates(currentPage, totalProductsPage, totalData);
		_view.addObject("paginateInfo", paginateInfo);
		_view.addObject("productColorPaginate", _iAdProductColorService.getProductColorWithPagination( 
				paginateInfo.getFirstProduct(), paginateInfo.getLimit()));
		return _view;
	}
	
	@GetMapping("/edit/{id}")
    public ModelAndView editProduct(@PathVariable("id") long id){
		_view.setViewName(add_edit_template);
		_view.addObject("ProductColor", _iAdProductColorService.findProductColorById(id));
        return _view;
    }
	
	@GetMapping("/add")
    public ModelAndView addProduct(){
		_view.setViewName(add_edit_template);
		_view.addObject("ProductColor", new ProductColor());
        return _view;
    }
	
	@PostMapping("/save")
    public String saveProduct(@ModelAttribute ProductColor productColor, HttpServletRequest request){
        boolean result = _iAdProductColorService.saveProductColor(productColor);
        if(!result){
            return "redirect:"+request.getHeader("Referer");
        }
        return list_redirect+"?success";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") long id) {
    	_iAdProductColorService.deleteProductColor(id);
        return list_redirect+"?deleted";
    }
}
