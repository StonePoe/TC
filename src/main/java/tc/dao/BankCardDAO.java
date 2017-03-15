package tc.dao;

import org.apache.ibatis.annotations.Param;
import tc.model.Bankcard;

/**
 * Created by stonezhang on 2017/1/20.
 */
public interface BankCardDAO {
    public Bankcard find(@Param("id")String id);

    Bankcard findByStudent(int sid);

    public void update(Bankcard bankCard);

    public void insert(@Param("id")String id, @Param("balance") double balance);

    public void delete(String id);
}
