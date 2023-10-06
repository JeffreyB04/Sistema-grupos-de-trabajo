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
<%@ page import="com.mycompany.proyecto01prograiv.logic.Service" %>
<%@ page import="com.mycompany.proyecto01prograiv.logic.Estudiante" %>
<%@ page import="com.mycompany.proyecto01prograiv.logic.Grupo" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Consulta de Estudiante</title>
</head>
<body>
    <h1>Consulta de Estudiante</h1>

    <form action="" method="post">
        <label for="estudianteID">Ingrese el ID del Estudiante:</label>
        <input type="text" id="estudianteID" name="estudianteID" required><br><br>

        <input type="submit" value="Consultar">
    </form>

    <%
        String estudianteID = request.getParameter("estudianteID");
        String resultado = "El estudiante no está incluido en ningún grupo.";

        if (estudianteID != null && !estudianteID.isEmpty()) {
            // Aquí puedes realizar la lógica de filtración
            // Usaremos la clase Service para recuperar el estudiante y verificar su grupo_id

            Service service = Service.obtenerInstancia();
            Estudiante estudiante = service.recuperar(estudianteID);

            if (estudiante != null && estudiante.getGrupo_id() != 0) {
                resultado = "El estudiante está incluido en un grupo con ID: " + estudiante.getGrupo_id();
            }
        }
    %>

    <h2>Resultado de la Consulta</h2>
    <p><%= resultado %></p>

    <a href="consultaEstudiante.jsp">Volver a la consulta</a>
</body>
</html>
