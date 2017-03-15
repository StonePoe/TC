package tc.dao;

import tc.model.Institution;

/**
 * Created by stonezhang on 2017/1/22.
 */
public interface InstitutionDAO {
    public Institution selectById(int id);

    public Institution selectByName(String name);

    public void update(Institution institution);

    public void insert(Institution institution);

    public void delete(int id);
}
