<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 18/6/2022
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Delete customer</h1>
<p>
    <a href="/trellos">Back to list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Post information</legend>
        <table>
            <tr>
                <td>id: </td>
                <td>${spCanXoa.id}</td>
            </tr>
            <tr>
                <td>title: </td>
                <td>${spCanXoa.title}</td>
            </tr>
            <tr>
                <td>dateCreated: </td>
                <td>${spCanXoa.dateCreated}</td>
            </tr>
            <tr>
                <td>content: </td>
                <td>${spCanXoa.content}</td>
            </tr>
            <tr>
                <td>description: </td>
                <td>${spCanXoa.description}</td>
            </tr>
            <tr>
                <td>authority: </td>
                <td>${spCanXoa.authority}</td>
            </tr>
            <tr>
                <td>status: </td>
                <td>${spCanXoa.status}</td>
            </tr>
            <tr>
                <td>userid: </td>
                <td>${spCanXoa.userid}</td>
            </tr>
            <tr>
                <td>typeid: </td>
                <td>${spCanXoa.typeid}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete post"></td>
                <td><a href="/trellos">Back to list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
<%--<tr>--%>
<%--    <td>title: </td>--%>
<%--    <td>${requestScope["spCanXoa"].getTitle()}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--    <td>dateCreated: </td>--%>
<%--    <td>${requestScope["spCanXoa"].getDateCreated()}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--    <td>description: </td>--%>
<%--    <td>${requestScope["spCanXoa"].getDescription()}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--    <td>authority: </td>--%>
<%--    <td>${requestScope["spCanXoa"].getAuthority()}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--    <td>status: </td>--%>
<%--    <td>${requestScope["spCanXoa"].getStatus()}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--    <td>userid: </td>--%>
<%--    <td>${requestScope["spCanXoa"].getUserid()}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--    <td>typeid: </td>--%>
<%--    <td>${requestScope["spCanXoa"].getTypeid()}</td>--%>
<%--</tr>--%>
