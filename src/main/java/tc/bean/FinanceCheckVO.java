package tc.bean;

import tc.model.FinanceCheck;

/**
 * Created by stonezhang on 2017/3/16.
 */
public class FinanceCheckVO {
    private int id;
    private int fromS;
    private String fromName;
    private int toS;
    private String toName;
    private int type;
    private double money;
    private String askTime;
    private String checkTime;
    private int state;
    private int mid;
    private int cid;
    private String cname;

    public FinanceCheckVO() {

    }

    public FinanceCheckVO(FinanceCheck financeCheck) {
        this.id = financeCheck.getId();
        this.fromS = financeCheck.getFromS();
        this.fromName = financeCheck.getFromName();
        this.toS = financeCheck.getToS();
        this.toName = financeCheck.getToName();
        this.type = financeCheck.getType();
        this.money = financeCheck.getMoney();
        this.askTime = financeCheck.getAskTime();
        this.checkTime = financeCheck.getCheckTime();
        this.state = financeCheck.getState();
        this.mid = financeCheck.getMid();
        this.cid = financeCheck.getCid();
        this.cname = financeCheck.getCname();
    }

    @Override
    public String toString() {
        return "FinanceCheckVO{" +
                "id=" + id +
                ", fromS=" + fromS +
                ", fromName='" + fromName + '\'' +
                ", toS=" + toS +
                ", toName='" + toName + '\'' +
                ", type=" + type +
                ", money=" + money +
                ", askTime='" + askTime + '\'' +
                ", checkTime='" + checkTime + '\'' +
                ", state=" + state +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFromS() {
        return fromS;
    }

    public void setFromS(int fromS) {
        this.fromS = fromS;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public int getToS() {
        return toS;
    }

    public void setToS(int toS) {
        this.toS = toS;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getAskTime() {
        return askTime;
    }

    public void setAskTime(String askTime) {
        this.askTime = askTime;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
