package e1;

public class HabitacionDisponible implements EstadoHabitacion{
    //Atributos
    private static final HabitacionDisponible instancia = new HabitacionDisponible();

    //Metodos
    private HabitacionDisponible() { }

    public static HabitacionDisponible getInstancia() {
        return instancia;
    }

    @Override
    public void reservarHabitacion(Habitacion habitacion, String huesped) {
        habitacion.setEstado(HabitacionOcupada.getInstancia());
        habitacion.setHuesped(huesped);
    }

    @Override
    public void terminarReserva(Habitacion habitacion) {
        throw new IllegalArgumentException("Error, la habitacion no. " + habitacion.getNumero() + " esta disponible");
    }

    @Override
    public void limpiarHabitacion(Habitacion habitacion, String personal) {
        throw new IllegalArgumentException("Error, la habitacion no. " + habitacion.getNumero() + " esta disponible");
    }

    @Override
    public void liberarHabitacion(Habitacion habitacion) {
        throw new IllegalArgumentException("Error, la habitacion no. " + habitacion.getNumero() + " esta disponible");
    }

    @Override
    public void aprobarLimpieza(Habitacion habitacion, String supervisorL, boolean aprobacion) {
        if(habitacion.getSupervisorL()==null){
            throw new IllegalArgumentException("La habitacion no. " + habitacion.getNumero() + " aun no ha sido limpiada");
        }else if(aprobacion){
            throw new IllegalArgumentException("La habitacion no. " + habitacion.getNumero() + " ya ha sido aprobada");
        }else{
            habitacion.setEstado(HabitacionLimpieza.getInstancia());
            habitacion.setSupervisorL(supervisorL);
        }
    }

    @Override
    public String mostrarInformacion(Habitacion habitacion) {
        if(habitacion.getSupervisorL()==null){
            return ("Room no. " + habitacion.getNumero() + ": Free. This room was registered by " + habitacion.getSupervisorR() + "\n");
        }else{
            return ("Room no. " + habitacion.getNumero() + ": Free. This room was approved by " + habitacion.getSupervisorL() + "\n");
        }
    }
}
