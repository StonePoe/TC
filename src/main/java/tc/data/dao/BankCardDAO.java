package tc.data.dao;

import org.apache.ibatis.annotations.Param;
import tc.model.BankCard;

/**
 * Created by stonezhang on 2017/1/20.
 */
public interface BankCardDAO {
    public BankCard find(int id);

    public void update(BankCard bankCard);

    public void insert(@Param("id")int id, @Param("balance") double balance);

    public void delete(int id);
}
