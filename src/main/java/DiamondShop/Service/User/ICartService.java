package DiamondShop.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import DiamondShop.Dto.CartDto;

@Service
public interface ICartService {

	public HashMap<Integer, CartDto> addCart(int id, HashMap<Integer, CartDto> cart, int qty);
	public HashMap<Integer, CartDto> editCart(int id, int qty, HashMap<Integer, CartDto> cart);
	public HashMap<Integer, CartDto> deleteCart(int id, HashMap<Integer, CartDto> cart);
	public int totalQty(HashMap<Integer, CartDto> cart);
	public int totalPrice(HashMap<Integer, CartDto> cart);
	
}
