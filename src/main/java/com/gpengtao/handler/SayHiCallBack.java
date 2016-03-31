package com.gpengtao.handler;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * ��̬�ֽ�������
 * <p>
 * Created by gpengtao on 3/30/15.
 */
public class SayHiCallBack implements MethodInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(SayHiCallBack.class);

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        logger.info("say hi call back obj:{}", obj.getClass());
        logger.info("say hi call back method:{}", method);
        logger.info("say hi call back args:{}", ToStringBuilder.reflectionToString(args));
        logger.info("say hi call back proxy:{}", proxy);
        proxy.invokeSuper(obj, args);
        return null;
    }
}
