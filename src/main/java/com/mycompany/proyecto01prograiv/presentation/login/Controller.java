/**
 * -------------------------------------------------------------------
 *
 * (c) 2023
 *
 * @author: Jeffry Barquero Torres
 * @author: Jennifer Mejías Salazar 
 * @author: Eduardo Orellana Rivas
 * @version 1.0.0 2023-10-07
 *
 * --------------------------------------------------------------------
 */
package com.mycompany.proyecto01prograiv.presentation.login;

import com.j256.ormlite.dao.Dao;
import com.mycompany.proyecto01prograiv.logic.Estudiante;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.mycompany.proyecto01prograiv.logic.Service;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;

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
        
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "login":
                    login(request, response);
                    break;
                    
                case "cambiarClave":
                    cambiarClave(request, response);
                    break;
                    
                case "logout":
                    logout(request, response);
                    break;
                    
                default:
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    response.getWriter().println("Acción desconocida");
            }
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Se requiere un parámetro 'action'");
        }
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
     private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String clave = request.getParameter("clave");

        Service service = Service.obtenerInstancia();

        try {
            if (service != null) {
                Dao<Estudiante, String> estudianteDAO = service.getEstudianteDAO();

                if (estudianteDAO != null) {
                    Estudiante estudiante = service.getEstudianteDAO().queryForId(id);

                    if (estudiante != null && estudiante.getClave() != null && estudiante.getClave().equals(clave)) {
                        HttpSession session = request.getSession();
                        session.setAttribute("loggedInUser", estudiante);
                        response.sendRedirect("/Proyecto01PrograIV/presentation/paginasProtegidas/TablaEstudiante.jsp");
                        System.out.println(estudiante);
                    } else {
                        System.out.println("Invalid id or clave");
                        request.setAttribute("errorMessage", "Invalido id o clave");
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/presentation/login/View.jsp");
                        dispatcher.forward(request, response);
                    }
                } else {
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "No se pudo acceder a la base de datos.");
                }
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "No se pudo inicializar el servicio.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect(request.getContextPath() + "/Index.jsp");
    }

    
    private void cambiarClave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Estudiante loggedInUser = (Estudiante) session.getAttribute("loggedInUser");

        if (loggedInUser != null) {
            String id = loggedInUser.getId();
            String contraseñaActual = request.getParameter("claveActual");
            String nuevaContraseña = request.getParameter("clave");

            Service service = Service.obtenerInstancia();
            try {
                if (service != null) {
                    Dao<Estudiante, String> estudianteDAO = service.getEstudianteDAO();
                    Estudiante estudiante = estudianteDAO.queryForId(id);
                    
                    if (estudiante != null && estudiante.getClave().equals(contraseñaActual)) {
                        estudianteDAO.updateRaw("UPDATE estudiante SET clave = ? WHERE id = ?", nuevaContraseña, id);
                        response.sendRedirect("/Proyecto01PrograIV/presentation/paginasProtegidas/TablaEstudiante.jsp");
                        System.out.println(estudiante);
                    } else {
                        request.setAttribute("errorMessage", "Contraseña actual incorrecta");
                    }
                    
                }else{
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "No se pudo inicializar el servicio.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
