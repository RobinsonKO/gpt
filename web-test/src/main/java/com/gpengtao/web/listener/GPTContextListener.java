package com.gpengtao.web.listener;

import com.google.common.base.Objects;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Enumeration;

/**
 * Created by gpengtao on 15/5/17.
 */
public class GPTContextListener implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(GPTContextListener.class);

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("gpt context listener: init ...");

        ServletContext servletContext = servletContextEvent.getServletContext();
        logger.info("servlet context 是：{}", servletContext);

        // 查看context-param参数
        Enumeration initParameterNames = servletContextEvent.getServletContext().getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String element = (String) initParameterNames.nextElement();
            logger.info("gpt context listener 参数：{} -> {}", element, servletContext.getInitParameter(element));
        }

        // 查看attribute
        Enumeration attributeNames = servletContext.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String element = (String) attributeNames.nextElement();
            if (Objects.equal("org.apache.tomcat.util.scan.MergedWebXml", element)) {
                logger.info("gpt context listener attribute：{} -> {}", element, "xml文件太长了，不打印...");
            } else {
                logger.info("gpt context listener attribute：{} -> {}", element, servletContext.getAttribute(element));
            }
        }

        logger.info("servlet context path 是：{}", servletContext.getContextPath());
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("gpt context listener: destroy ...");
    }
}
