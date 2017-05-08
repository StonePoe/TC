package tc.dao;

import tc.model.FinanceCheck;

import java.util.List;

/**
 * Created by stonezhang on 2017/3/16.
 */
public interface FinanceCheckDAO {
    FinanceCheck selectById(int id);

    List<FinanceCheck> selectITS(int mid);

    List<FinanceCheck> selectUncheckedITS(int mid);

    List<FinanceCheck> selectPassedITS(int mid);

    List<FinanceCheck> selectRefusedITS(int mid);

    List<FinanceCheck> selectSTI(int mid);

    List<FinanceCheck> selectUncheckedSTI(int mid);

    List<FinanceCheck> selectPassedSTI(int mid);

    List<FinanceCheck> selectRefusedSTI(int mid);

    List<FinanceCheck> selectStudent(int sid);

    List<FinanceCheck> selectInstitution(int insid);

    void insert(FinanceCheck financeCheck);

    void update(FinanceCheck financeCheck);

}
