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
<a href="/trellos?action=create">Tạo bài viết</a>
<c:forEach items='${listUser}' var="user">
<h3>${user.username}</h3>
</c:forEach>
<c:forEach items='${listPost}' var="post">
    <h3>${post.id},${post.title},${post.dateCreated},${post.content},${post.description},${post.authority},${post.status},
    ${post.userid},${post.userid},<a href="/trellos?action=edit&id=${post.id}">Sửa</a></h3>
</c:forEach>
</body>
</html>
