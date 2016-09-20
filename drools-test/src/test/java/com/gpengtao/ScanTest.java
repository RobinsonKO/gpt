package com.gpengtao;

import com.gpengtao.model.BaseModel;
import org.junit.Test;
import org.reflections.Reflections;

import java.util.Set;

/**
 * Created by pengtao.geng on 2016/9/20.
 */
public class ScanTest {

    @Test
    public void test() {
        Reflections reflections = new Reflections("com.gpengtao");
        Set<Class<? extends BaseModel>> subTypesOf = reflections.getSubTypesOf(BaseModel.class);
        for (Class<?> aClass : subTypesOf) {
            System.out.println(aClass);
        }
    }
}
