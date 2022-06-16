<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 16/6/2022
  Time: 10:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items='${listPost}' var="post">
    <h3>${post.id},${post.title},,${post.dateCreated},${post.content},${post.description},${post.authority},${post.status},
            ${post.userid},${post.userid}</h3>
</c:forEach>
</body>
</html>
