package tc.service.institutionService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tc.dao.ActivityLogDAO;
import tc.dao.InstitutionDAO;
import tc.model.ActivityLog;
import tc.model.Institution;
import tc.service.institutionService.InstitutionVerify;

/**
 * Created by stonezhang on 2017/3/13.
 */
@Service("InstitutionVerify")
public class InstitutionVerifyImpl implements InstitutionVerify {

    @Autowired
    private InstitutionDAO institutionDAO;

    @Autowired
    private ActivityLogDAO activityLogDAO;

    @Override
    public boolean register(String name, String password) {
        Institution institution = new Institution();
        institution.setName(name);
        institution.setPassword(password);
        institution.setBalance(0);
        institution.setImgUrl("/institution/default.png");
        institution.setField(4);

        if (existName(name)) {

            return false;
        }
        else {

            institutionDAO.insert(institution);

            ActivityLog activityLog = new ActivityLog();
            activityLog.setType(3);
            activityLog.setBehaviour("register");
            activityLogDAO.insert(activityLog);
            return true;
        }
    }

    @Override
    public boolean existName(String name) {
        if(institutionDAO.selectByName(name) != null) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean existId(int id) {
        if(institutionDAO.selectById(id) != null) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean isCorrectPsw(String name, String password) {
        if(institutionDAO.selectByName(name).getPassword().equals(password)) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean isCorrectPsw(int id, String password) {
        if(institutionDAO.selectById(id).getPassword().equals(password)) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void update(String name, String bankId, String password) {

    }

    @Override
    public void updatePassword(int id, String password) {
        Institution institution = new Institution();
        institution.setId(id);
        institution.setPassword(password);
        institutionDAO.updatePassword(institution);
    }

    @Override
    public void updateName(int id, String name) {
        Institution institution = new Institution();
        institution.setId(id);
        institution.setName(name);
        institutionDAO.updateName(institution);

    }
}
