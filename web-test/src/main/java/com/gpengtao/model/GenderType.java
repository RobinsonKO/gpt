package com.gpengtao.model;

/**
 * Created by gpengtao on 15/4/21.
 */
public enum GenderType {

    M(1, "male"),
    F(2, "female");

    public int code;

    public String text;

    GenderType(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
