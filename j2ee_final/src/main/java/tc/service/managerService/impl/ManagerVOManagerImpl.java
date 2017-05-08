package tc.service.managerService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tc.bean.*;
import tc.dao.*;
import tc.model.*;
import tc.service.managerService.ManagerVOManger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stonezhang on 2017/3/15.
 */
@Service("ManagerVOManager")
public class ManagerVOManagerImpl implements ManagerVOManger {
    @Autowired
    private ManagerDAO managerDAO;

    @Autowired
    private CourseCheckDAO courseCheckDAO;

    @Autowired
    private FinanceCheckDAO financeCheckDAO;

    @Autowired
    private InstitutionDAO institutionDAO;

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private BankCardDAO bankCardDAO;

    @Autowired
    private MemberCardDAO memberCardDAO;

    @Autowired
    private AttendingDAO attendingDAO;

    @Autowired
    private CourseUpdateDAO courseUpdateDAO;

    @Autowired
    private CourseDAO courseDAO;

    @Autowired
    private ActivityLogDAO activityLogDAO;

    @Autowired
    private InstitutionCourseStatisticsDAO institutionCourseStatisticsDAO;

    @Override
    public ManagerInfoVO getManagerInfoVO(int id) {
        return new ManagerInfoVO(managerDAO.selectById(id));
    }

    @Override
    public ManagerInfoVO getManagerInfoVO(String name) {
        return new ManagerInfoVO(managerDAO.selectByName(name));
    }

    @Override
    public List<CourseCheckVO> getReleaseCourseCheckVOList(int mid) {
        List<CourseCheck> courseChecks = courseCheckDAO.selectReleaseByManager(mid);
        List<CourseCheckVO> result = new ArrayList<>();
        for(CourseCheck courseCheck: courseChecks) {
            result.add(new CourseCheckVO(courseCheck));
        }
        return result;
    }

    @Override
    public List<CourseCheckVO> getUpdateCourseCheckVOList(int mid) {
        List<CourseCheck> courseChecks = courseCheckDAO.selectUpdateByManager(mid);
        List<CourseCheckVO> result = new ArrayList<>();
        for(CourseCheck courseCheck: courseChecks) {
            result.add(new CourseCheckVO(courseCheck));
        }
        return result;
    }

    @Override
    public List<CourseCheckVO> getReleaseCourseCheckVOUncheck(int mid) {
        List<CourseCheck> courseChecks = courseCheckDAO.selectReleaseUncheck(mid);
        List<CourseCheckVO> result = new ArrayList<>();
        for(CourseCheck courseCheck: courseChecks) {
            result.add(new CourseCheckVO(courseCheck));
        }
        return result;
    }

    @Override
    public List<CourseCheckVO> getUpdateCourseCheckVOUncheck(int mid) {
        List<CourseCheck> courseChecks = courseCheckDAO.selectUpdateUncheck(mid);
        List<CourseCheckVO> result = new ArrayList<>();
        for(CourseCheck courseCheck: courseChecks) {
            result.add(new CourseCheckVO(courseCheck));
        }
        return result;
    }

    @Override
    public List<CourseCheckVO> getReleaseCourseCheckVOPass(int mid) {
        List<CourseCheck> courseChecks = courseCheckDAO.selectReleasePassed(mid);
        List<CourseCheckVO> result = new ArrayList<>();
        for(CourseCheck courseCheck: courseChecks) {
            result.add(new CourseCheckVO(courseCheck));
        }
        return result;
    }

    @Override
    public List<CourseCheckVO> getUpdateCourseCheckVOPass(int mid) {
        return null;
    }

    @Override
    public List<CourseCheckVO> getReleaseCourseCheckVORefused(int mid) {
        List<CourseCheck> courseChecks = courseCheckDAO.selectReleaseRefused(mid);
        List<CourseCheckVO> result = new ArrayList<>();
        for(CourseCheck courseCheck: courseChecks) {
            result.add(new CourseCheckVO(courseCheck));
        }
        return result;
    }

    @Override
    public List<CourseCheckVO> getUpdateCourseCheckVORefused(int mid) {
        return null;
    }

    @Override
    public void checkCourse(CourseCheckVO courseCheckVO) {
        CourseCheck courseCheck = new CourseCheck();
        courseCheck.setId(courseCheckVO.getId());
        courseCheck.setAgree(courseCheckVO.getAgree());
        courseCheck.setComment(courseCheckVO.getComment());
        courseCheck.setCheckTime(courseCheckVO.getCheckTime());
        System.out.println("from managerVOManager-courseCheckVO: " + courseCheck);
        int state = courseCheckDAO.update(courseCheck);

        CourseCheck ck = courseCheckDAO.selectReleaseById(courseCheckVO.getId());
//        InstitutionLog institutionLog = new InstitutionLog();
//        institutionLog.setBehavior("course release feedback");
//        if(courseCheckVO.getAgree() == 1) {
//
//            institutionLog.setDescription("pass");
//        }
//        else if(courseCheckVO.getAgree() == -1) {
//
//            institutionLog.setDescription("fail");
//        }
//        institutionLog.setCid(ck.getCid());
//        institutionLog.setInsid(ck.getInsid());
//        System.out.println("from managerVOManager:checkCourse: " + institutionLog);
//        institutionLogDAO.insert(institutionLog);
        ActivityLog activityLog = new ActivityLog();
        activityLog.setBehaviour("course release feedback");
        if(courseCheckVO.getAgree() == 1) {

            activityLog.setDescription("pass");
        }
        else if(courseCheckVO.getAgree() == -1) {
            activityLog.setDescription("fail");
        }
        activityLog.setCid(ck.getCid());
        activityLog.setInsid(ck.getInsid());
        activityLog.setType(3);
        activityLog.setSid(-1);
        activityLogDAO.insert(activityLog);
    }

    @Override
    public List<FinanceCheckVO> getFinanceCheckUnchecked(int mid) {
        List<FinanceCheck> financeCheckListSTI = financeCheckDAO.selectUncheckedSTI(mid);
        List<FinanceCheck> financeCheckListITS = financeCheckDAO.selectUncheckedITS(mid);

        List<FinanceCheckVO> financeCheckVOList = new ArrayList<>();

        for(FinanceCheck financeCheck: financeCheckListSTI) {
            financeCheckVOList.add(new FinanceCheckVO(financeCheck));
        }

        for(FinanceCheck financeCheck: financeCheckListITS) {
            financeCheckVOList.add(new FinanceCheckVO(financeCheck));
        }

        return financeCheckVOList;
    }

    @Override
    public List<FinanceCheckVO> getFinanceCheckPassed(int mid) {
        List<FinanceCheck> financeCheckListSTI = financeCheckDAO.selectPassedSTI(mid);
        List<FinanceCheck> financeCheckListITS = financeCheckDAO.selectPassedITS(mid);

        List<FinanceCheckVO> financeCheckVOList = new ArrayList<>();

        for(FinanceCheck financeCheck: financeCheckListSTI) {
            financeCheckVOList.add(new FinanceCheckVO(financeCheck));
        }

        for(FinanceCheck financeCheck: financeCheckListITS) {
            financeCheckVOList.add(new FinanceCheckVO(financeCheck));
        }

        return financeCheckVOList;
    }

    @Override
    public List<FinanceCheckVO> getFinanceCheckRefused(int mid) {
        List<FinanceCheck> financeCheckListSTI = financeCheckDAO.selectRefusedSTI(mid);
        List<FinanceCheck> financeCheckListITS = financeCheckDAO.selectRefusedITS(mid);

        List<FinanceCheckVO> financeCheckVOList = new ArrayList<>();

        for(FinanceCheck financeCheck: financeCheckListSTI) {
            financeCheckVOList.add(new FinanceCheckVO(financeCheck));
        }

        for(FinanceCheck financeCheck: financeCheckListITS) {
            financeCheckVOList.add(new FinanceCheckVO(financeCheck));
        }

        return financeCheckVOList;
    }

    @Override
    public boolean agreeFinance(int id) {
        FinanceCheck financeCheck = financeCheckDAO.selectById(id);
        financeCheck.setState(1);

        LocalDateTime checkTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
        String checkTimeStr = checkTime.format(format);

        financeCheck.setCheckTime(checkTimeStr);
        financeCheckDAO.update(financeCheck);

        if(financeCheck.getType() == 0) {
            ActivityLog activityLog = new ActivityLog();
            activityLog.setBehaviour("course enroll feedback");
            activityLog.setDescription("agree");
            activityLog.setCid(financeCheck.getCid());
            activityLog.setMoney(financeCheck.getMoney());
            activityLog.setSid(financeCheck.getFromS());
            activityLog.setType(0);
            activityLog.setInsid(financeCheck.getToS());
            activityLogDAO.insert(activityLog);

//            StudentLog studentLog = new StudentLog();
//            studentLog.setBehavior("course enroll feedback");
//            studentLog.setDescription("agree");
//            studentLog.setCid(financeCheck.getCid());
//            studentLog.setMoney(financeCheck.getMoney());
//            studentLog.setSid(financeCheck.getFromS());
//            studentLogDAO.insert(studentLog);

//            ActivityLog activityLogInsti = new ActivityLog();
//            activityLogInsti.setBehaviour("course enroll feedback");
//            activityLogInsti.setBehaviour("agree");
//            activityLogInsti.setCid(financeCheck.getCid());
//            activityLogInsti.setMoney(financeCheck.getMoney());
//            activityLogInsti.setUid(financeCheck.getFromS());
//            activityLogDAO.insert(activityLog);
//
//            InstitutionLog institutionLog = new InstitutionLog();
//            institutionLog.setBehavior("course enroll feedback");
//            institutionLog.setDescription("agree " + financeCheck.getFromS() + " with name: " + financeCheck.getFromName());
//            institutionLog.setMoney(financeCheck.getMoney());
//            institutionLog.setCid(financeCheck.getCid());
//            institutionLog.setInsid(financeCheck.getToS());
//            institutionLogDAO.insert(institutionLog);

            Institution institution = institutionDAO.selectById(financeCheck.getToS());
            double balance = institution.getBalance() + financeCheck.getMoney();
            if(balance < 0) {
                return false;
            }
            institution.setBalance(balance);
            institutionDAO.updateBalance(institution);
        }
        else {
            ActivityLog activityLog = new ActivityLog();
            activityLog.setBehaviour("course quit feedback");
            activityLog.setDescription("agree");
            activityLog.setCid(financeCheck.getCid());
            activityLog.setMoney(financeCheck.getMoney());
            activityLog.setSid(financeCheck.getToS());
            activityLog.setType(0);
            activityLog.setInsid(financeCheck.getFromS());
            activityLogDAO.insert(activityLog);
//            StudentLog studentLog = new StudentLog();
//            studentLog.setBehavior("course quit feedback");
//            studentLog.setDescription("agree");
//            studentLog.setCid(financeCheck.getCid());
//            studentLog.setMoney(financeCheck.getMoney());
//            studentLog.setSid(financeCheck.getToS());
//            studentLogDAO.insert(studentLog);
//
//            InstitutionLog institutionLog = new InstitutionLog();
//            institutionLog.setBehavior("course quit feedback");
//            institutionLog.setDescription("agree " + financeCheck.getFromS() + " with name: " + financeCheck.getFromName());
//            institutionLog.setMoney(financeCheck.getMoney());
//            institutionLog.setCid(financeCheck.getCid());
//            institutionLog.setInsid(financeCheck.getFromS());
//            institutionLogDAO.insert(institutionLog);

            Institution institution = institutionDAO.selectById(financeCheck.getFromS());
            Student student = studentDAO.selectById(financeCheck.getToS());
            double insBalance = institution.getBalance() - financeCheck.getMoney();
            institution.setBalance(insBalance);
            institutionDAO.updateBalance(institution);

            if(student.getLevel() == 0) {
                Bankcard bankcard = bankCardDAO.findByStudent(student.getId());
                double studentBalance = bankcard.getBalance() + financeCheck.getMoney();
                bankcard.setBalance(studentBalance);
                bankCardDAO.update(bankcard);
            }
            else {
                MemberCard memberCard = memberCardDAO.findByStudent(student.getId());
                double studentBalance = memberCard.getBalance() + financeCheck.getMoney();
                memberCard.setBalance(studentBalance);
                memberCardDAO.updateBalance(memberCard);
            }
        }
        return true;
    }

    @Override
    public boolean disagreeFinance(int id) {
        FinanceCheck financeCheck = financeCheckDAO.selectById(id);
        financeCheck.setState(-1);

        LocalDateTime checkTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
        String checkTimeStr = checkTime.format(format);

        financeCheck.setCheckTime(checkTimeStr);
        financeCheckDAO.update(financeCheck);

        if(financeCheck.getType() == 0) {
//            StudentLog studentLog = new StudentLog();
//            studentLog.setBehavior("course enroll feedback");
//            studentLog.setDescription("disagree");
//            studentLog.setCid(financeCheck.getCid());
//            studentLog.setMoney(financeCheck.getMoney());
//            studentLog.setSid(financeCheck.getFromS());
//            studentLogDAO.insert(studentLog);
//
//            InstitutionLog institutionLog = new InstitutionLog();
//            institutionLog.setBehavior("course enroll feedback");
//            institutionLog.setDescription("disagree " + financeCheck.getFromS() + " with name: " + financeCheck.getFromName());
//            institutionLog.setMoney(financeCheck.getMoney());
//            institutionLog.setCid(financeCheck.getCid());
//            institutionLog.setInsid(financeCheck.getToS());
//            institutionLogDAO.insert(institutionLog);

            ActivityLog activityLog = new ActivityLog();
            activityLog.setBehaviour("course enroll feedback");
            activityLog.setDescription("disagree");
            activityLog.setCid(financeCheck.getCid());
            activityLog.setMoney(financeCheck.getMoney());
            activityLog.setSid(financeCheck.getFromS());
            activityLog.setType(0);
            activityLog.setInsid(financeCheck.getToS());
            activityLogDAO.insert(activityLog);

            Student student = studentDAO.selectById(financeCheck.getFromS());
            if(student.getLevel() == 0) {
                Bankcard bankcard = bankCardDAO.findByStudent(student.getId());
                double studentBalance = bankcard.getBalance() + financeCheck.getMoney();
                bankcard.setBalance(studentBalance);
                bankCardDAO.update(bankcard);
            }
            else {
                MemberCard memberCard = memberCardDAO.findByStudent(student.getId());
                double studentBalance = memberCard.getBalance() + financeCheck.getMoney();
                memberCard.setBalance(studentBalance);
                memberCardDAO.updateBalance(memberCard);
            }

            Attending attending = attendingDAO.selectByBoth(student.getId(), financeCheck.getCid());
            attendingDAO.delete(attending);
        }
        else {
//            StudentLog studentLog = new StudentLog();
//            studentLog.setBehavior("course quit feedback");
//            studentLog.setDescription("disagree");
//            studentLog.setCid(financeCheck.getCid());
//            studentLog.setMoney(financeCheck.getMoney());
//            studentLog.setSid(financeCheck.getToS());
//            studentLogDAO.insert(studentLog);
//
//            InstitutionLog institutionLog = new InstitutionLog();
//            institutionLog.setBehavior("course quit feedback");
//            institutionLog.setDescription("disagree " + financeCheck.getFromS() + " with name: " + financeCheck.getFromName());
//            institutionLog.setMoney(financeCheck.getMoney());
//            institutionLog.setCid(financeCheck.getCid());
//            institutionLog.setInsid(financeCheck.getFromS());
//            institutionLogDAO.insert(institutionLog);
            ActivityLog activityLog = new ActivityLog();
            activityLog.setBehaviour("course quit feedback");
            activityLog.setDescription("disagree");
            activityLog.setCid(financeCheck.getCid());
            activityLog.setMoney(financeCheck.getMoney());
            activityLog.setSid(financeCheck.getToS());
            activityLog.setType(0);
            activityLog.setInsid(financeCheck.getFromS());
            activityLogDAO.insert(activityLog);
        }
        return true;
    }

    @Override
    public void agreeUpdate(int courseCheckId, int courseUpdateId,
                            int cid, String cname, String description, double price) {
        Course course = new Course();
        course.setId(cid);
        course.setName(cname);
        course.setDescription(description);
        course.setPrice(price);
        courseDAO.update(course);

        CourseCheck courseCheck = new CourseCheck();
        courseCheck.setId(courseCheckId);
        courseCheck.setAgree(1);
        LocalDateTime checkTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
        String checkTimeStr = checkTime.format(format);
        courseCheck.setCheckTime(checkTimeStr);
        courseCheckDAO.update(courseCheck);

//        InstitutionLog institutionLog = new InstitutionLog();
//        institutionLog.setCid(cid);
//        institutionLog.setBehavior("course update feedback");
//        institutionLog.setDescription("agree");
        Course course1 = courseDAO.selectById(cid);
//        institutionLog.setInsid(course1.getInsid());
//        institutionLogDAO.insert(institutionLog);


//        System.out.println("from managerVOMnager-agreeUpdate- coureUpdateId:" + courseCheck.ge)

        CourseUpdate courseUpdate = courseUpdateDAO.selectById(courseUpdateId);
        courseUpdate.setIsActive(0);
        courseUpdateDAO.update(courseUpdate);

        ActivityLog activityLog = new ActivityLog();
        activityLog.setBehaviour("course update feedback");
        activityLog.setDescription("agree");
        activityLog.setCid(cid);
        activityLog.setMoney(0);
        activityLog.setSid(-1);
        activityLog.setType(3);
        activityLog.setInsid(course1.getInsid());
        activityLogDAO.insert(activityLog);
    }

    @Override
    public void disagreeUpdate(int courseCheckId, int courseUpdateId, int cid) {
        CourseCheck courseCheck = new CourseCheck();
        courseCheck.setId(courseCheckId);
        courseCheck.setAgree(-1);
        LocalDateTime checkTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
        String checkTimeStr = checkTime.format(format);
        courseCheck.setCheckTime(checkTimeStr);
        courseCheckDAO.update(courseCheck);

//        CourseCheck courseCheck1 = courseCheckDAO.selectById(courseCheckId);
        Course course = courseDAO.selectById(cid);

        ActivityLog activityLog = new ActivityLog();
        activityLog.setBehaviour("course update feedback");
        activityLog.setDescription("disagree");
        activityLog.setCid(cid);
        activityLog.setMoney(0);
        activityLog.setSid(-1);
        activityLog.setType(3);
        activityLog.setInsid(course.getInsid());
        activityLogDAO.insert(activityLog);

        CourseUpdate courseUpdate = courseUpdateDAO.selectById(courseUpdateId);
        courseUpdate.setIsActive(0);
        courseUpdateDAO.update(courseUpdate);
    }

    @Override
    public List<ActivityLogVO> geCourseFinanceLogs(int mid) {
        List<ActivityLog> activityLogList = activityLogDAO.selectCourseFinances();

        List<ActivityLogVO> activityLogVOList = new ArrayList<>();
        for(ActivityLog activityLog: activityLogList) {
            ActivityLogVO activityLogVO = new ActivityLogVO(activityLog);
            activityLogVOList.add(activityLogVO);
        }

        return activityLogVOList;
    }

    @Override
    public List<ActivityLogVO> getOtherFinanceLogs(int mid) {
        List<ActivityLog> activityLogList = activityLogDAO.selectOtherFinances();

        List<ActivityLogVO> activityLogVOList = new ArrayList<>();
        for(ActivityLog activityLog: activityLogList) {
            ActivityLogVO activityLogVO = new ActivityLogVO(activityLog);
            activityLogVOList.add(activityLogVO);
        }

        return activityLogVOList;
    }


    @Override
    public List<ActivityLogVO> getInstitutionLogs(int mid) {
        List<ActivityLog> activityLogList = activityLogDAO.selectInstitutionLogs();

        List<ActivityLogVO> activityLogVOList = new ArrayList<>();
        for(ActivityLog activityLog: activityLogList) {
            ActivityLogVO activityLogVO = new ActivityLogVO(activityLog);
            activityLogVOList.add(activityLogVO);
        }

        return activityLogVOList;
    }

    @Override
    public List<ActivityLogVO> getStudentLogs(int mid) {
        List<ActivityLog> activityLogList = activityLogDAO.selectStudentLogs();

        List<ActivityLogVO> activityLogVOList = new ArrayList<>();
        for(ActivityLog activityLog: activityLogList) {
            ActivityLogVO activityLogVO = new ActivityLogVO(activityLog);
            activityLogVOList.add(activityLogVO);
        }

        return activityLogVOList;
    }

    @Override
    public List<InstitutionCourseStatisticsVO> getInstitutionStatistics() {
        List<InstitutionCourseStatistics> institutionCourseStatisticsList =
                institutionCourseStatisticsDAO.selectAll();
        List<InstitutionCourseStatisticsVO> result = new ArrayList<>();
        for(InstitutionCourseStatistics institutionCourseStatistics: institutionCourseStatisticsList) {
            result.add(new InstitutionCourseStatisticsVO(institutionCourseStatistics));
        }
        System.out.println("from managerVOManager: " + result);
        return result;
    }
}
