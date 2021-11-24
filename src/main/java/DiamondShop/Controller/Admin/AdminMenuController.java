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
import DiamondShop.Entity.Menus;
import DiamondShop.Service.Admin.IAdminMenuService;
import DiamondShop.Service.User.IPaginateService;

@Controller
@RequestMapping("/admin/menu")
public class AdminMenuController extends AdminBaseController {

	@Autowired
	private IAdminMenuService _iAdminMenuService;
	
	@Autowired
	private IPaginateService _iPaginateService;
	
	private int totalProductsPage = 10;
	private String add_edit_template="/admin/menu/menu";
    private String list_template="/admin/menu/list-menu";
    private String list_redirect="redirect:/admin/menu/list";
    
    @GetMapping(value = {"/list"})
	public ModelAndView index() {
		int totalData = _iAdminMenuService.listMenus().size();
		PaginatesDto paginateInfo = _iPaginateService.getInfoPaginates(1, totalProductsPage, totalData);
		_view.addObject("paginateInfo", paginateInfo);
		
		//Method getProductWithPagination used to get all product without category id => default id = 0
		_view.addObject("menuPaginate", _iAdminMenuService.getMenuWithPagination( 
				paginateInfo.getFirstProduct(), paginateInfo.getLimit()));
		_view.setViewName(list_template);
		return _view;
	}
	
	@GetMapping(value = {"/list/{currentPage}"})
	public ModelAndView Category(@PathVariable int currentPage) {
		_view.setViewName(list_template);
		int totalData = _iAdminMenuService.listMenus().size();
		PaginatesDto paginateInfo = _iPaginateService.getInfoPaginates(currentPage, totalProductsPage, totalData);
		_view.addObject("paginateInfo", paginateInfo);
		_view.addObject("menuPaginate", _iAdminMenuService.getMenuWithPagination( 
				paginateInfo.getFirstProduct(), paginateInfo.getLimit()));
		return _view;
	}
	
	@GetMapping("/edit/{id}")
    public ModelAndView editProduct(@PathVariable("id") int id){
		_view.setViewName(add_edit_template);
		_view.addObject("Menus", _iAdminMenuService.findMenuById(id));
        return _view;
    }
	
	@GetMapping("/add")
    public ModelAndView addProduct(){
		_view.setViewName(add_edit_template); 
		_view.addObject("Menus", new Menus());
        return _view;
    }
	
	@PostMapping("/save")
    public String saveProduct(@ModelAttribute Menus menus, HttpServletRequest request){
        boolean result = _iAdminMenuService.saveMenu(menus);
        if(!result){
            return "redirect:"+request.getHeader("Referer");
        }
        return list_redirect+"?success";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
    	_iAdminMenuService.deleteMenu(id);
        return list_redirect+"?deleted";
    }
}
