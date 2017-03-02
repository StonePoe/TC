package tc.data.dao;

import tc.model.Course;

import java.util.List;

/**
 * Created by stonezhang on 2017/1/20.
 */
public interface CourseDAO {
    public Course findById(int id);

    public List<Course> findByName(String name);

    public void update(Course course);

    public void insert(Course course);

    public void delete(Course course);
}
