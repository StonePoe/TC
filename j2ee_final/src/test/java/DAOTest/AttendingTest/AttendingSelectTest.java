package DAOTest.AttendingTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tc.dao.AttendingDAO;

/**
 * Created by stonezhang on 2017/3/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class AttendingSelectTest {
    @Autowired
    private AttendingDAO attendingDAO;

    @Test
    public void testSelect() {
        System.out.println(attendingDAO.selectBySid(3));
    }

}
