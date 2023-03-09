package modelo.services;

import modelo.Empresas;
import org.hibernate.Session;

import java.util.List;

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
        List<Empresas> lista=session.createQuery("Select e from Empresas e order by e.cif").list();
        for (Empresas e:lista) {
            System.out.println(e);
        }
    }
}
