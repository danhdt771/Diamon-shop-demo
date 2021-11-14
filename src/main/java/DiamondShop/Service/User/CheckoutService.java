package DiamondShop.Service.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.DAO.BillDAO;
import DiamondShop.Dto.CartDto;
import DiamondShop.Entity.BillDetail;
import DiamondShop.Entity.Bills;

@Service
public class CheckoutService implements ICheckoutService {

	@Autowired
	private BillDAO _billDAO;

	@Override
	public int addBills(Bills bill) {
		return _billDAO.addBill(bill);
	}

	@Override
	public void addBillDetail(HashMap<Integer, CartDto> cart) {
		int idBill = _billDAO.getIdLastBill();
		
		for (Map.Entry<Integer, CartDto> itemCart : cart.entrySet()) {
			BillDetail billDetail = new BillDetail();
			billDetail.setId_bill(idBill);
			billDetail.setId_product(itemCart.getValue().getProduct().getId());
			billDetail.setTotal(itemCart.getValue().getTotalPrice());
			billDetail.setQty(itemCart.getValue().getQty());
			_billDAO.addBillDetail(billDetail);
		}
	}

}
