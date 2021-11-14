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
		return _userDAO.addAccount(user);
	}

	@Override
	public Account checkAcc(Account user) {
		String password = user.getPassword();
		Account _user = _userDAO.findUserByUserName(user.getUserName());
		
		if(_user != null) {
			if (BCrypt.checkpw(password, _user.getPassword())) {
				return _user;
			} else {
				return null;
			}
		}
		return null;
	}

}
