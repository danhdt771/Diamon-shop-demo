package DiamondShop.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.DAO.BillDAO;
import DiamondShop.Entity.Bills;

@Service
public class AdminBillImpl implements IAdminBillService {

	@Autowired
	private BillDAO _billDAO;
	
	@Override
	public List<Bills> listBill() {
		return _billDAO.listBill();
	}

	@Override
	public List<Bills> getBillWithPagination(int firstBill, int limit) {
		return _billDAO.getBillPagination(firstBill, limit);
	}

	@Override
	public boolean saveBill(Bills bill) {
		return _billDAO.updateBill(bill);
	}

	@Override
	public boolean deleteBill(int id) {
		return _billDAO.deleteBill(id);
	}

	@Override
	public Bills findBillById(int id) {
		return _billDAO.findBillById(id);
	}

}
