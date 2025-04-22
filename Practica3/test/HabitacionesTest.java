import e1.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HabitacionesTest {
    Habitacion h = new Habitacion(1, "Alfonso");

    @Test
    public void testHabitacion(){
        assertEquals(h.getNumero(),1);
        assertEquals(h.getSupervisorR(),"Alfonso");
        assertNull(h.getSupervisorL());
        assertNull(h.getPersonal());
        assertNull(h.getHuesped());
        assertEquals(h.getEstado(), HabitacionDisponible.getInstancia());
        try {
            h.terminarReserva();    //Intentar llamar al método que debería lanzar la excepción
            fail("Se esperaba que terminarReserva lanzara una IllegalArgumentException");   //El método no lanzó la excepción cuando debería haberlo hecho
        } catch (IllegalArgumentException e) {
            assertEquals("Error, la habitacion no. 1 esta disponible", e.getMessage());
        }
        try {
            h.limpiarHabitacion("Fulanita");    //Intentar llamar al método que debería lanzar la excepción
            fail("Se esperaba que limpiarHabitacion lanzara una IllegalArgumentException");   //El método no lanzó la excepción cuando debería haberlo hecho
        } catch (IllegalArgumentException e) {
            assertEquals("Error, la habitacion no. 1 esta disponible", e.getMessage());
        }try {
            h.liberarHabitacion();    //Intentar llamar al método que debería lanzar la excepción
            fail("Se esperaba que liberarHabitacion lanzara una IllegalArgumentException");   //El método no lanzó la excepción cuando debería haberlo hecho
        } catch (IllegalArgumentException e) {
            assertEquals("Error, la habitacion no. 1 esta disponible", e.getMessage());
        }
        try {
            h.aprobarLimpieza("Fulanita", true);    //Intentar llamar al método que debería lanzar la excepción
            fail("Se esperaba que aprobarLimpieza lanzara una IllegalArgumentException");   //El método no lanzó la excepción cuando debería haberlo hecho
        } catch (IllegalArgumentException e) {
            assertEquals("La habitacion no. 1 aun no ha sido limpiada", e.getMessage());
        }

    }

    @Test
    public void testReservarHabitacion(){
        h.reservarHabitacion("Maria");
        assertEquals(h.getNumero(),1);
        assertEquals(h.getSupervisorR(),"Alfonso");
        assertNull(h.getSupervisorL());
        assertNull(h.getPersonal());
        assertEquals(h.getHuesped(), "Maria");
        assertEquals(h.getEstado(), HabitacionOcupada.getInstancia());
        try {
            h.reservarHabitacion("Fulanita");    //Intentar llamar al método que debería lanzar la excepción
            fail("Se esperaba que reservarHabitacion lanzara una IllegalArgumentException");   //El método no lanzó la excepción cuando debería haberlo hecho
        } catch (IllegalArgumentException e) {
            assertEquals("Error, la habitacion no. 1 esta ocupada", e.getMessage());
        }
        try {
            h.limpiarHabitacion("Fulanita");    //Intentar llamar al método que debería lanzar la excepción
            fail("Se esperaba que limpiarHabitacion lanzara una IllegalArgumentException");   //El método no lanzó la excepción cuando debería haberlo hecho
        } catch (IllegalArgumentException e) {
            assertEquals("Error, la habitacion no. 1 esta ocupada", e.getMessage());
        }
        try {
            h.aprobarLimpieza("Fulanita", true);    //Intentar llamar al método que debería lanzar la excepción
            fail("Se esperaba que aprobarLimpieza lanzara una IllegalArgumentException");   //El método no lanzó la excepción cuando debería haberlo hecho
        } catch (IllegalArgumentException e) {
            assertEquals("Error, la habitacion no. 1 esta ocupada", e.getMessage());
        }
    }

    @Test
    public void testTerminarReserva(){
        h.reservarHabitacion("Maria");
        h.terminarReserva();
        assertEquals(h.getNumero(),1);
        assertEquals(h.getSupervisorR(),"Alfonso");
        assertNull(h.getSupervisorL());
        assertNull(h.getPersonal());
        assertNull(h.getHuesped());
        assertEquals(h.getEstado(), HabitacionDisponible.getInstancia());
        try {
            h.terminarReserva();    //Intentar llamar al método que debería lanzar la excepción
            fail("Se esperaba que terminarReserva lanzara una IllegalArgumentException");   //El método no lanzó la excepción cuando debería haberlo hecho
        } catch (IllegalArgumentException e) {
            assertEquals("Error, la habitacion no. 1 esta disponible", e.getMessage());
        }
        try {
            h.limpiarHabitacion("Fulanita");    //Intentar llamar al método que debería lanzar la excepción
            fail("Se esperaba que limpiarHabitacion lanzara una IllegalArgumentException");   //El método no lanzó la excepción cuando debería haberlo hecho
        } catch (IllegalArgumentException e) {
            assertEquals("Error, la habitacion no. 1 esta disponible", e.getMessage());
        }try {
            h.liberarHabitacion();    //Intentar llamar al método que debería lanzar la excepción
            fail("Se esperaba que liberarHabitacion lanzara una IllegalArgumentException");   //El método no lanzó la excepción cuando debería haberlo hecho
        } catch (IllegalArgumentException e) {
            assertEquals("Error, la habitacion no. 1 esta disponible", e.getMessage());
        }
        try {
            h.aprobarLimpieza("Fulanita", true);    //Intentar llamar al método que debería lanzar la excepción
            fail("Se esperaba que aprobarLimpieza lanzara una IllegalArgumentException");   //El método no lanzó la excepción cuando debería haberlo hecho
        } catch (IllegalArgumentException e) {
            assertEquals("La habitacion no. 1 aun no ha sido limpiada", e.getMessage());
        }
    }

    @Test
    public void testLiberarHabitacion(){
        h.reservarHabitacion("Mario");
        h.liberarHabitacion();
        assertEquals(h.getNumero(),1);
        assertEquals(h.getSupervisorR(),"Alfonso");
        assertNull(h.getSupervisorL());
        assertNull(h.getPersonal());
        assertNull(h.getHuesped());
        assertEquals(h.getEstado(), HabitacionLimpieza.getInstancia());
        try {
            h.reservarHabitacion("Fulanita");    //Intentar llamar al método que debería lanzar la excepción
            fail("Se esperaba que reservarHabitacion lanzara una IllegalArgumentException");   //El método no lanzó la excepción cuando debería haberlo hecho
        } catch (IllegalArgumentException e) {
            assertEquals("Error, la habitacion no. 1 esta pendiente de limpieza", e.getMessage());
        }
        try {
            h.terminarReserva();    //Intentar llamar al método que debería lanzar la excepción
            fail("Se esperaba que terminarReserva lanzara una IllegalArgumentException");   //El método no lanzó la excepción cuando debería haberlo hecho
        } catch (IllegalArgumentException e) {
            assertEquals("Error, la habitacion no. 1 esta pendiente de limpieza", e.getMessage());
        }
        try {
            h.liberarHabitacion();    //Intentar llamar al método que debería lanzar la excepción
            fail("Se esperaba que liberarHabitacion lanzara una IllegalArgumentException");   //El método no lanzó la excepción cuando debería haberlo hecho
        } catch (IllegalArgumentException e) {
            assertEquals("Error, la habitacion no. 1 esta pendiente de limpieza", e.getMessage());
        }
        try {
            h.aprobarLimpieza("Fulanita", true);    //Intentar llamar al método que debería lanzar la excepción
            fail("Se esperaba que aprobarLimpieza lanzara una IllegalArgumentException");   //El método no lanzó la excepción cuando debería haberlo hecho
        } catch (IllegalArgumentException e) {
            assertEquals("Error, la habitacion no. 1 esta pendiente de limpieza", e.getMessage());
        }
    }

    @Test
    public void testLimpiarHabitacion(){
        h.reservarHabitacion("Mario");
        h.liberarHabitacion();
        h.limpiarHabitacion("Eduardo");
        assertEquals(h.getNumero(),1);
        assertEquals(h.getSupervisorR(),"Alfonso");
        assertNull(h.getSupervisorL());
        assertEquals(h.getPersonal(), "Eduardo");
        assertNull(h.getHuesped());
        assertEquals(h.getEstado(), HabitacionAprobacion.getInstancia());
        try {
            h.reservarHabitacion("Fulanita");    //Intentar llamar al método que debería lanzar la excepción
            fail("Se esperaba que reservarHabitacion lanzara una IllegalArgumentException");   //El método no lanzó la excepción cuando debería haberlo hecho
        } catch (IllegalArgumentException e) {
            assertEquals("Error, la habitacion no. 1 esta pendiente de aprobacion", e.getMessage());
        }
        try {
            h.terminarReserva();    //Intentar llamar al método que debería lanzar la excepción
            fail("Se esperaba que terminarReserva lanzara una IllegalArgumentException");   //El método no lanzó la excepción cuando debería haberlo hecho
        } catch (IllegalArgumentException e) {
            assertEquals("Error, la habitacion no. 1 esta pendiente de aprobacion", e.getMessage());
        }
        try {
            h.limpiarHabitacion("Fulanita");    //Intentar llamar al método que debería lanzar la excepción
            fail("Se esperaba que limpiarHabitacion lanzara una IllegalArgumentException");   //El método no lanzó la excepción cuando debería haberlo hecho
        } catch (IllegalArgumentException e) {
            assertEquals("Error, la habitacion no. 1 esta pendiente de aprobacion", e.getMessage());
        }
        try {
            h.liberarHabitacion();    //Intentar llamar al método que debería lanzar la excepción
            fail("Se esperaba que liberarHabitacion lanzara una IllegalArgumentException");   //El método no lanzó la excepción cuando debería haberlo hecho
        } catch (IllegalArgumentException e) {
            assertEquals("Error, la habitacion no. 1 esta pendiente de aprobacion", e.getMessage());
        }
    }

    @Test
    public void testAprobarLimpiezaTrue(){
        h.reservarHabitacion("Mario");
        h.liberarHabitacion();
        h.limpiarHabitacion("Eduardo");
        h.aprobarLimpieza("Fernanda", true);
        assertEquals(h.getNumero(),1);
        assertEquals(h.getSupervisorR(),"Alfonso");
        assertEquals(h.getSupervisorL(), "Fernanda");
        assertEquals(h.getPersonal(), "Eduardo");
        assertNull(h.getHuesped());
        assertEquals(h.getEstado(), HabitacionDisponible.getInstancia());
        try {
            h.terminarReserva();    //Intentar llamar al método que debería lanzar la excepción
            fail("Se esperaba que terminarReserva lanzara una IllegalArgumentException");   //El método no lanzó la excepción cuando debería haberlo hecho
        } catch (IllegalArgumentException e) {
            assertEquals("Error, la habitacion no. 1 esta disponible", e.getMessage());
        }
        try {
            h.limpiarHabitacion("Fulanita");    //Intentar llamar al método que debería lanzar la excepción
            fail("Se esperaba que limpiarHabitacion lanzara una IllegalArgumentException");   //El método no lanzó la excepción cuando debería haberlo hecho
        } catch (IllegalArgumentException e) {
            assertEquals("Error, la habitacion no. 1 esta disponible", e.getMessage());
        }try {
            h.liberarHabitacion();    //Intentar llamar al método que debería lanzar la excepción
            fail("Se esperaba que liberarHabitacion lanzara una IllegalArgumentException");   //El método no lanzó la excepción cuando debería haberlo hecho
        } catch (IllegalArgumentException e) {
            assertEquals("Error, la habitacion no. 1 esta disponible", e.getMessage());
        }
        try {
            h.aprobarLimpieza("Fulanita", true);    //Intentar llamar al método que debería lanzar la excepción
            fail("Se esperaba que aprobarLimpieza lanzara una IllegalArgumentException");   //El método no lanzó la excepción cuando debería haberlo hecho
        } catch (IllegalArgumentException e) {
            assertEquals("La habitacion no. 1 ya ha sido aprobada", e.getMessage());
        }
    }

    @Test
    public void testAprobarLimpiezaFalse(){
        h.reservarHabitacion("Mario");
        h.liberarHabitacion();
        h.limpiarHabitacion("Eduardo");
        h.aprobarLimpieza("Fernanda", true);
        h.aprobarLimpieza("Fernando", false);
        assertEquals(h.getNumero(),1);
        assertEquals(h.getSupervisorR(),"Alfonso");
        assertEquals(h.getSupervisorL(), "Fernando");
        assertEquals(h.getPersonal(), "Eduardo");
        assertNull(h.getHuesped());
        assertEquals(h.getEstado(), HabitacionLimpieza.getInstancia());
        try {
            h.reservarHabitacion("Fulanita");    //Intentar llamar al método que debería lanzar la excepción
            fail("Se esperaba que reservarHabitacion lanzara una IllegalArgumentException");   //El método no lanzó la excepción cuando debería haberlo hecho
        } catch (IllegalArgumentException e) {
            assertEquals("Error, la habitacion no. 1 esta pendiente de limpieza", e.getMessage());
        }
        try {
            h.terminarReserva();    //Intentar llamar al método que debería lanzar la excepción
            fail("Se esperaba que terminarReserva lanzara una IllegalArgumentException");   //El método no lanzó la excepción cuando debería haberlo hecho
        } catch (IllegalArgumentException e) {
            assertEquals("Error, la habitacion no. 1 esta pendiente de limpieza", e.getMessage());
        }
        try {
            h.liberarHabitacion();    //Intentar llamar al método que debería lanzar la excepción
            fail("Se esperaba que liberarHabitacion lanzara una IllegalArgumentException");   //El método no lanzó la excepción cuando debería haberlo hecho
        } catch (IllegalArgumentException e) {
            assertEquals("Error, la habitacion no. 1 esta pendiente de limpieza", e.getMessage());
        }
        try {
            h.aprobarLimpieza("Fulanita", true);    //Intentar llamar al método que debería lanzar la excepción
            fail("Se esperaba que aprobarLimpieza lanzara una IllegalArgumentException");   //El método no lanzó la excepción cuando debería haberlo hecho
        } catch (IllegalArgumentException e) {
            assertEquals("Error, la habitacion no. 1 esta pendiente de limpieza", e.getMessage());
        }
    }

    @Test
    public void testAprobarLimpiezaFalse2(){
        Habitacion h2 = new Habitacion(2, "Francisco");
        h2.reservarHabitacion("Mario");
        h2.liberarHabitacion();
        h2.limpiarHabitacion("Marcelo");
        h2.aprobarLimpieza("Felipe", false);
        assertEquals(h2.getNumero(),2);
        assertEquals(h2.getSupervisorR(),"Francisco");
        assertEquals(h2.getSupervisorL(), "Felipe");
        assertEquals(h2.getPersonal(), "Marcelo");
        assertNull(h2.getHuesped());
        assertEquals(h2.getEstado(), HabitacionLimpieza.getInstancia());
        try {
            h2.reservarHabitacion("Fulanita");    //Intentar llamar al método que debería lanzar la excepción
            fail("Se esperaba que reservarHabitacion lanzara una IllegalArgumentException");   //El método no lanzó la excepción cuando debería haberlo hecho
        } catch (IllegalArgumentException e) {
            assertEquals("Error, la habitacion no. 2 esta pendiente de limpieza", e.getMessage());
        }
        try {
            h2.terminarReserva();    //Intentar llamar al método que debería lanzar la excepción
            fail("Se esperaba que terminarReserva lanzara una IllegalArgumentException");   //El método no lanzó la excepción cuando debería haberlo hecho
        } catch (IllegalArgumentException e) {
            assertEquals("Error, la habitacion no. 2 esta pendiente de limpieza", e.getMessage());
        }
        try {
            h2.liberarHabitacion();    //Intentar llamar al método que debería lanzar la excepción
            fail("Se esperaba que liberarHabitacion lanzara una IllegalArgumentException");   //El método no lanzó la excepción cuando debería haberlo hecho
        } catch (IllegalArgumentException e) {
            assertEquals("Error, la habitacion no. 2 esta pendiente de limpieza", e.getMessage());
        }
        try {
            h2.aprobarLimpieza("Fulanita", true);    //Intentar llamar al método que debería lanzar la excepción
            fail("Se esperaba que aprobarLimpieza lanzara una IllegalArgumentException");   //El método no lanzó la excepción cuando debería haberlo hecho
        } catch (IllegalArgumentException e) {
            assertEquals("Error, la habitacion no. 2 esta pendiente de limpieza", e.getMessage());
        }
    }

    @Test
    public void testMostrarInformacion(){
        Habitacion h3 = new Habitacion(3, "Francisco");
        assertEquals(h3.mostrarInformacion(),"Room no. 3: Free. This room was registered by Francisco\n");

        h3.reservarHabitacion("Mario");
        assertEquals(h3.mostrarInformacion(),"Room no. 3: Booked by Mario. Occupied\n");

        h3.liberarHabitacion();
        assertEquals(h3.mostrarInformacion(),"Room no. 3: Free. Cleaning pending\n");

        h3.limpiarHabitacion("Marcelo");
        assertEquals(h3.mostrarInformacion(), "Room no. 3: Free. Room cleaned by Marcelo, pending approval\n");

        h3.aprobarLimpieza("Felipe", true);
        assertEquals(h3.mostrarInformacion(), "Room no. 3: Free. This room was approved by Felipe\n");

        h3.aprobarLimpieza("Nuria", false);
        assertEquals(h3.mostrarInformacion(), "Room no. 3: Free. This room was not approved by Nuria. Cleaning pending\n");
    }
}
