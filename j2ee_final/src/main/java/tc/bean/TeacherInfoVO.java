package tc.bean;

import tc.model.Teacher;

/**
 * Created by stonezhang on 2017/3/14.
 */
public class TeacherInfoVO {
    private int id;
    private String password;
    private String imgUrl;
    private String name;

    public TeacherInfoVO() {

    }

    public TeacherInfoVO(Teacher teacher) {
        this.id = teacher.getId();
        this.password = teacher.getPassword();
        this.imgUrl = teacher.getImgUrl();
        this.name = teacher.getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
