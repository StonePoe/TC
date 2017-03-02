package tc.model;

import java.sql.Date;

/**
 * Created by stonezhang on 2017/2/20.
 */
public class MemberCard {
    private long id;
    private Double balance;
    private Integer state;
    private Integer level;
    private Long bankid;
    private Date suspenddate;
    private Date destroydate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MemberCard that = (MemberCard) o;

        if (id != that.id) return false;
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;
        if (bankid != null ? !bankid.equals(that.bankid) : that.bankid != null) return false;
        if (suspenddate != null ? !suspenddate.equals(that.suspenddate) : that.suspenddate != null) return false;
        if (destroydate != null ? !destroydate.equals(that.destroydate) : that.destroydate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (bankid != null ? bankid.hashCode() : 0);
        result = 31 * result + (suspenddate != null ? suspenddate.hashCode() : 0);
        result = 31 * result + (destroydate != null ? destroydate.hashCode() : 0);
        return result;
    }
}
