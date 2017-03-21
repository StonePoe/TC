package tc.dao;


import org.apache.ibatis.annotations.Param;
import tc.model.Attending;

import java.util.List;

/**
 * Created by stonezhang on 2017/1/20.
 */
public interface AttendingDAO {
    public Attending selectById(int id);

    public List<Attending> selectBySid(int sid);

    public List<Attending> selectByCid(int cid);

    public Attending selectByBoth(@Param("sid") int sid, @Param("cid") int cid);

    public void updateScore(Attending attending);

    void updateState(Attending attending);

    public void insert(Attending attending);

    public void delete(Attending attending);
}
