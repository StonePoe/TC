package tc.model;

import java.sql.Timestamp;

/**
 * Created by stonezhang on 2017/2/20.
 */
public class Attending {
    private long id;
    private Long sid;
    private Long cid;
    private Integer state;
    private Integer ismemeber;
    private Timestamp time;
    private Double score;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attending that = (Attending) o;

        if (id != that.id) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (cid != null ? !cid.equals(that.cid) : that.cid != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (ismemeber != null ? !ismemeber.equals(that.ismemeber) : that.ismemeber != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (score != null ? !score.equals(that.score) : that.score != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (cid != null ? cid.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (ismemeber != null ? ismemeber.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        return result;
    }
}
