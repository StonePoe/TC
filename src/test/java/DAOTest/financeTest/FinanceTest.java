package DAOTest.financeTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tc.dao.CourseDAO;
import tc.dao.FinanceCheckDAO;

/**
 * Created by stonezhang on 2017/3/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class FinanceTest {
    @Autowired
    private FinanceCheckDAO financeCheckDAO;

    @Test
    public void testSelect() {
        System.out.println(financeCheckDAO.selectSTI(1));
    }
}
