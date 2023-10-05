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

import com.mycompany.proyecto01prograiv.logic.Estudiante;
import com.mycompany.proyecto01prograiv.logic.Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ConsultaGrupoTrabajoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreGrupoTrabajo = request.getParameter("nombreGrupoTrabajo");

        Service service = Service.obtenerInstancia();

        try {
            // Consultar la lista de estudiantes asociados al grupo de trabajo por nombre
            List<Estudiante> estudiantes = service.obtenerEstudiantesPorGrupoTrabajo(nombreGrupoTrabajo);

            if (!estudiantes.isEmpty()) {
                request.setAttribute("nombreGrupoTrabajo", nombreGrupoTrabajo);
                request.setAttribute("estudiantes", estudiantes);
                request.getRequestDispatcher("/Proyecto01PrograIV/presentation/resultadoConsultaGrupoTrabajo.jsp").forward(request, response);
            } else {
                request.setAttribute("mensaje", "No se encontraron estudiantes asociados al grupo de trabajo " + nombreGrupoTrabajo);
                request.getRequestDispatcher("/Proyecto01PrograIV/presentation/errorConsultaGrupoTrabajo.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/Proyecto01PrograIV/presentation/error.jsp");
        }
    }
}
