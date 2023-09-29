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
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jeffr
 */
public class Controller extends HttpServlet {
 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        Estudiante estudiante = service.estudianteDAO.queryForId(id);

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
    }
}

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
