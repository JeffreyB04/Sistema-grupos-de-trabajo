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
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.mycompany.proyecto01prograiv.logic.Service" %>
<%@ page import="com.mycompany.proyecto01prograiv.logic.Grupo" %>
<%@ page import="java.util.List" %>

<%
    Service service = Service.obtenerInstancia();
    List<Grupo> grupos = service.listarTodosGrupos();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Lista de Grupos</title>
    </head>
    <body>
        <h1>Lista de Grupos</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Secuencia</th>
                <th>Nombre</th>
                <th>Cupo</th>
                <th>Activo</th>
            </tr>
            <% out.println("Número de grupos en la lista: " + grupos.size()); %>

            <%
                for (Grupo grupo : grupos) {
            %>
                <tr>
                    <td><%= grupo.getId() %></td>
                    <td><%= grupo.getSecuencia() %></td>
                    <td><%= grupo.getNombre() %></td>
                    <td><%= grupo.getCupo() %></td>
                    <td><%= grupo.isActivo() %></td>
                </tr>
            <%
                }
            %>
        </table>
        <a href="FormacionGrupos.jsp">Ir a Formación de Grupos</a>
        <br>
        <a href="TablaEstudiante.jsp">Tabla de estudiantes</a>
    </body>
</html>
