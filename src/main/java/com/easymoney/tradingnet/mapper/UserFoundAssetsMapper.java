package com.easymoney.tradingnet.mapper;

import com.easymoney.tradingnet.entity.UserFoundAssets;
import com.easymoney.tradingnet.entity.UserFoundAssetsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserFoundAssetsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_found_assets
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    long countByExample(UserFoundAssetsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_found_assets
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    int deleteByExample(UserFoundAssetsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_found_assets
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_found_assets
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    int insert(UserFoundAssets record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_found_assets
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    int insertSelective(UserFoundAssets record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_found_assets
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    List<UserFoundAssets> selectByExampleWithRowbounds(UserFoundAssetsExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_found_assets
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    List<UserFoundAssets> selectByExample(UserFoundAssetsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_found_assets
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    UserFoundAssets selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_found_assets
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    int updateByExampleSelective(@Param("record") UserFoundAssets record, @Param("example") UserFoundAssetsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_found_assets
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    int updateByExample(@Param("record") UserFoundAssets record, @Param("example") UserFoundAssetsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_found_assets
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    int updateByPrimaryKeySelective(UserFoundAssets record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_found_assets
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    int updateByPrimaryKey(UserFoundAssets record);
}