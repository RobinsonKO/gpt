package com.gpengtao.test.other;

import com.gpengtao.json.RootSpringUtil;
import org.junit.Test;

import java.net.URL;

/**
 * Created by pengtao.geng on 2015/3/20.
 */
public class TestClassPath {

    @Test
    public void test() {
        ClassLoader classLoader = TestClassPath.class.getClassLoader();
        System.out.println(classLoader);
        URL resource = classLoader.getResource("");
        System.out.println(resource);

        ClassLoader loader = RootSpringUtil.class.getClassLoader();
        System.out.println(loader);
        URL loaderResource = loader.getResource("");
        System.out.println(loaderResource);

        URL systemResource = ClassLoader.getSystemResource("");
        System.out.println(systemResource);
    }

    @Test
    public void testClassPath() {
        ClassLoader classLoader = TestClassPath.class.getClassLoader();
        while (classLoader != null) {
            System.out.println(classLoader);
            classLoader = classLoader.getParent();
        }
    }
}
