package modelo.services;

import org.hibernate.Session;

public interface IServicioEmpleados {
    void addEmpleados(Session session, String cifEmpresa);

    void deleteEmpleados(Session session, String s);

}
