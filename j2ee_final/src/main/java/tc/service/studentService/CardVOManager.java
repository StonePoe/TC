package tc.service.studentService;

import tc.bean.BankcardVO;
import tc.bean.MemberCardVO;
import tc.model.MemberCard;

/**
 * Created by stonezhang on 2017/3/12.
 */
public interface CardVOManager {
    BankcardVO getBankcardVO(int sid);

    MemberCardVO getMemberCardVO(int sid);
}
