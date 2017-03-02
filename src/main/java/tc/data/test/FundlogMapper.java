package tc.data.test;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tc.data.test.Fundlog;
import tc.data.test.FundlogExample;

public interface FundlogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fundlog
     *
     * @mbggenerated Sat Feb 25 15:12:43 CST 2017
     */
    int countByExample(FundlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fundlog
     *
     * @mbggenerated Sat Feb 25 15:12:43 CST 2017
     */
    int deleteByExample(FundlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fundlog
     *
     * @mbggenerated Sat Feb 25 15:12:43 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fundlog
     *
     * @mbggenerated Sat Feb 25 15:12:43 CST 2017
     */
    int insert(Fundlog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fundlog
     *
     * @mbggenerated Sat Feb 25 15:12:43 CST 2017
     */
    int insertSelective(Fundlog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fundlog
     *
     * @mbggenerated Sat Feb 25 15:12:43 CST 2017
     */
    List<Fundlog> selectByExample(FundlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fundlog
     *
     * @mbggenerated Sat Feb 25 15:12:43 CST 2017
     */
    Fundlog selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fundlog
     *
     * @mbggenerated Sat Feb 25 15:12:43 CST 2017
     */
    int updateByExampleSelective(@Param("record") Fundlog record, @Param("example") FundlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fundlog
     *
     * @mbggenerated Sat Feb 25 15:12:43 CST 2017
     */
    int updateByExample(@Param("record") Fundlog record, @Param("example") FundlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fundlog
     *
     * @mbggenerated Sat Feb 25 15:12:43 CST 2017
     */
    int updateByPrimaryKeySelective(Fundlog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fundlog
     *
     * @mbggenerated Sat Feb 25 15:12:43 CST 2017
     */
    int updateByPrimaryKey(Fundlog record);
}