package com.gpengtao.example.statefull.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 报警
 * <p>
 * Created by pengtao.geng on 2016/11/15.
 */
public class Alarm {

    private String name;

    public Alarm() {

    }

    public Alarm(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
