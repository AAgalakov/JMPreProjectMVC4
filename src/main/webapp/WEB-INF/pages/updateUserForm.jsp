<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Update User</title>
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
    <tr>
        <th> User id</th>
        <th> User name</th>
        <th> User password</th>
        <th> User age</th>
        <th> User role</th>
        <th> Action</th>
    </tr>
    <tr>
        <form action="/admin/editUser" method="post">
            <td style="text-align: center"> ${user.id}</td>
            <td style="text-align: center"><input name="name" value="${user.name}"/></td>
            <td style="text-align: center"><input name="password" value="${user.password}"/></td>
            <td style="text-align: center"><input name="age" value="${user.age}" type="number" min=1/></td>
            <td style="text-align: center">
                <input type="checkbox" name="roles" value="admin" >admin<Br>
                <input type="checkbox" checked="true" name="roles" value="user">user<Br>
            <td style="text-align: center">
                <button name="id" value="${user.id}">Submit</button>
            </td>
        </form>
    </tr>
</table>
<form action="/logout" method="GET">
    <input type="submit" value="Log out">
</form>
</body>
</html>
