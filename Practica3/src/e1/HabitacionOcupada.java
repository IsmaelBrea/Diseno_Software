package e1;

public class HabitacionOcupada implements EstadoHabitacion{
    //Atributos
    private static final HabitacionOcupada instancia = new HabitacionOcupada();

    //Metodos
    private HabitacionOcupada() { }

    public static HabitacionOcupada getInstancia() {
        return instancia;
    }

    @Override
    public void reservarHabitacion(Habitacion habitacion, String huesped) {
        throw new IllegalArgumentException("Error, la habitacion no. " + habitacion.getNumero() + " esta ocupada");
    }

    @Override
    public void terminarReserva(Habitacion habitacion) {
        habitacion.setEstado(HabitacionDisponible.getInstancia());
        habitacion.setHuesped(null);
    }

    @Override
    public void limpiarHabitacion(Habitacion habitacion, String personal) {
        throw new IllegalArgumentException("Error, la habitacion no. " + habitacion.getNumero() + " esta ocupada");
    }

    @Override
    public void liberarHabitacion(Habitacion habitacion) {
        habitacion.setEstado(HabitacionLimpieza.getInstancia());
        habitacion.setHuesped(null);
    }

    @Override
    public void aprobarLimpieza(Habitacion habitacion, String supervisorL, boolean aprobacion) {
        throw new IllegalArgumentException("Error, la habitacion no. " + habitacion.getNumero() + " esta ocupada");
    }

    @Override
    public String mostrarInformacion(Habitacion habitacion) {
        return ("Room no. " + habitacion.getNumero() + ": Booked by " + habitacion.getHuesped() + ". Occupied\n");
    }
}
