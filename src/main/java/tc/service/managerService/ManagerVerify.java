package tc.service.managerService;

/**
 * Created by stonezhang on 2017/1/23.
 */
public interface ManagerVerify {
    public void register(String name, String password);

    public boolean exist(String name);

    public boolean exist(int id);

    public boolean isCorrectPsw(String name, String password);

    public boolean isCorrectPsw(int id, String password);

    public void update(String name, String password);

    boolean updateName(int id, String name);

    boolean updatePassword(int id, String password);
}
