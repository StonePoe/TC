package tc.service.institutionService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tc.bean.InstitutionCourseVO;
import tc.bean.InstitutionInfoVO;
import tc.dao.CourseDAO;
import tc.dao.InstitutionDAO;
import tc.model.Course;
import tc.model.Institution;
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
}
