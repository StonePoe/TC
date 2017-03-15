package tc.service.institutionService;

/**
 * Created by stonezhang on 2017/1/23.
 */
public interface InstitutionVerify {
    public boolean register(String name, String password);

    public boolean existName(String name);

    public boolean existId(int id);

    public boolean isCorrectPsw(String name, String password);

    public boolean isCorrectPsw(int id, String password);

    public void update(String name, String bankId, String password);

    void updatePassword(int id, String password);
}
