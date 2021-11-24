package DiamondShop.Service.User;

import org.springframework.stereotype.Service;

import DiamondShop.Entity.Account;

@Service
public interface IAccountService {
	public int addAcc(Account user);
	public int checkUserExists(String userName);
	public Account findByUserName(String userName);
}
