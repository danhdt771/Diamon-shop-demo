package DiamondShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamondShop.Service.User.IProductService;

@Controller
public class ProductController extends BaseController {

	@Autowired
	IProductService _iProductService;
	
	@RequestMapping(value= {"/product-details/{id}"}, method=RequestMethod.GET)
	public ModelAndView index(@PathVariable int id) {
		_mavShare.addObject("product",_iProductService.getProductById(id));
		int idCategory = _iProductService.getProductById(id).getId_categories();
		_mavShare.addObject("relatedProducts",_iProductService.getRelatedProduct(idCategory, 5));
		_mavShare.setViewName("user/products/product_detail");
		return _mavShare;
	}
}
