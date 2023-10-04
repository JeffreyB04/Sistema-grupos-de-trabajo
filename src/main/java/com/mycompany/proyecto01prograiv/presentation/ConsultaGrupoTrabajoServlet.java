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
                request.getRequestDispatcher("resultadoConsultaGrupoTrabajo.jsp").forward(request, response);
            } else {
                request.setAttribute("mensaje", "No se encontraron estudiantes asociados al grupo de trabajo " + nombreGrupoTrabajo);
                request.getRequestDispatcher("errorConsultaGrupoTrabajo.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
