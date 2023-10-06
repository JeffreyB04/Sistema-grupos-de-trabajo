/**
* -------------------------------------------------------------------
*
* (c) 2023
*
* @author: Jeffry Barquero Torres
* @author: 
* @author: 
* @version 1.0.0 2023-10-07
*
* --------------------------------------------------------------------
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

public class UnirseGrupoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            response.sendRedirect("/Proyecto01PrograIV/presentation/error.jsp");
            return;
        }

        Service service = Service.obtenerInstancia();

        try {
            if (action.equals("unirse")) {
                String codigoGrupo = request.getParameter("codigoGrupo");
                String estudianteIDUnirse = request.getParameter("estudianteIDUnirse");

                int grupoID = Integer.parseInt(codigoGrupo);
                Grupo grupo = service.recuperarGrupo(grupoID);

                if (grupo != null) {
                    if (grupo.getCupo() < 5) {
                        Estudiante estudiante = service.recuperar(estudianteIDUnirse);
                        estudiante.setGrupo_id(grupoID);
                        service.actualizar(estudiante);

                        grupo.setCupo(grupo.getCupo() + 1);
                        service.actualizarGrupo(grupo);

                        response.sendRedirect("/Proyecto01PrograIV/presentation/exito.jsp");
                    } else {
                        response.sendRedirect("/Proyecto01PrograIV/presentation//Proyecto01PrograIV/presentation/grupoLleno.jsp");
                    }
                } else {
                    response.sendRedirect("/Proyecto01PrograIV/presentation/grupoNoExiste.jsp");
                }
            } else if (action.equals("desasignar")) {
                String estudianteIDDesasignar = request.getParameter("estudianteIDDesasignar");

                Estudiante estudiante = service.recuperar(estudianteIDDesasignar);

                if (estudiante != null) {
                    int grupoID = estudiante.getGrupo_id();

                    estudiante.setGrupo_id(0);
                    service.actualizar(estudiante);

                    int grupoIdInt = grupoID;
                    Grupo grupo = service.recuperarGrupo(grupoIdInt);
                    grupo.setCupo(grupo.getCupo() - 1);
                    service.actualizarGrupo(grupo);

                    if (grupo.getCupo() == 0) {
                        service.eliminarGrupo(grupoIdInt);
                    }

                    response.sendRedirect("/Proyecto01PrograIV/presentation/exitoDesasignar.jsp");
                } else {
                    response.sendRedirect("/Proyecto01PrograIV/presentation/errorDesasignar.jsp");
                }
            } else {
                response.sendRedirect("/Proyecto01PrograIV/presentation/error.jsp");
            }
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("/Proyecto01PrograIV/presentation/error.jsp");
        }
    }
}
