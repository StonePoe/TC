package tc.model;

import java.util.Date;

public class MemberCard {
    private int id;
    private double balance;
    private int state;
    private int level;
    private String bankid;
    private String suspenddate;
    private String destroydate;
    private int sid;

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

    @Override
    public String toString() {
        return "MemberCard{" +
                "id=" + id +
                ", balance=" + balance +
                ", state=" + state +
                ", level=" + level +
                ", bankid=" + bankid +
                ", suspenddate='" + suspenddate + '\'' +
                ", destroydate='" + destroydate + '\'' +
                '}';
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
}