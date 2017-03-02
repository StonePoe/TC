package tc.data.dao;

import tc.model.Institution;

/**
 * Created by stonezhang on 2017/1/22.
 */
public interface InstitutionDAO {
    public Institution findById(int id);

    public Institution findByName(String name);

    public void update(Institution institution);

    public void insert(Institution institution);

    public void delete(int id);
}
