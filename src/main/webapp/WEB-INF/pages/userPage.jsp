<%--
  Created by IntelliJ IDEA.
  User: andreyagalakov
  Date: 14.03.2020
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

Hello, ${name}!

<form action="/logout" method="GET">
    <input type="submit" value="Log out">
</form>

</body>
</html>
