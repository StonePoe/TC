package tc.bean;

import tc.model.ActivityLog;

/**
 * Created by stonezhang on 2017/3/21.
 */
public class ActivityLogVO {
    private int id;
    private int type;
    private int sid;
    private String modifyTime;
    private String behaviour;
    private String description;
    private double money;
    private int cid;
    private int insid;
    private String sname;
    private String cname;
    private String instiName;

    @Override
    public String toString() {
        return "ActivityLogVO{" +
                "id=" + id +
                ", type=" + type +
                ", sid=" + sid +
                ", modifyTime='" + modifyTime + '\'' +
                ", behaviour='" + behaviour + '\'' +
                ", description='" + description + '\'' +
                ", money=" + money +
                ", cid=" + cid +
                ", insid=" + insid +
                ", sname='" + sname + '\'' +
                ", cname='" + cname + '\'' +
                ", instiName='" + instiName + '\'' +
                '}';
    }

    public ActivityLogVO() {

    }

    public ActivityLogVO(ActivityLog activityLog) {
        this.id = activityLog.getId();
        this.type = activityLog.getType();
        this.sid = activityLog.getSid();
        this.modifyTime = activityLog.getModifyTime();
        this.behaviour = activityLog.getBehaviour();
        this.money = activityLog.getMoney();
        this.cid = activityLog.getCid();
        this.insid = activityLog.getInsid();
        this.sname = activityLog.getSname();
        this.cname = activityLog.getCname();
        this.instiName = activityLog.getInstiName();
        this.description = activityLog.getDescription();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getBehaviour() {
        return behaviour;
    }

    public void setBehaviour(String behaviour) {
        this.behaviour = behaviour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getInsid() {
        return insid;
    }

    public void setInsid(int insid) {
        this.insid = insid;
    }

    public String getInstiName() {
        return instiName;
    }

    public void setInstiName(String instiName) {
        this.instiName = instiName;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
