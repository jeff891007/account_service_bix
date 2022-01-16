package jeff.bix.account.service;

import jeff.bix.account.dao.AccountDao;
import jeff.bix.account.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountDao cusDao;


	@Override
	public List<Account> listAllAccount() {
		return cusDao.listAllAccount();
	}

	@Override
	public int delAccount(String account) {
		return cusDao.delAccount(account);
	}

	@Override
	public int createAccount(Account account) {
		return cusDao.createAccount(account);
	}

	@Override
	public int updateAccount(Account account) {
		return cusDao.updateAccount(account);
	}


}
