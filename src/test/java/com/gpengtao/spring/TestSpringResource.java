package com.gpengtao.spring;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

/**
 * Created by gpengtao on 15/3/18.
 */
public class TestSpringResource {

    @Test
    public void testDefaultResourceLoader() {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("/etc/hosts");
        Assert.assertTrue(resource instanceof ClassPathResource);
        Assert.assertFalse(resource.exists());

        System.out.println("resource类型:" + resource);
        System.out.println("resource是否存在" + resource.exists());

        DefaultResourceLoader resourceLoader2 = new DefaultResourceLoader();
        Resource resource2 = resourceLoader2.getResource("file:/etc/hosts");
        Assert.assertTrue(resource2 instanceof UrlResource);
        Assert.assertTrue(resource2.exists());
    }

    @Test
    public void testFileSystemResourceLoader() {
        FileSystemResourceLoader resourceLoader = new FileSystemResourceLoader();
        Resource resource = resourceLoader.getResource("//etc/hosts");// 会去掉第一个"/"
        Assert.assertTrue(resource instanceof FileSystemResource);
        Assert.assertTrue(resource.exists());
        System.out.println(resource);
        System.out.println(resource.exists());
    }

    @Test
    public void testPatternResolver() throws IOException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath*:*.xml");

        System.out.println(resources.length);
    }
}
