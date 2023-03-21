package modelo.services;

import modelo.Empleados;
import modelo.Empresas;
import modelo.Fijos;
import modelo.Temporales;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.SessionFactoryUtil;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class ServicioEmpleados implements IServicioEmpleados{
    @Override
    public Empleados addEmpleados(Empleados empleado) {
        SessionFactory sessionFactory= SessionFactoryUtil.getSessionFactory();
        Transaction tx=null;
        try(Session session= sessionFactory.openSession()){
            tx=session.beginTransaction();
            session.save(empleado);
            tx.commit();

        }catch (Exception ex) {
            System.out.println("Ha ocurrido una exception: " + ex.getMessage());

            if (tx != null) {
                tx.rollback();
            }
            empleado = null;
        }
        return empleado;

    }

    @Override
    public boolean deleteEmpleados(String dni) {
        boolean exito=true;
        SessionFactory sessionFactory=SessionFactoryUtil.getSessionFactory();
        Transaction tx=null;
        try(Session session=sessionFactory.openSession()){
            tx=session.beginTransaction();
            Empleados empleado=session.get(Empleados.class, dni);
            if(empleado!=null){
                session.delete(empleado);
            }else{
                System.out.println("No se puede borrar el empleado con DNI: "+dni+", No existe en la BD");
            }
        }catch (Exception ex) {
            System.out.println("Ha ocurrido una exception: " + ex.getMessage());

            if (tx != null) {
                tx.rollback();
            }
            exito = false;
        }
        return exito;

    }


}
