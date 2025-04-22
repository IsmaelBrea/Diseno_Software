package e1;

public class HabitacionLimpieza implements EstadoHabitacion{
    //Atributos
    private static final HabitacionLimpieza instancia = new HabitacionLimpieza();

    //Metodos
    private HabitacionLimpieza() { }

    public static HabitacionLimpieza getInstancia() {
        return instancia;
    }

    @Override
    public void reservarHabitacion(Habitacion habitacion, String huesped) {
        throw new IllegalArgumentException("Error, la habitacion no. " + habitacion.getNumero() + " esta pendiente de limpieza");
    }

    @Override
    public void terminarReserva(Habitacion habitacion) {
        throw new IllegalArgumentException("Error, la habitacion no. " + habitacion.getNumero() + " esta pendiente de limpieza");
    }

    @Override
    public void limpiarHabitacion(Habitacion habitacion, String personal) {
        habitacion.setEstado(HabitacionAprobacion.getInstancia());
        habitacion.setPersonal(personal);
    }

    @Override
    public void liberarHabitacion(Habitacion habitacion) {
        throw new IllegalArgumentException("Error, la habitacion no. " + habitacion.getNumero() + " esta pendiente de limpieza");
    }

    @Override
    public void aprobarLimpieza(Habitacion habitacion, String supervisorL, boolean aprobacion) {
        throw new IllegalArgumentException("Error, la habitacion no. " + habitacion.getNumero() + " esta pendiente de limpieza");
    }

    @Override
    public String mostrarInformacion(Habitacion habitacion) {
        if(habitacion.getSupervisorL()==null){
            return ("Room no. " + habitacion.getNumero() + ": Free. Cleaning pending\n");
        }else{
            return ("Room no. " + habitacion.getNumero() + ": Free. This room was not approved by " + habitacion.getSupervisorL() + ". Cleaning pending\n");
        }

    }
}
