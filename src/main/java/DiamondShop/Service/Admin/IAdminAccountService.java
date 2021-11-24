package DiamondShop.Service.Admin;

import java.util.List;

import org.springframework.stereotype.Service;

import DiamondShop.Entity.Account;

@Service
public interface IAdminAccountService {

	public List<Account> listAccount();
	public List<Account> getAccountWithPagination(int firstAccount, int limit);
	public boolean saveAccount(Account account);
	public boolean register(Account account);
	public boolean deleteAccount(int id);
	public Account findAccountById(int id);
	public Integer checkAccountByUserName(String userName);
} 
