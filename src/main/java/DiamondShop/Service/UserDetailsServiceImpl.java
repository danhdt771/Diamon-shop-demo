package DiamondShop.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import DiamondShop.DAO.AccountDAO;
import DiamondShop.Entity.Account;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AccountDAO userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = userDao.findUserByUserName(username);
		if (account == null) {
			throw new UsernameNotFoundException("User " //
					+ username + " was not found in the database");
		}
		
		// EMPLOYEE,MANAGER,..
        String role = account.getUserRole();

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

        // EMPLOYEE, MANAGER, USER
        GrantedAuthority authority = new SimpleGrantedAuthority(role);
		
        grantList.add(authority);
        
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        UserDetails userDetails = (UserDetails) new User(account.getUserName(), //
                account.getPassword(), enabled, accountNonExpired, //
                credentialsNonExpired, accountNonLocked, grantList);

        return userDetails;
	}

}
