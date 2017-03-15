package tc.bean;

import tc.model.InstitutionField;

/**
 * Created by stonezhang on 2017/3/14.
 */
public class InstitutionFieldVO {
    private int id;

    private String type;

    public InstitutionFieldVO() {

    }

    public InstitutionFieldVO(InstitutionField institutionField) {
        this.id = institutionField.getId();
        this.type = institutionField.getType();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
