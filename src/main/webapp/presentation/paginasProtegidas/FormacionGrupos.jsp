<!--
 ===================================================================
 *
 * (c) 2023
 *
 * Jeffry Barquero Torres
 * Jennifer Mejías Salazar
 * Eduardo Orellana Rivas
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
           <header>
        <nav>
            <ul>
                <li><a href="TablaEstudiante.jsp">Tabla de estudiantes</a></li>
            </ul>
        </nav>
    </header>
        <h1>Formación de Grupos</h1>
    
    <div class="opciones">
        <button id="mostrar-form1">Crear un grupo</button>
        <button id="mostrar-form2">Unirse a un grupo</button>
        <button id="mostrar-form3">Desasignar estudiante</button>
    </div>

    <form action="${pageContext.request.contextPath}/CrearGrupoServlet" method="POST" id="formulario1" class="formulario" style="display: none;">
        <h2>Crear un nuevo grupo</h2>
         <label for="nombreGrupo">Nombre del Grupo:</label>
            <input type="text" id="nombreGrupo" name="nombreGrupo" required><br><br>

            <label for="estudianteID">Tu ID de Estudiante:</label>
            <input type="text" id="estudianteID" name="estudianteID" required><br><br>

            <input class="opciones" type="submit" value="Crear Grupo">
    </form>

    <form action="${pageContext.request.contextPath}/UnirseGrupoServlet" method="POST" id="formulario2" class="formulario" style="display: none;">
        <h2>Unirse a un grupo existente</h2>
          <label for="codigoGrupo">Código del Grupo:</label>
            <input type="text" id="codigoGrupo" name="codigoGrupo" required><br><br>

            <label for="estudianteIDUnirse">Tu ID de Estudiante:</label>
            <input type="text" id="estudianteIDUnirse" name="estudianteIDUnirse" required><br><br>

            <input type="submit" value="Unirse al Grupo">
    </form>

    <form action="${pageContext.request.contextPath}/DesasignarServlet" method="POST" id="formulario3" class="formulario" style="display: none;">
        <h2> Desasignar Estudiante de un Grupo </h2>
        <label for="estudianteIDDesasignar">Tu ID de Estudiante:</label>
            <input type="text" id="estudianteIDDesasignar" name="estudianteIDDesasignar" required><br><br>

            <input type="submit" value="Desasignar Estudiante">
    </form>

    <script>
        document.addEventListener("DOMContentLoaded", function () {
            const formularios = document.querySelectorAll(".formulario");
            const botonesMostrar = document.querySelectorAll("button[id^='mostrar-form']");

            botonesMostrar.forEach((boton, index) => {
                boton.addEventListener("click", function () {
                    formularios.forEach((formulario) => {
                        formulario.style.display = "none";
                    });
                    formularios[index].style.display = "block";
                });
            });
        });
    </script>
     
        <strong>Nota: Los grupos tienen un límite de no más de 5 estudiantes.</strong>
            
    </body>
</html>
