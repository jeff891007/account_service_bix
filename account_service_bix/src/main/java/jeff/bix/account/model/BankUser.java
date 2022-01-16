package jeff.bix.account.model;

import jeff.bix.account.model.type.Gender;
import jeff.bix.account.model.type.UType;

import java.util.Date;

public class BankUser {
    private long id;
    private String name;
    private Gender gender;
    private Date birthday;
    private UType uType;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public UType getuType() {
        return uType;
    }

    public void setuType(UType uType) {
        this.uType = uType;
    }
}
