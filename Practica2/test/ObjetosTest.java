import e2.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ObjetosTest {
    @Test
    public void testAtaque(){
        FireBall fireball = new FireBall();
        Sword sword = new Sword();
        Wand wand =new Wand();

        //resta 1 a su poder de ataque cuando solo le queda un uso
        System.out.println(fireball.getCodename()+", usos: "+fireball.obtenerUsos());
        assertEquals("FireBall", fireball.obtenerNombre());
        assertEquals(2, fireball.obtenerUsos());
        assertEquals(2, fireball.obtenerMana());
        assertEquals(8, fireball.obtenerDano());

        fireball.setUsos(fireball.obtenerUsos()-1);

        System.out.println(fireball.getCodename()+", usos: "+fireball.obtenerUsos());
        assertEquals(1, fireball.obtenerUsos());
        assertEquals(7, fireball.obtenerDano());

        System.out.println(sword.getCodename());
        assertEquals("Sword", sword.obtenerNombre());
        assertEquals(2, sword.obtenerUsos());
        assertEquals(1, sword.obtenerMana());
        assertEquals(6, sword.obtenerDano());

        //multiplica por 2 su poder de ataque en el primer uso
        System.out.println(wand.getCodename()+", usos: "+wand.obtenerUsos());
        assertEquals("Wand", wand.obtenerNombre());
        assertEquals(2, wand.obtenerUsos());
        assertEquals(1, wand.obtenerMana());
        assertEquals(10, wand.obtenerDano());
        assertFalse(wand.isUsado());

        wand.setUsos(wand.obtenerUsos()-1);

        System.out.println(wand.getCodename()+", usos: "+wand.obtenerUsos());
        assertEquals(1, wand.obtenerUsos());
        assertEquals(5, wand.obtenerDano());
        assertTrue(wand.isUsado());
    }

    @Test
    public void testDefensa(){
        Armor armor = new Armor();
        Sword sword = new Sword();
        Wand wand =new Wand();

        System.out.println(armor.getCodename());
        assertEquals("Armor", armor.obtenerNombre());
        assertEquals(2, armor.obtenerProteccion());
        assertEquals(6, armor.obtenerFuerzaMin());

        System.out.println(sword.getCodename());
        assertEquals(1, sword.obtenerProteccion());
        assertEquals(8, sword.obtenerFuerzaMin());

        System.out.println(wand.getCodename());
        assertEquals(1, wand.obtenerProteccion());
        assertEquals(3, wand.obtenerFuerzaMin());
    }


}
