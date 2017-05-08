package tc.bean;

import tc.model.Bankcard;
import tc.model.MemberCard;

/**
 * Created by stonezhang on 2017/3/12.
 */
public class MemberCardVO {
    private int id;
    private double balance;
    private int state;
    private int level;
    private String bankid;
    private String suspenddate;
    private String destroydate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getBankid() {
        return bankid;
    }

    public void setBankid(String bankid) {
        this.bankid = bankid;
    }

    public String getSuspenddate() {
        return suspenddate;
    }

    public void setSuspenddate(String suspenddate) {
        this.suspenddate = suspenddate;
    }

    public String getDestroydate() {
        return destroydate;
    }

    public void setDestroydate(String destroydate) {
        this.destroydate = destroydate;
    }

    public MemberCardVO() {

    }

    public MemberCardVO (MemberCard memberCard) {
        this.id = memberCard.getId();
        this.balance = memberCard.getBalance();
        this.bankid = memberCard.getBankid();
        this.level = memberCard.getLevel();
        this.state = memberCard.getState();
        this.suspenddate = memberCard.getSuspenddate();
        this.destroydate = memberCard.getDestroydate();
    }
}
