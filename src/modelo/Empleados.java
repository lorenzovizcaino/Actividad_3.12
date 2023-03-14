package modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Empleados")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Empleados implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8963821792569445991L;

	private String dni;

    private String nombre;

    private String telefono;
    private Empresas empresa;

    protected float porcentaRetencion;

   @Id
   @Column(name = "dni", unique = true,nullable = false)
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

   @Column(name="nombre", length = 50)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name="telefono", length = 15)
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //lado propietario el lado n, es el que tiene la foreign key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cif", nullable = false)
    public Empresas getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresas empresa) {
        this.empresa = empresa;
    }

    @Column(name="porcentajeRetenciones", length = 10)
    public float getPorcentaRetencion() {
        return porcentaRetencion;
    }

    public void setPorcentaRetencion(float porcentaRetencion) {
        this.porcentaRetencion = porcentaRetencion;
    }

    public abstract void calculoNomina();

    @Override
    public String toString() {
        return "Empleados{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", empresa=" + empresa.getNombre() +
                ", porcentaRetencion=" + porcentaRetencion +
                '}';
    }
}
