package tc.dao;

import tc.model.CourseUpdate;

/**
 * Created by stonezhang on 2017/3/19.
 */
public interface CourseUpdateDAO {
    CourseUpdate selectById(int id);
    void insert(CourseUpdate courseUpdate);
    void update(CourseUpdate courseUpdate);
}
