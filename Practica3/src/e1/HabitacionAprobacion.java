package e1;

public class HabitacionAprobacion implements EstadoHabitacion{
    //Atributos
    private static final HabitacionAprobacion instancia = new HabitacionAprobacion();

    //Metodos
    private HabitacionAprobacion() { }

    public static HabitacionAprobacion getInstancia() {
        return instancia;
    }

    @Override
    public void reservarHabitacion(Habitacion habitacion, String huesped) {
        throw new IllegalArgumentException("Error, la habitacion no. " + habitacion.getNumero() + " esta pendiente de aprobacion");
    }

    @Override
    public void terminarReserva(Habitacion habitacion) {
        throw new IllegalArgumentException("Error, la habitacion no. " + habitacion.getNumero() + " esta pendiente de aprobacion");
    }

    @Override
    public void limpiarHabitacion(Habitacion habitacion, String personal) {
        throw new IllegalArgumentException("Error, la habitacion no. " + habitacion.getNumero() + " esta pendiente de aprobacion");
    }

    @Override
    public void liberarHabitacion(Habitacion habitacion) {
        throw new IllegalArgumentException("Error, la habitacion no. " + habitacion.getNumero() + " esta pendiente de aprobacion");
    }

    @Override
    public void aprobarLimpieza(Habitacion habitacion, String supervisorL, boolean aprobacion) {
        if(aprobacion){
            habitacion.setEstado(HabitacionDisponible.getInstancia());
            habitacion.setSupervisorL(supervisorL);
        }else{
            habitacion.setEstado(HabitacionLimpieza.getInstancia());
            habitacion.setSupervisorL(supervisorL);
        }
    }

    @Override
    public String mostrarInformacion(Habitacion habitacion) {
        return ("Room no. " + habitacion.getNumero() + ": Free. Room cleaned by " + habitacion.getPersonal() + ", pending approval\n");
    }
}
