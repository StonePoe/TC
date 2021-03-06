package tc.model;

import java.util.Date;

public class Course {
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
   private String teacherImg;
   private String insImg;
   private String fieldName;
   private int fieldId;

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

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", insid=" + insid +
                ", insName='" + insName + '\'' +
                ", tid=" + tid +
                ", description='" + description + '\'' +
                ", startdate='" + startdate + '\'' +
                ", enddate='" + enddate + '\'' +
                ", price=" + price +
                ", agree=" + agree +
                ", name='" + name + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherImg='" + teacherImg + '\'' +
                ", insImg='" + insImg + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", fieldId=" + fieldId +
                '}';
    }

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getInsName() {
        return insName;
    }

    public void setInsName(String insName) {
        this.insName = insName;
    }

    public String getInsImg() {
        return insImg;
    }

    public void setInsImg(String insImg) {
        this.insImg = insImg;
    }

    public String getTeacherImg() {
        return teacherImg;
    }

    public void setTeacherImg(String teacherImg) {
        this.teacherImg = teacherImg;
    }
}