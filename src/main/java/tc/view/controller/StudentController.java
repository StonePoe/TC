package tc.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tc.bean.*;
import tc.service.studentService.CardManager;
import tc.service.studentService.CardVOManager;
import tc.service.studentService.StudentVOManager;
import tc.service.studentService.StudentVerify;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by stonezhang on 2017/1/25.
 */
@Controller
@RequestMapping("/student")
public class StudentController {
//    @RequestMapping(value = "/register", method = RequestMethod.GET)
//    public String getRegisterPage() {
//        return "/student/StudentRegister";
//    }
    @Autowired
    private StudentVerify studentVerifyImpl;

    @Autowired
    private StudentVOManager studentVOManagerImpl;

    @Autowired
    private CardVOManager cardVOManagerImpl;

    @Autowired
    private CardManager cardManagerImpl;

    @RequestMapping(value = "/register/info", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> doRegister(HttpServletRequest request) {
        System.out.println("student register");
        String username = request.getParameter("username");
        String bank = request.getParameter("bank");
        System.out.println("from student controller: register " + bank);
        String password = request.getParameter("password");
        System.out.println("from student controller: register  " + username);
        System.out.println("from student controller " + password);
        Map<String, Object> map = new HashMap<>();
        if (studentVerifyImpl.existName(username)) {
            map.put("success", false);
        }
        else {
            System.out.println("from student controller: name not uesed");

            studentVerifyImpl.register(username, password, bank);

            StudentInfoVO studentInfoVO = studentVOManagerImpl.getStudentByName(username);

            HttpSession session = request.getSession(false);
            if (session == null) {
                System.out.println("from student controller: fail to post: invalid session");
                map.put("success", false);
            }
            else {
                map.put("success", true);
                System.out.println("from student controller: post successfully");
                session.setAttribute("studentInfoVO", studentInfoVO);
            }
        }
        return map;

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(HttpServletRequest request) {
        System.out.println("student login");
        return "student/studentLogin";
    }

    @RequestMapping(value = "/login/info", method = RequestMethod.POST)
//    @ResponseStatus(value= HttpStatus.OK)
    public @ResponseBody Map<String, Object> doLogin(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        String userame = request.getParameter("username");
        String password = request.getParameter("password");

        if(studentVerifyImpl.existName(userame) &&
                studentVerifyImpl.isCorrectPsw(userame, password)){
            StudentInfoVO studentInfoVO = studentVOManagerImpl.getStudentByName(userame);
            HttpSession session = request.getSession(false);
            if (session == null) {
                map.put("success", false);
            }
            else {
                session.setAttribute("studentInfoVO", studentInfoVO);
            }
            map.put("success", true);
        }
        else {
            map.put("success", false);
        }
        return map;
    }

    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public String getHomepage(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        StudentInfoVO studentInfoVO = (StudentInfoVO) session.getAttribute("studentInfoVO");
        System.out.println("student homepage" + studentInfoVO);

        int sid = studentInfoVO.getId();

        List<StudentCourseVO> activeCourses = studentVOManagerImpl.getActiveCourses(sid);
        List<StudentCourseVO> unstartCourses = studentVOManagerImpl.getUnstartCourses(sid);
        List<StudentCourseVO> finishedCourses = studentVOManagerImpl.getFinishedCourses(sid);

        request.setAttribute("activeCourses", activeCourses);
        request.setAttribute("unstartCourses", unstartCourses);
        request.setAttribute("finishedCourses", finishedCourses);

        session.setAttribute("fromUrl", "/student/homepage");

        return "/student/homepage";
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String getInfo(HttpServletRequest request) {
        System.out.println("studentInfo page");

        HttpSession session = request.getSession(false);

        return "/student/studentInfo";
    }

    @RequestMapping(value = "/info/password", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> updatePassword(HttpServletRequest request) {
        String password = request.getParameter("password");
        System.out.println("from info/password: " + password);

        HttpSession session = request.getSession(false);
        StudentInfoVO studentInfoVO = (StudentInfoVO) session.getAttribute("studentInfoVO");

        studentVerifyImpl.updatePassword(studentInfoVO.getId(), password);

        Map<String, Object> map = new HashMap<>();
        map.put("success", true);

        return map;
    }
//
//    @RequestMapping(value = "/info/password", method = RequestMethod.POST)
//    public String updatePassword(HttpServletRequest request) {
//        String password = request.getParameter("password");
//        System.out.println(password);
//        return "redirect:/student/info";
//    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request)  {
        HttpSession session = request.getSession(false);
        session.invalidate();
        return "redirect:/student/login";
    }

    @RequestMapping(value = "/member", method = RequestMethod.GET)
    public String getMemberPage(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        StudentInfoVO studentInfoVO = (StudentInfoVO) session.getAttribute("studentInfoVO");
        BankcardVO bankcardVO = cardVOManagerImpl.getBankcardVO(studentInfoVO.getId());
        MemberCardVO memberCardVO = cardVOManagerImpl.getMemberCardVO(studentInfoVO.getId());

        System.out.println("from memberPage: getNumberId:" + studentInfoVO.getMemberId());

        request.setAttribute("bankcardVO", bankcardVO);
        request.setAttribute("memberCardVO", memberCardVO);

        return "/student/memberInfo";
    }

    @RequestMapping(value = "/member/active", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> doActiveMember(HttpServletRequest request) {
        String bankid = request.getParameter("bankcardID");
        int memberid = Integer.parseInt(request.getParameter("memberCardID"));

        HttpSession session = request.getSession(false);
//        int sid = ((StudentInfoVO) session.getAttribute("studentInfoVO")).getId();
        StudentInfoVO studentInfoVO = (StudentInfoVO) session.getAttribute("studentInfoVO");
        int sid = studentInfoVO.getId();
        cardManagerImpl.active(bankid, memberid, sid);
        StudentInfoVO newStudentInfo = studentVOManagerImpl.getStudentById(sid);
        session.setAttribute("studentInfoVO", newStudentInfo);

        Map<String, Object> map = new HashMap<>();
        map.put("success", true);

        return map;
    }

    @RequestMapping(value = "/course/quit", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> doCourseQuit(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();

        int sid = Integer.parseInt(request.getParameter("sid"));
        int cid = Integer.parseInt(request.getParameter("cid"));
        double price = Double.parseDouble(request.getParameter("price"));

        System.out.println("from studentController: quit class " + cid + " with sid: " + sid);

        HttpSession session = request.getSession(false);
        if (session == null) {
            map.put("success", false);
        }
        else {

            StudentInfoVO studentInfoVO = (StudentInfoVO) session.getAttribute("studentInfoVO");
            studentVOManagerImpl.doCourseQuit(sid, cid, studentInfoVO.getLevel(), price);
            map.put("success", true);
        }
        return map;

    }

    @RequestMapping(value = "/course/book", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> doCourseEnroll(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();

        int sid = Integer.parseInt(request.getParameter("sid"));
        int cid = Integer.parseInt(request.getParameter("cid"));
        double price = Double.parseDouble(request.getParameter("price"));

        HttpSession  session = request.getSession(false);
        if(session == null) {
            map.put("success", false);
        }
        else {

            StudentInfoVO studentInfoVO = (StudentInfoVO) session.getAttribute("studentInfoVO");
            boolean success = studentVOManagerImpl.doCourseEnroll(sid, cid, studentInfoVO.getLevel(), price);
            if(success) {
                map.put("success", true);
            }
            else {
                map.put("success", false);
            }
        }
        return map;
    }

    @RequestMapping(value = "/member/finance", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> doCharge(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        String bankId = (request.getParameter("bankId"));
        int memberId = Integer.parseInt(request.getParameter("memberId"));
        double money = Double.parseDouble(request.getParameter("money"));
        HttpSession session = request.getSession(false);
//        int sid = ((StudentInfoVO) session.getAttribute("studentInfoVO")).getId();
        StudentInfoVO studentInfoVO = (StudentInfoVO) session.getAttribute("studentInfoVO");
        int sid = studentInfoVO.getId();
        boolean success = cardManagerImpl.recharge(bankId, memberId, money, sid);

        if(success) {
            map.put("success", true);
        }
        else {
            map.put("success", false);
        }
        return map;
    }


    @RequestMapping(value = "/member/destroy", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> doDestroy(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();

        int memberId = Integer.parseInt(request.getParameter("memberId"));

        HttpSession session = request.getSession(false);
//        int sid = ((StudentInfoVO) session.getAttribute("studentInfoVO")).getId();
        StudentInfoVO studentInfoVO = (StudentInfoVO) session.getAttribute("studentInfoVO");
        int sid = studentInfoVO.getId();

        boolean success = cardManagerImpl.destroy(memberId, sid);

//        HttpSession session = (HttpSession) request.getSession(false);
//        StudentInfoVO studentInfoVO = (StudentInfoVO) session.getAttribute("studentInfoVO");
        studentInfoVO.setLevel(0);
        session.setAttribute("studentInfoVO", studentInfoVO);
        if(success) {
            map.put("success", true);
        }
        else {
            map.put("success", false);
        }
        return map;
    }



    @RequestMapping(value = "/member/finance", method = RequestMethod.GET)
    public String getMemberFinance(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        StudentInfoVO studentInfoVO = (StudentInfoVO) session.getAttribute("studentInfoVO");
        BankcardVO bankcardVO = cardVOManagerImpl.getBankcardVO(studentInfoVO.getId());
        MemberCardVO memberCardVO = cardVOManagerImpl.getMemberCardVO(studentInfoVO.getId());

        System.out.println("from memberFinancePage: getNumberId:" + studentInfoVO.getMemberId());

        request.setAttribute("bankcardVO", bankcardVO);
        request.setAttribute("memberCardVO", memberCardVO);

        return "/student/memberFinance";
    }
}

