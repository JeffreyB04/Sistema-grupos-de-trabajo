package com.mycompany.proyecto01prograiv.presentation;

import com.mycompany.proyecto01prograiv.logic.Grupo;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.mycompany.proyecto01prograiv.logic.Service;
import java.sql.SQLException;

public class ConsultaGruposServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service service = Service.obtenerInstancia();

        try {
            List<Grupo> grupos = service.listarTodosGrupos();
            request.setAttribute("grupos", grupos);
            request.getRequestDispatcher("ConsultaGrupos.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
