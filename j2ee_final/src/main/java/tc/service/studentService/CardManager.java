package tc.service.studentService;

/**
 * Created by stonezhang on 2017/1/23.
 */
public interface CardManager {
    void insertBankcard(String bankcardId);

    public boolean active(String bankid, int memberid, int sid);

    public boolean recharge(String bankId, int membeId, double amount, int sid);

    public boolean suspend(int memberId, int sid);

    public boolean destroy(int memberId, int sid);

    public boolean hasToSuspend(int memberId);

    public boolean hasToDestroy(int memberId);
}
