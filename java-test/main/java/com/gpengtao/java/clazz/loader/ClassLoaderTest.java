package com.gpengtao.java.clazz.loader;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by gpengtao on 16/7/21.
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        ClassLoader myClassLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String className) throws ClassNotFoundException {
                System.out.println("myClassLoader load class : " + className);

                // java的类不能又自定义的来加载器加载
                if (className.startsWith("java.")) {
                    return super.loadClass(className);
                }

                // 读取class文件
                String fileName = "/" + className.replace(".", "/") + ".class";
                InputStream inputStream = getClass().getResourceAsStream(fileName);
                try {
                    byte[] bytes = new byte[inputStream.available()];

                    inputStream.read(bytes);

                    // 转换成class
                    return defineClass(className, bytes, 0, bytes.length);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new ClassNotFoundException();
                }
            }
        };

        // 会被默认的类加载器加载
        String className = MyClass.class.getName();

        // 用自己写的类加载加载,并new一个对象
        Class<?> myClass = myClassLoader.loadClass(className);
        Object myClassInstance = myClass.newInstance();

        // 不是同一个类型
        System.out.println("instanceof: " + (myClassInstance instanceof MyClass));
        System.out.println("class name: " + myClassInstance.getClass());
        System.out.println("class loader: " + myClassInstance.getClass().getClassLoader());

        System.out.println("class loader: " + MyClass.class.getClassLoader());
    }
}
