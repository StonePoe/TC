package tc.bean;

import tc.model.Attending;
import tc.model.Course;

import java.io.Serializable;

/**
 * Created by stonezhang on 2017/1/30.
 */
public class StudentCourseVO implements Serializable {
    private int id;
    private String name;
    private int insid;
    private String instiName;
    private int tid;
    private String tName;
    private int type;
    private String typeName;
    private String img;
    private String description;
    private String startdate;
    private String enddate;
    private double price;
    private String enrollingTime;
    private double score;
    private int state;
    private int isMember;
    private String institutionImg;
    private String teacherImg;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getEnrollingTime() {
        return enrollingTime;
    }

    public void setEnrollingTime(String enrollingTime) {
        this.enrollingTime = enrollingTime;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getIsMember() {
        return isMember;
    }

    public void setIsMember(int isMember) {
        this.isMember = isMember;
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

    public String getInstiName() {
        return instiName;
    }

    public void setInstiName(String instiName) {
        this.instiName = instiName;
    }

    public String getTName() {
        return tName;
    }

    public void setTName(String tName) {
        this.tName = tName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


    public String getInstitutionImg() {
        return institutionImg;
    }

    public void setInstitutionImg(String institutionImg) {
        this.institutionImg = institutionImg;
    }

    public String getTeacherImg() {
        return teacherImg;
    }

    public void setTeacherImg(String teacherImg) {
        this.teacherImg = teacherImg;
    }

    public StudentCourseVO() {

    }

    public StudentCourseVO(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.insid = course.getInsid();
        this.instiName = course.getInsName();
        this.tid = course.getTid();
        this.tName = course.getTeacherName();
        this.type = course.getFieldId();
        this.typeName = course.getFieldName();
        this.img = "../.." + course.getImgUrl();
        this.description = course.getDescription();
        this.startdate = course.getStartdate();
        this.enddate = course.getEnddate();
        this.price = course.getPrice();
        this.institutionImg = "../.." + course.getInsImg();
        this.teacherImg = "../.." + course.getTeacherImg();
    }

    public StudentCourseVO(Course course, Attending attending) {
        this.id = course.getId();
        this.name = course.getName();
        this.insid = course.getInsid();
        this.instiName = course.getInsName();
        this.tid = course.getTid();
        this.tName = course.getTeacherName();
        this.type = course.getFieldId();
        this.typeName = course.getFieldName();
        this.img = "../.." + course.getImgUrl();
        this.description = course.getDescription();
        this.startdate = course.getStartdate();
        this.enddate = course.getEnddate();
        this.price = course.getPrice();
        this.enrollingTime = attending.getEnrollingTime();
        this.score = attending.getScore();
        this.state = attending.getState();
        this.isMember = attending.getIsMember();
        this.institutionImg = "../.." + course.getInsImg();
        this.teacherImg = "../.." + course.getTeacherImg();
    }

    @Override
    public String toString() {
        return "StudentCourseVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", insid=" + insid +
                ", instiName='" + instiName + '\'' +
                ", tid=" + tid +
                ", tName='" + tName + '\'' +
                ", type=" + type +
                ", typeName='" + typeName + '\'' +
                ", img='" + img + '\'' +
                ", description='" + description + '\'' +
                ", startdate='" + startdate + '\'' +
                ", enddate='" + enddate + '\'' +
                ", price=" + price +
                ", enrollingTime='" + enrollingTime + '\'' +
                ", score=" + score +
                ", state=" + state +
                ", isMember=" + isMember +
                '}';
    }
}
