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
import DiamondShop.Entity.Categories;
import DiamondShop.Service.Admin.IAdminCateogryService;
import DiamondShop.Service.User.IPaginateService;

@Controller
@RequestMapping("/admin/category")
public class AdminCategoryContoller extends AdminBaseController {

	@Autowired
	private IAdminCateogryService _iAdminCateogryService;
	
	@Autowired
	private IPaginateService _iPaginateService;
	
	private int totalProductsPage = 10;
	private String add_edit_template="/admin/category/category";
    private String list_template="/admin/category/list-categories";
    private String list_redirect="redirect:/admin/category/list";
    
    @GetMapping(value = {"/list"})
	public ModelAndView index() {
		int totalData = _iAdminCateogryService.listCategories().size();
		PaginatesDto paginateInfo = _iPaginateService.getInfoPaginates(1, totalProductsPage, totalData);
		_view.addObject("paginateInfo", paginateInfo);
		
		//Method getProductWithPagination used to get all product without category id => default id = 0
		_view.addObject("cateogriesPaginate", _iAdminCateogryService.getCategoryWithPagination( 
				paginateInfo.getFirstProduct(), paginateInfo.getLimit()));
		_view.setViewName(list_template);
		return _view;
	}
	
	@GetMapping(value = {"/list/{currentPage}"})
	public ModelAndView Category(@PathVariable int currentPage) {
		_view.setViewName(list_template);
		int totalData = _iAdminCateogryService.listCategories().size();
		PaginatesDto paginateInfo = _iPaginateService.getInfoPaginates(currentPage, totalProductsPage, totalData);
		_view.addObject("paginateInfo", paginateInfo);
		_view.addObject("cateogriesPaginate", _iAdminCateogryService.getCategoryWithPagination( 
				paginateInfo.getFirstProduct(), paginateInfo.getLimit()));
		return _view;
	}
	
	@GetMapping("/edit/{id}")
    public ModelAndView editProduct(@PathVariable("id") long id){
		_view.setViewName(add_edit_template);
		_view.addObject("Categories", _iAdminCateogryService.findCategoryById(id));
        return _view;
    }
	
	@GetMapping("/add")
    public ModelAndView addProduct(){
		_view.setViewName(add_edit_template); 
		_view.addObject("Categories", new Categories());
        return _view;
    }
	
	@PostMapping("/save")
    public String saveProduct(@ModelAttribute Categories categories, HttpServletRequest request){
        boolean result = _iAdminCateogryService.saveCategory(categories);
        if(!result){
            return "redirect:"+request.getHeader("Referer");
        }
        return list_redirect+"?success";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") long id) {
    	_iAdminCateogryService.deleteCategory(id);
        return list_redirect+"?deleted";
    }
}
