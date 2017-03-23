package tc.service.studentService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tc.bean.ActivityLogVO;
import tc.bean.StudentCourseVO;
import tc.bean.StudentInfoVO;
import tc.dao.*;
import tc.model.*;
import tc.service.studentService.StudentVOManager;
import tc.service.tools.Discount;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

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

    @Autowired
    private FinanceCheckDAO financeCheckDAO;

    @Autowired
    private MemberCardDAO memberCardDAO;

    @Autowired
    private BankCardDAO bankCardDAO;

    @Autowired
    private ActivityLogDAO activityLogDAO;

    @Autowired
    private InstitutionDAO institutionDAO;

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
                studentCourseVOList.add(new StudentCourseVO(course));
            }

            result.put(courseField.getType(), studentCourseVOList);
        }

        return result;
    }

    @Override
    public StudentCourseVO getCourse(int sid, int cid) {
        StudentCourseVO studentCourseVO = new StudentCourseVO();
        Course course = courseDAO.selectById(cid);
        Attending attending = attendingDAO.selectByBoth(sid, cid);

        if(attending == null) {
            attending = new Attending();
            attending.setState(-1);
            attending.setIsMember(-1);
            attending.setEnrollingTime("");
            attending.setScore(-1);
        }

        return new StudentCourseVO(course, attending);
    }


    @Override
    public List<StudentCourseVO> getActiveCourses(int sid) {
        List<Attending> attendings = attendingDAO.selectBySid(sid);

        List<StudentCourseVO> studentCourseVOList = new ArrayList<>();

        for(Attending attending: attendings) {
            Course course = courseDAO.selectById(attending.getSid());
            System.out.println("from service: studentVOManager-getActiveCourse: " + course +
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
            StudentCourseVO studentCourseVO = new StudentCourseVO(courseDAO.selectById(attending.getCid()), attending);
            if(studentCourseVO.getState() == 0) {
                studentCourseVOList.add(studentCourseVO);
            }
        }

        return studentCourseVOList;
    }

    @Override
    public boolean doCourseQuit(int sid, int cid, int level, double price) {
        // 需要干的事：从attend表里删除；发送一个退款请求给经理；加在学生log里；
        // 等审批结果下来以后加在institution的log里
        // 所以经理的审批那里也要加入机构log和学生log的插入
        // 经理审批之后从哪扣钱也在经理那边实现吧

        // 另外一个别忘了的事就是要在这里加上institution用的log 里的相关记录

        MemberCard memberCard = memberCardDAO.findByStudent(sid);

        double actualPrice = Discount.calculateQuitMoney(level, price);

        Attending attending = new Attending();
        attending.setCid(cid);
        attending.setSid(sid);
        attendingDAO.delete(attending);

        FinanceCheck financeCheck = new FinanceCheck();


        Course course = courseDAO.selectById(cid);
        financeCheck.setFromS(course.getInsid());

        financeCheck.setToS(sid);

        LocalDateTime askTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
        String askTimeStr = askTime.format(format);

        financeCheck.setAskTime(askTimeStr);
        financeCheck.setState(0);
        financeCheck.setType(1);
        financeCheck.setCid(cid);
        financeCheck.setMoney(actualPrice);
        financeCheck.setMid(1);

        financeCheckDAO.insert(financeCheck);

        ActivityLog activityLog = new ActivityLog();
        activityLog.setSid(sid);
        activityLog.setCid(cid);
        activityLog.setInsid(course.getInsid());
        activityLog.setMoney(actualPrice);
        activityLog.setBehaviour("course quit");
        activityLog.setDescription("");
        activityLog.setType(0);
        activityLogDAO.insert(activityLog);

//        StudentLog studentLog = new StudentLog();
//        studentLog.setSid(sid);
//        studentLog.setCid(cid);
//        studentLog.setMoney(actualPrice);
//        studentLog.setBehavior("course quit");
//        studentLog.setDescription("quit class: " + cid + " with name: " +
//                course.getName() + " with actual price: " + actualPrice +
//                " while origin price: " + price);
//
//        studentLogDAO.insert(studentLog);
//
//        Student student = studentDAO.selectById(sid);
//        InstitutionLog institutionLog = new InstitutionLog();
//        institutionLog.setCid(cid);
//        institutionLog.setInsid(course.getInsid());
//        institutionLog.setMoney(actualPrice);
//        institutionLog.setBehavior("course quit");
//        institutionLog.setDescription("quit class " + cid + " with name: " +
//                course.getName() + " with student: " + sid + " with name: " +
//                student.getName());
//        institutionLogDAO.insert(institutionLog);

        if(actualPrice > memberCard.getBalance()) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public boolean doCourseEnroll(int sid, int cid, int level, double price) {
        LocalDateTime askTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
        String askTimeStr = askTime.format(format);

        Student student = studentDAO.selectById(sid);

        Bankcard bankcard = bankCardDAO.findByStudent(sid);
        MemberCard memberCard = memberCardDAO.findByStudent(sid);
        double actualPrice = Discount.calculateEnrollMoney(level, price);

        Course course = courseDAO.selectById(cid);

        if(actualPrice > memberCard.getBalance() || student.getLevel() == 0) {
            double balance = bankcard.getBalance();
            bankcard.setBalance(balance - actualPrice);
            if(balance - actualPrice < 0) {
                return false;
            }
            System.out.println("from StudentVOManager: pay the bill from bank: " + bankcard);
            bankCardDAO.update(bankcard);

            ActivityLog activityLog = new ActivityLog();
            activityLog.setSid(sid);
            activityLog.setCid(cid);
            activityLog.setInsid(course.getInsid());
            activityLog.setMoney(actualPrice);
            activityLog.setBehaviour("course enroll bankcard");
            activityLog.setDescription("");
            activityLog.setType(0);
            activityLogDAO.insert(activityLog);

            Institution institution = institutionDAO.selectById(course.getInsid());
            double insBalance = institution.getBalance();
            institution.setBalance(insBalance + actualPrice);
            institutionDAO.updateBalance(institution);
        }
        else {
            double balance = memberCard.getBalance();
            memberCard.setBalance(balance - actualPrice);
            memberCardDAO.updateBalance(memberCard);
            System.out.println("from StudentVOManager: pay the bill from memberCard: " + memberCard);

            ActivityLog activityLog = new ActivityLog();
            activityLog.setSid(sid);
            activityLog.setCid(cid);
            activityLog.setInsid(course.getInsid());
            activityLog.setMoney(actualPrice);
            activityLog.setBehaviour("course enroll membercard");
            activityLog.setDescription("");
            activityLog.setType(0);
            activityLogDAO.insert(activityLog);

            FinanceCheck financeCheck = new FinanceCheck();
            financeCheck.setType(0);
            financeCheck.setState(0);
            financeCheck.setFromS(sid);
            financeCheck.setCid(cid);
            financeCheck.setToS(course.getInsid());
            financeCheck.setMoney(actualPrice);

            financeCheck.setAskTime(askTimeStr);
            financeCheck.setMid(1);

            financeCheckDAO.insert(financeCheck);

            double exp = student.getExp() + actualPrice;
            student.setExp(exp);

            if(Discount.canUpdate(student)) {
                level = student.getLevel() + 1;
                student.setLevel(level);
                student.setExp(0);
                System.out.println("from StudentVOManager: update the exp: " + student);
                ActivityLog activityLogS = new ActivityLog();
                activityLogS.setSid(sid);
                activityLogS.setCid(cid);
                activityLogS.setInsid(course.getInsid());
                activityLogS.setMoney(0);
                activityLogS.setBehaviour("update");
                activityLogS.setDescription("update to level " + level);
                activityLogS.setType(1);
                activityLogDAO.insert(activityLogS);
                studentDAO.updateLevel(student);
            }
            else {
                student.setExp(exp);
                System.out.println("from StudentVOManager: accumulate the exp: " + student);
                studentDAO.updateLevel(student);
            }

        }

        Attending attending = new Attending();
        attending.setCid(cid);
        attending.setSid(sid);

        String startdate = course.getStartdate();
        String enddate = course.getEnddate();

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date ask = sdf.parse(askTimeStr);
            Date start = sdf.parse(startdate);
            Date end = sdf.parse(enddate);
            if(ask.before(start)) {
                attending.setState(2);
            }
            else if(ask.after(end)) {
                attending.setState(0);
            }
            else if (ask.after(start) && ask.before(end) || ask.equals(start) || ask.equals(end)) {
                attending.setState(1);
            }
            else {
                attending.setState(-1);
            }
        } catch (ParseException e) {
            attending.setState(-1);
            e.printStackTrace();
        }

        if(level == 0) {
            attending.setIsMember(0);
        }
        else {
            attending.setIsMember(1);
        }


        attendingDAO.insert(attending);


//
//        StudentLog studentLog = new StudentLog();
//        studentLog.setCid(cid);
//        studentLog.setSid(sid);
//        studentLog.setBehavior("course enroll");
//        studentLog.setDescription("enroll class " + cid + " with name: " +
//                course.getName() + " with actual price: " + actualPrice +
//                " while origin price: " + price);
//        studentLog.setMoney(actualPrice);
//        studentLogDAO.insert(studentLog);
//

//
//        InstitutionLog institutionLog = new InstitutionLog();
//        institutionLog.setCid(cid);
//        institutionLog.setInsid(course.getInsid());
//        institutionLog.setBehavior("course enroll");
//        institutionLog.setDescription("enroll class " + cid + " with name: " +
//                course.getName() + " with student: " + sid + " with name: " +
//                student.getName());
//        institutionLog.setMoney(actualPrice);
//        institutionLogDAO.insert(institutionLog);

        return true;
    }

    @Override
    public List<ActivityLogVO> getFinanceLogs(int sid) {
        List<ActivityLog> activityLogList = activityLogDAO.selectStudentCourse(sid);

        List<ActivityLogVO> activityLogVOList = new ArrayList<>();
        for(ActivityLog activityLog: activityLogList) {
            ActivityLogVO activityLogVO = new ActivityLogVO(activityLog);
            activityLogVOList.add(activityLogVO);
        }

        return activityLogVOList;
    }

    @Override
    public List<ActivityLogVO> getStudentLogs(int sid) {
        List<ActivityLog> activityLogList = activityLogDAO.selectStudentOtherConsume(sid);
        List<ActivityLog> activityLogList1 = activityLogDAO.selectStudentLog(sid);

        List<ActivityLogVO> activityLogVOList = new ArrayList<>();
        for(ActivityLog activityLog: activityLogList) {
            ActivityLogVO activityLogVO = new ActivityLogVO(activityLog);
            activityLogVOList.add(activityLogVO);
        }
        for(ActivityLog activityLog: activityLogList1) {
            ActivityLogVO activityLogVO = new ActivityLogVO(activityLog);
            activityLogVOList.add(activityLogVO);
        }

        return activityLogVOList;
    }

    @Override
    public boolean study(int sid, int cid) {
        ActivityLog activityLog = new ActivityLog();
        activityLog.setCid(cid);
        activityLog.setSid(sid);
        activityLog.setBehaviour("study course");
        Course course = courseDAO.selectById(cid);
        activityLog.setDescription("study course " + course.getName());
        activityLog.setType(1);
        activityLogDAO.insert(activityLog);
        return true;
    }
}
