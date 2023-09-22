/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto01prograiv;


import com.mycompany.proyecto01prograiv.logic.Service;
/**
 *
 * @author eeor2
 */
public class TestBD {
    
    public static void main(String[] args) {
        new TestBD().test();
    }

    public void test() {
        Service estudiantes = Service.obtenerInstancia();
        System.out.println(estudiantes);
        System.out.println();

        /*try {
            estudiantes.actualizar();
            JAXBContext ctx = JAXBContext.newInstance(Service.class);
            Marshaller mrs = ctx.createMarshaller();
            mrs.setProperty(Marshaller.JAXB_ENCODING, UTF_8.toString());
            mrs.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            mrs.marshal(estudiantes, new FileOutputStream("../estudiantes.xml"));
            System.out.println();

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(java.sql.Date.class, new SqlDateTypeAdapter())
                    .setPrettyPrinting()
                    .create();
            System.out.println(gson.toJson(estudiantes.listarTodos()));
            System.out.println();

        } catch (JAXBException | FileNotFoundException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }*/
    }
    
}
