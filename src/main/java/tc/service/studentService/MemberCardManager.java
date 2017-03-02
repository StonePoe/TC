package tc.service.studentService;

/**
 * Created by stonezhang on 2017/1/23.
 */
public interface MemberCardManager {
    public boolean active(int sid);

    public boolean recharge(int sid, double amount);

    public boolean suspend(int sid);

    public boolean destroy(int sid);

    public boolean hasToSuspend(int sid);

    public boolean hasToDestroy(int sid);
}
