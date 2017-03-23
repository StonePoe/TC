package tc.model;

/**
 * Created by stonezhang on 2017/3/20.
 */

// type=0 资金类课程相关 ftype=1 文字类学生 type=2 资金类学生 type=3 文字类机构 type=4 资金类机构
public class ActivityLog {
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
        return "ActivityLog{" +
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

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getInstiName() {
        return instiName;
    }

    public void setInstiName(String instiName) {
        this.instiName = instiName;
    }
}
