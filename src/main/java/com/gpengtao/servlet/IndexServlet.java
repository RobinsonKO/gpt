package com.gpengtao.servlet;

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

/**
 * Created by gpengtao on 4/5/15.
 */
public class IndexServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(IndexServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("visit IndexServlet,url：{}", req.getRequestURL());
        PrintWriter writer = resp.getWriter();
        writer.write("IndexServlet " + new Date());
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        logger.info("Index servlet 开始 init...");
        super.init(config);
    }

    @Override
    public void destroy() {
        logger.info("Index servlet 开始 destroy...");
        super.destroy();
    }
}
