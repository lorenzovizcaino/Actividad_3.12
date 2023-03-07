package modelos;

import java.io.Serializable;

public abstract class Empleados implements Serializable {
    private String dni;

    private String nombre;

    private String teléfono;

    protected float porcentaRetención;

    public abstract void calculoNomina();
}
