package DiamondShop.Service.User;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.DAO.CartDAO;
import DiamondShop.Dto.CartDto;

@Service
public class CartServiceImpl implements ICartService {
	
	@Autowired
	private CartDAO _cartDAO;

	@Override
	public HashMap<Integer, CartDto> addCart(int id, HashMap<Integer, CartDto> cart, int qty) {
		return _cartDAO.addCart(id, cart, qty);
	}

	@Override
	public HashMap<Integer, CartDto> editCart(int id, int qty, HashMap<Integer, CartDto> cart) {
		return _cartDAO.editCart(id, qty, cart);
	}

	@Override
	public HashMap<Integer, CartDto> deleteCart(int id, HashMap<Integer, CartDto> cart) {
		return _cartDAO.deleteCart(id, cart);
	}

	@Override
	public int totalQty(HashMap<Integer, CartDto> cart) {
		return _cartDAO.totalQty(cart);
	}

	@Override
	public int totalPrice(HashMap<Integer, CartDto> cart) {
		return _cartDAO.totalPrice(cart);
	}

}
