package tc.service.studentService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tc.bean.StudentInfoVO;
import tc.dao.ActivityLogDAO;
import tc.dao.BankCardDAO;
import tc.dao.MemberCardDAO;
import tc.dao.StudentDAO;
import tc.model.ActivityLog;
import tc.model.Bankcard;
import tc.model.MemberCard;
import tc.model.Student;
import tc.service.studentService.StudentVerify;
import tc.service.tools.BankConnector;

import javax.annotation.Resource;

/**
 * Created by stonezhang on 2017/2/21.
 */
@Service("StudentVerify")
public class StudentVerifyImpl implements StudentVerify {

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private BankCardDAO bankCardDAO;

    @Autowired
    private MemberCardDAO memberCardDAO;

    @Autowired
    private ActivityLogDAO activityLogDAO;

    @Override
    public boolean register(String name, String password, String bankid) {
        Bankcard bankcard = new Bankcard();
        bankcard.setId(bankid);
        double balance = BankConnector.getBalance(bankid);
        System.out.println("from student register: " + bankcard);
        bankCardDAO.insert(bankid, balance);

        MemberCard memberCard = new MemberCard();
        memberCard.setBalance(0);
        memberCard.setLevel(0);
        // 0 for unused;
        memberCard.setState(0);
        memberCard.setBankid(bankid);
        memberCardDAO.insert(memberCard);
        int memberId = memberCard.getId();

        Student student = new Student();
        student.setName(name);
        student.setPassword(password);
        student.setBankid(bankid);
        student.setMemberid(memberId);
        student.setImgUrl("/img/student/default.png");
        if (!existName(name)) {

            studentDAO.insert(student);

            ActivityLog activityLog = new ActivityLog();
            activityLog.setType(1);
            activityLog.setBehaviour("register");
            activityLog.setSid(student.getId());
            activityLogDAO.insert(activityLog);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean existName(String name) {
        Student student = studentDAO.selectByName(name);
        System.out.println("existName:" + name);
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
        System.out.println("exist id: " + id);
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
        System.out.println("is correct pw:" + name + " " + password);
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
        System.out.println("is correct pw:" + id + " " + password);
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

    @Override
    public void updatePassword(int id, String password) {
        studentDAO.updatePassword(id, password);
    }

    @Override
    public void updateName(int id, String name) {
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        studentDAO.updateName(student);
    }

    @Override
    public void updateBank(int id, String bank) {
        Student student = new Student();
        student.setId(id);
        student.setBankid(bank);
        studentDAO.updateBank(student);
    }
}
