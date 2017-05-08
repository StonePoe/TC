package tc.service.studentService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tc.bean.BankcardVO;
import tc.bean.MemberCardVO;
import tc.dao.BankCardDAO;
import tc.dao.MemberCardDAO;
import tc.model.MemberCard;
import tc.service.studentService.CardVOManager;

/**
 * Created by stonezhang on 2017/3/12.
 */
@Service("CardVOManager")
public class CardVOManagerImpl implements CardVOManager {

    @Autowired
    private BankCardDAO bankCardDAO;

    @Autowired
    private MemberCardDAO memberCardDAO;

    @Override
    public BankcardVO getBankcardVO(int sid) {
        return new BankcardVO(bankCardDAO.findByStudent(sid));
    }

    @Override
    public MemberCardVO getMemberCardVO(int sid) {
        return new MemberCardVO(memberCardDAO.findByStudent(sid));
    }
}
