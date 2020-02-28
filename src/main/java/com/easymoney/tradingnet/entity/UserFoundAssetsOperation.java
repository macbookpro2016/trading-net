package com.easymoney.tradingnet.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UserFoundAssetsOperation implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_found_assets_operation.id
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_found_assets_operation.user_id
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_found_assets_operation.found_code
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    private String foundCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_found_assets_operation.found_name
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    private String foundName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_found_assets_operation.operate_type
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    private String operateType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_found_assets_operation.count
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    private Integer count;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_found_assets_operation.price
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    private BigDecimal price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_found_assets_operation.create_time
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_found_assets_operation
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_found_assets_operation
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    public UserFoundAssetsOperation(Integer id, Integer userId, String foundCode, String foundName, String operateType, Integer count, BigDecimal price, Date createTime) {
        this.id = id;
        this.userId = userId;
        this.foundCode = foundCode;
        this.foundName = foundName;
        this.operateType = operateType;
        this.count = count;
        this.price = price;
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_found_assets_operation
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    public UserFoundAssetsOperation() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_found_assets_operation.id
     *
     * @return the value of user_found_assets_operation.id
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_found_assets_operation.id
     *
     * @param id the value for user_found_assets_operation.id
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_found_assets_operation.user_id
     *
     * @return the value of user_found_assets_operation.user_id
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_found_assets_operation.user_id
     *
     * @param userId the value for user_found_assets_operation.user_id
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_found_assets_operation.found_code
     *
     * @return the value of user_found_assets_operation.found_code
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    public String getFoundCode() {
        return foundCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_found_assets_operation.found_code
     *
     * @param foundCode the value for user_found_assets_operation.found_code
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    public void setFoundCode(String foundCode) {
        this.foundCode = foundCode == null ? null : foundCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_found_assets_operation.found_name
     *
     * @return the value of user_found_assets_operation.found_name
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    public String getFoundName() {
        return foundName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_found_assets_operation.found_name
     *
     * @param foundName the value for user_found_assets_operation.found_name
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    public void setFoundName(String foundName) {
        this.foundName = foundName == null ? null : foundName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_found_assets_operation.operate_type
     *
     * @return the value of user_found_assets_operation.operate_type
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    public String getOperateType() {
        return operateType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_found_assets_operation.operate_type
     *
     * @param operateType the value for user_found_assets_operation.operate_type
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    public void setOperateType(String operateType) {
        this.operateType = operateType == null ? null : operateType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_found_assets_operation.count
     *
     * @return the value of user_found_assets_operation.count
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    public Integer getCount() {
        return count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_found_assets_operation.count
     *
     * @param count the value for user_found_assets_operation.count
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_found_assets_operation.price
     *
     * @return the value of user_found_assets_operation.price
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_found_assets_operation.price
     *
     * @param price the value for user_found_assets_operation.price
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_found_assets_operation.create_time
     *
     * @return the value of user_found_assets_operation.create_time
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_found_assets_operation.create_time
     *
     * @param createTime the value for user_found_assets_operation.create_time
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_found_assets_operation
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", foundCode=").append(foundCode);
        sb.append(", foundName=").append(foundName);
        sb.append(", operateType=").append(operateType);
        sb.append(", count=").append(count);
        sb.append(", price=").append(price);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_found_assets_operation
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UserFoundAssetsOperation other = (UserFoundAssetsOperation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getFoundCode() == null ? other.getFoundCode() == null : this.getFoundCode().equals(other.getFoundCode()))
            && (this.getFoundName() == null ? other.getFoundName() == null : this.getFoundName().equals(other.getFoundName()))
            && (this.getOperateType() == null ? other.getOperateType() == null : this.getOperateType().equals(other.getOperateType()))
            && (this.getCount() == null ? other.getCount() == null : this.getCount().equals(other.getCount()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_found_assets_operation
     *
     * @mbg.generated Fri Feb 28 00:55:08 CST 2020
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getFoundCode() == null) ? 0 : getFoundCode().hashCode());
        result = prime * result + ((getFoundName() == null) ? 0 : getFoundName().hashCode());
        result = prime * result + ((getOperateType() == null) ? 0 : getOperateType().hashCode());
        result = prime * result + ((getCount() == null) ? 0 : getCount().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}