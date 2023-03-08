package modelos;

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

    private String teléfono;
    private Empresas empresa;

    protected float porcentaRetención;

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
    public String getTeléfono() {
        return teléfono;
    }

    public void setTeléfono(String teléfono) {
        this.teléfono = teléfono;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cif", nullable = false)
    public Empresas getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresas empresa) {
        this.empresa = empresa;
    }

    @Column(name="porcentajeRetenciones", length = 10)
    public float getPorcentaRetención() {
        return porcentaRetención;
    }

    public void setPorcentaRetención(float porcentaRetención) {
        this.porcentaRetención = porcentaRetención;
    }

    public abstract void calculoNomina();
}
