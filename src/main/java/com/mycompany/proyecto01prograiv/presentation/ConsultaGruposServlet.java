/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto01prograiv.presentation;

import com.mycompany.proyecto01prograiv.logic.Grupo;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.mycompany.proyecto01prograiv.logic.Service;
import java.sql.SQLException;

//@WebServlet("/consultaGruposServlet")
public class ConsultaGruposServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener una instancia de Service
        Service service = Service.obtenerInstancia();

        try {
            // Obtener la lista de todos los grupos
            List<Grupo> grupos = service.listarTodosGrupos();

            // Agregar la lista de grupos al ámbito de solicitud para que el JSP pueda acceder a ella
            request.setAttribute("grupos", grupos);

            // Redireccionar a la página JSP de consulta de grupos
            request.getRequestDispatcher("ConsultaGrupos.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de errores en caso de excepción
            response.sendRedirect("error.jsp");
        }
    }
}
