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
    </head>
    <body>
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
