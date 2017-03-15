package tc.dao;

import tc.model.InstitutionLog;

/**
 * Created by stonezhang on 2017/1/22.
 */
public interface InstitutionLogDAO {
    public InstitutionLog find(int id);

    public void update(InstitutionLog institutionLog);

    public void insert(InstitutionLog institutionLog);

    public void delete(int id);
}
