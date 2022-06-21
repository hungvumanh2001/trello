<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 16/6/2022
  Time: 11:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit form</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/trellos">Back to  list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>title: </td>
                <td><input type="text" name="title" id="title" value="${requestScope["spCanSua"].getTitle()}"></td>
            </tr>
            <tr>
                <td>dateCreated: </td>
                <td><input type="text" name="dateCreated" id="dateCreated" value="${requestScope["spCanSua"].getDateCreated()}"></td>
            </tr>
            <tr>
                <td>description: </td>
                <td><input type="text" name="description" id="description" value="${requestScope["spCanSua"].getDescription()}"></td>
            </tr>
            <tr>
                <td>authority: </td>
                <td><input type="text" name="authority" id="authority" value="${requestScope["spCanSua"].getAuthority()}"></td>
            </tr>
            <tr>
                <td>status: </td>
                <td><input type="text" name="status" id="status" value="${requestScope["spCanSua"].getStatus()}"></td>
            </tr>
            <tr>
                <td>userid: </td>
                <td><input type="text" name="userid" id="userid" value="${requestScope["spCanSua"].getUserid()}"></td>
            </tr>
            <tr>
                <td>typeid: </td>
                <td><input type="text" name="typeid" id="typeid" value="${requestScope["spCanSua"].getTypeid()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update bai viet"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
