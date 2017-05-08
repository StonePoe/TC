package tc.dao;

import tc.model.Teacher;

import java.util.List;

/**
 * Created by stonezhang on 2017/1/22.
 */
public interface TeacherDAO {
    public Teacher selectById(int id);

    public List<Teacher> selectByName(String name);

    List<Teacher> select();

    public void update(Teacher teacher);

    public void insert(Teacher teacher);

    public void delete(int id);
}
