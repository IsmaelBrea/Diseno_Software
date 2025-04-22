import e4.BolaBillar;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BolaBillarTest {
    @Test
    public void testValoresEnumerados() {
        // Comprobación de valores enumerados

        assertEquals(0, BolaBillar.BLANCA.getNumero());
        assertEquals("BLANCO", BolaBillar.BLANCA.getColor());
        assertEquals("LISA", BolaBillar.BLANCA.getTipo());

        assertEquals(8, BolaBillar.BOLA8.getNumero());
        assertEquals("NEGRO", BolaBillar.BOLA8.getColor());
        assertEquals("LISA", BolaBillar.BOLA8.getTipo());

        assertEquals(15, BolaBillar.BOLA15.getNumero());
        assertEquals("GRANATE", BolaBillar.BOLA15.getColor());
        assertEquals("RAYADA", BolaBillar.BOLA15.getTipo());

        assertEquals(1, BolaBillar.BOLA1.getNumero());
        assertEquals("AMARILLO", BolaBillar.BOLA1.getColor());
        assertEquals("LISA", BolaBillar.BOLA1.getTipo());
    }

    @Test
    public void testExcepciones() {
        // Comprobación de excepciones

        // Intenta obtener un valor fuera del rango de enumerados
        assertThrows(IllegalArgumentException.class, () -> BolaBillar.valueOf("BOLA16"));

        // Intenta obtener un valor con minusculas
        assertThrows(IllegalArgumentException.class, () -> BolaBillar.valueOf("blanca"));

        // Introduce valores incorrectos
        assertNotEquals(15, BolaBillar.BOLA7.getNumero());
        assertNotEquals("VERDE", BolaBillar.BOLA7.getColor());
        assertNotEquals("RAYADA", BolaBillar.BOLA7.getTipo());
    }
}
