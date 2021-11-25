package DiamondShop.Service.User;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.DAO.AccountDAO;
import DiamondShop.DAO.BillDAO;
import DiamondShop.DAO.BillDetailDAO;
import DiamondShop.Dto.BillDetailDto;
import DiamondShop.Entity.Account;
import DiamondShop.Entity.Bills;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private AccountDAO _userDAO;
	
	@Autowired
	private BillDAO _billDAO;
	
	@Autowired
	private BillDetailDAO _billDetailDAO;

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
	
	@Override
	public boolean updateMyAccount(Account user) {
		return _userDAO.updateMyAccount(user);
	} 
	
	@Override
	public boolean resetPassword(Account user) {
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
		return _userDAO.resetPassword(user);
	}
	
	@Override
	public List<Bills> getBillByUserName(String userName) {
		return _billDAO.getBillByUserName(userName); 
	}
	
	@Override
	public List<BillDetailDto> getBillDeatail(int id) {
		return _billDetailDAO.getBillDetail(id);
	}
	
	@Override
	public List<Bills> getBillWithPaginationByUserName(int firstBill, int limit, String userName) {
		return _billDAO.getBillPaginationByUserName(firstBill, limit, userName);
	}
	
	@Override
	public Bills findBillById(int id) {
		return _billDAO.findBillById(id);
	}
}
