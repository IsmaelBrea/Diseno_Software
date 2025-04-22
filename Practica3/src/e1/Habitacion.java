package e1;

import java.util.ArrayList;
import java.util.List;

public class Habitacion {
    //Atributos
    private EstadoHabitacion estado;
    private int numero;
    private String supervisorR;
    private String supervisorL;
    private String personal;
    private String huesped;

    //Metodos
    public Habitacion(int numero, String supervisorR) {
        this.numero = numero;
        this.supervisorR = supervisorR;
        this.supervisorL = null;
        this.estado = HabitacionDisponible.getInstancia();
        this.personal=null;
        this.huesped=null;
    }

    public EstadoHabitacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoHabitacion estado) {
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public String getSupervisorR() {
        return supervisorR;
    }

    public String getSupervisorL() {
        return supervisorL;
    }

    public void setSupervisorL(String supervisorL) {
        this.supervisorL = supervisorL;
    }

    public String getHuesped() {
        return huesped;
    }

    public void setHuesped(String huesped) {
        this.huesped = huesped;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }



    public void reservarHabitacion(String huesped) {
        estado.reservarHabitacion(this, huesped);
    }

    public void terminarReserva() {
        estado.terminarReserva(this);
    }

    public void limpiarHabitacion(String personal) {
        estado.limpiarHabitacion(this, personal);
    }

    public void liberarHabitacion() {
        estado.liberarHabitacion(this);
    }

    public void aprobarLimpieza(String supervisorL, boolean aprobacion) {
        estado.aprobarLimpieza(this, supervisorL, aprobacion);
    }

    public String mostrarInformacion() {
        return estado.mostrarInformacion(this);
    }
}
