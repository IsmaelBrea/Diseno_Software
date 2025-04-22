package e1;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    //Atributos
    public List<Habitacion> habitaciones = new ArrayList<>();

    //Metodos
    public Hotel(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }



    public void anadirHabitacion(String supervisorR){
        habitaciones.add(new Habitacion(habitaciones.size() + 1, supervisorR));
    }

    public String habitacionesDisponibles(){
        String resultado;
        resultado="Habitaciones Disponibles:\n";
        for (Habitacion h:habitaciones){
            if(h.getEstado().equals(HabitacionDisponible.getInstancia())){
                resultado = resultado + h.mostrarInformacion();
            }
        }
        return resultado;
    }

    public String habitacionesPendientesLimpieza(){
        String resultado;
        resultado="Habitaciones Pendientes de Limpieza:\n";
        for (Habitacion h:habitaciones){
            if(h.getEstado().equals(HabitacionLimpieza.getInstancia())){
                resultado = resultado + h.mostrarInformacion();
            }
        }
        return resultado;
    }

    public String habitacionesPendientesAprobacion(){
        String resultado;
        resultado = "Habitaciones Pendientes de Aprobacion:\n";
        for (Habitacion h:habitaciones){
            if(h.getEstado().equals(HabitacionAprobacion.getInstancia())){
                resultado = resultado + h.mostrarInformacion();
            }
        }
        return resultado;
    }

    public String informacionHabitaciones(){
        String resultado;
        resultado="***********************\n";
        resultado = resultado +"Hotel UDC-Hills\n";
        resultado = resultado +"***********************\n";
        for (Habitacion h:habitaciones){
            resultado = resultado + h.mostrarInformacion();
        }
        resultado = resultado +"***********************\n+";
        return resultado;
    }

}
