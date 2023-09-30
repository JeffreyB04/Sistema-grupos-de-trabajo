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
import javax.sql.DataSource;

public class Service implements Serializable {
    
    
    private static Service instancia = null;

    private DataSource bd = null;
    private Dao<Estudiante, String> estudianteDAO;
    private Dao<Grupo, Integer> grupoDAO;

    private Service() {
        try {
            InitialContext ctx = new InitialContext();
            bd = (DataSource) ctx.lookup("jdbc/bd_grupos");
            System.out.println("Usando JNDI para acceder a la base de datos..");

        } catch (NamingException | NullPointerException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());

            bd = new MysqlDataSource();
            MysqlDataSource mds = (MysqlDataSource) bd;
            mds.setServerName("localhost");
            mds.setPortNumber(3306);
            mds.setDatabaseName("bd_grupos");
            mds.setUser("root");
            mds.setPassword("root");

            System.out.println("Usando el manejador JDBC para acceder a la base de datos..");
        }
        if (bd != null) {
            try {
                String url = bd.getConnection().getMetaData().getURL();
                System.out.printf("Origen de datos: %s%n", url);

                DataSourceConnectionSource connectionSource = new DataSourceConnectionSource(bd, url);
                estudianteDAO = DaoManager.createDao(connectionSource, Estudiante.class);
                grupoDAO = DaoManager.createDao(connectionSource, Grupo.class);
            } catch (SQLException ex) {
                System.err.printf("Excepción: '%s'%n", ex.getMessage());
            }
        } else {
            System.err.println("No se pudo establecer el origen de datos.");
        }
    }
    
    public Service(Dao<Estudiante, String> estudianteDAO){
        this.estudianteDAO = estudianteDAO;
    }

    public static Service obtenerInstancia() {
        if (instancia == null) {
            instancia = new Service();
        }
        return instancia;
    }
    
    public Dao<Estudiante, String> getEstudianteDAO() {
        return estudianteDAO;
    }

    public Dao<Grupo, Integer> getGrupoDAO() {
        return grupoDAO;
    }

    public int agregarGrupo(Grupo nuevo) throws SQLException {
        return grupoDAO.create(nuevo);
    }

    public Grupo recuperarGrupo(int id) throws SQLException {
        return grupoDAO.queryForId(id);
    }

    public int actualizarGrupo(Grupo grupo) throws SQLException {
        return grupoDAO.update(grupo);
    }

    public int eliminarGrupo(int id) throws SQLException {
        return grupoDAO.deleteById(id);
    }

    public List<Grupo> listarTodosGrupos() throws SQLException {
        return grupoDAO.queryForAll();
    }

    public void actualizarGrupos() {
        grupos.clear();
        try {
            grupos.addAll(listarTodosGrupos());
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public String toStringGrupos() {
        StringBuilder r = new StringBuilder("{");
        actualizar();
        for (Grupo g : grupos) { 
            r.append(String.format("\n\t%s,", g));
        }
        r.append("\n}");
        return r.toString();
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
    
    // se hace un metodo bool para verifcar
    
   //public boolean verificar (String Id, String Clave){
    //boolean r = false;{
    //   Estudiante e = recuperar(id);   
    //r = e.clave().equals(clave);
   //}
//ejm 21
//}

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


    @XmlElementWrapper(name = "estudiantes")
    @XmlElement(name = "estudiante")
    private List<Estudiante> estudiantes = new ArrayList<>();

    @XmlElementWrapper(name = "grupos")
    @XmlElement(name = "grupo")
    private List<Grupo> grupos = new ArrayList<>();

}
