package tc.data.test;

import java.util.Date;

public class Membercard {
    private Long id;

    private Double balance;

    private Integer state;

    private Integer level;

    private Long bankid;

    private Date suspenddate;

    private Date destroydate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getBankid() {
        return bankid;
    }

    public void setBankid(Long bankid) {
        this.bankid = bankid;
    }

    public Date getSuspenddate() {
        return suspenddate;
    }

    public void setSuspenddate(Date suspenddate) {
        this.suspenddate = suspenddate;
    }

    public Date getDestroydate() {
        return destroydate;
    }

    public void setDestroydate(Date destroydate) {
        this.destroydate = destroydate;
    }
}