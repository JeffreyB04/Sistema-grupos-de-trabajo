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
package com.mycompany.proyecto01prograiv;

import com.mycompany.proyecto01prograiv.logic.Service;

public class TestBD {

    public static void main(String[] args) {
        new TestBD().test();
    }

    public void test() {
        Service service = Service.obtenerInstancia();
        System.out.println("Estudiantes:");
        System.out.println(service.toString());
        System.out.println();

        System.out.println("Grupos:");
        service.actualizarGrupos(); // Asegúrate de actualizar los grupos
        System.out.println(service.toStringGrupos());
        System.out.println();
    }

}
