package tc.dao;

import tc.model.CourseCheck;

import java.util.List;

/**
 * Created by stonezhang on 2017/3/15.
 */
public interface CourseCheckDAO {
    List<CourseCheck> selectByManager(int mid);

    List<CourseCheck> selectByInsti(int insid);

    List<CourseCheck> selectByCourse(int cid);

    void update(CourseCheck courseCheck);

    void insert(CourseCheck courseCheck);
}
