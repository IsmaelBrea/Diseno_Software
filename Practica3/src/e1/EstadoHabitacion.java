package e1;

public interface EstadoHabitacion {
    void reservarHabitacion(Habitacion habitacion, String huesped);

    void terminarReserva(Habitacion habitacion);

    void limpiarHabitacion(Habitacion habitacion, String personal);

    void liberarHabitacion(Habitacion habitacion);

    void aprobarLimpieza(Habitacion habitacion, String supervisor, boolean aprobacion);

    String mostrarInformacion(Habitacion habitacion);
}
