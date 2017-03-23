package tc.service.institutionService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tc.bean.CourseCheckVO;
import tc.dao.*;
import tc.model.*;
import tc.service.institutionService.InstitutionCourse;

import javax.jws.Oneway;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by stonezhang on 2017/3/14.
 */
@Service("InstitutionCourse")
public class InstitutionCourseImpl implements InstitutionCourse{
    @Autowired
    private CourseDAO courseDAO;

    @Autowired
    private CourseCheckDAO courseCheckDAO;

    @Autowired
    private AttendingDAO attendingDAO;

    @Autowired
    private CourseUpdateDAO courseUpdateDAO;

    @Autowired
    private ActivityLogDAO activityLogDAO;

    @Autowired
    private StudentDAO studentDAO;

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

        LocalDateTime releaseTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
        String releaseTimeStr = releaseTime.format(format);
        courseCheck.setReleaseTime(releaseTimeStr);
        courseCheck.setCheckTime("");
        courseCheck.setCheckType(0);

//        InstitutionLog institutionLog = new InstitutionLog();
//        institutionLog.setBehavior("course release");
//        institutionLog.setCid(course.getId());
//        institutionLog.setInsid(insid);
//
//        institutionLogDAO.insert(institutionLog);
        ActivityLog activityLog = new ActivityLog();
        activityLog.setBehaviour("course release");
        activityLog.setDescription("");
        activityLog.setCid(course.getId());
        activityLog.setMoney(0);
        activityLog.setSid(-1);
        activityLog.setType(3);
        activityLog.setInsid(insid);
        activityLogDAO.insert(activityLog);

        courseCheckDAO.insert(courseCheck);
    }

    @Override
    public void update(int cid, String description, double price, String name) {
        CourseUpdate courseUpdate = new CourseUpdate();
        courseUpdate.setCid(cid);
        courseUpdate.setDescription(description);
        courseUpdate.setCname(name);
        courseUpdate.setPrice(price);
        courseUpdate.setIsActive(1);
        courseUpdateDAO.insert(courseUpdate);

        CourseCheck courseCheck = new CourseCheck();
        courseCheck.setAgree(0);
        courseCheck.setMid(1);
        courseCheck.setCid(cid);
        courseCheck.setComment("");

        LocalDateTime releaseTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
        String releaseTimeStr = releaseTime.format(format);
        courseCheck.setReleaseTime(releaseTimeStr);
        courseCheck.setCheckTime("");
        courseCheck.setCheckType(1);
        courseCheckDAO.insert(courseCheck);

//        InstitutionLog institutionLog = new InstitutionLog();
//        institutionLog.setBehavior("course update");
//        institutionLog.setCid(cid);
//        Course course = courseDAO.selectById(cid);
//        institutionLog.setInsid(course.getInsid());
//        institutionLogDAO.insert(institutionLog);
        Course course = courseDAO.selectById(cid);

        ActivityLog activityLog = new ActivityLog();
        activityLog.setBehaviour("course update");
        activityLog.setDescription("");
        activityLog.setCid(cid);
        activityLog.setMoney(0);
        activityLog.setSid(-1);
        activityLog.setType(3);
        activityLog.setInsid(course.getInsid());
        activityLogDAO.insert(activityLog);

    }

    @Override
    public void setScore(int sid, int cid, double score) {
        Attending attending = attendingDAO.selectByBoth(sid, cid);
        attending.setScore(score);
        attendingDAO.updateScore(attending);
        Course course = courseDAO.selectById(cid);

        ActivityLog activityLog = new ActivityLog();
        activityLog.setBehaviour("course score");
        activityLog.setDescription("得分：" + score);
        activityLog.setCid(cid);
        activityLog.setMoney(0);
        activityLog.setSid(sid);
        activityLog.setType(3);
        activityLog.setInsid(course.getInsid());
        activityLogDAO.insert(activityLog);

        Student student = studentDAO.selectById(sid);

        ActivityLog activityLogS = new ActivityLog();
        activityLogS.setBehaviour("course score");
        activityLogS.setDescription("得分：" + score + "; 学生: " + student.getName());
        activityLogS.setCid(cid);
        activityLogS.setMoney(0);
        activityLogS.setSid(sid);
        activityLogS.setType(1);
        activityLogS.setInsid(course.getInsid());
        activityLogDAO.insert(activityLog);
    }
}
