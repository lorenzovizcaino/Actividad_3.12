package modelo.services;

import modelo.Empleados;
import org.hibernate.Session;

public interface IServicioEmpleados {
    public Empleados addEmpleados(Empleados empleado);

    public boolean deleteEmpleados(String dni);

}
