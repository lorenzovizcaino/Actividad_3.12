package modelo;

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
    private String direccion;
    private String telefono;
    private Set<Empleados> empleados = new HashSet<Empleados>(0);

    public Empresas() {
    }

    public Empresas(String cif, String nombre, String direccion, String telefono) {
        this.cif = cif;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
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
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Column(name = "telefono", length = 15)
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    @OneToMany(fetch = FetchType.EAGER,mappedBy = "empresa", cascade=CascadeType.ALL)
    public Set <Empleados> getEmpleados() {
        return this.empleados;
    }

    public void setEmpleados(Set <Empleados> empleados) {
        this.empleados = empleados;
    }



    @Override
    public String toString() {
        return "Empresas{" +
                "cif='" + cif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}