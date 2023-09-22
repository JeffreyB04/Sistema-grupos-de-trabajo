/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto01prograiv.logic;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.DataSourceConnectionSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Service implements Serializable {
    
    private Service() {
        try {
            InitialContext ctx = new InitialContext();
            bd = (MysqlDataSource) ctx.lookup("jdbc/bd_grupos");
            System.out.println("Usando JNDI para acceder a la base de datos..");

        } catch (NamingException | NullPointerException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());

            bd = new MysqlDataSource();
            bd.setServerName("localhost");
            bd.setPortNumber(3306);
            bd.setDatabaseName("bd_grupos");
            bd.setUser("root");
            bd.setPassword("root");

            System.out.println("Usando el manejador JDBC para acceder a la base de datos..");
        }

        if (bd != null) {
            System.out.printf("Origen de datos: %s%n", bd.getURL());
        } else {
            System.err.println("No se pudo establecer el origen de datos.");
        }
        System.out.println();

        try {
            DataSourceConnectionSource connectionSource
                    = new DataSourceConnectionSource(bd, bd.getURL());
            estudianteDAO = DaoManager.createDao(connectionSource, Estudiante.class);
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public static Service obtenerInstancia() {
        if (instancia == null) {
            instancia = new Service();
        }
        return instancia;
    }

    public int agregar(Estudiante nuevo) throws SQLException {
        return estudianteDAO.create(nuevo);
    }

    public Estudiante recuperar(String id) throws SQLException {
        return estudianteDAO.queryForId(id);
    }

    public int actualizar(Estudiante estudiante) throws SQLException {
        return estudianteDAO.update(estudiante);
    }

    public int eliminar(String id) throws SQLException {
        return estudianteDAO.deleteById(id);
    }

    public List<Estudiante> listarTodos() throws SQLException {
        return estudianteDAO.queryForAll();
    }

    public void actualizar() {
        estudiantes.clear();
        try {
            estudiantes.addAll(listarTodos());
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder("{");
        actualizar();
        for (Estudiante e : estudiantes) {
            r.append(String.format("\n\t%s,", e));
        }
        r.append("\n}");
        return r.toString();
    }

    private static Service instancia = null;

    private MysqlDataSource bd = null;
    private Dao<Estudiante, String> estudianteDAO;

    @XmlElementWrapper(name = "estudiantes")
    @XmlElement(name = "estudiante")
    private List<Estudiante> estudiantes = new ArrayList<>();
    
}
