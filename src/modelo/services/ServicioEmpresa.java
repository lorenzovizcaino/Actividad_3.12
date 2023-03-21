package modelo.services;

import exceptions.InstanceNotFoundException;
import modelo.Empleados;
import modelo.Empresas;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.SessionFactoryUtil;

import java.util.List;

public class ServicioEmpresa implements IServicioEmpresa{


    @Override
    public Empresas addEmpresa(Empresas empresa) {
        SessionFactory sessionFactory= SessionFactoryUtil.getSessionFactory();
        Transaction tx = null;
        try(Session session=sessionFactory.openSession()){
            tx=session.beginTransaction();
            session.save(empresa);
            tx.commit();
        }catch (Exception ex) {
            System.out.println("Ha ocurrido una exception: " + ex.getMessage());

            if (tx != null) {
                tx.rollback();
            }
            empresa = null;
        }
        return empresa;
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
    public List<Empresas> listarEmpresasConEmpleados2() {
        SessionFactory sessionFactory=SessionFactoryUtil.getSessionFactory();
        Transaction tx=null;
        List<Empresas> lista;
        try(Session session=sessionFactory.openSession()){
            tx=session.beginTransaction();
            lista=session.createQuery("Select e from Empresas e order by e.cif").list();
            tx.commit();


        }catch (Exception ex) {
            System.out.println("Ha ocurrido una exception: " + ex.getMessage());

            if (tx != null) {
                tx.rollback();
            }
            lista = null;
        }
        return lista;

    }

    @Override
    public boolean deleteEmpresa(String cif) {
        SessionFactory sessionFactory=SessionFactoryUtil.getSessionFactory();
        Transaction tx=null;
        boolean exito=true;
        try(Session session= sessionFactory.openSession()){
            tx= session.beginTransaction();
            Empresas empresa=session.get(Empresas.class,cif);
            if (empresa != null) {
                session.remove(empresa);
            } else {
                throw new InstanceNotFoundException(Empresas.class.getName());
            }

            tx.commit();
        }catch (Exception ex) {
            System.out.println("Ha ocurrido una exception: " + ex.getMessage());

            if (tx != null) {
                tx.rollback();
            }
            exito=false;
        }
        return exito;

    }
}
//borrado de una empresa con  todos sus empleados
//por cada empresa que se traiga todos su empleados.
