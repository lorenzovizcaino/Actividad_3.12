package modelo.services;

import modelo.Empresas;
import org.hibernate.Session;

import java.util.List;

public interface IServicioEmpresa {
    public Empresas addEmpresa(Empresas empresa);

    void listarEmpresasConEmpleados(Session session);
    public List<Empresas> listarEmpresasConEmpleados2();

    public boolean deleteEmpresa(String cif);
}
