package tc.bean;

import tc.model.InstitutionCourseStatistics;

/**
 * Created by stonezhang on 2017/3/25.
 */
public class InstitutionCourseStatisticsVO {
    private int id;
    private int insid;
    private String insName;
    private int cid;
    private String cname;
    private int count;

    public InstitutionCourseStatisticsVO() {

    }

    public InstitutionCourseStatisticsVO(InstitutionCourseStatistics institutionCourseStatistics) {
        this.id = institutionCourseStatistics.getId();
        this.insid = institutionCourseStatistics.getInsid();
        this.insName = institutionCourseStatistics.getInsName();
        this.cid = institutionCourseStatistics.getCid();
        this.cname = institutionCourseStatistics.getCname();
        this.count = institutionCourseStatistics.getCount();
    }

    @Override
    public String toString() {
        return "InstitutionCourseStatisticsVO{" +
                "id=" + id +
                ", insid=" + insid +
                ", insName='" + insName + '\'' +
                ", cid=" + cid +
                ", cname='" + cname + '\'' +
                ", count=" + count +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInsid() {
        return insid;
    }

    public void setInsid(int insid) {
        this.insid = insid;
    }

    public String getInsName() {
        return insName;
    }

    public void setInsName(String insName) {
        this.insName = insName;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
