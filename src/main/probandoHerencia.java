package main;

import modelo.Empleados;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class probandoHerencia {

    private static IServicioEmpresa servicioEmpresa;
    private static IServicioEmpleados servicioEmpleados;


    public static void main(String[] args) {
        servicioEmpresa=new ServicioEmpresa();
        servicioEmpleados=new ServicioEmpleados();
        boolean exito=false;

        Empresas empresa=new Empresas();
        empresa.setCif("B36887453");
        empresa.setNombre("Zivocs S.L");
        empresa.setDireccion("Fernando Conde 15");
        empresa.setTelefono("986295330");
        servicioEmpresa.addEmpresa(empresa);

        Empresas empresa2=new Empresas();
        empresa2.setCif("D36345453");
        empresa2.setNombre("Mapaliona S.L");
        empresa2.setDireccion("Manuel Solis 135");
        empresa2.setTelefono("934565330");
        servicioEmpresa.addEmpresa(empresa2);


        Set<Empleados> empleadosSet=new HashSet<>();
        Fijos emp1=new Fijos();
        emp1.setDni("76912388C");
        emp1.setNombre("Antonio Lorenzo");
        emp1.setEmpresa(empresa);
        emp1.setPorcentaRetencion(3);
        emp1.setSalarioBase(1500);
        emp1.setTrienios(2);
        empleadosSet.add(emp1);
        empresa.setEmpleados(empleadosSet);
        servicioEmpleados.addEmpleados(emp1);

        Temporales emp2=new Temporales();
        emp2.setDni("45912386D");
        emp2.setNombre("David Aganzo");
        emp2.setEmpresa(empresa);
        emp2.setPorcentaRetencion(4);
        LocalDate fechaInicio = LocalDate.of(2018, 10, 30);
        LocalDate fechaFin = LocalDate.of(2021, 10, 30);
        emp2.setFechaInicio(fechaInicio);
        emp2.setFechaFin(fechaFin);
        empleadosSet.add(emp2);
        empresa.setEmpleados(empleadosSet);
        servicioEmpleados.addEmpleados(emp2);


       // servicioEmpleados.deleteEmpleados("45912386D");




        List<Empresas> lista=servicioEmpresa.listarEmpresasConEmpleados2();
        for (Empresas e:lista) {
            System.out.println(e);
            System.out.println("Empleados de:"+e.getNombre());
            System.out.println(e.getEmpleados().size());
            for (Empleados emp:e.getEmpleados()) {
                System.out.println("\t"+emp);
            }

        }


        exito=servicioEmpresa.deleteEmpresa("B36887453");

    }


}
