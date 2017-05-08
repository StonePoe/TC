package tc.bean;

import tc.model.Course;
import tc.model.CourseField;

/**
 * Created by stonezhang on 2017/3/14.
 */
public class CourseFieldVO {
    private int id;

    private String type;

    public CourseFieldVO() {

    }

    public CourseFieldVO(CourseField courseField) {
        this.id = courseField.getId();
        this.type = courseField.getType();
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
