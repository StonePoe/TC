package tc.dao;

import tc.model.MemberCard;

/**
 * Created by stonezhang on 2017/1/22.
 */
public interface MemberCardDAO {
    public MemberCard find(int id);

    MemberCard findByStudent(int sid);

    public void update(MemberCard memberCard);

    public int insert(MemberCard memberCard);

    public void delete(int id);
}
