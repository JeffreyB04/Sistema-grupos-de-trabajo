<!--
 ===================================================================
 *
 * (c) 2023
 *
 * Jeffry Barquero Torres
 * Eduardo Orellana Rivas
 *
 * version 1.0.0 2023-09-30
 *
 ===================================================================
-->
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.mycompany.proyecto01prograiv.logic.Service" %>
<%@ page import="com.mycompany.proyecto01prograiv.logic.Estudiante" %>
<%@ page import="com.mycompany.proyecto01prograiv.logic.Grupo" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Consulta de Grupo de Trabajo</title>
    </head>
    <body>
        <h1>Consulta de Grupo de Trabajo</h1>

        <form action="" method="post">
            <label for="grupo_id">ID del Grupo de Trabajo:</label>
            <input type="text" id="grupo_id" name="grupo_id" required><br><br>

            <input type="submit" value="Consultar">
        </form>

        <%
            String grupo_id = request.getParameter("grupo_id");
            Service service = Service.obtenerInstancia();

            if (grupo_id != null && !grupo_id.isEmpty()) {
                List<Estudiante> estudiantes = service.obtenerEstudiantesPorGrupoTrabajo(grupo_id);

                if (!estudiantes.isEmpty()) {
        %>

        <h2>Resultado de la Consulta de Grupo de Trabajo</h2>
        <h3>Grupo de Trabajo ID: <%= grupo_id %></h3>
        <h3>Estudiantes:</h3>
        <ul>
            <%
                for (Estudiante estudiante : estudiantes) {
            %>
            <li><%= estudiante.getNombre() %> (ID: <%= estudiante.getId() %>)</li>
                <%
                    }
                %>
        </ul>

        <%
                } else {
        %>
        <p>No se encontraron estudiantes para el Grupo de Trabajo ID: <%= grupo_id %>.</p>
        <%
                }
            }
        %>

        <a href="consultaGrupoTrabajo.jsp">Volver a la consulta</a>
                <br>
        <a href="TablaEstudiante.jsp">Tabla de estudiantes</a>
    </body>
</html>