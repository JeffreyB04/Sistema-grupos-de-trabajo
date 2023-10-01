/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto01prograiv.presentation.login;

import com.mycompany.proyecto01prograiv.logic.Estudiante;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import com.mycompany.proyecto01prograiv.logic.Service;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;

//Cambiar la clave de un usuario (estudiante
/**
 *
 * @author jeffr
 */
//@WebServlet("/Controller")
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String clave = request.getParameter("clave");

        Service service = Service.obtenerInstancia();

        try {
            if (service != null) {
                Service estudianteDAO = (Service) service.getEstudianteDAO();

                if (estudianteDAO != null) {
                    Estudiante estudiante = service.getEstudianteDAO().queryForId(id);

                    if (estudiante != null && estudiante.getClave() != null && estudiante.getClave().equals(clave)) {
                        HttpSession session = request.getSession();
                        session.setAttribute("loggedInUser", estudiante);
                        response.sendRedirect("TablaEstudiante.jsp");
                    } else {
                        request.setAttribute("errorMessage", "Invalid id or clave");
                        RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
                        dispatcher.forward(request, response);
                    }
                } else {
                    // Manejo de error si estudianteDAO es nulo
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "No se pudo acceder a la base de datos.");
                }
            } else {
                // Manejo de error si service es nulo
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "No se pudo inicializar el servicio.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the database error appropriately
        }

        /*try {
            Estudiante estudiante = service.getEstudianteDAO().queryForId(id);

            if (estudiante != null && estudiante.getClave().equals(clave)) {
                HttpSession session = request.getSession();
                session.setAttribute("loggedInUser", estudiante);
                response.sendRedirect("TablaEstudiante.jsp");
            } else {
                request.setAttribute("errorMessage", "Invalid id or clave");
                RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the database error appropriately
        }*/
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
