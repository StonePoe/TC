package tc.service.studentService;

import tc.bean.StudentCourseVO;
import tc.bean.StudentInfoVO;

import java.util.List;

/**
 * Created by stonezhang on 2017/1/29.
 */
public interface StudentVOManager {
    public StudentInfoVO getStudentVOById(int id);

    public StudentInfoVO getStudentVOByName(String name);

    public List<StudentCourseVO> getStudentCourses(int sid);
}
