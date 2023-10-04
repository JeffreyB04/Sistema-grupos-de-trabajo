<!--
 ===================================================================
 *
 * (c) 2023
 *
 * Jeffry Barquero Torres
 * 
 *
 * version 1.0.0 2023-09-30
 *
 ===================================================================
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
    </head>
    <body>
        <h1>Login Page</h1>

    <c:if test="${not empty errorMessage}">
        <p class="error-message">${errorMessage}</p>
    </c:if>

    <form name="loginForm" action="${pageContext.request.contextPath}/Controller" method="post">
        <label for="id">ID:</label>
        <input type="text" id="id" name="id" required><br><br>

        <label for="clave">Clave:</label>
        <input type="password" id="clave" name="clave" required><br><br>

        <input type="submit" value="Login">
    </form>
</body>
</html>

