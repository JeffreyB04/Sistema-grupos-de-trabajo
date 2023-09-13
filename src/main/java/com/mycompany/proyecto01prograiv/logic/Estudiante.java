/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto01prograiv.logic;

import java.sql.Timestamp;

public class Estudiante {

    private String id;
    private int nrc;
    private String apellidos;
    private String nombre;
    private int secuencia;
    private String clave;
    private Timestamp ultimoAcceso;
    private int grupoId;

    public Estudiante() {
        // Constructor vacío
    }

    public Estudiante(String id, int nrc, String apellidos, String nombre, int secuencia, String clave,
            Timestamp ultimoAcceso, int grupoId) {
        this.id = id;
        this.nrc = nrc;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.secuencia = secuencia;
        this.clave = clave;
        this.ultimoAcceso = ultimoAcceso;
        this.grupoId = grupoId;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNrc() {
        return nrc;
    }

    public void setNrc(int nrc) {
        this.nrc = nrc;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Timestamp getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(Timestamp ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }

    public int getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(int grupoId) {
        this.grupoId = grupoId;
    }

    @Override
    public String toString() {
        return "Estudiante [id=" + id + ", nrc=" + nrc + ", apellidos=" + apellidos + ", nombre=" + nombre
                + ", secuencia=" + secuencia + ", clave=" + clave + ", ultimoAcceso=" + ultimoAcceso + ", grupoId="
                + grupoId + "]";
    }
}
