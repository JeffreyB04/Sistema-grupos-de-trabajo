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
        <input type="text" id="id" name="id" value="<%= request.getParameter("id") != null ? request.getParameter("id") : "" %>" required><br><br>

        <label for="clave">Clave:</label>
        <input type="password" id="clave" name="clave" value="<%= request.getParameter("clave") != null ? request.getParameter("clave") : "" %>" required><br><br>

        <input type="submit" value="Login">
    </form>
</body>
</html>

