package tc.data.dao;

import tc.model.Teacher;

/**
 * Created by stonezhang on 2017/1/22.
 */
public interface TeacherDAO {
    public Teacher findById(int id);

    public Teacher findByName(String name);

    public void update(Teacher teacher);

    public void insert(Teacher teacher);

    public void delete(int id);
}
