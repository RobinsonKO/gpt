package com.gpengtao.java.reflect.main;

import com.gpengtao.java.reflect.model.BaseModel;
import org.reflections.Reflections;

import java.util.Set;

/**
 * Created by pengtao.geng on 2016/9/20.
 */
public class ScanTest {

    public static void main(String[] args) {
        Reflections reflections = new Reflections("com.gpengtao");
        Set<Class<? extends BaseModel>> subTypes = reflections.getSubTypesOf(BaseModel.class);
        for (Class<?> aClass : subTypes) {
            System.out.println(aClass);
        }
    }

}
