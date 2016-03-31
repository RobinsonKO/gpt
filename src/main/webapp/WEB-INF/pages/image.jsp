<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<div>
    <c:forEach var="path" items="${pathList}">
        <img src="./viewImage?path=${path}" width="100%">
    </c:forEach>
</div>
</body>
</html>
