package tc.service.studentService;

/**
 * Created by stonezhang on 2017/1/23.
 */
public interface StudentCurrent {
    public boolean bookWithMC(int cid);

    public boolean bookWithBC(int cid);

    public boolean cancelToMC(int cid);

    public boolean cancelToBC(int cid);

    public boolean quit(int cid);
}
