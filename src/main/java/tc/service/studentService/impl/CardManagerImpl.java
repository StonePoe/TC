package tc.service.studentService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tc.dao.BankCardDAO;
import tc.dao.MemberCardDAO;
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

    @Override
    public void insertBankcard(String bankcardId) {
        double money = BankConnector.getBalance(bankcardId);
        bankCardDAO.insert(bankcardId, money);
    }

    @Override
    public boolean active(String bankid, int memberid) {
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
        memberCardDAO.update(memberCard);

        return true;
    }

    @Override
    public boolean recharge(int sid, double amount) {
        return false;
    }

    @Override
    public boolean suspend(int sid) {
        return false;
    }

    @Override
    public boolean destroy(int sid) {
        return false;
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
