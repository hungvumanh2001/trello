<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 16/6/2022
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách khách hàng</h1>
<form action="/trellos">
    <table>
        <tr style="border-style: solid; border-color: #1b1e21">
            <td><h3>USERNAME</h3></td>
            <td><h3>PASSWORD</h3></td>
        </tr>
        <c:forEach items='${users}' var="user">
            <tr>
                <td><p>${user.username}</p></td>
                <td><p>${user.password}</p></td>
            </tr>
        </c:forEach>
    </table>
    <div class="form-group">
        <input type="text" class="form-control" placeholder="Search" name="namesearch" required>
        <button type="submit" class="form-control btn btn-primary submit px-3">Search</button>
    </div>
</form>
</body>
</html>
