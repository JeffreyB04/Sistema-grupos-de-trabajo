<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="cr.ac.una.estudiantes.entidades.Estudiante" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Registro de estudiantes</title>
    <link rel="shortcut icon" href="./css/imagenes/GA_icon.png">
    <link href="./css/default.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <div id="wrapper">
        <header>
            <h1>Registro de estudiantes</h1>
            <h2>Datos generales</h2>
            <nav>
                <ul>
                    <li>
                        <a href="./listado.jsp">Lista de estudiantes</a>
                    </li>
                    <li>
                        <a href="./consulta-estudiante.jsp">Formulario de consulta</a>
                    </li>
                </ul>
            </nav>
        </header>
        <div id="contents">
            <div class="info">
                <%
                    Estudiante e = (Estudiante) request.getAttribute("registroEstudiante");
                    if (e != null) {
                %>

                <table class="tablaDatos">
                    <tr>
                        <td class="col1">Id:</td>
                        <td class="col2"><%= e.getId() %></td>
                    </tr>
                    <tr>
                        <td class="col1">Nombre:</td>
                        <td class="col2"><%= e.getNombre() %></td>
                    </tr>
                    <tr>
                        <td class="col1">Apellidos:</td>
                        <td class="col2">
                            <%= e.getApellidos() %>
                        </td>
                    </tr>
                    <tr>
                        <td class="col1">Nacimiento:</td>
                        <td class="col2">
                            <%= e.getNacimiento() %>
                        </td>
                    </tr>
                    <tr>
                        <td class="col1">NRC:</td>
                        <td class="col2">
                            <%= e.getNrc() %>
                        </td>
                    </tr>
                    <tr>
                        <td class="col1">Secuencia:</td> <!-- Agrega una fila para mostrar el campo secuencia -->
                        <td class="col2">
                            <%= e.getSecuencia() %>
                        </td>
                    </tr>
                    <tr>
                        <td class="col1">Clave:</td> <!-- Agrega una fila para mostrar el campo clave -->
                        <td class="col2">
                            <%= e.getClave() %>
                        </td>
                    </tr>
                </table>

                <%
                    } else {
                        String id = request.getParameter("id");
                        if ((id != null) && !id.isEmpty()) {
                %>

                <p class="mensajeError">
                    No se encuentra el registro para el (la) estudiante
                    con la identificación: <strong><%= id %></strong>.
                </p>

                <%
                        } else {
                %>

                <p class="mensajeError">
                    No se indicó la identificación del(la) estudiante a consultar.
                </p>

                <%
                        }
                    }
                %>   
            </div>
        </div>
        <footer></footer>
    </div>
</body>
</html>
