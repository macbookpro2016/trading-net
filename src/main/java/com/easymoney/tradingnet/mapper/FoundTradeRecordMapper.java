package com.easymoney.tradingnet.mapper;

import com.easymoney.tradingnet.entity.FoundTradeRecord;
import com.easymoney.tradingnet.entity.FoundTradeRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface FoundTradeRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table found_trade_record
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    long countByExample(FoundTradeRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table found_trade_record
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    int deleteByExample(FoundTradeRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table found_trade_record
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table found_trade_record
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    int insert(FoundTradeRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table found_trade_record
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    int insertSelective(FoundTradeRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table found_trade_record
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    List<FoundTradeRecord> selectByExampleWithRowbounds(FoundTradeRecordExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table found_trade_record
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    List<FoundTradeRecord> selectByExample(FoundTradeRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table found_trade_record
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    FoundTradeRecord selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table found_trade_record
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    int updateByExampleSelective(@Param("record") FoundTradeRecord record, @Param("example") FoundTradeRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table found_trade_record
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    int updateByExample(@Param("record") FoundTradeRecord record, @Param("example") FoundTradeRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table found_trade_record
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    int updateByPrimaryKeySelective(FoundTradeRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table found_trade_record
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    int updateByPrimaryKey(FoundTradeRecord record);
}