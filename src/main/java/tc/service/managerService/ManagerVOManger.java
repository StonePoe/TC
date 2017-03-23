package tc.service.managerService;

import tc.bean.ActivityLogVO;
import tc.bean.CourseCheckVO;
import tc.bean.FinanceCheckVO;
import tc.bean.ManagerInfoVO;
import tc.model.ActivityLog;
import tc.model.CourseUpdate;
import tc.model.FinanceCheck;

import java.util.List;
import java.util.Map;

/**
 * Created by stonezhang on 2017/3/15.
 */
public interface ManagerVOManger {
    ManagerInfoVO getManagerInfoVO(int id);

    ManagerInfoVO getManagerInfoVO(String name);

    List<CourseCheckVO> getReleaseCourseCheckVOList(int mid);

    List<CourseCheckVO> getUpdateCourseCheckVOList(int mid);

    List<CourseCheckVO> getReleaseCourseCheckVOUncheck(int mid);

    List<CourseCheckVO> getUpdateCourseCheckVOUncheck(int mid);

    List<CourseCheckVO> getReleaseCourseCheckVOPass(int mid);

    List<CourseCheckVO> getUpdateCourseCheckVOPass(int mid);

    List<CourseCheckVO> getReleaseCourseCheckVORefused(int mid);

    List<CourseCheckVO> getUpdateCourseCheckVORefused(int mid);

    void checkCourse(CourseCheckVO courseCheckVO);

    List<FinanceCheckVO> getFinanceCheckUnchecked(int mid);

    List<FinanceCheckVO> getFinanceCheckPassed(int mid);

    List<FinanceCheckVO> getFinanceCheckRefused(int mid);

    boolean agreeFinance(int id);

    boolean disagreeFinance(int id);

    void agreeUpdate(int courseCheckId, int courseUpdateId,
                     int cid, String cname, String description, double price);

    void disagreeUpdate(int courseCheckId, int courseUpdateId, int cid);

    List<ActivityLogVO> geCourseFinanceLogs(int mid);

    List<ActivityLogVO> getOtherFinanceLogs(int mid);

    List<ActivityLogVO> getInstitutionLogs(int mid);

    List<ActivityLogVO> getStudentLogs(int mid);


}
