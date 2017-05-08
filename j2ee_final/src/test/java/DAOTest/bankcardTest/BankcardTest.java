package DAOTest.bankcardTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tc.dao.BankCardDAO;

/**
 * Created by stonezhang on 2017/3/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class BankcardTest {
    @Autowired
    private BankCardDAO bankCardDAO;

    @Test
    public void testFind() {
        System.out.println(bankCardDAO.findByStudent(10));
    }

    @Test
    public void testInsert() {
        bankCardDAO.insert("111111111111", 10000);
    }
}
