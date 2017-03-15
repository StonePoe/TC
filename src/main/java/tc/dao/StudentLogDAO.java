package tc.dao;

import tc.model.StudentLog;

/**
 * Created by stonezhang on 2017/1/22.
 */
public interface StudentLogDAO {
    public StudentLog find(int id);

    public void update(StudentLog studentLog);

    public void insert(StudentLog studentLog);

    public void delete(int id);
}
