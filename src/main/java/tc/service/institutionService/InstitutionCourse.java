package tc.service.institutionService;

/**
 * Created by stonezhang on 2017/1/23.
 */
public interface InstitutionCourse {
    public void release(int tid, String description, String startdate, String enddate, double price);

    public void update(int tid, String description, String startdate, String enddate, double price);

    public void setScore(int cid, double score);
}
