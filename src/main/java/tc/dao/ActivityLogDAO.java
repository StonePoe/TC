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

    List<ActivityLog> selectCourseFinances();

    List<ActivityLog> selectOtherFinances();

    List<ActivityLog> selectStudentLogs();

    List<ActivityLog> selectInstitutionLogs();

    void insert(ActivityLog activityLog);

    List<ActivityLog> selectStudentFinanceList();

    List<ActivityLog> selectInstitutionFinanceList();

    List<ActivityLog> selectStudentFinance(int sid);

    List<ActivityLog> selectInstitutionFinance(int insid);
}
