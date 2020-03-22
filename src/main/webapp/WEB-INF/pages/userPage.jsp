<%--
  Created by IntelliJ IDEA.
  User: andreyagalakov
  Date: 14.03.2020
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Hello, ${user.name}!<br><br>
Age - ${user.age}<br><br>
Role:<br><br>
<c:forEach var="role" items="${user.roles}">
    <span>${role}</span><br><br>
</c:forEach>
<form action="/logout" method="GET">
    <input type="submit" value="Log out">
</form>
</body>
</html>
