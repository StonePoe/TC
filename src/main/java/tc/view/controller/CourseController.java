package tc.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tc.bean.StudentCourseVO;
import tc.bean.StudentInfoVO;
import tc.service.studentService.StudentVOManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by stonezhang on 2017/3/5.
 */
@Controller
public class CourseController {
    @Autowired
    private StudentVOManager studentVOManagerImpl;

    @RequestMapping(value = "/student/course", method = RequestMethod.GET)
    public String getStudentRegisteredCourse(@RequestParam("cid") int cid, HttpServletRequest request) {
        System.out.println(cid);
        HttpSession session = request.getSession(false);
        StudentInfoVO studentInfoVO = (StudentInfoVO) session.getAttribute("studentInfoVO");
        int sid = studentInfoVO.getId();
        System.out.println("course " + cid + ", by student " + studentInfoVO.getId());
        StudentCourseVO studentCourseVO = studentVOManagerImpl.getCourse(sid, cid);
        request.setAttribute("studentCourseVO", studentCourseVO);

        return "/student/courseDetail";
    }

    @RequestMapping(value = "/student/coursechoice", method = RequestMethod.GET)
    public String getCourseChoice(HttpServletRequest request) {
        System.out.println("student course choice");

        Map<String, List<StudentCourseVO>> studentCourseVOList = studentVOManagerImpl.getCourses();

        request.setAttribute("studentCourseVOList", studentCourseVOList);

        return "/student/courseChoice";
    }
}
