package DiamondShop.DAO;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import DiamondShop.Dto.CartDto;
import DiamondShop.Dto.ProductsDto;

@Repository
public class CartDAO extends BaseDAO {
	
	@Autowired
	ProductsDAO _productDAO;
	
	public HashMap<Integer, CartDto> addCart(int id, HashMap<Integer, CartDto> cart, int qty) {
		CartDto itemCart = new CartDto();
		ProductsDto product = _productDAO.findProductById(id);
		if(product != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQty(itemCart.getQty() + qty);
			itemCart.setTotalPrice(itemCart.getQty() * itemCart.getProduct().getPrice());
		} else {
			itemCart.setProduct(product);
			itemCart.setQty(qty);
			itemCart.setTotalPrice(product.getPrice());
		}
		cart.put(id, itemCart);
		
		return cart;
	}
	
	public HashMap<Integer, CartDto> editCart(int id, int qty, HashMap<Integer, CartDto> cart) {
		if(cart == null) {
			return cart;
		}
		CartDto itemCart = new CartDto();
		if(cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQty(qty);
			double totalPrice = qty * itemCart.getProduct().getPrice();
			itemCart.setTotalPrice(totalPrice);
		}
		cart.put(id, itemCart);
		
		return cart;
	}
	
	public HashMap<Integer, CartDto> deleteCart(int id, HashMap<Integer, CartDto> cart) {
		if(cart == null) {
			return cart;
		}
		if(cart.containsKey(id)) {
			cart.remove(id);
		}
		
		return cart;
	}
	
	public int totalQty(HashMap<Integer, CartDto> cart) {
		int totalQty = 0;
		for (Map.Entry<Integer, CartDto> itemCart : cart.entrySet()) {
			totalQty += itemCart.getValue().getQty();
		}
		
		return totalQty;
	}
	
	public int totalPrice(HashMap<Integer, CartDto> cart) {
		int totalPrice = 0;
		for (Map.Entry<Integer, CartDto> itemCart : cart.entrySet()) {
			totalPrice += itemCart.getValue().getTotalPrice();
		}
		
		return totalPrice;
	}
}
