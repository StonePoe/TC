package serviceTest.studentTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tc.data.dao.BankCardDAO;
import tc.service.studentService.StudentVerify;

import javax.annotation.Resource;

/**
 * Created by stonezhang on 2017/2/21.
 */

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class StudentVerifyTest {
//    private static Logger logger = Logger.getLogger(StudentVerifyTest.class);
    @Autowired
    private StudentVerify studentVerify = null;
    @Autowired
    private BankCardDAO bankCardDAO = null;

    @Test
    public void testExist() {
        System.out.println("#########test#########");
        studentVerify.existName("abc");
        System.out.println();
    }

//    @Test
//    public void testBankCard() {
//        bankCardDAO.insert(1000000000, 100);
//    }

//    @Test
//    public void testRegister () {
//        System.out.println(studentVerify.register("shifu", "qwer", "123"));
//    }
}
