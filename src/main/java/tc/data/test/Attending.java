package tc.data.test;

import java.util.Date;

public class Attending {
    private Long id;

    private Long sid;

    private Long cid;

    private Integer state;

    private Integer ismemeber;

    private Date enrollingtime;

    private Double score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getIsmemeber() {
        return ismemeber;
    }

    public void setIsmemeber(Integer ismemeber) {
        this.ismemeber = ismemeber;
    }

    public Date getEnrollingtime() {
        return enrollingtime;
    }

    public void setEnrollingtime(Date enrollingtime) {
        this.enrollingtime = enrollingtime;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}