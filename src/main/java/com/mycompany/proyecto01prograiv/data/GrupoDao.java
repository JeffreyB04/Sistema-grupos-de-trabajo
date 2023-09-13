/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto01prograiv.data;

import com.mycompany.proyecto01prograiv.logic.Grupo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GrupoDao {

    RelDatabase db;

    public GrupoDao(RelDatabase db){
        this.db= db;
    }

    public List<Grupo> getAllGrupos() throws SQLException {
        List<Grupo> grupos = new ArrayList<>();
        String query = "SELECT * FROM bd_grupos.grupo";
        try (PreparedStatement preparedStatement = db.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Grupo grupo = new Grupo();
                grupo.setId(resultSet.getInt("id"));
                grupo.setSecuencia(resultSet.getInt("secuencia"));
                grupo.setNombre(resultSet.getString("nombre"));
                grupo.setCupo(resultSet.getInt("cupo"));
                grupo.setActivo(resultSet.getBoolean("activo"));
                grupos.add(grupo);
            }
        }
        return grupos;
    }

    public void insertGrupo(Grupo grupo) throws SQLException {
        String query = "INSERT INTO bd_grupos.grupo (secuencia, nombre, cupo, activo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = db.prepareStatement(query)) {
            preparedStatement.setInt(1, grupo.getSecuencia());
            preparedStatement.setString(2, grupo.getNombre());
            preparedStatement.setInt(3, grupo.getCupo());
            preparedStatement.setBoolean(4, grupo.isActivo());
            preparedStatement.executeUpdate();
        }
    }

    public void updateGrupo(Grupo grupo) throws SQLException {
        String query = "UPDATE bd_grupos.grupo SET secuencia=?, nombre=?, cupo=?, activo=? WHERE id=?";
        try (PreparedStatement preparedStatement = db.prepareStatement(query)) {
            preparedStatement.setInt(1, grupo.getSecuencia());
            preparedStatement.setString(2, grupo.getNombre());
            preparedStatement.setInt(3, grupo.getCupo());
            preparedStatement.setBoolean(4, grupo.isActivo());
            preparedStatement.setInt(5, grupo.getId());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteGrupo(int id) throws SQLException {
        String query = "DELETE FROM bd_grupos.grupo WHERE id=?";
        try (PreparedStatement preparedStatement = db.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
    public Grupo readGrupo(int id) throws SQLException {
    Grupo grupo = null;
    String query = "SELECT * FROM bd_grupos.grupo WHERE id=?";
    try (PreparedStatement preparedStatement = db.prepareStatement(query)) {
        preparedStatement.setInt(1, id);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                grupo = new Grupo();
                grupo.setId(resultSet.getInt("id"));
                grupo.setSecuencia(resultSet.getInt("secuencia"));
                grupo.setNombre(resultSet.getString("nombre"));
                grupo.setCupo(resultSet.getInt("cupo"));
                grupo.setActivo(resultSet.getBoolean("activo"));
            }
        }
    }
    return grupo;
}

}
