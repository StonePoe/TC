package tc.dao;

import tc.model.Manager;

/**
 * Created by stonezhang on 2017/1/22.
 */
public interface ManagerDAO {
    public Manager findById(int id);

    public Manager findByName(String name);

    public void update(Manager manager);

    public void insert(Manager manager);

    public void delete(int id);
}
