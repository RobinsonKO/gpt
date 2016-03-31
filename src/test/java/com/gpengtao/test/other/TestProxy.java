package com.gpengtao.test.other;

import com.gpengtao.handler.SayHiCallBack;
import com.gpengtao.handler.SayHiHandler;
import com.gpengtao.interfaces.ISayHiable;
import com.gpengtao.service.SayHiService;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by gpengtao on 3/29/15.
 */
public class TestProxy {

    @Test
    public void dynamicProxy() {
        ISayHiable sayHiImpl = new SayHiService();
        ISayHiable sayHi = (ISayHiable) Proxy.newProxyInstance(ISayHiable.class.getClassLoader(),
                new Class[]{ISayHiable.class}, new SayHiHandler(sayHiImpl));
        System.out.println("say hi proxy class: " + sayHi.getClass());

        System.out.println("say hi proxy methods: ");
        Method[] methods = sayHi.getClass().getMethods();
        for (int i = 0; i < methods.length; ++i) {
            System.out.println(i + " method: " + methods[i]);
        }

        sayHi.sayHi();
    }

    @Test
    public void cglib(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SayHiService.class);
        enhancer.setCallback(new SayHiCallBack());

        SayHiService sayHiService = (SayHiService) enhancer.create();
        sayHiService.sayHi();
    }
}
