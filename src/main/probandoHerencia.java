package main;

import modelo.Empresas;
import modelo.Fijos;
import modelo.Temporales;
import modelo.services.IServicioEmpleados;
import modelo.services.IServicioEmpresa;
import modelo.services.ServicioEmpleados;
import modelo.services.ServicioEmpresa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class probandoHerencia {
    private static SessionFactory sessionFactory = null;


    private static Session session = null;


    private static Transaction tx = null;
    private static IServicioEmpresa servicioEmpresa;
    private static IServicioEmpleados servicioEmpleados;


    public static void main(String[] args) {
        servicioEmpresa=new ServicioEmpresa();
        servicioEmpleados=new ServicioEmpleados();
        sessionFactory=util.SessionFactoryUtil.getSessionFactory();
        session=sessionFactory.openSession();
        tx= session.beginTransaction();

        servicioEmpresa.addEmpresa(session);
        servicioEmpleados.addEmpleados(session,"B36887453");
       // servicioEmpleados.deleteEmpleados(session, "45912386D");
        servicioEmpresa.listarEmpresasConEmpleados2(session);
        tx.commit();

        session.close();

    }


}
