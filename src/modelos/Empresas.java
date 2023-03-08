package modelos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "Empresas")
public class Empresas implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1799531894432940281L;
	private String cif;
    private String nombre;
    private String dirección;
    private String teléfono;
    private Set<Empleados> empleados = new HashSet<Empleados>(0);

    public Empresas() {
    }

    public Empresas(String cif, String nombre, String dirección, String teléfono) {
        this.cif = cif;
        this.nombre = nombre;
        this.dirección = dirección;
        this.teléfono = teléfono;
    }

    @Id
    @Column(name = "cif", unique = true, nullable = false)
    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    @Column(name = "nombre", length = 100)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "direccion", length = 100)
    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    @Column(name = "telefono", length = 15)
    public String getTeléfono() {
        return teléfono;
    }

    public void setTeléfono(String teléfono) {
        this.teléfono = teléfono;
    }


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "empresa")
    public Set <Empleados> getEmpleados() {
        return this.empleados;
    }

    public void setEmpleados(Set <Empleados> empleados) {
        this.empleados = empleados;
    }
}