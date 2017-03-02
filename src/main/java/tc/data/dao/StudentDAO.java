package tc.data.dao;

import tc.model.Student;

/**
 * Created by stonezhang on 2017/2/20.
 */
public interface StudentDAO {
    public void insert(Student student);

    public void delete(int id);

    public void update(Student student);

    public Student selectById(int id);

    public Student selectByName(String name);
}
