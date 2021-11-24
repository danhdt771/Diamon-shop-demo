package DiamondShop.Service.Admin;

import java.util.List;

import org.springframework.stereotype.Service;

import DiamondShop.Entity.Bills;

@Service
public interface IAdminBillService {
	
	public List<Bills> listBill();
	public List<Bills> getBillWithPagination(int firstBill, int limit);
	public boolean saveBill(Bills bill);
	public boolean deleteBill(int id);
	public Bills findBillById(int id);
}
