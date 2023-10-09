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
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../../css/formacionGrupos.css" rel="stylesheet" type="text/css"/>
        <title>Formación de Grupos</title>
    </head>
    <body>
        <h1>Formación de Grupos</h1>

        <h2>Crear un Nuevo Grupo</h2>
        <form action="${pageContext.request.contextPath}/CrearGrupoServlet" method="POST">
            <label for="nombreGrupo">Nombre del Grupo:</label>
            <input type="text" id="nombreGrupo" name="nombreGrupo" required><br><br>

            <label for="estudianteID">Tu ID de Estudiante:</label>
            <input type="text" id="estudianteID" name="estudianteID" required><br><br>

            <input type="submit" value="Crear Grupo">
        </form>

        <h2>Unirse a un Grupo Existente</h2>
        <form action="${pageContext.request.contextPath}/UnirseGrupoServlet" method="POST">
            <label for="codigoGrupo">Código del Grupo:</label>
            <input type="text" id="codigoGrupo" name="codigoGrupo" required><br><br>

            <label for="estudianteIDUnirse">Tu ID de Estudiante:</label>
            <input type="text" id="estudianteIDUnirse" name="estudianteIDUnirse" required><br><br>

            <input type="submit" value="Unirse al Grupo">
        </form>

        <h2>Desasignar Estudiante de un Grupo</h2>
        <form action="${pageContext.request.contextPath}/DesasignarServlet" method="POST">
            <label for="estudianteIDDesasignar">Tu ID de Estudiante:</label>
            <input type="text" id="estudianteIDDesasignar" name="estudianteIDDesasignar" required><br><br>

            <input type="submit" value="Desasignar Estudiante">
        </form>

        <p>Nota: Los grupos tienen un límite de no más de 5 estudiantes.</p>
                <br>
        <a href="TablaEstudiante.jsp">Tabla de estudiantes</a>
    </body>
</html>
