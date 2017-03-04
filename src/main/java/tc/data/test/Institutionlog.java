package tc.data.test;

import java.util.Date;

public class Institutionlog {
    private Long id;

    private Long insid;

    private Long cid;

    private Date modifytime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }
}