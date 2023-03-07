package modelos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Empresas implements Serializable {
    private String cif;
    private String nombre;
    private String dirección;
    private String teléfono;
    private Set empleados = new HashSet(0);

    public Empresas() {
    }

    public Empresas(String cif, String nombre, String dirección, String teléfono) {
        this.cif = cif;
        this.nombre = nombre;
        this.dirección = dirección;
        this.teléfono = teléfono;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public String getTeléfono() {
        return teléfono;
    }

    public void setTeléfono(String teléfono) {
        this.teléfono = teléfono;
    }

    public Set getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Set empleados) {
        this.empleados = empleados;
    }
}