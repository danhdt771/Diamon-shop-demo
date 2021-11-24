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
import DiamondShop.Entity.Bills;
import DiamondShop.Service.Admin.IAdminBillDetailService;
import DiamondShop.Service.Admin.IAdminBillService;
import DiamondShop.Service.User.IPaginateService;

@Controller
@RequestMapping("/admin/bill")
public class AdminBillController extends AdminBaseController {

	@Autowired
	private IAdminBillService _iAdminBillService;
	
	@Autowired
	private IAdminBillDetailService _iAdminBillDetailService;
	
	@Autowired
	private IPaginateService _iPaginateService;
	
	private int totalProductsPage = 10;
	private String add_edit_template="/admin/bill/bill-details";
    private String list_template="/admin/bill/list-bill";
    private String list_redirect="redirect:/admin/bill/list";
    
    @GetMapping(value = {"/list"})
	public ModelAndView index() {
		int totalData = _iAdminBillService.listBill().size();
		PaginatesDto paginateInfo = _iPaginateService.getInfoPaginates(1, totalProductsPage, totalData);
		_view.addObject("paginateInfo", paginateInfo);
		
		//Method getProductWithPagination used to get all product without category id => default id = 0
		_view.addObject("billPaginate", _iAdminBillService.getBillWithPagination( 
				paginateInfo.getFirstProduct(), paginateInfo.getLimit()));
		_view.setViewName(list_template);
		return _view;
	}
	
	@GetMapping(value = {"/list/{currentPage}"})
	public ModelAndView Category(@PathVariable int currentPage) {
		_view.setViewName(list_template);
		int totalData = _iAdminBillService.listBill().size();
		PaginatesDto paginateInfo = _iPaginateService.getInfoPaginates(currentPage, totalProductsPage, totalData);
		_view.addObject("paginateInfo", paginateInfo);
		_view.addObject("billPaginate", _iAdminBillService.getBillWithPagination( 
				paginateInfo.getFirstProduct(), paginateInfo.getLimit()));
		return _view;
	} 
	 
	@GetMapping("/view/{id}")
    public ModelAndView editProduct(@PathVariable("id") int id){
		_view.setViewName(add_edit_template);
		_view.addObject("Bill", _iAdminBillService.findBillById(id));
		_view.addObject("BillDetail", _iAdminBillDetailService.getBillDeatail(id));
        return _view;
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
    	_iAdminBillService.deleteBill(id);
        return list_redirect+"?deleted";
    }
}
