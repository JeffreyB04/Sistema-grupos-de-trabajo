/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto01prograiv.logic;

import com.mycompany.proyecto01prograiv.data.EstudianteDao;
import com.mycompany.proyecto01prograiv.data.GrupoDao;
import com.mycompany.proyecto01prograiv.data.RelDatabase;
import java.sql.SQLException;

public class Service {

    private static Service uniqueInstance;

    public static Service instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Service();
        }
        return uniqueInstance;
    }
    RelDatabase relDatabase;

    EstudianteDao estudianteDao;
    GrupoDao grupoDao;

    private Service() {
        relDatabase = new RelDatabase();
        estudianteDao = new EstudianteDao(relDatabase);
        grupoDao = new GrupoDao(relDatabase);
    }


    public Estudiante estudianteFind(String id, String clave) throws SQLException {
        Estudiante estudiante = estudianteDao.readEstudiante(id, clave);
        return estudiante;
    }

    public Grupo grupoFind(int id) throws SQLException {
        Grupo grupo = grupoDao.readGrupo(id);
        return grupo;
    }


    public void estudianteInsert(Estudiante estudiante) throws SQLException {
        estudianteDao.insertEstudiante(estudiante);
    }

    public void estudianteUpdate(Estudiante estudiante) throws SQLException {
        estudianteDao.updateEstudiante(estudiante);
    }

    public void estudianteDelete(String id) throws SQLException {
        estudianteDao.deleteEstudiante(id);
    }


    public void grupoInsert(Grupo grupo) throws SQLException {
        grupoDao.insertGrupo(grupo);
    }

    public void grupoUpdate(Grupo grupo) throws SQLException {
        grupoDao.updateGrupo(grupo);
    }

    public void grupoDelete(int id) throws SQLException {
        grupoDao.deleteGrupo(id);
    }
}