import e2.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonajeTest {
    @Test
    public void testAtributos(){
        Personaje jugador = new Personaje("Jugador1", Tipo.WIZARD, 20, 10, 8);

        assertEquals("Jugador1", jugador.getNombre());
        assertEquals(20, jugador.getVida());
        assertEquals(10, jugador.getFuerza());
        assertEquals(8, jugador.getMana());

        assertEquals(0, jugador.getProteccionTotal());
        Armor armor = new Armor();
        jugador.setProteccionTotal(jugador.getProteccionTotal() + armor.obtenerProteccion());
        assertEquals(2, jugador.getProteccionTotal());

        assertTrue(jugador.ataquesVacia());
        FireBall fireBall = new FireBall();
        jugador.agregarAtaque(fireBall);
        assertFalse(jugador.ataquesVacia());
    }

    @Test
    public void testAtacar(){
        Personaje wizard = new Personaje("Jugador1", Tipo.WIZARD, 20, 10, 8);
        Personaje warrior = new Personaje("Jugador2", Tipo.WARRIOR, 20, 8, 10);

        FireBall fireBall = new FireBall();
        wizard.agregarAtaque(fireBall);
        Armor armor = new Armor();
        warrior.setProteccionTotal(warrior.getProteccionTotal() + armor.obtenerProteccion());

        assertEquals(20, warrior.getVida());
        assertEquals(8, wizard.getMana());
        warrior.setVida(warrior.getVida() - ( fireBall.obtenerDano() - warrior.getProteccionTotal()));
        wizard.setMana(wizard.getMana() - fireBall.obtenerMana());
        assertEquals(14, warrior.getVida());
        assertEquals(6, wizard.getMana());

        assertEquals(2, fireBall.obtenerUsos());
        wizard.atacar(warrior);
        assertEquals(8, warrior.getVida());
        assertEquals(4, wizard.getMana());
        assertEquals(1, fireBall.obtenerUsos());

        wizard.atacar(warrior);
        assertTrue(wizard.ataquesVacia());
    }
}
