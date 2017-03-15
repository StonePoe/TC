package tc.service.studentService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tc.bean.StudentCourseVO;
import tc.bean.StudentInfoVO;
import tc.dao.*;
import tc.model.*;
import tc.service.studentService.StudentVOManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by stonezhang on 2017/3/1.
 */
@Service("StudentVOManager")
public class StudentVOManagerImpl implements StudentVOManager {
    @Autowired
    private AttendingDAO attendingDAO;

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private CourseDAO courseDAO;

    @Autowired
    private CourseFieldDAO courseFieldDAO;

//    @Autowired
//    private InstitutionDAO institutionDAO;
//
//    @Autowired
//    private TeacherDAO teacherDAO;

    @Override
    public StudentInfoVO getStudentById(int id) {
        Student student = studentDAO.selectById(id);
        StudentInfoVO studentInfoVO = new StudentInfoVO(student);
        return studentInfoVO;
    }

    @Override
    public StudentInfoVO getStudentByName(String name) {
        Student student = studentDAO.selectByName(name);
        StudentInfoVO studentInfoVO = new StudentInfoVO(student);
        return studentInfoVO;
    }
    @Override
    public Map<String, List<StudentCourseVO>> getCourses() {
        List<CourseField> fieldList = courseFieldDAO.select();
        Map<String, List<StudentCourseVO>> result = new HashMap<>();

        for(CourseField courseField: fieldList) {

            List<Course> courseList = courseDAO.selectByType(courseField.getId());

            List<StudentCourseVO> studentCourseVOList = new ArrayList<>();

            for (Course course: courseList) {

//                int insid = course.getInsid();
//                int tid = course.getTid();
//                int field = course.getFieldId();
//
//                String description = course.getDescription();
//                String startdate = course.getStartdate();
//                String enddate = course.getEnddate();
//                double price = course.getPrice();
//                String name = course.getName();
//                String imgUrl = "../.." + course.getImgUrl();
//
//                Institution institution = institutionDAO.selectById(insid);
//                String instiName = institution.getName();
//                String instiImg = institution.getImgUrl();
//
//                Teacher teacher = teacherDAO.selectById(tid);
//                String teacherName = teacher.getName();
//                String teacherImg = teacher.getImgUrl();
//
////                CourseField courseField = courseFieldDAO.selectById(field);
//                String type = courseField.getType();
//
//                courseVO.setId(course.getId());
//                courseVO.setInsid(insid);
//                courseVO.setInstiName(instiName);
//                courseVO.setTid(tid);
//                courseVO.setTName(teacherName);
//                courseVO.setState(-1);
//                courseVO.setIsMember(0);
//                courseVO.setScore(-100);
//                courseVO.setDescription(description);
//                courseVO.setStartdate(startdate);
//                courseVO.setEnddate(enddate);
//                courseVO.setPrice(price);
//                courseVO.setName(name);
//                courseVO.setImg(imgUrl);
//                courseVO.setType(field);
//                courseVO.setTypeName(type);
//                courseVO.setTeacherImg(teacherImg);
//                courseVO.setInstitutionImg(instiImg);


                studentCourseVOList.add(new StudentCourseVO(course));
            }

            result.put(courseField.getType(), studentCourseVOList);
        }

        return result;
//        Course course = courseDAO.
//        return null;
    }

    @Override
    public StudentCourseVO getCourse(int sid, int cid) {
        StudentCourseVO studentCourseVO = new StudentCourseVO();
        Course course = courseDAO.selectById(cid);
        Attending attending = attendingDAO.selectByBoth(sid, cid);

//        int state;
//        int isMember;
//        String enrollingTime;
//        double score;
//
//        if(attending != null) {
//            state = attending.getState();
//            isMember = attending.getIsMember();
//            enrollingTime = attending.getEnrollingTime();
//            score = attending.getScore();
//        }
        if(attending == null) {
            attending = new Attending();
            attending.setState(-1);
            attending.setIsMember(-1);
            attending.setEnrollingTime("");
            attending.setScore(-1);
//            state = -1;
//            isMember = -1;
//            enrollingTime = "";
//            score = -1;
        }

        return new StudentCourseVO(course, attending);

//        int insid = course.getInsid();
//        int tid = course.getTid();
//        int field = course.getFieldId();
//
//        String description = course.getDescription();
//        String startdate = course.getStartdate();
//        String enddate = course.getEnddate();
//        double price = course.getPrice();
//        String name = course.getName();
//        String imgUrl = "../.." + course.getImgUrl();
//
//        Institution institution = institutionDAO.selectById(insid);
//        String instiName = institution.getName();
//        String instiImg = institution.getImgUrl();
//
//        Teacher teacher = teacherDAO.selectById(tid);
//        String teacherName = teacher.getName();
//        String teacherImg = teacher.getImgUrl();
//
//        CourseField courseField = courseFieldDAO.selectById(field);
//        String type = courseField.getType();
//
//        studentCourseVO.setId(cid);
//        studentCourseVO.setInsid(insid);
//        studentCourseVO.setInstiName(instiName);
//        studentCourseVO.setTid(tid);
//        studentCourseVO.setTName(teacherName);
//        studentCourseVO.setState(state);
//        studentCourseVO.setIsMember(isMember);
//        studentCourseVO.setScore(score);
//        studentCourseVO.setEnrollingTime(enrollingTime);
//        studentCourseVO.setDescription(description);
//        studentCourseVO.setStartdate(startdate);
//        studentCourseVO.setEnddate(enddate);
//        studentCourseVO.setPrice(price);
//        studentCourseVO.setName(name);
//        studentCourseVO.setImg(imgUrl);
//        studentCourseVO.setType(field);
//        studentCourseVO.setTypeName(type);
//        studentCourseVO.setTeacherImg(teacherImg);
//        studentCourseVO.setInstitutionImg(instiImg);

//        return studentCourseVO;
    }


    @Override
    public List<StudentCourseVO> getActiveCourses(int sid) {
        List<Attending> attendings = attendingDAO.selectBySid(sid);

        List<StudentCourseVO> studentCourseVOList = new ArrayList<>();

        for(Attending attending: attendings) {
            Course course = courseDAO.selectById(attending.getSid());
            System.out.println("from service: studentVOmanager-getActiveCourse: " + course +
                    " where attending: " + attending);
            StudentCourseVO studentCourseVO = new StudentCourseVO(courseDAO.selectById(attending.getCid()), attending);
            if(studentCourseVO.getState() == 1) {
                studentCourseVOList.add(studentCourseVO);
            }
        }

        return studentCourseVOList;
    }

    @Override
    public List<StudentCourseVO> getUnstartCourses(int sid) {
        List<Attending> attendings = attendingDAO.selectBySid(sid);

        List<StudentCourseVO> studentCourseVOList = new ArrayList<>();

        for(Attending attending: attendings) {
            StudentCourseVO studentCourseVO = new StudentCourseVO(courseDAO.selectById(attending.getCid()), attending);
            if(studentCourseVO.getState() == 2) {
                studentCourseVOList.add(studentCourseVO);
            }
        }

        return studentCourseVOList;
    }

    @Override
    public List<StudentCourseVO> getFinishedCourses(int sid) {
        List<Attending> attendings = attendingDAO.selectBySid(sid);

        List<StudentCourseVO> studentCourseVOList = new ArrayList<>();

        for(Attending attending: attendings) {
//            StudentCourseVO studentCourseVO = new StudentCourseVO();
//            int cid = attending.getCid();
//            int state = attending.getState();
//            int isMember = attending.getIsMember();
//            String enrollingTime = attending.getEnrollingTime();
//            double score = attending.getScore();
//
//            Course course = courseDAO.selectById(cid);
//
//            int insid = course.getInsid();
//            int tid = course.getTid();
//            int field = course.getFieldId();
//
//            String description = course.getDescription();
//            String startdate = course.getStartdate();
//            String enddate = course.getEnddate();
//            double price = course.getPrice();
//            String name = course.getName();
//            String imgUrl = "../.." + course.getImgUrl();
//
//            Institution institution = institutionDAO.selectById(insid);
//            String instiName = institution.getName();
//
//            Teacher teacher = teacherDAO.selectById(tid);
//            String teacherName = teacher.getName();
//
//            CourseField courseField = courseFieldDAO.selectById(field);
//            String type = courseField.getType();
//
//            studentCourseVO.setId(cid);
//            studentCourseVO.setInsid(insid);
//            studentCourseVO.setInstiName(instiName);
//            studentCourseVO.setTid(tid);
//            studentCourseVO.setTName(teacherName);
//            studentCourseVO.setState(state);
//            studentCourseVO.setIsMember(isMember);
//            studentCourseVO.setScore(score);
//            studentCourseVO.setEnrollingTime(enrollingTime);
//            studentCourseVO.setDescription(description);
//            studentCourseVO.setStartdate(startdate);
//            studentCourseVO.setEnddate(enddate);
//            studentCourseVO.setPrice(price);
//            studentCourseVO.setName(name);
//            studentCourseVO.setImg(imgUrl);
//            studentCourseVO.setType(field);
//            studentCourseVO.setTypeName(type);
            StudentCourseVO studentCourseVO = new StudentCourseVO(courseDAO.selectById(attending.getCid()), attending);
            if(studentCourseVO.getState() == 0) {
                studentCourseVOList.add(studentCourseVO);
            }
        }

        return studentCourseVOList;
    }
}
