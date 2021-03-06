package tc.service.studentService;

import tc.bean.StudentInfoVO;

/**
 * Created by stonezhang on 2017/1/23.
 */
public interface StudentVerify {
    public boolean register(String name, String password, String bankcard);

    public boolean existName(String name);

    public boolean existId(int id);

    public boolean isCorrectPsw(String name, String password);

    public boolean isCorrectPsw(int id, String password);

    public void update(String name, String bankId, String password);

    void updatePassword(int id, String password);

    void updateName(int id, String name);

    void updateBank(int id, String bank);
}
