package jeff.bix.account.service;


import jeff.bix.account.model.Account;

import java.util.List;

public interface AccountService {
	
	public List<Account> listAllAccount();

	public int delAccount(String csId);
	
	public int createAccount(Account account);

	public int updateAccount(Account account);

}
