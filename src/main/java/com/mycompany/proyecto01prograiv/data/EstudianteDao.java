/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto01prograiv.data;

import com.mycompany.proyecto01prograiv.logic.Estudiante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDao {

    RelDatabase db;

    public EstudianteDao(RelDatabase db){
        this.db= db;
    }
    public List<Estudiante> getAllEstudiantes() throws SQLException {
        List<Estudiante> estudiantes = new ArrayList<>();
        String query = "SELECT * FROM bd_grupos.estudiante";
        try (PreparedStatement preparedStatement = db.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setId(resultSet.getString("id"));
                estudiante.setNrc(resultSet.getInt("nrc"));
                estudiante.setApellidos(resultSet.getString("apellidos"));
                estudiante.setNombre(resultSet.getString("nombre"));
                estudiante.setSecuencia(resultSet.getInt("secuencia"));
                estudiante.setClave(resultSet.getString("clave"));
                estudiante.setUltimoAcceso(resultSet.getTimestamp("ultimo_acceso"));
                estudiante.setGrupoId(resultSet.getInt("grupo_id"));
                estudiantes.add(estudiante);
            }
        }
        return estudiantes;
    }

    public void insertEstudiante(Estudiante estudiante) throws SQLException {
        String query = "INSERT INTO bd_grupos.estudiante (id, nrc, apellidos, nombre, secuencia, clave, grupo_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = db.prepareStatement(query)) {
            preparedStatement.setString(1, estudiante.getId());
            preparedStatement.setInt(2, estudiante.getNrc());
            preparedStatement.setString(3, estudiante.getApellidos());
            preparedStatement.setString(4, estudiante.getNombre());
            preparedStatement.setInt(5, estudiante.getSecuencia());
            preparedStatement.setString(6, estudiante.getClave());
            preparedStatement.setInt(7, estudiante.getGrupoId());
            preparedStatement.executeUpdate();
        }
    }

    public void updateEstudiante(Estudiante estudiante) throws SQLException {
        String query = "UPDATE bd_grupos.estudiante SET nrc=?, apellidos=?, nombre=?, secuencia=?, clave=?, grupo_id=? " +
                "WHERE id=?";
        try (PreparedStatement preparedStatement = db.prepareStatement(query)) {
            preparedStatement.setInt(1, estudiante.getNrc());
            preparedStatement.setString(2, estudiante.getApellidos());
            preparedStatement.setString(3, estudiante.getNombre());
            preparedStatement.setInt(4, estudiante.getSecuencia());
            preparedStatement.setString(5, estudiante.getClave());
            preparedStatement.setInt(6, estudiante.getGrupoId());
            preparedStatement.setString(7, estudiante.getId());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteEstudiante(String id) throws SQLException {
        String query = "DELETE FROM bd_grupos.estudiante WHERE id=?";
        try (PreparedStatement preparedStatement = db.prepareStatement(query)) {
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        }
    }
    public Estudiante readEstudiante(String id) throws SQLException {
    Estudiante estudiante = null;
    String query = "SELECT * FROM bd_grupos.estudiante WHERE id=?";
    try (PreparedStatement preparedStatement = db.prepareStatement(query)) {
        preparedStatement.setString(1, id);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                estudiante = new Estudiante();
                estudiante.setId(resultSet.getString("id"));
                estudiante.setNrc(resultSet.getInt("nrc"));
                estudiante.setApellidos(resultSet.getString("apellidos"));
                estudiante.setNombre(resultSet.getString("nombre"));
                estudiante.setSecuencia(resultSet.getInt("secuencia"));
                estudiante.setClave(resultSet.getString("clave"));
                estudiante.setUltimoAcceso(resultSet.getTimestamp("ultimo_acceso"));
                estudiante.setGrupoId(resultSet.getInt("grupo_id"));
            }
        }
    }
    return estudiante;
}

}
