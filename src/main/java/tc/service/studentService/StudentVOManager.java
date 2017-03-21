package tc.service.studentService;

import tc.bean.*;

import java.util.List;
import java.util.Map;

/**
 * Created by stonezhang on 2017/1/29.
 */
public interface StudentVOManager {
    public StudentInfoVO getStudentById(int id);

    StudentInfoVO getStudentByName(String name);

    public Map<String, List<StudentCourseVO>> getCourses();

    public StudentCourseVO getCourse(int sid, int cid);

    List<StudentCourseVO> getActiveCourses(int sid);

    List<StudentCourseVO> getUnstartCourses(int sid);

    List<StudentCourseVO> getFinishedCourses(int sid);

    boolean doCourseQuit(int sid, int cid, int level, double price);

    boolean doCourseEnroll(int sid, int cid, int level, double price);
}
