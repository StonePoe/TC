package tc.bean;

import java.io.Serializable;

/**
 * Created by stonezhang on 2017/1/24.
 */
public class StudentInfoVO implements Serializable {
    private long id;
    private String name;
    private String password;

    private String bankCard;
    private int memberId;

    private int state;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "StudentInfoVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", bankCard='" + bankCard + '\'' +
                ", memberId=" + memberId +
                ", state=" + state +
                '}';
    }
}
