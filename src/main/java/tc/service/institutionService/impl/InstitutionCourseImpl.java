package tc.service.institutionService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tc.dao.CourseCheckDAO;
import tc.dao.CourseDAO;
import tc.model.Course;
import tc.model.CourseCheck;
import tc.service.institutionService.InstitutionCourse;

/**
 * Created by stonezhang on 2017/3/14.
 */
@Service("InstitutionCourse")
public class InstitutionCourseImpl implements InstitutionCourse{
    @Autowired
    private CourseDAO courseDAO;

    @Autowired
    private CourseCheckDAO courseCheckDAO;

    @Override
    public void release(String name, int tid, double price, String startdate, String enddate, int field,
                        String imgUrl, int insid, String description, int agree) {
        Course course = new Course();
        course.setName(name);
        course.setPrice(price);
        course.setStartdate(startdate);
        course.setEnddate(enddate);
        course.setFieldId(field);
        course.setImgUrl(imgUrl);
        course.setInsid(insid);
        course.setDescription(description);
        course.setAgree(agree);
        course.setTid(tid);

        System.out.println("from institutionCourse: Course " + course);

        courseDAO.insert(course);

        CourseCheck courseCheck = new CourseCheck();
        courseCheck.setAgree(0);
        courseCheck.setMid(1);
        courseCheck.setCid(course.getId());
        courseCheck.setComment("");

        courseCheckDAO.insert(courseCheck);
    }

    @Override
    public void update(int tid, String description, String startdate, String enddate, double price) {

    }

    @Override
    public void setScore(int cid, double score) {

    }
}
