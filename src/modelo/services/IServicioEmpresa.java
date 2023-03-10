package modelo.services;

import org.hibernate.Session;

public interface IServicioEmpresa {
    void addEmpresa(Session session);

    void listarEmpresasConEmpleados(Session session);
    void listarEmpresasConEmpleados2(Session session);
}
