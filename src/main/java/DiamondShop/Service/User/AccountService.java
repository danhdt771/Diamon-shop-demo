package DiamondShop.Service.User;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.DAO.AccountDAO;
import DiamondShop.Entity.Account;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private AccountDAO _userDAO;

	@Override
	public int addAcc(Account user) {
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
		user.setUserRole("ROLE_USER");
		return _userDAO.addAccount(user);
	}

	@Override
	public int checkUserExists(String userName) {
		return _userDAO.checkUserExistsByUserName(userName);
	}
	
	@Override
	public Account findByUserName(String userName) {
		return _userDAO.findUserByUserName(userName);
	}
}
