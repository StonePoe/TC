package tc.service.fieldService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tc.bean.CourseFieldVO;
import tc.dao.CourseFieldDAO;
import tc.model.CourseField;
import tc.service.fieldService.CourseFieldVOManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stonezhang on 2017/3/14.
 */
@Service("CourseFieldVOManager")
public class CourseFieldVOManagerImpl implements CourseFieldVOManager{
    @Autowired
    private CourseFieldDAO courseFieldDAO;

    @Override
    public List<CourseFieldVO> getCourseFieldList() {
        List<CourseFieldVO> result = new ArrayList<>();
        for(CourseField courseField: courseFieldDAO.select()) {
            result.add(new CourseFieldVO(courseField));
        }
        return result;
    }

    @Override
    public CourseFieldVO getCourseFieldVO(int id) {
        return new CourseFieldVO(courseFieldDAO.selectById(id));
    }

    @Override
    public CourseFieldVO getCourseFieldVO(String type) {
        return new CourseFieldVO(courseFieldDAO.selectByName(type));
    }
}
