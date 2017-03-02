package tc.service.managerService;

/**
 * Created by stonezhang on 2017/1/23.
 */
public interface TCFinance {
    public void mcToInsti();

    public void mcToInsti(int sid, int cid);

    public void mcToInstiAll();

    public void instiToMc();

    public void instiToMc(int sid, int cid);

    public void instiToMcAll();
}
