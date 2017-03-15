package tc.service.teacherService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tc.bean.TeacherInfoVO;
import tc.dao.TeacherDAO;
import tc.model.Teacher;
import tc.service.teacherService.TeacherVOManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stonezhang on 2017/3/14.
 */
@Service("TeacherVOManager")
public class TeacherVOManagerImpl implements TeacherVOManager {
    @Autowired
    private TeacherDAO teacherDAO;

    @Override
    public TeacherInfoVO getTeacherVO(int id) {
        return new TeacherInfoVO(teacherDAO.selectById(id));
    }

    @Override
    public List<TeacherInfoVO> getTeacherVOListByName(String name) {
        List<TeacherInfoVO> result = new ArrayList<>();
        for(Teacher teacher: teacherDAO.selectByName(name)) {
            result.add(new TeacherInfoVO(teacher));
        }
        return result;
    }

    @Override
    public List<TeacherInfoVO> getTeacherVOList() {
        List<TeacherInfoVO> result = new ArrayList<>();
        for (Teacher teacher: teacherDAO.select()) {
            result.add(new TeacherInfoVO(teacher));
        }
        return result;
    }
}
