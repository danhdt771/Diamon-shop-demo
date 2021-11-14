package DiamondShop.Service.User;

import org.springframework.stereotype.Service;

import DiamondShop.Entity.Account;

@Service
public interface IAccountService {
	public int addAcc(Account user);
	public Account checkAcc(Account user);
}
