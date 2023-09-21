package com.mycompany.proyecto01prograiv.servicios;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cr.ac.una.estudiantes.entidades.GestorEstudiantes;
import cr.ac.una.util.conversion.json.SqlDateTypeAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServicioEstudiantes", urlPatterns = {"/ServicioEstudiantes"})
public class ServicioEstudiantes extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            GestorEstudiantes estudiantes = GestorEstudiantes.obtenerInstancia();
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(java.sql.Date.class, new SqlDateTypeAdapter())
                    .setPrettyPrinting()
                    .create();
            out.println(gson.toJson(estudiantes.listarTodos()));
        } catch (Exception ex) {
            System.err.printf("Excepción; '%s'%n", ex.getMessage());
            throw new ServletException(ex.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
