package tc.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tc.bean.StudentInfoVO;
import tc.bean.TeacherInfoVO;
import tc.service.teacherService.TeacherVOManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by stonezhang on 2017/3/28.
 */
@Controller
public class TeacherController {
    @Autowired
    private TeacherVOManager teacherVOManager;

    @RequestMapping(value = "teacher/login", method = RequestMethod.GET)
    public String getLogin() {
        return "/institution/teacherReg";
    }

    @RequestMapping(value = "teacher/register/info", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> doRegister(HttpServletRequest request) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Map<String, Object> map = new HashMap<>();
        teacherVOManager.register(name, password);

        TeacherInfoVO teacherInfoVO = new TeacherInfoVO();
        teacherInfoVO.setName(name);
        teacherInfoVO.setPassword(password);
        HttpSession session = request.getSession();
        session.setAttribute("teacherInfoVO", teacherInfoVO);
        map.put("success", true);
        return map;
    }

    @RequestMapping(value = "teacher/homepage", method = RequestMethod.GET)
    public String getTeacherHomepage() {
        return "/institution/teacherHome";
    }
}


