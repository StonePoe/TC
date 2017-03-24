package tc.trigger;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import tc.bean.StudentInfoVO;
import tc.dao.MemberCardDAO;
import tc.dao.StudentDAO;
import tc.model.MemberCard;
import tc.service.studentService.CardManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * Created by stonezhang on 2017/3/20.
 */
public class CheckMember {
    @Autowired
    private MemberCardDAO memberCardDAO;

    @Autowired
    private CardManager cardManager;

    public boolean doCheck() {
        List<MemberCard> memberCardList = memberCardDAO.selectAllActive();
        LocalDate now = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String nowTimeStr = now.format(format);
        for(MemberCard memberCard: memberCardList) {
            if(nowTimeStr.equals(memberCard.getDestroydate())) {
                cardManager.destroy(memberCard.getId(), memberCard.getSid());
            }
            else if(nowTimeStr.equals(memberCard.getSuspenddate())) {
                cardManager.suspend(memberCard.getId(), memberCard.getSid());
            }
        }
        return true;
    }
}
