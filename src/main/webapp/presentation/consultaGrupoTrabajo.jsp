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
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Consulta de Grupo de Trabajo</title>
    </head>
    <body>
        <h1>Consulta de Grupo de Trabajo</h1>

        <form action="${pageContext.request.contextPath}/ConsultaGrupoTrabajoServlet" method="post">
            <label for="nombreGrupoTrabajo">Nombre del Grupo de Trabajo:</label>
            <input type="text" id="nombreGrupoTrabajo" name="nombreGrupoTrabajo" required><br><br>

            <input type="submit" value="Consultar">
        </form>
    </body>
</html>
