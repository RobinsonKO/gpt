package com.gpengtao.servlet;

import org.apache.logging.log4j.core.config.plugins.util.ResolverUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

/**
 * Created by gpengtao on 15/5/22.
 */
public class TestServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(TestServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("visit TestServlet,url：{}", req.getRequestURL());
        PrintWriter writer = resp.getWriter();
        writer.write("~~~~~Test Servlet " + new Date() + "~~~~~~");

        // 查看servletConfig参数
        ServletConfig servletConfig = getServletConfig();
        Enumeration configParam = servletConfig.getInitParameterNames();
        while (configParam.hasMoreElements()) {
            String element = (String) configParam.nextElement();
            logger.info("TestServlet查看servletConfig 参数：{} -> {}", element, servletConfig.getInitParameter(element));
        }

        // 查看servletConfig参数
        ServletContext servletContext = getServletContext();
        Enumeration contextParam = servletContext.getInitParameterNames();
        while (contextParam.hasMoreElements()) {
            String element = (String) contextParam.nextElement();
            logger.info("TestServlet查看servletContext 参数：{} -> {}", element, servletContext.getInitParameter(element));
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        logger.info("test servlet 开始 init...");
        super.init(config);
    }

    @Override
    public void destroy() {
        logger.info("test servlet 开始 destroy...");
        super.destroy();
    }
}
