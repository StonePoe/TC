package tc.service.managerService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tc.dao.ManagerDAO;
import tc.model.Manager;
import tc.service.managerService.ManagerVerify;

/**
 * Created by stonezhang on 2017/3/15.
 */
@Service("ManagerVerify")
public class ManagerVerifyImpl implements ManagerVerify {

    @Autowired
    private ManagerDAO managerDAO;

    @Override
    public void register(String name, String password) {
        Manager manager = new Manager();
        manager.setName(name);
        manager.setPassword(password);
        manager.setImgUrl("/img/manager/default.png");
        managerDAO.insert(manager);
    }

    @Override
    public boolean exist(String name) {
        if(managerDAO.selectByName(name) != null) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean exist(int id) {
        if(managerDAO.selectById(id) != null) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean isCorrectPsw(String name, String password) {
        if(managerDAO.selectByName(name).getPassword().equals(password)) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean isCorrectPsw(int id, String password) {
        if(managerDAO.selectById(id).getPassword().equals(password)) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void update(String name, String password) {

    }

    @Override
    public boolean updateName(int id, String name) {
        if(exist(name)) {
            return false;
        }
        else {
            Manager manager = new Manager();
            manager.setId(id);
            manager.setName(name);
            managerDAO.updateName(manager);
            return true;
        }
    }

    @Override
    public boolean updatePassword(int id, String password) {
        Manager manager = new Manager();
        manager.setId(id);
        manager.setPassword(password);
        managerDAO.updatePassword(manager);
        return true;
    }
}
