package tc.service.institutionService;

import tc.bean.*;
import tc.model.ActivityLog;

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

    InstitutionCourseVO getCourse(int cid);

    List<InstitutionStudentVO> getCourseStudentList(int cid);

    List<ActivityLogVO> getCourseLog(int insid);

    List<ActivityLogVO> getInstitutionLog(int insid);

    List<ActivityLogVO> getInstitutionOtherConsume(int insid);

    List<InstitutionCourseStatisticsVO> getInstiStatistics(int insid);
}
