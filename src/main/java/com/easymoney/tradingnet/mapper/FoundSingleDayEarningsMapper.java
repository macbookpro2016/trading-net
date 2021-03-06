package com.easymoney.tradingnet.mapper;

import com.easymoney.tradingnet.entity.FoundSingleDayEarnings;
import com.easymoney.tradingnet.entity.FoundSingleDayEarningsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface FoundSingleDayEarningsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table found_single_day_earnings
     *
     * @mbg.generated Fri Feb 28 00:43:16 CST 2020
     */
    long countByExample(FoundSingleDayEarningsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table found_single_day_earnings
     *
     * @mbg.generated Fri Feb 28 00:43:16 CST 2020
     */
    int deleteByExample(FoundSingleDayEarningsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table found_single_day_earnings
     *
     * @mbg.generated Fri Feb 28 00:43:16 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table found_single_day_earnings
     *
     * @mbg.generated Fri Feb 28 00:43:16 CST 2020
     */
    int insert(FoundSingleDayEarnings record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table found_single_day_earnings
     *
     * @mbg.generated Fri Feb 28 00:43:16 CST 2020
     */
    int insertSelective(FoundSingleDayEarnings record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table found_single_day_earnings
     *
     * @mbg.generated Fri Feb 28 00:43:16 CST 2020
     */
    List<FoundSingleDayEarnings> selectByExampleWithRowbounds(FoundSingleDayEarningsExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table found_single_day_earnings
     *
     * @mbg.generated Fri Feb 28 00:43:16 CST 2020
     */
    List<FoundSingleDayEarnings> selectByExample(FoundSingleDayEarningsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table found_single_day_earnings
     *
     * @mbg.generated Fri Feb 28 00:43:16 CST 2020
     */
    FoundSingleDayEarnings selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table found_single_day_earnings
     *
     * @mbg.generated Fri Feb 28 00:43:16 CST 2020
     */
    int updateByExampleSelective(@Param("record") FoundSingleDayEarnings record, @Param("example") FoundSingleDayEarningsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table found_single_day_earnings
     *
     * @mbg.generated Fri Feb 28 00:43:16 CST 2020
     */
    int updateByExample(@Param("record") FoundSingleDayEarnings record, @Param("example") FoundSingleDayEarningsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table found_single_day_earnings
     *
     * @mbg.generated Fri Feb 28 00:43:16 CST 2020
     */
    int updateByPrimaryKeySelective(FoundSingleDayEarnings record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table found_single_day_earnings
     *
     * @mbg.generated Fri Feb 28 00:43:16 CST 2020
     */
    int updateByPrimaryKey(FoundSingleDayEarnings record);
}