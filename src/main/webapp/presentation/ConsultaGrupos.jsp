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
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta de Grupos</title>
    </head>
    <body>
        <h1>Consulta de Grupos</h1>

        <form action="${pageContext.request.contextPath}/ConsultaGruposServlet" method="POST">
            <label for="nombreGrupo">Nombre del Grupo:</label>
            <input type="text" id="nombreGrupo" name="nombreGrupo">
            <input type="submit" value="Buscar">
        </form>

        <h2>Resultados de la Búsqueda</h2>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nombre del Grupo</th>
                <th>Cupo</th>
                <th>Activo</th>
            </tr>
            <c:forEach var="grupo" items="${grupos}">
                <tr>
                    <td>${grupo.id}</td>
                    <td>${grupo.nombre}</td>
                    <td>${grupo.cupo}</td>
                    <td>${grupo.activo ? 'Sí' : 'No'}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
