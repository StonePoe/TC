package serviceTest.institutionTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tc.service.institutionService.InstitutionVOManager;

/**
 * Created by stonezhang on 2017/3/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class InstitutionVOTest {

    @Autowired
    private InstitutionVOManager institutionVOManagerImpl;

    @Test
    public void test() {
        System.out.println(institutionVOManagerImpl.getActiveCourses(0));
    }
}
