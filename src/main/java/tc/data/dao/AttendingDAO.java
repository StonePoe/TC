package tc.data.dao;


import tc.model.Attending;

/**
 * Created by stonezhang on 2017/1/20.
 */
public interface AttendingDAO {
    public Attending findById(int id);

    public Attending findByName(String name);

    public void update(Attending attending);

    public void insert(Attending attending);

    public void delete(int id);
}
