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
        String codigoGrupo = request.getParameter("codigoGrupo");
        String estudianteIDUnirse = request.getParameter("estudianteIDUnirse");

        int grupoID = Integer.parseInt(codigoGrupo);
        Service service = Service.obtenerInstancia();

        try {
            Grupo grupo = service.recuperarGrupo(grupoID);

            if (grupo != null && grupo.getCupo() < 5) {
                Estudiante estudiante = service.recuperar(estudianteIDUnirse);
                estudiante.setGrupo_id(grupoID);
                service.actualizar(estudiante);

                grupo.setCupo(grupo.getCupo() + 1);
                service.actualizarGrupo(grupo);

                response.sendRedirect("/Proyecto01PrograIV/presentation/paginasProtegidas/exito.jsp");
            } else {
                response.sendRedirect("/Proyecto01PrograIV/presentation/paginasProtegidas/grupoLleno.jsp");
            }
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("/Proyecto01PrograIV/presentation/paginasProtegidas/error.jsp");
        }
    }
}
