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
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.mycompany.proyecto01prograiv.logic.Service;
import java.sql.SQLException;

public class CrearGrupoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreGrupo = request.getParameter("nombreGrupo");
        String estudianteID = request.getParameter("estudianteID");

        Service service = Service.obtenerInstancia();

        try {
            List<Grupo> grupos = service.listarTodosGrupos();
            boolean grupoExistente = false;
            for (Grupo grupo : grupos) {
                if (grupo.getNombre().equals(nombreGrupo)) {
                    grupoExistente = true;
                    break;
                }
            }

            if (!grupoExistente) {
                Grupo nuevoGrupo = new Grupo();
                nuevoGrupo.setNombre(nombreGrupo);
                nuevoGrupo.setActivo(true);
                nuevoGrupo.setSecuencia(1);

                int grupoID = service.agregarGrupo(nuevoGrupo);

                Estudiante estudiante = service.recuperar(estudianteID);
                estudiante.setGrupo_id(grupoID);
                service.actualizar(estudiante);

                response.sendRedirect("/Proyecto01PrograIV/presentation/exito.jsp");
            } else {
                response.sendRedirect("/Proyecto01PrograIV/presentation/error.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("/Proyecto01PrograIV/presentation/error.jsp");
        }
    }
}
