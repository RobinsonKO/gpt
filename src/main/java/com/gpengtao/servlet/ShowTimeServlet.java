package com.gpengtao.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by gpengtao on 4/2/15.
 */
public class ShowTimeServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(ShowTimeServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("show time servlet receive request,uri:{}", req.getRequestURI());
        resp.getWriter().write("ShowTime,现在时刻： " + new Date());

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        logger.info("ShowTime servlet 开始 init...");
        super.init(config);
    }

    @Override
    public void destroy() {
        logger.info("ShowTime servlet 开始 destroy...");
        super.destroy();
    }

    public ShowTimeServlet() {
        logger.info("ShowTimeServlet constructed!");
    }
}
