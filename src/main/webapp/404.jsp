<%@ page import="org.slf4j.Logger" %>
<%@ page import="org.slf4j.LoggerFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%!
    private static final Logger logger = LoggerFactory.getLogger("404_jsp");
%>
<%
    logger.warn("request url not found");
%>
<h1>404</h1>

<h3>么有找到</h3>

</body>
</html>
