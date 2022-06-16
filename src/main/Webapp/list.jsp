<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 16/6/2022
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách khách hàng</h1>
<c:forEach items='${listUser}' var="user">
<h3>${user.username}</h3>
</c:forEach>
</body>
</html>
