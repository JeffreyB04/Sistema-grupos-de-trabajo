<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.mycompany.proyecto01prograiv.logic.Service" %>
<%@ page import="com.mycompany.proyecto01prograiv.logic.Estudiante" %>
<%@ page import="java.util.List" %>

<%
    Service service = Service.obtenerInstancia();
    List<Estudiante> estudiantes = service.listarTodos();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Lista de Estudiantes</title>
        <link href="../../css/tablaEstudiante.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="box">
            <a class="button" href="#popup1">Cambiar clave</a>
        </div>
        <div>
            <form action="${pageContext.request.contextPath}/Controller" method="post">
                <input type="hidden" name="action" value="logout">
                <input type="submit" value="Cerrar sesión">
            </form>

        </div>

        <div id="popup1" class="overlay">
            <div class="popup">
                <h2>Cambiar Clave</h2>
                <a class="close" href="#">&times;</a>
                <div class="content">
                    <c:if test="${not empty errorMessage}">
                        <p class="error-message">${errorMessage}</p>
                    </c:if>

                    <form name="changePassFrom" action="${pageContext.request.contextPath}/Controller" method="post">
                        <input type="hidden" name="action" value="cambiarClave">
                        <label for="claveActual">Ingrese clave actual:</label>
                        <input type="text" id="claveActual" name="claveActual" required><br><br>

                        <label for="nuevaClave">Ingrese nueva clave:</label>
                        <input type="password" id="nuevaClave" name="clave" required><br><br>

                        <input type="submit" value="Aplicar">
                    </form>
                </div>
            </div>
        </div>
        <h1>Lista de Estudiantes</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>NRC</th>
                <th>Apellidos</th>
                <th>Nombre</th>
                <th>Secuencia</th>
                <th>Grupo ID</th>
            </tr>
            <%
                for (Estudiante estudiante : estudiantes) {
            %>
            <tr>
                <td><%= estudiante.getId() %></td>
                <td><%= estudiante.getNrc() %></td>
                <td><%= estudiante.getApellidos() %></td>
                <td><%= estudiante.getNombre() %></td>
                <td><%= estudiante.getSecuencia() %></td>
                <td><%= estudiante.getGrupo_id() %></td>
            </tr>
            <%
                }
            %>
        </table>
        <a href="FormacionGrupos.jsp">Ir a Formación de Grupos</a>
        <br>
        <a href="ConsultaGrupos.jsp">Consultar Grupos</a>
        
    </body>
</html>
