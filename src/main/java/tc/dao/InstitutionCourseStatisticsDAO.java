package tc.dao;

import tc.model.InstitutionCourseStatistics;

import java.util.List;

/**
 * Created by stonezhang on 2017/3/25.
 */
public interface InstitutionCourseStatisticsDAO {
    List<InstitutionCourseStatistics> selectAll();

    List<InstitutionCourseStatistics> selectByInsti(int insid);
}
