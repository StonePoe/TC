package controllerTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tc.service.studentService.StudentVOManager;

/**
 * Created by stonezhang on 2017/3/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class StudentVOTest {
    @Autowired
    private StudentVOManager studentVOManager;

    @Test
    public void testCourse() {
//        System.out.println(studentVOManager.getCourses(3));
    }
}
