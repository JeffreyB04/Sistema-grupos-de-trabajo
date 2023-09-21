package cr.ac.una.estudiantes.entidades;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cr.ac.una.util.conversion.xml.SqlDateAdapter;
import jakarta.xml.bind.annotation.XmlType;
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
@XmlType
@DatabaseTable(tableName = "estudiante")
public class Estudiante implements Serializable {

    @Getter
    @Setter
    @DatabaseField(id = true)
    private String id;
    
    @Getter
    @Setter
    @DatabaseField(columnName = "apellidos")
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
    @DatabaseField(columnName = "grupo_id")
    private int grupoId;
    
    @Getter
    @Setter
    @DatabaseField(columnName = "nrc") // Agrega el campo nrc
    private int nrc;
    
    @Getter
    @Setter
    @DatabaseField(columnName = "ultimo_acceso") // Agrega el campo ultimo_acceso
    private java.sql.Timestamp ultimoAcceso;

    public java.sql.Date getNacimiento() {
        return nacimiento;
    }

    @XmlJavaTypeAdapter(SqlDateAdapter.class)
    public void setNacimiento(java.sql.Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    @DatabaseField(columnName = "nacimiento") // Agrega el campo nacimiento
    private java.sql.Date nacimiento;
}