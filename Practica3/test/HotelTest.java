import e1.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HotelTest {
    List<Habitacion> h = new ArrayList<>();
    Hotel habitaciones = new Hotel(h);

    @Test
    public void testHotel(){
        assertTrue(habitaciones.getHabitaciones().isEmpty());
        assertEquals(habitaciones.getHabitaciones().size(), 0);
    }

    @Test
    public void testAnadirHabitacion(){
        habitaciones.anadirHabitacion("Antonio");

        assertFalse(habitaciones.getHabitaciones().isEmpty());
        assertEquals(habitaciones.getHabitaciones().size(), 1);
        assertEquals(habitaciones.getHabitaciones().get(0).getNumero(), 1);
        assertEquals(habitaciones.getHabitaciones().get(0).getEstado(), HabitacionDisponible.getInstancia());
        assertNull(habitaciones.getHabitaciones().get(0).getHuesped());
        assertNull(habitaciones.getHabitaciones().get(0).getPersonal());
        assertNull(habitaciones.getHabitaciones().get(0).getSupervisorL());
        assertEquals(habitaciones.getHabitaciones().get(0).getSupervisorR(), "Antonio");
    }

    @Test
    public void testHabitacionesDisponibles(){
        habitaciones.anadirHabitacion("Paula");
        habitaciones.anadirHabitacion("Anxo");
        habitaciones.anadirHabitacion("Diego");

        String resultadoEsperado="Habitaciones Disponibles:\nRoom no. 1: Free. This room was registered by Paula\nRoom no. 2: Free. This room was registered by Anxo\nRoom no. 3: Free. This room was registered by Diego\n";

        assertEquals(habitaciones.habitacionesDisponibles(), resultadoEsperado);
    }

    @Test
    public void testHabitacionesPendientesLimpieza(){
        habitaciones.anadirHabitacion("Paula");
        habitaciones.anadirHabitacion("Anxo");
        habitaciones.anadirHabitacion("Diego");

        habitaciones.getHabitaciones().get(1).reservarHabitacion("Julian");
        habitaciones.getHabitaciones().get(1).liberarHabitacion();
        habitaciones.getHabitaciones().get(2).reservarHabitacion("Julia");
        habitaciones.getHabitaciones().get(2).liberarHabitacion();

        String resultadoEsperado="Habitaciones Pendientes de Limpieza:\nRoom no. 2: Free. Cleaning pending\nRoom no. 3: Free. Cleaning pending\n";

        assertEquals(habitaciones.habitacionesPendientesLimpieza(), resultadoEsperado);
    }

    @Test
    public void testHabitacionesPendientesAprobacion(){
        habitaciones.anadirHabitacion("Paula");
        habitaciones.anadirHabitacion("Anxo");
        habitaciones.anadirHabitacion("Diego");

        habitaciones.getHabitaciones().get(0).reservarHabitacion("Julian");
        habitaciones.getHabitaciones().get(0).liberarHabitacion();
        habitaciones.getHabitaciones().get(0).limpiarHabitacion("Xaime");
        habitaciones.getHabitaciones().get(2).reservarHabitacion("Julia");
        habitaciones.getHabitaciones().get(2).liberarHabitacion();
        habitaciones.getHabitaciones().get(2).limpiarHabitacion("Jesus");

        String resultadoEsperado="Habitaciones Pendientes de Aprobacion:\nRoom no. 1: Free. Room cleaned by Xaime, pending approval\nRoom no. 3: Free. Room cleaned by Jesus, pending approval\n";

        assertEquals(habitaciones.habitacionesPendientesAprobacion(), resultadoEsperado);
    }

    @Test
    public void testInformacionHabitaciones(){
        habitaciones.anadirHabitacion("Paula");
        habitaciones.anadirHabitacion("Anxo");
        habitaciones.anadirHabitacion("Diego");
        habitaciones.anadirHabitacion("Sara");
        habitaciones.anadirHabitacion("Marcos");
        habitaciones.anadirHabitacion("Pedro");

        habitaciones.getHabitaciones().get(1).reservarHabitacion("Julian");
        habitaciones.getHabitaciones().get(2).reservarHabitacion("Manuel");
        habitaciones.getHabitaciones().get(2).liberarHabitacion();
        habitaciones.getHabitaciones().get(3).reservarHabitacion("Manuel");
        habitaciones.getHabitaciones().get(3).liberarHabitacion();
        habitaciones.getHabitaciones().get(3).limpiarHabitacion("Xaime");
        habitaciones.getHabitaciones().get(4).reservarHabitacion("Ana");
        habitaciones.getHabitaciones().get(4).liberarHabitacion();
        habitaciones.getHabitaciones().get(4).limpiarHabitacion("Jesus");
        habitaciones.getHabitaciones().get(4).aprobarLimpieza("Carla", false);
        habitaciones.getHabitaciones().get(5).reservarHabitacion("Adrian");
        habitaciones.getHabitaciones().get(5).liberarHabitacion();
        habitaciones.getHabitaciones().get(5).limpiarHabitacion("Andrea");
        habitaciones.getHabitaciones().get(5).aprobarLimpieza("Pepe", true);

        String resultadoEsperado="***********************\nHotel UDC-Hills\n***********************\nRoom no. 1: Free. This room was registered by Paula\nRoom no. 2: Booked by Julian. Occupied\nRoom no. 3: Free. Cleaning pending\nRoom no. 4: Free. Room cleaned by Xaime, pending approval\nRoom no. 5: Free. This room was not approved by Carla. Cleaning pending\nRoom no. 6: Free. This room was approved by Pepe\n***********************\n";

        assertEquals(habitaciones.informacionHabitaciones(), resultadoEsperado);
    }
}
