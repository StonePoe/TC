package tc.bean;

import tc.model.CourseCheck;

/**
 * Created by stonezhang on 2017/3/15.
 */
public class CourseCheckVO {
    private int id;
    private int insid;
    private String insName;
    private int tid;
    private String description;
    private String startdate;
    private String enddate;
    private double price;
    private int agree;
    private String name;
    private String imgUrl;
    private String teacherName;
    private String fieldName;
    private int fieldId;
    private int mid;
    private String managerName;
    private String comment;

    public CourseCheckVO() {

    }

    public CourseCheckVO(CourseCheck courseCheck) {
        this.id = courseCheck.getId();
        this.insid = courseCheck.getInsid();
        this.insName = courseCheck.getInsName();
        this.tid = courseCheck.getTid();
        this.description = courseCheck.getDescription();
        this.startdate = courseCheck.getStartdate();
        this.enddate = courseCheck.getEnddate();
        this.price = courseCheck.getPrice();
        this.agree = courseCheck.getAgree();
        this.name = courseCheck.getName();
        this.imgUrl = courseCheck.getImgUrl();
        this.teacherName = courseCheck.getTeacherName();
        this.fieldName = courseCheck.getFieldName();
        this.mid = courseCheck.getMid();
        this.managerName = courseCheck.getManagerName();
        this.comment = courseCheck.getComment();
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

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAgree() {
        return agree;
    }

    public void setAgree(int agree) {
        this.agree = agree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
