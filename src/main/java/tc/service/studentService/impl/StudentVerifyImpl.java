package tc.service.studentService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tc.data.dao.BankCardDAO;
import tc.data.dao.StudentDAO;
import tc.model.BankCard;
import tc.model.Student;
import tc.service.studentService.StudentVerify;
import tc.service.tools.BankConnector;

import javax.annotation.Resource;

/**
 * Created by stonezhang on 2017/2/21.
 */
@Service("StudentVerify")
public class StudentVerifyImpl implements StudentVerify {

    @Resource
    private StudentDAO studentDAO;

    @Resource
    private BankCardDAO bankCardDAO;

    @Override
    public boolean register(String name, String password, String bankcard) {
        BankCard bankCard = new BankCard();
        bankCard.setId(Integer.parseInt(bankcard));
        double balance = BankConnector.getBalance(bankCard);
        bankCardDAO.insert(Integer.parseInt(bankcard), balance);

        Student student = new Student();
        student.setName(name);
        student.setPassword(password);
        student.setBankid(Long.parseLong(bankcard));
        if (!existName(name)) {
            studentDAO.insert(student);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean existName(String name) {
        Student student = studentDAO.selectByName(name);
        System.out.println(student);
        if (student == null) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public boolean existId(int id) {
        Student student = studentDAO.selectById(id);
        System.out.println(student);
        if (student == null) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public boolean isCorrectPsw(String name, String password) {
        Student student = studentDAO.selectByName(name);
        System.out.println(student);
        if (student.getPassword().equals(password)) {
            return true;
        }
        else  {
            return false;
        }
    }

    @Override
    public boolean isCorrectPsw(int id, String password) {
        Student student = studentDAO.selectById(id);
        System.out.println(student);
        if (student.getPassword().equals(password)) {
            return true;
        }
        else  {
            return false;
        }
    }

    @Override
    public void update(String name, String bankId, String password) {

    }

}
