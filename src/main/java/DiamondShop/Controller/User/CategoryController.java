package DiamondShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamondShop.Dto.PaginatesDto;
import DiamondShop.Service.User.CategoryServiceImpl;
import DiamondShop.Service.User.PaginatesImpl;

@Controller
public class CategoryController extends BaseController {

	@Autowired
	private CategoryServiceImpl categoryService;
	
	@Autowired
	private PaginatesImpl paginateService;
	
	private int totalProductsPage = 9;
	
	@RequestMapping(value= {"/products/{id}"}, method=RequestMethod.GET)
	public ModelAndView product(@PathVariable String id) {
		_mavShare.setViewName("user/products/category");
		int totalData = categoryService.getAllProductByCategoryId(Integer.parseInt(id)).size();
		PaginatesDto paginateInfo = paginateService.getInfoPaginates(1, totalProductsPage, totalData);
		_mavShare.addObject("idCategory", id);
		_mavShare.addObject("paginateInfo", paginateInfo);
		_mavShare.addObject("productsPaginate", categoryService.getProductPaginate(Integer.parseInt(id), 
				paginateInfo.getFirstProduct(), paginateInfo.getLimit()));
		return _mavShare;
	}
	
	@RequestMapping(value= {"/products/{id}/{currentPage}"}, method=RequestMethod.GET)
	public ModelAndView product(@PathVariable String id, @PathVariable int currentPage) {
		_mavShare.setViewName("user/products/category");
		int totalData = categoryService.getAllProductByCategoryId(Integer.parseInt(id)).size();
		PaginatesDto paginateInfo = paginateService.getInfoPaginates(currentPage, totalProductsPage, totalData);
		_mavShare.addObject("idCategory", id);
		_mavShare.addObject("paginateInfo", paginateInfo);
		_mavShare.addObject("productsPaginate", categoryService.getProductPaginate(Integer.parseInt(id), 
				paginateInfo.getFirstProduct(), paginateInfo.getLimit()));
		return _mavShare;
	}
}
