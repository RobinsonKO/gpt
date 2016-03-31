<%@ page import="org.slf4j.Logger" %>
<%@ page import="org.slf4j.LoggerFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title></title>
</head>
<body>
<%!
    private static final Logger logger = LoggerFactory.getLogger("nullPointerError_jsp");
%>
<%
    logger.error("request error", exception);
%>
<h1>NullPointerException Error page</h1>

<h3>错误码：<%=request.getAttribute("javax.servlet.error.status_code")%>
</h3>

<h3>信息：<%=request.getAttribute("javax.servlet.error.message")%>
</h3>

<h3>异常：<%=request.getAttribute("javax.servlet.error.exception_type")%>
</h3>

<h3>异常类：<%=exception%>
</h3>

</body>
</html>
