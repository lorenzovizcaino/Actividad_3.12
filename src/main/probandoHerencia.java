package main;

import modelos.Empleados;
import modelos.Empresas;
import modelos.Fijos;
import modelos.Temporales;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class probandoHerencia {
    private static SessionFactory sessionFactory = null;


    private static Session session = null;


    private static Transaction tx = null;


    public static void main(String[] args) {
        sessionFactory=util.SessionFactoryUtil.getSessionFactory();
        session=sessionFactory.openSession();
        tx= session.beginTransaction();
        addDatos();

    }



    private static void addDatos() {
        Empresas empresa=new Empresas();
        empresa.setCif("B36887453");
        empresa.setNombre("Zivocs S.L");
        empresa.setDirección("Fernando Conde 15");
        empresa.setTeléfono("986295330");
        session.save(empresa);
        System.out.println("La clave del nuevo objeto es: " + empresa.getCif());

        Fijos emp1=new Fijos();
        emp1.setDni("76912388C");
        emp1.setNombre("Antonio Lorenzo");
        emp1.setEmpresa(empresa);
        emp1.setPorcentaRetención(3);
        emp1.setSalarioBase(1500);
        emp1.setTrienios(2);
        session.save(emp1);
        System.out.println("La clave del nuevo objeto es: " + emp1.getDni());

        Temporales emp2=new Temporales();
        emp2.setDni("45912386D");
        emp2.setNombre("David Aganzo");
        emp2.setEmpresa(empresa);
        emp2.setPorcentaRetención(4);
        LocalDate fechaInicio = LocalDate.of(2018, 10, 30);
        LocalDate fechaFin = LocalDate.of(2021, 10, 30);
        emp2.setFechaInicio(fechaInicio);
        emp2.setFechaFin(fechaFin);
        session.save(emp2);
        System.out.println("La clave del nuevo objeto es: " + emp2.getDni());

    }

}
