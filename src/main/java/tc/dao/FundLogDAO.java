package tc.dao;

import tc.model.FundLog;

/**
 * Created by stonezhang on 2017/1/21.
 */
public interface FundLogDAO {
    public FundLog find(int id);

    public void update(FundLog fundLog);

    public void insert(FundLog fundLog);

    public void delete(FundLog fundLog);
}
