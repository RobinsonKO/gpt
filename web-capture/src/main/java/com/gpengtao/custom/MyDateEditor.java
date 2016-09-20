package com.gpengtao.custom;

import org.springframework.beans.propertyeditors.CustomDateEditor;

import java.text.SimpleDateFormat;

/**
 * Created by gpengtao on 16/9/3.
 */
public class MyDateEditor extends CustomDateEditor {

    public MyDateEditor() {
        super(new SimpleDateFormat("yyyy-MM-dd"), true);
    }
}
