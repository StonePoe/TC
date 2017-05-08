package tc.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tc.bean.*;
import tc.model.Institution;
import tc.service.fieldService.CourseFieldVOManager;
import tc.service.institutionService.InstitutionCourse;
import tc.service.institutionService.InstitutionVOManager;
import tc.service.institutionService.InstitutionVerify;
import tc.service.teacherService.TeacherVOManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by stonezhang on 2017/3/2.
 */
@Controller
@RequestMapping("/institution")
public class InstitutionController {
    @Autowired
    private InstitutionVerify institutionVerifyImpl;

    @Autowired
    private InstitutionVOManager institutionVOManagerImpl;

    @Autowired
    private InstitutionCourse institutionCourseImpl;

    @Autowired
    private CourseFieldVOManager courseFieldVOManagerImpl;

    @Autowired
    private TeacherVOManager teacherVOManagerImpl;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String doLoginPage() {
        return "institution/institutionLogin";
    }

    @RequestMapping(value = "/login/info", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> doLogin(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        String instiName = request.getParameter("instiName");
        String password = request.getParameter("password");

        if (institutionVerifyImpl.existName(instiName) &&
                institutionVerifyImpl.isCorrectPsw(instiName, password)) {
            InstitutionInfoVO institutionInfoVO = institutionVOManagerImpl.getInstitutionInfoVO(instiName);
            HttpSession session = request.getSession(false);
            if (session == null) {
                map.put("success", false);
            } else {
                session.setAttribute("institutionInfoVO", institutionInfoVO);
            }
            map.put("success", true);
        } else {
            map.put("success", false);
        }
        return map;
    }

    @RequestMapping(value = "/register/info", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> doRegister(HttpServletRequest request) {
        String instiName = request.getParameter("instiName");
        String password = request.getParameter("password");

        Map<String, Object> map = new HashMap<>();

        if (institutionVerifyImpl.existName(instiName)) {
            map.put("success", false);
        } else {
            institutionVerifyImpl.register(instiName, password);
//            StudentInfoVO studentInfoVO = studentVOManagerImpl.getStudentByName(username);

            InstitutionInfoVO institutionInfoVO = institutionVOManagerImpl.getInstitutionInfoVO(instiName);

            HttpSession session = request.getSession(false);
            if (session == null) {
                System.out.println("from institution controller: fail to post: invalid session");
                map.put("success", false);
            } else {
                map.put("success", true);
                System.out.println("from institution controller: post successfully");
                session.setAttribute("institutionInfoVO", institutionInfoVO);
            }
        }

        return map;
    }

    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public String getHomepage(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        InstitutionInfoVO institutionInfoVO = (InstitutionInfoVO) session.getAttribute("institutionInfoVO");
        System.out.println("from institutionController-getHomepage: judging institutionVOmanager "
                + institutionVOManagerImpl);
        System.out.println("from institutionController-getHomepage: judging institutionInfoVO "
                + institutionInfoVO);
        List<InstitutionCourseVO> activeCourses =
                institutionVOManagerImpl.getActiveCourses(institutionInfoVO.getId());
        List<InstitutionCourseVO> abandonCourses =
                institutionVOManagerImpl.getAbandonCourses(institutionInfoVO.getId());
        List<InstitutionCourseVO> checkingCourses =
                institutionVOManagerImpl.getCheckingCourses(institutionInfoVO.getId());

        System.out.println(checkingCourses);
        request.setAttribute("activeCourses", activeCourses);
        request.setAttribute("abandonCourses", abandonCourses);
        request.setAttribute("checkingCourses", checkingCourses);
        return "/institution/homepage";
    }

    @RequestMapping(value = "/release", method = RequestMethod.GET)
    public String getReleasePage(HttpServletRequest request) {
        List<CourseFieldVO> courseFieldVOList = courseFieldVOManagerImpl.getCourseFieldList();
        List<TeacherInfoVO> teacherInfoVOList = teacherVOManagerImpl.getTeacherVOList();

        request.setAttribute("courseFieldVOList", courseFieldVOList);
        request.setAttribute("teacherInfoVOList", teacherInfoVOList);

        return "/institution/courseRelease";
    }

    @RequestMapping(value = "/release", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> doCourseRelease(HttpServletRequest request) {
        String name = request.getParameter("name");
        int tid = Integer.parseInt(request.getParameter("tid"));
        double price = Double.parseDouble(request.getParameter("price"));
        String startdate = request.getParameter("startdate");
        String enddate = request.getParameter("enddate");
        int field = Integer.parseInt(request.getParameter("field"));
        String imgUrl = request.getParameter("imgUrl");
        int insid = Integer.parseInt(request.getParameter("insid"));
        String description = request.getParameter("description");
        int agree = 0;

        System.out.println("from institutionController: " + tid);
        institutionCourseImpl.release(name, tid, price, startdate, enddate, field, imgUrl,
                insid, description, agree);

        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

    @RequestMapping(value = "/courseCheck", method = RequestMethod.GET)
    public String getCourseCheckPage(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        InstitutionInfoVO institutionInfoVO = (InstitutionInfoVO) session.getAttribute("institutionInfoVO");

        List<InstitutionCourseVO> institutionCourseVOList =
                institutionVOManagerImpl.getCheckingCourses(institutionInfoVO.getId());

        request.setAttribute("checkingCourseList", institutionCourseVOList);
        return "/institution/institutionChecking";
    }

    @RequestMapping(value = "/log", method = RequestMethod.GET)
    public String getFinanceLog(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        InstitutionInfoVO institutionInfoVO = (InstitutionInfoVO) session.getAttribute("institutionInfoVO");

        List<ActivityLogVO> activityLogVOList = institutionVOManagerImpl.getCourseLog(institutionInfoVO.getId());

        List<InstitutionCourseStatisticsVO> statisticsVOList = institutionVOManagerImpl.
                getInstiStatistics(institutionInfoVO.getId());

        model.addAttribute("courseLogList", activityLogVOList);
        model.addAttribute("statisticsVOList", statisticsVOList);
        model.addAttribute("balance", institutionInfoVO.getBalance());

        return "/institution/financeLog";
    }

    @RequestMapping(value = "/courseLog", method = RequestMethod.GET)
    public String getCourseLog(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        InstitutionInfoVO institutionInfoVO = (InstitutionInfoVO) session.getAttribute("institutionInfoVO");

        List<ActivityLogVO> activityLogVOList = institutionVOManagerImpl.getInstitutionLog(institutionInfoVO.getId());

        model.addAttribute("courseLogList", activityLogVOList);

        return "/institution/institutionLog";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request)  {
        HttpSession session = request.getSession(false);
        session.invalidate();
        return "redirect:/institution/login";
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String getInfoPage(HttpServletRequest request) {
        return "/institution/institutionInfo";
    }

    @RequestMapping(value = "/info/password", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> updatePassword(HttpServletRequest request) {
        String password = request.getParameter("password");
        System.out.println("from info/password: " + password);

        HttpSession session = request.getSession(false);
        InstitutionInfoVO institutionInfoVO = (InstitutionInfoVO) session.getAttribute("institutionInfoVO");

        institutionVerifyImpl.updatePassword(institutionInfoVO.getId(), password);

        Map<String, Object> map = new HashMap<>();
        map.put("success", true);

        return map;
    }

    @RequestMapping(value = "/info/name", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> updateName(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        String name = request.getParameter("name");
        System.out.println("from info/name: " + name);
        if(institutionVerifyImpl.existName(name)) {
            map.put("success", false);
        }
        else {
            HttpSession session = request.getSession(false);
            InstitutionInfoVO institutionInfoVO = (InstitutionInfoVO) session.getAttribute("institutionInfoVO");
            institutionVerifyImpl.updateName(institutionInfoVO.getId(), name);

            map.put("success", true);

            InstitutionInfoVO newInstitutionInfoVO = institutionVOManagerImpl.
                    getInstitutionInfoVO(institutionInfoVO.getId());
            session.setAttribute("institutionInfoVO", newInstitutionInfoVO);
        }
        return map;
    }

}
