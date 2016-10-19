package com.gpengtao.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by pengtao.geng on 2015/10/27.
 */
public class ModelGenerateUtil {

    public static <T> T generateModel(Class<T> clazz) throws Exception {
        T vo = clazz.newInstance();

        Field[] declaredFields = getInheritedFields(clazz).toArray(new Field[]{});
        for (Field field : declaredFields) {
            String name = field.getName();
            Class<?> type = field.getType();

            if ("serialVersionUID".equals(name)) {
                continue;
            }
            String firstLetter = name.substring(0, 1).toUpperCase();
            String setter = "set" + firstLetter + name.substring(1);
            if (type.isAssignableFrom(String.class)) {
                Method setterMethod = clazz.getMethod(setter, String.class);
                setterMethod.invoke(vo, name + randomInt());
            } else if (type.isAssignableFrom(int.class)) {
                Method setterMethod = clazz.getMethod(setter, int.class);
                setterMethod.invoke(vo, randomInt());
            } else if (type.isAssignableFrom(Integer.class)) {
                Method setterMethod = clazz.getMethod(setter, Integer.class);
                setterMethod.invoke(vo, randomInt());
            } else if (type.isAssignableFrom(long.class)) {
                Method setterMethod = clazz.getMethod(setter, long.class);
                setterMethod.invoke(vo, randomInt());
            } else if (type.isAssignableFrom(double.class)) {
                Method setterMethod = clazz.getMethod(setter, double.class);
                setterMethod.invoke(vo, new Random().nextDouble());
            } else if (type.isAssignableFrom(boolean.class)) {
                Method setterMethod = clazz.getMethod(setter, boolean.class);
                setterMethod.invoke(vo, randomBoolean());
            } else if (type.isAssignableFrom(BigDecimal.class)) {
                Method setterMethod = clazz.getMethod(setter, BigDecimal.class);
                setterMethod.invoke(vo, randomBigDecimal());
            } else if (type.isAssignableFrom(Date.class)) {
                Method setterMethod = clazz.getMethod(setter, Date.class);
                setterMethod.invoke(vo, new Date());
            }
            // else if (field.getType().isAssignableFrom(List.class)) {
            // Type type = field.getGenericType();
            //
            // String fullTypeName = field.getGenericType().getTypeName();
            // String listType = fullTypeName.substring(fullTypeName.indexOf("<") + 1, fullTypeName.lastIndexOf(">"));
            // Class<?> listClass = Class.forName(listType);
            // Object o1 = generateModel(listClass);
            // Object o2 = generateModel(listClass);
            // Method setterMethod = clazz.getMethod(setter, List.class);
            // setterMethod.invoke(vo, Lists.newArrayList(o1, o2));
            // }
            else {
                Object o = generateModel(type);
                Method setterMethod = clazz.getMethod(setter, type);
                setterMethod.invoke(vo, o);
                System.out.println("========" + name);
            }
        }

        return vo;
    }

    private static List<Field> getInheritedFields(Class<?> type) {
        List<Field> fields = new ArrayList<>();
        for (Class<?> c = type; c != null; c = c.getSuperclass()) {
            fields.addAll(Arrays.asList(c.getDeclaredFields()));
        }
        return fields;
    }

    private static Object randomBigDecimal() {
        return new BigDecimal(randomInt());
    }

    private static int randomInt() {
        int i = new Random().nextInt(10);
        return i < 0 ? -i : i;
    }

    private static boolean randomBoolean() {
        return new Random().nextBoolean();
    }
}
