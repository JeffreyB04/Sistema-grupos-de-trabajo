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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../../css/consultaGrupos.css" rel="stylesheet" type="text/css"/>
        <title>Lista de Grupos</title>
    </head>
    <body>
           <header>
        <nav>
            <ul>
                <li><a href="FormacionGrupos.jsp">Formación de Grupos</a></li>
                 <li>
                   <a href="TablaEstudiante.jsp">Tabla de estudiantes</a>
                </li>
            </ul>
        </nav>
    </header>
        <h1>Lista de Grupos</h1>
        <div class="container">
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
        </div>
    </body>
</html>
