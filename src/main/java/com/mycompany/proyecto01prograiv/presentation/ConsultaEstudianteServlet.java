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
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.mycompany.proyecto01prograiv.logic.Service;

public class ConsultaEstudianteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String estudianteID = request.getParameter("estudianteID");

        Service service = Service.obtenerInstancia();

        try {
            Estudiante estudiante = service.recuperar(estudianteID);

            if (estudiante != null && estudiante.getGrupo_id() != 0) {
                request.setAttribute("resultado", "El estudiante está incluido en un grupo.");
            } else {
                request.setAttribute("resultado", "El estudiante no está incluido en ningún grupo.");
            }

            request.getRequestDispatcher("/Proyecto01PrograIV/presentation/resultadoConsulta.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/Proyecto01PrograIV/presentation/error.jsp");
        }
    }
}
