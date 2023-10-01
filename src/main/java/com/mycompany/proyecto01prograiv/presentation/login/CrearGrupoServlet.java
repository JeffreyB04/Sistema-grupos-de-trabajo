/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto01prograiv.presentation.login;

import com.mycompany.proyecto01prograiv.logic.Grupo;
import com.mycompany.proyecto01prograiv.logic.Estudiante;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.mycompany.proyecto01prograiv.logic.Service;
import jakarta.servlet.annotation.WebServlet;
import java.sql.SQLException;

//@WebServlet("/crearGrupoServlet")
public class CrearGrupoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener datos del formulario
        String nombreGrupo = request.getParameter("nombreGrupo");
        String estudianteID = request.getParameter("estudianteID");

        // Crear una instancia del servicio
        Service service = Service.obtenerInstancia();

        try {
            // Verificar si el grupo ya existe
            List<Grupo> grupos = service.listarTodosGrupos();
            boolean grupoExistente = false;
            for (Grupo grupo : grupos) {
                if (grupo.getNombre().equals(nombreGrupo)) {
                    grupoExistente = true;
                    break;
                }
            }

            if (!grupoExistente) {
                // Crear un nuevo grupo
                Grupo nuevoGrupo = new Grupo();
                nuevoGrupo.setNombre(nombreGrupo);
                nuevoGrupo.setActivo(true);
                nuevoGrupo.setSecuencia(1); // Puedes establecer la secuencia según tu lógica

                int grupoID = service.agregarGrupo(nuevoGrupo);

                // Actualizar el ID del grupo en el estudiante
                Estudiante estudiante = service.recuperar(estudianteID);
                estudiante.setGrupo_id(Integer.toString(grupoID));
                service.actualizar(estudiante);

                response.sendRedirect("exito.jsp"); // Redirecciona a una página de éxito
            } else {
                response.sendRedirect("error.jsp"); // Redirecciona a una página de error (grupo ya existe)
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Redirecciona a una página de error en caso de excepción
        }
    }
}
