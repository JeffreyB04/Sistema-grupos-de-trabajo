/**
 * -------------------------------------------------------------------
 *
 * (c) 2023
 *
 * @author: Jeffry Barquero Torres
 * @author: Jennifer Mejías Salazar 
 * @author: Eduardo Orellana Rivas
 * @version 1.0.0 2023-10-07
 *
 * --------------------------------------------------------------------
 */
package com.mycompany.proyecto01prograiv.logic;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@DatabaseTable(tableName = "grupo")
public class Grupo implements Serializable {

    @Getter
    @Setter
    @DatabaseField(generatedId = true) // Indica que es una clave primaria generada automáticamente
    private int id;

    @Getter
    @Setter
    @DatabaseField
    private int secuencia;

    @Getter
    @Setter
    @DatabaseField
    private String nombre;

    @Getter
    @Setter
    @DatabaseField
    private int cupo;

    @Getter
    @Setter
    @DatabaseField
    private boolean activo;
}
