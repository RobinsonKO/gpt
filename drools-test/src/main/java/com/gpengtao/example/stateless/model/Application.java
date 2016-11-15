package com.gpengtao.example.stateless.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 申请
 * <p>
 * Created by pengtao.geng on 2016/11/15.
 */
public class Application {

    private Date applyDate;

    private boolean applyDateValid;

    private boolean ageValid;

    public Application(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public boolean isAgeValid() {
        return ageValid;
    }

    public void setAgeValid(boolean ageValid) {
        this.ageValid = ageValid;
    }

    public boolean isApplyDateValid() {
        return applyDateValid;
    }

    public void setApplyDateValid(boolean applyDateValid) {
        this.applyDateValid = applyDateValid;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
