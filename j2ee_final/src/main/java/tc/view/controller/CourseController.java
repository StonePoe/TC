package tc.view.controller;

import org.apache.commons.collections.FastHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tc.bean.*;
import tc.service.institutionService.InstitutionCourse;
import tc.service.institutionService.InstitutionVOManager;
import tc.service.studentService.StudentVOManager;
import tc.service.teacherService.TeacherVOManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by stonezhang on 2017/3/5.
 */
@Controller
public class CourseController {
    @Autowired
    private StudentVOManager studentVOManagerImpl;

    @Autowired
    private InstitutionVOManager institutionVOManagerImpl;

    @Autowired
    private TeacherVOManager teacherVOManagerImpl;

    @Autowired
    private InstitutionCourse institutionCourseImpl;

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

    @RequestMapping(value = "/institution/course", method = RequestMethod.GET)
    public String getInstitutionCourse(@RequestParam("cid") int cid, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);

        InstitutionCourseVO institutionCourseVO = institutionVOManagerImpl.getCourse(cid);

        System.out.println("from institutionController: " + institutionCourseVO);

        List<InstitutionStudentVO> institutionStudentVOList = institutionVOManagerImpl.getCourseStudentList(cid);

        List<TeacherInfoVO> teacherInfoVOList = teacherVOManagerImpl.getTeacherVOList();

        model.addAttribute("institutionCourseVO", institutionCourseVO);
        request.setAttribute("institutionCourseVO", institutionCourseVO);
        model.addAttribute("institutionStudentVOList", institutionStudentVOList);
        model.addAttribute("teacherInfoVOList", teacherInfoVOList);

        return "/institution/courseDetail";
    }

    @RequestMapping(value = "/institution/course/score", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> doScore(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        int sid = Integer.parseInt(request.getParameter("sid"));
        int cid = Integer.parseInt(request.getParameter("cid"));
        double score = Double.parseDouble(request.getParameter("score"));
        institutionCourseImpl.setScore(sid, cid, score);
        map.put("success", true);
        return map;
    }

    @RequestMapping(value = "/institution/course/update", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> doUpdate(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        int cid = Integer.parseInt(request.getParameter("cid"));
        String cname = request.getParameter("cname");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        institutionCourseImpl.update(cid, description, price, cname);
        map.put("success", true);
        return map;
    }
}
