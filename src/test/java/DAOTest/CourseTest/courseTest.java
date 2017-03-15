package DAOTest.CourseTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tc.dao.CourseDAO;
import tc.model.Course;

/**
 * Created by stonezhang on 2017/3/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class courseTest {
    @Autowired
    private CourseDAO courseDAO = null;

    @Test
    public void testCourse() {
        System.out.println("#########test#########");
//        System.out.println(courseDAO.selectById(1));
        System.out.println(courseDAO.selectByStudent(9));
        System.out.println(courseDAO.selectInstiCheckingCourse(3));
    }

    @Test
    public void testInsert() {
        Course course = new Course();
        course.setTid(1);
        course.setInsid(1);
        course.setName("testCourse3");
        course.setAgree(1);
        course.setDescription("this is a short description; /n " +
                "bearing this meanings that this course is inserted from the test class");
        course.setPrice(123.0);
        course.setStartdate("2016-11-11");
        course.setEnddate("2017-02-02");
        courseDAO.insert(course);
    }

}
