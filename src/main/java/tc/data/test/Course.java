package tc.data.test;

import java.util.Date;

public class Course {
    private Long id;

    private Long insid;

    private Long tid;

    private Date startdate;

    private Date enddate;

    private Double price;

    private Integer agree;

    private String name;

    private Long field;

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

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAgree() {
        return agree;
    }

    public void setAgree(Integer agree) {
        this.agree = agree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getField() {
        return field;
    }

    public void setField(Long field) {
        this.field = field;
    }
}