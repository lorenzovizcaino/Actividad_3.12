package modelo.services;

import modelo.Empresas;
import org.hibernate.Session;

public class ServicioEmpresa implements IServicioEmpresa{
    @Override
    public void addEmpresa(Session session) {
        Empresas empresa=new Empresas();
        empresa.setCif("B36887453");
        empresa.setNombre("Zivocs S.L");
        empresa.setDireccion("Fernando Conde 15");
        empresa.setTelefono("986295330");
        session.save(empresa);
    }

    @Override
    public void listarEmpresasConEmpleados(Session session) {

    }
}
