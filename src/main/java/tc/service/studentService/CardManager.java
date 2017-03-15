package tc.service.studentService;

/**
 * Created by stonezhang on 2017/1/23.
 */
public interface CardManager {
    void insertBankcard(String bankcardId);

    public boolean active(String bankid, int memberid);

    public boolean recharge(int sid, double amount);

    public boolean suspend(int sid);

    public boolean destroy(int sid);

    public boolean hasToSuspend(int sid);

    public boolean hasToDestroy(int sid);
}
