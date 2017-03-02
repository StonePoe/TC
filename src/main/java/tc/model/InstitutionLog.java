package tc.model;

import java.sql.Timestamp;

/**
 * Created by stonezhang on 2017/2/20.
 */
public class InstitutionLog {
    private long id;
    private Long insid;
    private Long cid;
    private String behavior;
    private String description;
    private Timestamp time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getInsid() {
        return insid;
    }

    public void setInsid(Long insid) {
        this.insid = insid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InstitutionLog that = (InstitutionLog) o;

        if (id != that.id) return false;
        if (insid != null ? !insid.equals(that.insid) : that.insid != null) return false;
        if (cid != null ? !cid.equals(that.cid) : that.cid != null) return false;
        if (behavior != null ? !behavior.equals(that.behavior) : that.behavior != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (insid != null ? insid.hashCode() : 0);
        result = 31 * result + (cid != null ? cid.hashCode() : 0);
        result = 31 * result + (behavior != null ? behavior.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
