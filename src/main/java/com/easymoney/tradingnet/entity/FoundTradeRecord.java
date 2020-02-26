package com.easymoney.tradingnet.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FoundTradeRecord implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column found_trade_record.id
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column found_trade_record.user_id
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column found_trade_record.found_code
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    private String foundCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column found_trade_record.operation
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    private Boolean operation;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column found_trade_record.trade_count
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    private Integer tradeCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column found_trade_record.trade_price
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    private BigDecimal tradePrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column found_trade_record.trade_time
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    private Date tradeTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table found_trade_record
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table found_trade_record
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    public FoundTradeRecord(Long id, Long userId, String foundCode, Boolean operation, Integer tradeCount, BigDecimal tradePrice, Date tradeTime) {
        this.id = id;
        this.userId = userId;
        this.foundCode = foundCode;
        this.operation = operation;
        this.tradeCount = tradeCount;
        this.tradePrice = tradePrice;
        this.tradeTime = tradeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table found_trade_record
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    public FoundTradeRecord() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column found_trade_record.id
     *
     * @return the value of found_trade_record.id
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column found_trade_record.id
     *
     * @param id the value for found_trade_record.id
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column found_trade_record.user_id
     *
     * @return the value of found_trade_record.user_id
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column found_trade_record.user_id
     *
     * @param userId the value for found_trade_record.user_id
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column found_trade_record.found_code
     *
     * @return the value of found_trade_record.found_code
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    public String getFoundCode() {
        return foundCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column found_trade_record.found_code
     *
     * @param foundCode the value for found_trade_record.found_code
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    public void setFoundCode(String foundCode) {
        this.foundCode = foundCode == null ? null : foundCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column found_trade_record.operation
     *
     * @return the value of found_trade_record.operation
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    public Boolean getOperation() {
        return operation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column found_trade_record.operation
     *
     * @param operation the value for found_trade_record.operation
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    public void setOperation(Boolean operation) {
        this.operation = operation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column found_trade_record.trade_count
     *
     * @return the value of found_trade_record.trade_count
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    public Integer getTradeCount() {
        return tradeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column found_trade_record.trade_count
     *
     * @param tradeCount the value for found_trade_record.trade_count
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    public void setTradeCount(Integer tradeCount) {
        this.tradeCount = tradeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column found_trade_record.trade_price
     *
     * @return the value of found_trade_record.trade_price
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    public BigDecimal getTradePrice() {
        return tradePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column found_trade_record.trade_price
     *
     * @param tradePrice the value for found_trade_record.trade_price
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    public void setTradePrice(BigDecimal tradePrice) {
        this.tradePrice = tradePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column found_trade_record.trade_time
     *
     * @return the value of found_trade_record.trade_time
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    public Date getTradeTime() {
        return tradeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column found_trade_record.trade_time
     *
     * @param tradeTime the value for found_trade_record.trade_time
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table found_trade_record
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
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
        sb.append(", operation=").append(operation);
        sb.append(", tradeCount=").append(tradeCount);
        sb.append(", tradePrice=").append(tradePrice);
        sb.append(", tradeTime=").append(tradeTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table found_trade_record
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
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
        FoundTradeRecord other = (FoundTradeRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getFoundCode() == null ? other.getFoundCode() == null : this.getFoundCode().equals(other.getFoundCode()))
            && (this.getOperation() == null ? other.getOperation() == null : this.getOperation().equals(other.getOperation()))
            && (this.getTradeCount() == null ? other.getTradeCount() == null : this.getTradeCount().equals(other.getTradeCount()))
            && (this.getTradePrice() == null ? other.getTradePrice() == null : this.getTradePrice().equals(other.getTradePrice()))
            && (this.getTradeTime() == null ? other.getTradeTime() == null : this.getTradeTime().equals(other.getTradeTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table found_trade_record
     *
     * @mbg.generated Wed Feb 26 15:31:50 CST 2020
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getFoundCode() == null) ? 0 : getFoundCode().hashCode());
        result = prime * result + ((getOperation() == null) ? 0 : getOperation().hashCode());
        result = prime * result + ((getTradeCount() == null) ? 0 : getTradeCount().hashCode());
        result = prime * result + ((getTradePrice() == null) ? 0 : getTradePrice().hashCode());
        result = prime * result + ((getTradeTime() == null) ? 0 : getTradeTime().hashCode());
        return result;
    }
}