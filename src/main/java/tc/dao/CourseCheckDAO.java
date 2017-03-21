package tc.dao;

import tc.model.CourseCheck;

import java.util.List;

/**
 * Created by stonezhang on 2017/3/15.
 */
public interface CourseCheckDAO {
    List<CourseCheck> selectReleaseByManager(int mid);

    List<CourseCheck> selectUpdateByManager(int mid);

    List<CourseCheck> selectByInsti(int insid);

    List<CourseCheck> selectByCourse(int cid);

    List<CourseCheck> selectReleaseUncheck(int mid);

    List<CourseCheck> selectUpdateUncheck(int mid);

    List<CourseCheck> selectReleasePassed(int mid);

    List<CourseCheck> selectUpdatePassed(int mid);

    List<CourseCheck> selectReleaseRefused(int mid);

    List<CourseCheck> selectUpdateRefused(int mid);

    CourseCheck selectReleaseById(int id);

    CourseCheck selectUpdateById(int id);

    int update(CourseCheck courseCheck);

    void insert(CourseCheck courseCheck);
}
