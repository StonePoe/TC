package tc.service.teacherService;

import tc.bean.TeacherInfoVO;

import java.util.List;

/**
 * Created by stonezhang on 2017/3/14.
 */
public interface TeacherVOManager {
    TeacherInfoVO getTeacherVO(int id);

    List<TeacherInfoVO> getTeacherVOListByName(String name);

    List<TeacherInfoVO> getTeacherVOList();

    void register(String name, String password);
}
