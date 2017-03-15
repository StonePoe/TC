package tc.service.institutionService;

import tc.bean.InstitutionCourseVO;
import tc.bean.InstitutionInfoVO;

import java.util.List;

/**
 * Created by stonezhang on 2017/3/13.
 */
public interface InstitutionVOManager {
    InstitutionInfoVO getInstitutionInfoVO(String name);
    InstitutionInfoVO getInstitutionInfoVO(int id);

    List<InstitutionCourseVO> getActiveCourses(int insid);

    List<InstitutionCourseVO> getAbandonCourses(int insid);

    List<InstitutionCourseVO> getCheckingCourses(int insid);
}
