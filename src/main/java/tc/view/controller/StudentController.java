package tc.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tc.bean.*;
import tc.service.studentService.CardManager;
import tc.service.studentService.CardVOManager;
import tc.service.studentService.StudentVOManager;
import tc.service.studentService.StudentVerify;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
        String username = request.getParameter("username");
        String bank = request.getParameter("bank");
        System.out.println("from student controller: " + bank);
        String password = request.getParameter("password");
        System.out.println("from student controller " + username);
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
//        String studentName = request.getParameter("studentname");
//        String studentPass = request.getParameter("studentpassword");
//        String bankCard = request.getParameter("bankCard");
//
//        final String beanName = "StudentVerify";
//        final String viewClassName = StudentVerify.class.getName();
//
//        String namespace = EJBFactory.getJNDIPath() + beanName + "!" + viewClassName;
//        StudentVerify studentVerify = (StudentVerify)EJBFactory.getEjb(namespace);
//
//        studentVerify.register(studentName, studentPass, bankCard);
//
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(HttpServletRequest request) {
        System.out.println("student login");
//        HttpSession session = request.getSession();
//        if(session == null) {
//            return "/student/StudentLogin";
//        }
//        else {
//            if (session.getAttribute("studentinfo") != null) {
//                String fromURL = (String)session.getAttribute("fromURL");
//                return "redirect:" + fromURL;
//            }
//            else {
//                return "/student/StudentLogin";
//            }
//        }
        return "student/studentLogin";
    }

    @RequestMapping(value = "/login/info", method = RequestMethod.POST)
//    @ResponseStatus(value= HttpStatus.OK)
    public String doLogin(HttpServletRequest request) {
        String studentName = request.getParameter("name");
        String studentPass = request.getParameter("password");
        String bankId = request.getParameter("bankid");
        boolean isId = false;
        int sid = 0;
        boolean isValid = false;
        try {
            sid = Integer.parseInt(studentName);
            isId = studentVerifyImpl.existId(sid);
        } catch (Exception e) {
            isId = false;Map<String, Object> map = new HashMap<>();
        }Map<String, Object> map = new HashMap<>();

        if(isId) {
            isValid = studentVerifyImpl.existId(sid);
        }
        else {
            isValid = studentVerifyImpl.existName(studentName);
        }

        if (!isValid) {
            return "redirect: /student/login";
        }

        StudentInfoVO studentInfoVO;

        if(isId) {
            studentInfoVO = studentVOManagerImpl.getStudentById(Integer.parseInt(studentName));
        }
        else {
           studentInfoVO = studentVOManagerImpl.getStudentByName(studentName);
        }

        HttpSession session = request.getSession(false);
        if (session == null) {
            return "/student/StudentLogin";
        }
        session.setAttribute("studentInfoVO", studentInfoVO);
        session.setAttribute("fromURL", "/student/login");
        return "redirect:/student/homepage";
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

    @RequestMapping(value = "member/active", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> doActiveMember(HttpServletRequest request) {
        String bankid = request.getParameter("bankcardID");
        int memberid = Integer.parseInt(request.getParameter("memberCardID"));

        cardManagerImpl.active(bankid, memberid);
        HttpSession session = request.getSession(false);

        StudentInfoVO studentInfoVO = (StudentInfoVO) session.getAttribute("studentInfoVO");
        int sid = studentInfoVO.getId();
        StudentInfoVO newStudentInfo = studentVOManagerImpl.getStudentById(sid);
        session.setAttribute("studentInfoVO", newStudentInfo);

        Map<String, Object> map = new HashMap<>();
        map.put("success", true);

        return map;
    }
}
