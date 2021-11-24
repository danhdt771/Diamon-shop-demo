package DiamondShop.Service.Admin;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.DAO.AccountDAO;
import DiamondShop.Entity.Account;

@Service
public class AdminAccountImpl implements IAdminAccountService {

	@Autowired
	private AccountDAO _accountDAO;
	
	@Override
	public List<Account> listAccount() {
		return _accountDAO.listUser();
	}

	@Override
	public List<Account> getAccountWithPagination(int firstAccount, int limit) {
		return _accountDAO.getUserPagination(firstAccount, limit);
	}

	@Override
	public boolean saveAccount(Account account) {
		if (_accountDAO.checkUserExists(account.getId()) == 0) {
			account.setPassword(BCrypt.hashpw(account.getPassword(), BCrypt.gensalt(12)));
			return _accountDAO.createUser(account);
		}
		return _accountDAO.updateUser(account);
	}

	@Override
	public boolean deleteAccount(int id) {
		return _accountDAO.deleteUser(id);
	}

	@Override
	public Account findAccountById(int id) {
		return _accountDAO.findUserById(id);
	}
	
	@Override
	public boolean register(Account account) {
		account.setUserRole("ROLE_EMPLOYEE");
		account.setPassword(BCrypt.hashpw(account.getPassword(), BCrypt.gensalt(12)));
		return _accountDAO.createUser(account);
	}

	@Override
	public Integer checkAccountByUserName(String userName) { 
		return _accountDAO.checkUserExistsByUserName(userName);
	}
}
