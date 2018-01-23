<%--
  Created by IntelliJ IDEA.
  User: sbt-sizov-ns
  Date: 10.01.2018
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Управление пользователями</title>
</head>
<body>
<form method="get" action="/showAll">
<table>
    <caption>Таблица пользователей</caption>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>login</th>
        <th>password</th>
    </tr>
    <c:forEach items="${list}" var="list">
        <tr>
            <td>${list.id}</td>
            <td>${list.name}</td>
            <td>${list.login}</td>
            <td>${list.password}</td>
                <th><a href="/update?id=<c:out value="${list.id}"/>">update</a> </th>
                <th><a href="/delete?id=<c:out value="${list.id}"/>">delete</a> </th>
        </tr>
    </c:forEach>
</table>
</form>
<form method="get" action="/">
    <input type="submit" name="back" value="back">
</form>
</body>
</html>
