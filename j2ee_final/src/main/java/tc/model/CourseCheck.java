package tc.model;

/**
 * Created by stonezhang on 2017/3/15.
 */
public class CourseCheck {
    private int id;
    private int cid;
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
    private String releaseTime;
    private String checkTime;
    private int checkType;
    private int courseUpdateId;

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
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

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }


    @Override
    public String toString() {
        return "CourseCheck{" +
                "id=" + id +
                ", cid=" + cid +
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
                ", fieldName='" + fieldName + '\'' +
                ", fieldId=" + fieldId +
                ", mid=" + mid +
                ", managerName='" + managerName + '\'' +
                ", comment='" + comment + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                ", checkTime='" + checkTime + '\'' +
                '}';
    }

    public int getCheckType() {
        return checkType;
    }

    public void setCheckType(int checkType) {
        this.checkType = checkType;
    }

    public int getCourseUpdateId() {
        return courseUpdateId;
    }

    public void setCourseUpdateId(int courseUpdateId) {
        this.courseUpdateId = courseUpdateId;
    }
}
