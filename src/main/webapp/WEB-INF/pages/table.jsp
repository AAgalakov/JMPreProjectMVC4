<%--
  Created by IntelliJ IDEA.
  User: andreyagalakov
  Date: 27.02.2020
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--<%@ taglib uri="http://www.springframework.org/tags" prefix="locale" %>--%>


<html>
<head>
    <meta charset="UTF-8"/>
    <title>User table</title>
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
    <caption> Users </caption>
    <tr>
        <th> User id</th>
        <th> User name</th>
        <th> User password</th>
        <th> User age</th>
        <th> User role</th>
        <th> Edit </th>
        <th> Delete </th>
<%--        <th colspan="2"> Action</th>--%>
<%--        <th></th>--%>

    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.password}</td>
            <td>${user.age}</td>
            <td>
                <c:forEach var="role" items="${user.roles}">
                    <span>${role}</span><br><br>
                </c:forEach>
            </td>
            <td>
                <form action="/updateUserForm/${user.id}" method="get">
                    <button name="id" value="${user.id}" type="submit" >Edit</button>
                </form>
            </td>
            <td>
                <form action="/delete/${user.id}" method="get">
                    <button name="id" value="${user.id}" type="submit" >Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <form action="/userAdd" method="post">
            <td></td>
            <td><input name="name" placeholder="Name"/></td>
            <td><input name="password" placeholder="Password"/></td>
            <td><input name="age" placeholder="Age" type="number" min=1/></td>
            <td style="text-align: center">
                <select name="roles" multiple>
                    <option selected="selected">user</option>
                    <option>admin</option>
                </select>
            </td>
            <td colspan="2">
                <button>Add new user</button>
            </td>
        </form>
    </tr>
</table>
<form action="/logout" method="GET">
    <input type="submit" value="Log out">
</form>
</body>
</html>