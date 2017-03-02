package tc.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tc.bean.StudentInfoVO;
import tc.service.studentService.StudentVOManager;
import tc.service.studentService.StudentVerify;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    @RequestMapping(value = "/register/infogotta", method = RequestMethod.POST)
    public String doRegister(HttpServletRequest request) {
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
        return "forward:/student/homepage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(HttpServletRequest request) {
        System.out.println("login");
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
        return "/student/studentLogin";
    }

    @RequestMapping(value = "/login/infogotta", method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request) {
        String studentName = request.getParameter("name");
        String studentPass = request.getParameter("password");
        String bankId = request.getParameter("bankid");
//
//        String beanName = "StudentVerify";
//        String viewClassName = StudentVerify.class.getName();
//        String namespace = EJBFactory.getJNDIPath() + beanName + "!" + viewClassName;
//        StudentVerify studentVerify = (StudentVerify)EJBFactory.getEjb(namespace);
//
//        beanName = "StudentVOManager";
//        viewClassName = StudentVOManager.class.getName();
//        namespace = EJBFactory.getJNDIPath() + beanName + "!" + viewClassName;
//        StudentVOManager studentVOManager = (StudentVOManager)EJBFactory.getEjb(namespace);
//
////        boolean isName = studentVerify.existName(studentName);
        boolean isId = false;
        try {
            int sid = Integer.parseInt(studentName);
            isId = studentVerifyImpl.existId(sid);
        } catch (Exception e) {
            isId = false;
        }

        StudentInfoVO studentInfoVO = new StudentInfoVO();


        if(isId) {
            studentInfoVO = studentVOManagerImpl.getStudentVOById(Integer.parseInt(studentName));
        }
        else {
           studentInfoVO = studentVOManagerImpl.getStudentVOByName(studentName);
        }

        HttpSession session = request.getSession(false);
        if (session == null) {
            return "/student/StudentLogin";
        }
        session.setAttribute("studentinfo", studentInfoVO);
        session.setAttribute("fromURL", "/student/login");

        return "forward:/student/homepage";
    }

    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public String getHomepage(HttpServletRequest request) {
//        String beanName = "StudentVOManager";
//        String viewClassName = StudentVOManager.class.getName();
//        String namespace = EJBFactory.getJNDIPath() + beanName + "!" + viewClassName;
//        StudentVOManager studentVOManager = (StudentVOManager)EJBFactory.getEjb(namespace);
//
//        HttpSession session = request.getSession(false);
//
//        StudentInfoVO studentInfoVO = (StudentInfoVO)session.getAttribute("studentinfo");
//        if(studentInfoVO == null) {
//            return "forward:student/login";
//        }
//
//        int id = studentInfoVO.getId();
//        List<StudentCourseVO> courseVOList = studentVOManager.getStudentCourses(id);
//        request.setAttribute("courseList", courseVOList);
        return "/student/homepage";
    }
}
