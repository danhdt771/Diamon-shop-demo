package DiamondShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import DiamondShop.Dto.BillDetailDto;
import DiamondShop.Entity.Account;
import DiamondShop.Entity.Bills;

@Service
public interface IAccountService {
	public int addAcc(Account user);
	public int checkUserExists(String userName);
	public Account findByUserName(String userName);
	public boolean updateMyAccount(Account user);
	public boolean resetPassword(Account user);
	public List<Bills> getBillByUserName(String userName);
	public List<BillDetailDto> getBillDeatail(int id);
	public List<Bills> getBillWithPaginationByUserName(int firstBill, int limit, String userName);
	public Bills findBillById(int id);
}
