package modelo.services;

import modelo.Empleados;
import modelo.Empresas;
import modelo.Fijos;
import modelo.Temporales;
import org.hibernate.Session;

import java.time.LocalDate;

public class ServicioEmpleados implements IServicioEmpleados{
    @Override
    public void addEmpleados(Session session, String cifEmpresa) {
        Empresas empresa=session.get(Empresas.class,cifEmpresa);
        if(empresa!=null){
            Fijos emp1=new Fijos();
            emp1.setDni("76912388C");
            emp1.setNombre("Antonio Lorenzo");
            emp1.setEmpresa(empresa);
            emp1.setPorcentaRetencion(3);
            emp1.setSalarioBase(1500);
            emp1.setTrienios(2);
            session.save(emp1);


            Temporales emp2=new Temporales();
            emp2.setDni("45912386D");
            emp2.setNombre("David Aganzo");
            emp2.setEmpresa(empresa);
            emp2.setPorcentaRetencion(4);
            LocalDate fechaInicio = LocalDate.of(2018, 10, 30);
            LocalDate fechaFin = LocalDate.of(2021, 10, 30);
            emp2.setFechaInicio(fechaInicio);
            emp2.setFechaFin(fechaFin);
            session.save(emp2);
        }else{
            System.out.println("Esa empresa no existe en la BD, no se pueden insertar empleados");
        }



    }

    @Override
    public void deleteEmpleados(Session session, String dni) {
        Empleados empleado=session.get(Empleados.class, dni);
        if(empleado!=null){
            session.delete(empleado);
        }else{
            System.out.println("No se puede borrar el empleado con DNI: "+dni+", No existe en la BD");
        }
    }
}
