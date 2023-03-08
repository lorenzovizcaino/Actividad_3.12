package modelos;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@PrimaryKeyJoinColumn(name="empleadoId")
public class Fijos extends Empleados implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 134100636180972258L;
	private int salarioBase;
    private int trienios;

    public Fijos() {
    }

    public Fijos(int salarioBase, int trienios) {
        super();
        this.salarioBase = salarioBase;
        this.trienios= trienios;

    }

    @Column(name="salarioBase", length = 10)
    public int getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(int salarioBase) {
        this.salarioBase = salarioBase;
    }

    @Column(name="trienios", length = 10)
    public int getTrienios() {
        return trienios;
    }

    public void setTrienios(int trienios) {
        this.trienios = trienios;
    }

    @Override
    public void calculoNomina() {
        float sueldo;
        sueldo=(salarioBase+trienios)-(salarioBase+trienios)*super.porcentaRetención;

    }
}
