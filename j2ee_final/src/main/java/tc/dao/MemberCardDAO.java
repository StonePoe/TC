package tc.dao;

import tc.model.MemberCard;

import java.util.List;

/**
 * Created by stonezhang on 2017/1/22.
 */
public interface MemberCardDAO {
    public MemberCard find(int id);

    MemberCard findByStudent(int sid);

    public void updateBalance(MemberCard memberCard);

    void updateReActive(MemberCard memberCard);

    void updateActive(MemberCard memberCard);

    void updateState(MemberCard memberCard);

    public int insert(MemberCard memberCard);

    public void delete(int id);

    List<MemberCard> selectAllActive();
}
