package modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@PrimaryKeyJoinColumn(name="empleadoId")
public class Temporales extends Empleados implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6360419373610479131L;
	private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private float pagoDia;
    private float suplemento;

    public Temporales() {
    }

    public Temporales(LocalDate fechaInicio, LocalDate fechaFin, float pagoDia, float suplemento) {
        super();
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.pagoDia = pagoDia;
        this.suplemento = suplemento;
    }

   // @Temporal(TemporalType.DATE)
    @Column(name="fechaInicio", length = 10)
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

 //   @Temporal(TemporalType.DATE)
    @Column(name="fechaFin", length = 10)
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }


    @Column(name = "pagoDia", length = 10)
    public float getPagoDia() {
        return pagoDia;
    }

    public void setPagoDia(float pagoDia) {
        this.pagoDia = pagoDia;
    }

    @Column(name = "suplemento", length = 10)
    public float getSuplemento() {
        return suplemento;
    }

    public void setSuplemento(float suplemento) {
        this.suplemento = suplemento;
    }

    @Override
    public void calculoNomina() {
        float sueldo;
        long diferenciaDias=ChronoUnit.DAYS.between(fechaFin,fechaInicio);
        sueldo=(pagoDia*diferenciaDias)-(pagoDia*diferenciaDias)*super.porcentaRetencion +suplemento;
    }

    @Override
    public String toString() {
        return "Temporales{" +super.toString()+
                "fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", pagoDia=" + pagoDia +
                ", suplemento=" + suplemento +
                "} ";
    }
}
