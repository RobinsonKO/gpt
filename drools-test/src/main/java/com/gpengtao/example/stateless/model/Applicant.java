package com.gpengtao.example.stateless.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * driving license application
 * <p>
 * Created by pengtao.geng on 2016/11/15.
 */
public class Applicant {

    private String name;

    private int age;

    private boolean validAge;

    public Applicant(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isValidAge() {
        return validAge;
    }

    public void setValidAge(boolean validAge) {
        this.validAge = validAge;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
