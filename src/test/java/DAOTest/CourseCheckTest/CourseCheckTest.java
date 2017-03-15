package DAOTest.CourseCheckTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tc.dao.CourseCheckDAO;

/**
 * Created by stonezhang on 2017/3/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class CourseCheckTest {
    @Autowired
    private CourseCheckDAO courseCheckDAO;

    @Test
    public void testFind() {
        System.out.println(courseCheckDAO.selectByInsti(3));
    }
}
