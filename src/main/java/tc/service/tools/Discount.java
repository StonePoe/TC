package tc.service.tools;

import tc.model.Course;
import tc.model.Student;

/**
 * Created by stonezhang on 2017/3/16.
 */
public class Discount {
    public static double calculateQuitMoney(int level, double price) {
        if(level >= 1) {
            return price * (1 - 1.0 / (2.0*level));
        }
        else {
            return price / 2;
        }
    }

    public static double calculateEnrollMoney(int level, double price) {
        if(level >= 1) {
            return price * (0.8 + 0.2 / level);
        }
        else {
            return price;
        }
    }

    public static boolean canUpdate(Student student) {
        if(student.getExp() >= student.getLevel()*2500) {
            return true;
        }
        else {
            return false;
        }
    }
}
