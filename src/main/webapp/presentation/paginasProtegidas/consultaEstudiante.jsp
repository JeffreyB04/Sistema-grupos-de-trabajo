<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Consulta de Estudiante</title>
    </head>
    <body>
        <h1>Consulta de Estudiante</h1>

        <form action="ConsultaEstudianteServlet" method="post">
            <label for="estudianteID">Ingrese el ID del Estudiante:</label>
            <input type="text" id="estudianteID" name="estudianteID" required><br><br>

            <input type="submit" value="Consultar">
        </form>
    </body>
</html>
