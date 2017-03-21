package tc.dao;

import tc.model.Manager;

/**
 * Created by stonezhang on 2017/1/22.
 */
public interface ManagerDAO {
    Manager selectById(int id);

    Manager selectByName(String name);

    void update(Manager manager);

    void insert(Manager manager);

}
