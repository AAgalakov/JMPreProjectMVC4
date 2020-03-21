<%--
  Created by IntelliJ IDEA.
  User: andreyagalakov
  Date: 17.03.2020
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Role table</title>
</head>
<body>
<style>
    table {
        border-collapse: collapse;
    }

    th, td {
        text-align: center;
        padding: 8px;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
</style>
<table>
    <caption> Roles</caption>
    <tr>
        <th> Role id</th>
        <th> Role name</th>
    </tr>
    <c:forEach var="role" items="${roleList}">
        <tr>
            <td>${role.id}</td>
            <td>${role.nameRole}</td>
        </tr>
    </c:forEach>
</table>
<form action="/logout" method="GET">
    <input type="submit" value="Log out">
</form>
</body>
</html>
