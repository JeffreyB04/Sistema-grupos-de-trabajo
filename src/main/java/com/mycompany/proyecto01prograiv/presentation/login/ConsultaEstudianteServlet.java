/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto01prograiv.presentation.login;

import com.mycompany.proyecto01prograiv.logic.Grupo;
import com.mycompany.proyecto01prograiv.logic.Estudiante;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.mycompany.proyecto01prograiv.logic.Service;
import jakarta.servlet.annotation.WebServlet;
import java.sql.SQLException;

/**
 *
 * @author jeffr
 */
public class ConsultaEstudianteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String estudianteID = request.getParameter("estudianteID");

        Service service = Service.obtenerInstancia();

        try {
            // Consultar si el estudiante está incluido en algún grupo
            Estudiante estudiante = service.recuperar(estudianteID);

            if (estudiante != null && estudiante.getGrupo_id() != null) {
                // El estudiante está incluido en un grupo
                request.setAttribute("resultado", "El estudiante está incluido en un grupo.");
            } else {
                // El estudiante no está incluido en ningún grupo
                request.setAttribute("resultado", "El estudiante no está incluido en ningún grupo.");
            }

            request.getRequestDispatcher("resultadoConsulta.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Redirecciona a una página de error en caso de excepción
        }
    }
}
