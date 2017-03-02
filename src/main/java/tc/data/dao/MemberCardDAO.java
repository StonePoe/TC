package tc.data.dao;

import tc.model.MemberCard;

/**
 * Created by stonezhang on 2017/1/22.
 */
public interface MemberCardDAO {
    public MemberCard find(int id);

    public void update(MemberCard memberCard);

    public void insert(MemberCard memberCard);

    public void delete(int id);
}
