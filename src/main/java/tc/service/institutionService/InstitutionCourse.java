package tc.service.institutionService;

/**
 * Created by stonezhang on 2017/1/23.
 */
public interface InstitutionCourse {
//    String name = request.getParameter("name");
//    int tid = Integer.parseInt(request.getParameter("tid"));
//    double price = Double.parseDouble(request.getParameter("price"));
//    String startdate = request.getParameter("startdate");
//    String enddate = request.getParameter("enddate");
//    int field = Integer.parseInt(request.getParameter("field"));
//    String imgUrl = request.getParameter("imgUrl");
//    int insid = Integer.parseInt(request.getParameter("insid"));
//    String description = request.getParameter("description");
//    int agree = 0;

    public void release(String name, int tid, double price, String startdate, String enddate, int field,
                        String imgUrl, int insid, String description, int agree);

    public void update(int cid, String description, double price, String name);

    public void setScore(int sic, int cid, double score);
}
