package DAOTest.MemberCardTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tc.dao.MemberCardDAO;
import tc.model.MemberCard;

/**
 * Created by stonezhang on 2017/3/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class MemberDAOTest {
    @Autowired
    private MemberCardDAO memberCardDAO;

    @Test
    public void testInsert() {
        MemberCard memberCard = new MemberCard();
        memberCard.setBalance(100);
        memberCardDAO.insert(memberCard);
        System.out.println(memberCard.getId());
    }

    @Test
    public void testFind() {
        System.out.println(memberCardDAO.findByStudent(10));
    }
}
