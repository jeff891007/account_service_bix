package jeff.bix.jwt.dao;

import jeff.bix.account.model.Account;
import jeff.bix.account.model.BankUser;
import jeff.bix.account.model.type.Gender;
import jeff.bix.account.model.type.State;
import jeff.bix.account.model.type.UType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Map;

@Repository
public class UserDao {

	NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	public UserDao(DataSource ds) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(ds);
	}
	

	private final String GET_DETAIL_BY_ACCOUNT = "select a.id as account_id, a.account, a.pwd_hash, a.user_id, a.balance, a.last_update_date, a.last_update_process, " +
			"a.state as account_state, a.last_update_user, a.create_date, a.create_user,  u.name as user_name," +
			" u.gender, u.birthday, u.u_type from account a, bank_user u where a.user_id = u.id and account=:account";




	public Account getDetailByAccont(String account){
		Map<String, String> paraMap = Collections.singletonMap("account", account);
		Account accountDetail = jdbcTemplate.queryForObject(GET_DETAIL_BY_ACCOUNT, paraMap, new RowMapper<Account>() {
			@Override
			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				Account account = new Account();
				BankUser user = new BankUser();
				user.setId(rs.getLong("user_id"));
				user.setName("user_name");
				user.setBirthday(rs.getDate("birthday"));
				user.setGender(Gender.valueOf(rs.getString("gender")));
				user.setuType(UType.valueOf(rs.getString("u_type")));
				account.setUser(user);

				account.setId(rs.getLong("account_id"));
				account.setPwdHash(rs.getString("pwd_hash"));
				account.setAccount(rs.getString("account"));
				account.setAccountState(State.valueOf(rs.getString("account_state")));
				account.setBalance(rs.getBigDecimal("balance"));
				account.setLastUpdateDate(rs.getDate("last_update_date"));
				account.setLastUpdateProcess(rs.getString("last_update_process"));
				account.setLastUpdateUser(rs.getLong("last_update_user"));

				account.setCreateDate(rs.getDate("create_date"));
				account.setCreateUser(rs.getLong("create_user"));
				return account;
			}
		});
		return accountDetail;
	}



}
