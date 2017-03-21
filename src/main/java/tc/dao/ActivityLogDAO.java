package tc.dao;

import tc.model.ActivityLog;

import java.util.List;

/**
 * Created by stonezhang on 2017/3/20.
 */
public interface ActivityLogDAO {
    ActivityLog selectById(int id);

    List<ActivityLog> selectStudentCourse(int sid);

    List<ActivityLog> selectStudentLog(int sid);

    List<ActivityLog> selectStudentOtherConsume(int sid);

    List<ActivityLog> selectInstitutionCourse(int sid);

    List<ActivityLog> selectInstitutionLog(int sid);

    List<ActivityLog> selectInstitutionOtherConsume(int sid);

    void insert(ActivityLog activityLog);
}
