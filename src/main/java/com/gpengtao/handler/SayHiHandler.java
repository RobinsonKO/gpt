package com.gpengtao.handler;

import com.gpengtao.interfaces.ISayHiable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ��̬����
 * <p>
 * Created by gpengtao on 3/29/15.
 */
public class SayHiHandler implements InvocationHandler {

    private static final Logger logger = LoggerFactory.getLogger(SayHiHandler.class);

    private ISayHiable target;

    public SayHiHandler(ISayHiable sayHiable) {
        target = sayHiable;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logger.info("say hi handler proxy :{}", proxy.getClass());
        logger.info("say hi handler method :{}", method);
        logger.info("say hi handler args :{}", ToStringBuilder.reflectionToString(args));

        method.invoke(target, args);
        return null;
    }
}
