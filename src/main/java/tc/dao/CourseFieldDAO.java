package tc.dao;

import tc.model.Attending;
import tc.model.CourseField;

import java.util.List;

/**
 * Created by stonezhang on 2017/3/5.
 */
public interface CourseFieldDAO {
    public CourseField selectById(int id);

    public CourseField selectByName(String name);

    public List<CourseField> select();

    public void update(CourseField courseField);

    public void insert(CourseField courseField);

    public void delete(int id);
}
