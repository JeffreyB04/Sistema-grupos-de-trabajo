<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Resultado de la Consulta de Grupo de Trabajo</title>
    </head>
    <body>
        <h1>Resultado de la Consulta de Grupo de Trabajo</h1>

        <c:if test="${not empty nombreGrupoTrabajo}">
            <h2>Grupo de Trabajo: ${nombreGrupoTrabajo}</h2>

            <c:if test="${not empty estudiantes}">
                <h2>Estudiantes:</h2>
                <ul>
                <c:forEach items="${estudiantes}" var="estudiante">
                    <li>${estudiante.nombre} (${estudiante.id})</li>
                </c:forEach>
                </ul>
            </c:if>
        </c:if>

        <a href="consultaGrupoTrabajo.jsp">Volver a la consulta</a>
    </body>
</html>
