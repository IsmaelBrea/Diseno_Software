import e4.MesaBillar;
import e4.BolaBillar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class MesaBillarTest {
    private MesaBillar mesa;

    @BeforeEach
    public void setUp() {
        List<BolaBillar> bolasMesa = new ArrayList<>();
        List<BolaBillar> cajetin = new ArrayList<>();
        mesa = new MesaBillar(bolasMesa, cajetin);
    }

    @Test
    public void testIniciarPartida() {
        assertFalse(mesa.esPartidaIniciada());
        mesa.iniciarPartida();
        assertTrue(mesa.esPartidaIniciada());
        assertEquals(16, mesa.bolasMesa().size());
        assertEquals(0, mesa.bolasCajetin().size());
    }

    @Test
    public void testMeterBola() {
        mesa.iniciarPartida();
        BolaBillar bola = BolaBillar.BOLA1;
        mesa.meterBola(bola, "lisas");
        assertFalse(mesa.bolasMesa().isEmpty());
        assertFalse(mesa.bolasCajetin().isEmpty());
        assertTrue(mesa.esPartidaIniciada());
        BolaBillar bola8 = BolaBillar.BOLA8;
        mesa.meterBola(bola8, "lisas");
        assertFalse(mesa.esPartidaIniciada());
    }

    @Test
    public void testMeterBolaInvalida() {
        mesa.iniciarPartida();
        assertThrows(IllegalArgumentException.class, () -> mesa.meterBola(null, "lisas"));
    }

    @Test
    public void testObtenerGanador() {
        mesa.iniciarPartida();
        mesa.meterBola(BolaBillar.BOLA1, "lisas");
        mesa.meterBola(BolaBillar.BOLA9, "rayadas");
        assertEquals("Van empate", mesa.obtenerGanador());

        mesa.meterBola(BolaBillar.BOLA8, "lisas");
        assertEquals("Ha ganado el jugador de las bolas rayadas", mesa.obtenerGanador());

        mesa.iniciarPartida();
        mesa.meterBola(BolaBillar.BOLA2, "lisas");
        assertEquals("Va ganando el jugador de las bolas lisas", mesa.obtenerGanador());

        mesa.meterBola(BolaBillar.BOLA10, "rayadas");
        mesa.meterBola(BolaBillar.BOLA11, "rayadas");
        assertEquals("Va ganando el jugador de las bolas rayadas", mesa.obtenerGanador());

        mesa.meterBola(BolaBillar.BOLA1, "lisas");
        mesa.meterBola(BolaBillar.BOLA3, "lisas");
        mesa.meterBola(BolaBillar.BOLA4, "lisas");
        mesa.meterBola(BolaBillar.BOLA5, "lisas");
        mesa.meterBola(BolaBillar.BOLA6, "lisas");
        mesa.meterBola(BolaBillar.BOLA7, "lisas");
        mesa.meterBola(BolaBillar.BOLA8, "lisas");
        assertEquals("Ha ganado el jugador de las bolas lisas", mesa.obtenerGanador());

    }
}