package modelo.services;

import modelo.Empleados;
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

        Empresas empresa2=new Empresas();
        empresa2.setCif("D36345453");
        empresa2.setNombre("Mapaliona S.L");
        empresa2.setDireccion("Manuel Solis 135");
        empresa2.setTelefono("934565330");
        session.save(empresa2);
    }

    @Override
    public void listarEmpresasConEmpleados(Session session) {
        List<Empresas> lista=session.createQuery("Select e from Empresas e order by e.cif").list();
        for (Empresas e:lista) {
            System.out.println(e);
            List<Empleados> listaEmp=session.createQuery("Select em from Empleados em where em.empresa.cif=:id").setParameter("id",e.getCif()).list();
            System.out.println("Empleados de:"+e.getNombre());
            for (Empleados emp:listaEmp) {
                System.out.println("\t"+emp);
            }
        }
    }

    @Override
    public void listarEmpresasConEmpleados2(Session session) {
        List<Empresas> lista=session.createQuery("Select e from Empresas e order by e.cif").list();
        for (Empresas e:lista) {
            System.out.println(e);
            System.out.println("Empleados de:"+e.getNombre());
            System.out.println(e.getEmpleados().size());
            for (Empleados emp:e.getEmpleados()) {
                System.out.println("\t"+emp);
            }

        }
    }
}
//borrado de una empresa con  todos sus empleados
//por cada empresa que se traiga todos su empleados.
