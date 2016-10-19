package com.gpengtao.utils;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

/**
 * Created by gpengtao on 16/7/7.
 */
public class MyUtil {

    private static final Joiner COMMA_JOINER = Joiner.on(",");

    private static final Joiner TAB_JOINER = Joiner.on("\t");

    public static String joinFieldValuesWithTab(Object object) {
        if (object instanceof Iterable) {
            return COMMA_JOINER.join((Iterable) object);
        }

        List<Object> result = Lists.newArrayList();

        for (Field field : object.getClass().getDeclaredFields()) {
            int modifiers = field.getModifiers();
            if (Modifier.isPrivate(modifiers) && !Modifier.isStatic(modifiers)) {
                field.setAccessible(true);
                try {
                    Object value = field.get(object);
                    if (value instanceof Iterable) {
                        result.add(joinFieldValuesWithTab(value));
                    } else {
                        result.add(value);
                    }
                } catch (Throwable t) {
                    t.printStackTrace();
                }
            }
        }

        for (int i = 0; i < result.size(); ++i) {
            if (result.get(i) == null) {
                result.set(i, "");
            }
        }
        return TAB_JOINER.join(result) + "\r\n";
    }
}
