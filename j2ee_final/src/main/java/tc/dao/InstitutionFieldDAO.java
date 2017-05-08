package tc.dao;

import tc.model.InstitutionField;

import java.util.List;

/**
 * Created by stonezhang on 2017/3/13.
 */
public interface InstitutionFieldDAO {
    InstitutionField selectById(int id);

    InstitutionField selectByType(String type);

    List<InstitutionField> select();

    void update(InstitutionField institutionField);

    void insert(InstitutionField institutionField);
}
