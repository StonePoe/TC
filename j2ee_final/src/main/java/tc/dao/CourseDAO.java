package tc.dao;

import tc.model.Course;

import java.util.List;

/**
 * Created by stonezhang on 2017/1/20.
 */
public interface CourseDAO {
    public Course selectById(int id);

    public List<Course> selectByName(String name);

    public List<Course> selectByStudent(int sid);

    public List<Course> selectInstiActiveCourse(int insid);

    public List<Course> selectInstiAbandonCourse(int insid);

    List<Course> selectInstiCheckingCourse(int insid);

    public void update(Course course);

    public void insert(Course course);

    public void delete(Course course);

    public List<Course> selectByType(int typeId);
}

