package tc.service.fieldService;

import tc.bean.InstitutionFieldVO;

import java.util.List;

/**
 * Created by stonezhang on 2017/3/14.
 */
public interface InstitutionFieldVOManager {
    List<InstitutionFieldVO> getInstitutionFieldList();

    InstitutionFieldVO getInstitutionVO(int id);

    InstitutionFieldVO getInstitutionVO(String type);
}
