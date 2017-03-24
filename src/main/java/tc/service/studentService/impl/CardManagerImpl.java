package tc.service.studentService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tc.dao.ActivityLogDAO;
import tc.dao.BankCardDAO;
import tc.dao.MemberCardDAO;
import tc.model.ActivityLog;
import tc.model.Bankcard;
import tc.model.MemberCard;
import tc.service.studentService.CardManager;
import tc.service.tools.BankConnector;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by stonezhang on 2017/3/11.
 */
@Service("CardManager")
public class CardManagerImpl implements CardManager{

    @Autowired
    BankCardDAO bankCardDAO;

    @Autowired
    MemberCardDAO memberCardDAO;

    @Autowired
    private ActivityLogDAO activityLogDAO;

    @Override
    public void insertBankcard(String bankcardId) {
        double money = BankConnector.getBalance(bankcardId);
        bankCardDAO.insert(bankcardId, money);
    }

    @Override
    public boolean active(String bankid, int memberid, int sid) {
        Bankcard bankcard = bankCardDAO.find(bankid);
        MemberCard memberCard = memberCardDAO.find(memberid);
        double bankBalance = bankcard.getBalance();
        double memberBalance = memberCard.getBalance();

        bankcard.setBalance(bankBalance - 1000);
        memberCard.setBalance(memberBalance + 1000);

        memberCard.setState(1);
        memberCard.setLevel(1);

        LocalDate today = LocalDate.now();
        LocalDate suspendDate = today.plusYears(1);
        LocalDate destroyDate = today.plusYears(2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        memberCard.setSuspenddate(suspendDate.format(formatter));
        memberCard.setDestroydate(destroyDate.format(formatter));

        System.out.println("from student member active: " + memberCard);
        bankCardDAO.update(bankcard);
        memberCardDAO.updateActive(memberCard);

//        StudentLog studentLog = new StudentLog();
//        studentLog.setSid(sid);
//        studentLog.setBehavior("active member");
//        studentLogDAO.insert(studentLog);
        ActivityLog activityLog = new ActivityLog();
        activityLog.setSid(sid);
        activityLog.setCid(-1);
        activityLog.setInsid(-1);
        activityLog.setMoney(0);
        activityLog.setBehaviour("active member");
        activityLog.setDescription("");
        activityLog.setType(1);
        activityLogDAO.insert(activityLog);

        return true;
    }

    @Override
    public boolean recharge(String bankId, int memberId, double amount, int sid) {
        Bankcard bankcard = bankCardDAO.find(bankId);

        MemberCard memberCard = memberCardDAO.find(memberId);

        double bankBalance = bankcard.getBalance() - amount;
        if(bankBalance < 0) {

            return false;
        }
        else {
            bankcard.setBalance(bankBalance);
            bankCardDAO.update(bankcard);

            double memberBalance = memberCard.getBalance() + amount;
            memberCard.setBalance(memberBalance);
            LocalDate today = LocalDate.now();
            LocalDate suspendDate = today.plusYears(1);
            LocalDate destroyDate = today.plusYears(2);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            memberCard.setSuspenddate(suspendDate.format(formatter));
            memberCard.setDestroydate(destroyDate.format(formatter));

            memberCardDAO.updateBalance(memberCard);

            ActivityLog activityLog = new ActivityLog();
            activityLog.setSid(sid);
            activityLog.setCid(-1);
            activityLog.setInsid(-1);
            activityLog.setMoney(amount);
            activityLog.setBehaviour("recharge member");
            activityLog.setDescription("");
            activityLog.setType(2);
            activityLogDAO.insert(activityLog);
            return true;
        }

    }

    @Override
    public boolean suspend(int memberId, int sid) {
        MemberCard memberCard = memberCardDAO.find(memberId);
        memberCard.setState(0);
        memberCard.setLevel(0);
        memberCardDAO.updateState(memberCard);

        ActivityLog activityLog = new ActivityLog();
        activityLog.setSid(sid);
        activityLog.setCid(-1);
        activityLog.setInsid(-1);
        activityLog.setMoney(0);
        activityLog.setBehaviour("suspend member");
        activityLog.setDescription("");
        activityLog.setType(1);
        activityLogDAO.insert(activityLog);
        return true;
    }

    @Override
    public boolean destroy(int memberId, int sid) {
        MemberCard memberCard = memberCardDAO.find(memberId);
        memberCard.setState(0);
        memberCard.setLevel(0);
        memberCard.setBalance(0);
        memberCardDAO.updateState(memberCard);

        ActivityLog activityLog = new ActivityLog();
        activityLog.setSid(sid);
        activityLog.setCid(-1);
        activityLog.setInsid(-1);
        activityLog.setMoney(0);
        activityLog.setBehaviour("destroy member");
        activityLog.setDescription("");
        activityLog.setType(1);
        activityLogDAO.insert(activityLog);
        return true;
    }

    @Override
    public boolean hasToSuspend(int sid) {
        return false;
    }

    @Override
    public boolean hasToDestroy(int sid) {
        return false;
    }
}
