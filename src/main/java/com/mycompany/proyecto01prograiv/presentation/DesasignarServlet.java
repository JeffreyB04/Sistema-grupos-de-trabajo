/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto01prograiv.presentation;

import com.mycompany.proyecto01prograiv.logic.Grupo;
import com.mycompany.proyecto01prograiv.logic.Estudiante;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.mycompany.proyecto01prograiv.logic.Service;
import java.sql.SQLException;

/**
 *
 * @author jeffry
 */
public class DesasignarServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String estudianteIDDesasignar = request.getParameter("estudianteIDDesasignar");
        Service service = Service.obtenerInstancia();

        try {
            Estudiante estudiante = service.recuperar(estudianteIDDesasignar);

            if (estudiante != null) {
                int grupoID = estudiante.getGrupo_id();

                // Desasignar al estudiante del grupo
                estudiante.setGrupo_id(null);

                service.actualizar(estudiante);

                Grupo grupo = service.recuperarGrupo(grupoID);
                grupo.setCupo(grupo.getCupo() - 1);
                service.actualizarGrupo(grupo);

                if (grupo.getCupo() < 1) {
                    service.eliminarGrupo(grupoID);
                }

                response.sendRedirect("/Proyecto01PrograIV/presentation/paginasProtegidas/exitoDesasignar.jsp");
            } else {
                response.sendRedirect("/Proyecto01PrograIV/presentation/paginasProtegidas/errorDesasignar.jsp");
            }
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("/Proyecto01PrograIV/presentation/paginasProtegidas/error.jsp");
        }
    }
}
