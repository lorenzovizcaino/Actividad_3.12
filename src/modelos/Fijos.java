package modelos;

import java.io.Serializable;

public class Fijos extends Empleados implements Serializable {
    private int salarioBase;
    private int trienios;

    public Fijos() {
    }

    public Fijos(int salarioBase) {
        super();
        this.salarioBase = salarioBase;

    }

    public int getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(int salarioBase) {
        this.salarioBase = salarioBase;
    }

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
