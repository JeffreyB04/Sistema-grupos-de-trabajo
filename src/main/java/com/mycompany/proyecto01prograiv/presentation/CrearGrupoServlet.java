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
import java.util.Random;

public class CrearGrupoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreGrupo = request.getParameter("nombreGrupo");
        String estudianteID = request.getParameter("estudianteID");

        Service service = Service.obtenerInstancia();

        try {
            List<Grupo> grupos = service.listarTodosGrupos();
            boolean grupoExistente = false;
            Grupo grupoEncontrado = null;

            for (Grupo grupo : grupos) {
                if (grupo.getNombre().equals(nombreGrupo)) {
                    grupoExistente = true;
                    grupoEncontrado = grupo;
                    break;
                }
            }

            if (!grupoExistente) {
                Grupo nuevoGrupo = new Grupo();
                nuevoGrupo.setNombre(nombreGrupo);
                nuevoGrupo.setActivo(true);

                Random random = new Random();
                int secuenciaAleatoria = random.nextInt(2000) + 1;
                nuevoGrupo.setSecuencia(secuenciaAleatoria);
                nuevoGrupo.setCupo(1);

                // Guarda el nuevo grupo en la base de datos
                service.agregarGrupo(nuevoGrupo);

                Estudiante estudiante = service.recuperar(estudianteID);

                // Asigna el ID del grupo al estudiante después de agregar el grupo
                estudiante.setGrupo_id(nuevoGrupo.getId());

                service.actualizar(estudiante);

                response.sendRedirect("/Proyecto01PrograIV/presentation/paginasProtegidas/exito.jsp");
        }else {
            if (grupoEncontrado.getCupo() < 5) {
                Estudiante estudiante = service.recuperar(estudianteID);
                estudiante.setGrupo_id(grupoEncontrado.getId());
                service.actualizar(estudiante);

                // Reducir el cupo del grupo en 1
                grupoEncontrado.setCupo(grupoEncontrado.getCupo() - 1);
                service.actualizarGrupo(grupoEncontrado);

                response.sendRedirect("/Proyecto01PrograIV/presentation/paginasProtegidas/exito.jsp");
            } else {
                response.sendRedirect("/Proyecto01PrograIV/presentation/paginasProtegidas/grupoLleno.jsp");
            }
        }
    }
    catch (SQLException e

    
        ) {
        e.printStackTrace();
        response.sendRedirect("/Proyecto01PrograIV/presentation/paginasProtegidas/error.jsp");
    }
}
}
