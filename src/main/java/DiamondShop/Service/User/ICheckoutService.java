package DiamondShop.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import DiamondShop.Dto.CartDto;
import DiamondShop.Entity.Bills;

@Service
public interface ICheckoutService {

	public int addBills(Bills bill);
	public void addBillDetail(HashMap<Integer, CartDto> cart);
}
