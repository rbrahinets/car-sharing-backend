<!DOCTYPE html>
<html lang="en" xmlns:th="http://thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<h2>Hello World!</h2>

    <input type="button" value="log in">



<a  th:href="@{http://localhost:8080/login}">
    <input type="submit" value="Login">
</a>
</body>
</html>
