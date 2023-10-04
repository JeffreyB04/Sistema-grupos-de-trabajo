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

//@WebServlet("/unirseGrupoServlet")
public class UnirseGrupoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        // Validar el parámetro de acción
        if (action == null) {
            response.sendRedirect("error.jsp");
            return;
        }

        Service service = Service.obtenerInstancia();

        try {
            if (action.equals("unirse")) {
                // Lógica para unirse a un grupo
                String codigoGrupo = request.getParameter("codigoGrupo");
                String estudianteIDUnirse = request.getParameter("estudianteIDUnirse");

                // Verificar si el grupo existe
                int grupoID = Integer.parseInt(codigoGrupo);
                Grupo grupo = service.recuperarGrupo(grupoID);

                if (grupo != null) {
                    // Verificar si el grupo tiene menos de 5 estudiantes (según el límite)
                    if (grupo.getCupo() < 5) {
                        // Actualizar el ID del grupo en el estudiante
                        Estudiante estudiante = service.recuperar(estudianteIDUnirse);
                        estudiante.setGrupo_id(Integer.toString(grupoID));
                        service.actualizar(estudiante);

                        // Incrementar el cupo del grupo
                        grupo.setCupo(grupo.getCupo() + 1);
                        service.actualizarGrupo(grupo);

                        response.sendRedirect("exito.jsp"); // Redirecciona a una página de éxito
                    } else {
                        response.sendRedirect("grupoLleno.jsp"); // Redirecciona a una página de grupo lleno
                    }
                } else {
                    response.sendRedirect("grupoNoExiste.jsp"); // Redirecciona a una página de grupo inexistente
                }
            } else if (action.equals("desasignar")) {
                // Lógica para desasignar a un estudiante de un grupo
                String estudianteIDDesasignar = request.getParameter("estudianteIDDesasignar");

                Estudiante estudiante = service.recuperar(estudianteIDDesasignar);

                if (estudiante != null) {
                    // Obtener el ID del grupo
                    String grupoID = estudiante.getGrupo_id();

                    // Desasignar al estudiante del grupo
                    estudiante.setGrupo_id(null);
                    service.actualizar(estudiante);

                    // Disminuir el cupo del grupo
                    int grupoIdInt = Integer.parseInt(grupoID);
                    Grupo grupo = service.recuperarGrupo(grupoIdInt);
                    grupo.setCupo(grupo.getCupo() - 1);
                    service.actualizarGrupo(grupo);

                    // Verificar si el grupo quedará sin estudiantes
                    if (grupo.getCupo() == 0) {
                        // Eliminar el grupo si no hay más estudiantes
                        service.eliminarGrupo(grupoIdInt);
                    }

                    response.sendRedirect("exitoDesasignar.jsp"); // Redirecciona a una página de éxito de desasignación
                } else {
                    response.sendRedirect("errorDesasignar.jsp"); // Redirecciona a una página de error de desasignación
                }
            } else {
                response.sendRedirect("error.jsp");
            }
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Redirecciona a una página de error en caso de excepción
        }
    }
}
