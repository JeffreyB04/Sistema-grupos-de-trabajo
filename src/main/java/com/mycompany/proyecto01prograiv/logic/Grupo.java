/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto01prograiv.logic;

public class Grupo {

    private int id;
    private int secuencia;
    private String nombre;
    private int cupo;
    private boolean activo;

    public Grupo() {
        // Constructor vacío
    }

    public Grupo(int id, int secuencia, String nombre, int cupo, boolean activo) {
        this.id = id;
        this.secuencia = secuencia;
        this.nombre = nombre;
        this.cupo = cupo;
        this.activo = activo;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Grupo [id=" + id + ", secuencia=" + secuencia + ", nombre=" + nombre + ", cupo=" + cupo + ", activo="
                + activo + "]";
    }
}
