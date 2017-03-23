package tc.service.institutionService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tc.bean.ActivityLogVO;
import tc.bean.InstitutionCourseVO;
import tc.bean.InstitutionInfoVO;
import tc.bean.InstitutionStudentVO;
import tc.dao.*;
import tc.model.*;
import tc.service.institutionService.InstitutionVOManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stonezhang on 2017/3/13.
 */
@Service("InstitutionVOManager")
public class InstitutionVOManagerImpl implements InstitutionVOManager{
    @Autowired
    private InstitutionDAO institutionDAO;

    @Autowired
    private CourseDAO courseDAO;

    @Autowired
    private AttendingDAO attendingDAO;

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private ActivityLogDAO activityLogDAO;

    @Override
    public InstitutionInfoVO getInstitutionInfoVO(String name) {
        Institution institution = institutionDAO.selectByName(name);
        return new InstitutionInfoVO(institution);
    }

    @Override
    public InstitutionInfoVO getInstitutionInfoVO(int id) {
        Institution institution = institutionDAO.selectById(id);
        return new InstitutionInfoVO(institution);
    }

    @Override
    public List<InstitutionCourseVO> getActiveCourses(int insid) {
        System.out.println("from institutionVOManager-getAvtiveCourses: " + insid);
        List<Course> courseList = courseDAO.selectInstiActiveCourse(insid);
        List<InstitutionCourseVO> institutionCourseVOS = new ArrayList<>();
        for(Course course: courseList) {
            institutionCourseVOS.add(new InstitutionCourseVO(course));
        }
        System.out.println("from institutionVOManager-getAvtiveCourses: " + institutionCourseVOS);
        return institutionCourseVOS;
    }

    @Override
    public List<InstitutionCourseVO> getAbandonCourses(int insid) {
        List<Course> courseList = courseDAO.selectInstiAbandonCourse(insid);
        List<InstitutionCourseVO> institutionCourseVOS = new ArrayList<>();
        for(Course course: courseList) {
            institutionCourseVOS.add(new InstitutionCourseVO(course));
        }
        return institutionCourseVOS;
    }

    @Override
    public List<InstitutionCourseVO> getCheckingCourses(int insid) {
        List<Course> courseList = courseDAO.selectInstiCheckingCourse(insid);
        List<InstitutionCourseVO> institutionCourseVOS = new ArrayList<>();
        for(Course course: courseList) {
            institutionCourseVOS.add(new InstitutionCourseVO(course));
        }
        return institutionCourseVOS;
    }

    @Override
    public InstitutionCourseVO getCourse(int cid) {
        System.out.println("from institutionVOManagerImpl: getMultipleCourse " + cid);
        return new InstitutionCourseVO(courseDAO.selectById(cid));
    }

    @Override
    public List<InstitutionStudentVO> getCourseStudentList(int cid) {
        List<InstitutionStudentVO> result = new ArrayList<>();

        List<Attending> attendingList = attendingDAO.selectByCid(cid);
        for(Attending attending: attendingList) {
            Student student = studentDAO.selectById(attending.getSid());
            InstitutionStudentVO institutionStudentVO = new InstitutionStudentVO();
            institutionStudentVO.setId(student.getId());
            institutionStudentVO.setName(student.getName());
            institutionStudentVO.setEnrollTime(attending.getEnrollingTime());
            institutionStudentVO.setScore(attending.getScore());
            institutionStudentVO.setLearningState(attending.getState());

            result.add(institutionStudentVO);
        }
        return result;
    }

    @Override
    public List<ActivityLogVO> getCourseLog(int insid) {
        List<ActivityLog> activityLogList = activityLogDAO.selectInstitutionCourse(insid);

        List<ActivityLogVO> activityLogVOList = new ArrayList<>();
        for(ActivityLog activityLog: activityLogList) {
            ActivityLogVO activityLogVO = new ActivityLogVO(activityLog);
            activityLogVOList.add(activityLogVO);
        }

        return activityLogVOList;
    }

    @Override
    public List<ActivityLogVO> getInstitutionLog(int insid) {
        List<ActivityLog> activityLogList = activityLogDAO.selectInstitutionLog(insid);

        List<ActivityLogVO> activityLogVOList = new ArrayList<>();
        for(ActivityLog activityLog: activityLogList) {
            ActivityLogVO activityLogVO = new ActivityLogVO(activityLog);
            activityLogVOList.add(activityLogVO);
        }

        return activityLogVOList;
    }

    @Override
    public List<ActivityLogVO> getInstitutionOtherConsume(int insid) {
        List<ActivityLog> activityLogList = activityLogDAO.selectInstitutionOtherConsume(insid);

        List<ActivityLogVO> activityLogVOList = new ArrayList<>();
        for(ActivityLog activityLog: activityLogList) {
            ActivityLogVO activityLogVO = new ActivityLogVO(activityLog);
            activityLogVOList.add(activityLogVO);
        }

        return activityLogVOList;
    }
}
