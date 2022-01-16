package jeff.bix.account.model;

import jeff.bix.account.model.type.State;

import java.math.BigDecimal;
import java.util.Date;

public class Account {
    private long id;
    private String account;
    private String pwdHash;
    private BankUser user;
    private BigDecimal balance;
    private State accountState;
    private Date lastUpdateDate;
    private String lastUpdateProcess;
    private long lastUpdateUser;
    private Date createDate;
    private long createUser;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwdHash() {
        return pwdHash;
    }

    public void setPwdHash(String pwdHash) {
        this.pwdHash = pwdHash;
    }

    public BankUser getUser() {
        return user;
    }

    public void setUser(BankUser user) {
        this.user = user;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public State getAccountState() {
        return accountState;
    }

    public void setAccountState(State accountState) {
        this.accountState = accountState;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getLastUpdateProcess() {
        return lastUpdateProcess;
    }

    public void setLastUpdateProcess(String lastUpdateProcess) {
        this.lastUpdateProcess = lastUpdateProcess;
    }

    public long getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(long lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(long createUser) {
        this.createUser = createUser;
    }
}