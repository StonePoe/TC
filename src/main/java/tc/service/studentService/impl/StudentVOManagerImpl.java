package tc.service.studentService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tc.bean.StudentCourseVO;
import tc.bean.StudentInfoVO;
import tc.data.dao.StudentDAO;
import tc.model.Student;
import tc.service.studentService.StudentVOManager;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by stonezhang on 2017/3/1.
 */
@Service("StudentVOManager")
public class StudentVOManagerImpl implements StudentVOManager {
    @Autowired
    private StudentDAO studentDAO;

    @Override
    public StudentInfoVO getStudentVOById(int id) {
        Student student = studentDAO.selectById(id);
        StudentInfoVO studentInfoVO = new StudentInfoVO();
        studentInfoVO.setPassword(student.getPassword());
        studentInfoVO.setName(student.getName());
        studentInfoVO.setBankCard(String.valueOf(student.getBankid()));
        studentInfoVO.setId(id);
        return studentInfoVO;
    }

    @Override
    public StudentInfoVO getStudentVOByName(String name) {
        Student student = studentDAO.selectByName(name);
        StudentInfoVO studentInfoVO = new StudentInfoVO();
        studentInfoVO.setPassword(student.getPassword());
        studentInfoVO.setName(student.getName());
        studentInfoVO.setBankCard(String.valueOf(student.getBankid()));
        studentInfoVO.setId(student.getId());
        return studentInfoVO;
    }

    @Override
    public List<StudentCourseVO> getStudentCourses(int sid) {
        return null;
    }
}
