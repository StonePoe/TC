package DAOTest.ActivityLogTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tc.dao.ActivityLogDAO;

/**
 * Created by stonezhang on 2017/3/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class ActivityLogTest {
    @Autowired
    private ActivityLogDAO activityLogDAO;

    @Test
    public void test() {
        System.out.println(activityLogDAO.selectInstitutionCourse(3));
    }

}
