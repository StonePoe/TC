package tc.service.fieldService;

import tc.bean.CourseFieldVO;

import java.util.List;

/**
 * Created by stonezhang on 2017/3/14.
 */
public interface CourseFieldVOManager {
    List<CourseFieldVO> getCourseFieldList();
    CourseFieldVO getCourseFieldVO(int id);
    CourseFieldVO getCourseFieldVO(String type);
}
