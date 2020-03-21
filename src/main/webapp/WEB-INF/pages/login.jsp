<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<body>
<fieldset>
    <legend>Авторизуйтесь</legend>
    <form action="/login" method="POST">
        <p><strong>Логин:</strong>
            <input maxlength="25" size="40" name="name"></p>
        <p><strong>Пароль:</strong>
            <input type="password" maxlength="25" size="40" name="password"></p>
        <input type="submit" value="OK">
    </form>
</fieldset>
</body>
</html>
