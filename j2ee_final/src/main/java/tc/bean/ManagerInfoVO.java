package tc.bean;

import tc.model.Manager;
import tc.service.managerService.ManagerVerify;

/**
 * Created by stonezhang on 2017/3/15.
 */
public class ManagerInfoVO {
    private int id;
    private String password;
    private String name;
    private String imgUrl;

    public ManagerInfoVO() {

    }

    @Override
    public String toString() {
        return "ManagerInfoVO{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }

    public ManagerInfoVO(Manager manager) {
        this.id = manager.getId();
        this.password = manager.getPassword();
        this.name = manager.getName();
        this.imgUrl = manager.getImgUrl();
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
}
