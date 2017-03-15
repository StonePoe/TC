package tc.bean;

import tc.model.Student;

import java.io.Serializable;

/**
 * Created by stonezhang on 2017/1/24.
 */
public class StudentInfoVO implements Serializable {
    private int id;
    private String name;
    private String password;

    private String img;

    private String bankCard;
    private int memberId;

    private int level;

    public StudentInfoVO() {

    }

    public StudentInfoVO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.password = student.getPassword();
        this.img = student.getImgUrl();
        this.bankCard = String.valueOf(student.getBankid());
        this.memberId = student.getMemberid();
        this.level = student.getLevel();
    }


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "StudentInfoVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", img='" + img + '\'' +
                ", bankCard='" + bankCard + '\'' +
                ", memberId=" + memberId +
                ", level=" + level +
                '}';
    }
}
