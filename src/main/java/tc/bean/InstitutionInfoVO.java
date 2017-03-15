package tc.bean;

import tc.model.Institution;

/**
 * Created by stonezhang on 2017/3/13.
 */
public class InstitutionInfoVO {
    private int id;
    private String password;
    private double balance;
    private String name;
    private String imgUrl;
    private int fieldId;
    private String field;

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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public InstitutionInfoVO() {

    }

    public InstitutionInfoVO(Institution institution) {
        this.id = institution.getId();
        this.name = institution.getName();
        this.balance = institution.getBalance();
        this.password = institution.getPassword();
        this.imgUrl = "../../img/" + institution.getImgUrl();
        this.fieldId = institution.getField();
        this.field = institution.getFieldName();
    }

    @Override
    public String toString() {
        return "InstitutionInfoVO{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", name='" + name + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", fieldId=" + fieldId +
                ", field='" + field + '\'' +
                '}';
    }
}
