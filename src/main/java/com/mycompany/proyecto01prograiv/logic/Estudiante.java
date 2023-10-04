package com.mycompany.proyecto01prograiv.logic;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
//import com.mycompany.proyecto01prograiv.xml.SqlDateAdapter;
import cr.ac.una.util.conversion.xml.SqlDateAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@DatabaseTable(tableName = "estudiante")
public class Estudiante implements Serializable {

    @Getter
    @Setter
    @DatabaseField(id = true)
    private String id;

    @Getter
    @Setter
    @DatabaseField
    private int nrc;

    @Getter
    @Setter
    @DatabaseField
    private String apellidos;

    @Getter
    @Setter
    @DatabaseField
    private String nombre;

    @Getter
    @Setter
    @DatabaseField
    private int secuencia;

    @Getter
    @Setter
    @DatabaseField
    private String clave;

    @Getter
    @Setter
    @DatabaseField
    private int grupo_id;

    public java.sql.Date getNacimiento() {
        return ultimo_acceso;
    }

    @XmlJavaTypeAdapter(SqlDateAdapter.class)
    public void setNacimiento(java.sql.Date ultimo_acceso) {
        this.ultimo_acceso = ultimo_acceso;
    }

    @DatabaseField
    private java.sql.Date ultimo_acceso;
}
