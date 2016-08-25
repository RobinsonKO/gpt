<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>

<script type="text/javascript" src="http://libs.useso.com/js/jquery/1.8.1/jquery.min.js"></script>

<c:forEach var="url" items="${contents}">
    ${url}
    <br/>
</c:forEach>

</body>
</html>
