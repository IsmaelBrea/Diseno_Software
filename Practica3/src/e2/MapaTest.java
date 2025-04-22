package e2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MapaTest {

    @Test
    public void testSimularIncursion_FlotaA() {
        // Crear los nodos según la estructura del mapa
        NodoFlota nodoFinalD = new NodoFinal("D End");
        NodoFlota nodoFinalK = new NodoFinal("K End");
        NodoFlota nodoFinalH = new NodoFinal("H End");
        NodoFlota nodoFinalI = new NodoFinal("I End");
        NodoAtaqueAereo nodoAtaqueAereoE = new NodoAtaqueAereo(nodoFinalK, "E Airpad", 50);
        NodoBatalla nodoBatallaB = new NodoBatalla(nodoFinalD, nodoAtaqueAereoE, "B Battle", 100, 20, 30);
        NodoTormentaMarina nodoMaelstromG = new NodoTormentaMarina(nodoFinalI, "G Maelstrom", 15);
        NodoBatalla nodoBatallaF = new NodoBatalla(nodoFinalH, nodoMaelstromG, "F Battle", 100, 20, 30);
        NodoTormentaMarina nodoMaelstromC = new NodoTormentaMarina(nodoBatallaF, "C Maelstrom", 15);
        NodoAvistamiento nodoAvistamientoA = new NodoAvistamiento(nodoBatallaB, nodoMaelstromC, "A WaypointingSpotting", 10);

        // Crear la flota A según las características especificadas para éxito
        Flota flotaA = new Flota(11, 42, 47, 0, 0);

        // Imprimir atributos de la flota antes de la incursión
        System.out.println("Flota A antes de la incursión:");
        System.out.println("HP: " + flotaA.getHp());
        System.out.println("Blindaje: " + flotaA.getBlindaje());
        System.out.println("Poder de fuego: " + flotaA.getPoderFuego());
        System.out.println("Antiareos: " + flotaA.getAntiaereo());
        System.out.println("Linea de visión: " + flotaA.getLineaVision());
        System.out.println(" ");

        // Crear el mapa
        Mapa mapa = new Mapa(nodoAvistamientoA);

        // Imprimir el nombre del nodo inicial
        System.out.println("Nodo inicial para la Flota A: " + mapa.getNodoInicial().nombre());



        // Simular la incursión de la Flota A
        mapa.simularIncursion(flotaA);

        // Verificar que el poder aéreo del enemigo es el esperado después de la simulación
        assertEquals(50, nodoAtaqueAereoE.getPoderAereoEnemigo());

        //Verificar que la fuerza de la tormenta es la esperada despues de la simulación
        assertEquals(15,nodoMaelstromG.getFuerza());
        assertEquals(15,nodoMaelstromC.getFuerza());

        //Verificar si la distancia de avistamiento es la esperada después de la simulación
        assertEquals(10, nodoAvistamientoA.getDistancia());

        //Verificar  si los atributos de la flota enemiga son los correctos
        //Batalla B
        assertEquals(100, nodoBatallaB.getHpEnemigo());
        assertEquals(20, nodoBatallaB.getBlindajeEnemigo());
        assertEquals(30, nodoBatallaB.getPoderDeFuegoEnemigo());
        //Batalla F
        assertEquals(100, nodoBatallaF.getHpEnemigo());
        assertEquals(20, nodoBatallaF.getBlindajeEnemigo());
        assertEquals(30, nodoBatallaF.getPoderDeFuegoEnemigo());

        // Verificar resultados esperados con assertions
        assertEquals("FAIL", mapa.getSortieResult());
        assertEquals("F Battle", mapa.getLastVisitedNode().nombre());
        assertEquals(-9, flotaA.getHp());

        //verificar el número  mínimo de nodos necesarios para alcanzar un Nodo final en el mapa
        assertEquals(3, mapa.getSmallestNodeCountToEnd());

        // verificar que la salida en texto en formato newick del mapa de nodos es la esperda
        String representacionEsperada = "(A WaypointingSpotting, (B Battle, (D End), (E Airpad, (K End))), (C Maelstrom, (F Battle, (H End), (G Maelstrom, (I End)))))";
        String representacionGenerada = mapa.representacionEnNewick();
        System.out.println(representacionGenerada);

        // Verificar si la representación Newick generada coincide con la esperada
        assertEquals(representacionEsperada, representacionGenerada);
        System.out.println(" ");

    }


    @Test
    public void testSimularIncursion_FlotaB() {
        // Crear los nodos según la estructura del mapa
        NodoFlota nodoFinalD = new NodoFinal("D End");
        NodoFlota nodoFinalK = new NodoFinal("K End");
        NodoFlota nodoFinalH = new NodoFinal("H End");
        NodoFlota nodoFinalI = new NodoFinal("I End");
        NodoAtaqueAereo nodoAtaqueAereoE = new NodoAtaqueAereo(nodoFinalK, "E Airpad", 50);
        NodoBatalla nodoBatallaB = new NodoBatalla(nodoFinalD, nodoAtaqueAereoE, "B Battle", 100, 20, 30);
        NodoTormentaMarina nodoMaelstromG = new NodoTormentaMarina(nodoFinalI, "G Maelstrom", 15);
        NodoBatalla nodoBatallaF = new NodoBatalla(nodoFinalH, nodoMaelstromG, "F Battle", 100, 20, 30);
        NodoTormentaMarina nodoMaelstromC = new NodoTormentaMarina(nodoBatallaF, "C Maelstrom", 15);
        NodoFlota nodoAvistamientoA = new NodoAvistamiento(nodoBatallaB, nodoMaelstromC, "A WaypointingSpotting", 10);

        // Crear la flota B según las características especificadas para éxito
        Flota flotaB = new Flota(1, 25, 0, 46, 28);

        // Imprimir atributos de la flota antes de la incursión
        System.out.println("Flota B antes de la incursión:");
        System.out.println("HP: " + flotaB.getHp());
        System.out.println("Blindaje: " + flotaB.getBlindaje());
        System.out.println("Poder de fuego: " + flotaB.getPoderFuego());
        System.out.println("Antiareos: " + flotaB.getAntiaereo());
        System.out.println("Linea de visión: " + flotaB.getLineaVision());
        System.out.println(" ");

        // Crear el mapa
        Mapa mapa = new Mapa(nodoAvistamientoA);

        // Imprimir el nombre del nodo inicial
        System.out.println("Nodo inicial para la Flota A: " + mapa.getNodoInicial().nombre());



        // Simular la incursión de la Flota B
        mapa.simularIncursion(flotaB);

        // Verificar que el poder aéreo del enemigo es el esperado después de la simulación
        assertEquals(50, nodoAtaqueAereoE.getPoderAereoEnemigo());

        //Verificar que la fuerza de la tormenta es la esperada despues de la simulación
        assertEquals(15, nodoMaelstromG.getFuerza());
        assertEquals(15, nodoMaelstromC.getFuerza());

        //Verificar  si los atributos de la flota enemiga son los correctos
        //Batalla F
        assertEquals(100, nodoBatallaF.getHpEnemigo());
        assertEquals(20, nodoBatallaF.getBlindajeEnemigo());
        assertEquals(30, nodoBatallaF.getPoderDeFuegoEnemigo());



        // Verificar resultados esperados con assertions
        assertEquals("SUCCESS", mapa.getSortieResult());
        assertEquals("K End", mapa.getLastVisitedNode().nombre());
        assertEquals(192, flotaB.getHp());

        assertEquals(3, mapa.getSmallestNodeCountToEnd());

        // verificar que la salida en texto en formato newick del mapa de nodos es la esperada
        String representacionEsperada = "(A WaypointingSpotting, (B Battle, (D End), (E Airpad, (K End))), (C Maelstrom, (F Battle, (H End), (G Maelstrom, (I End)))))";
        String representacionGenerada = mapa.representacionEnNewick();
        System.out.println(representacionGenerada);

        // Verificar si la representación Newick generada coincide con la esperada
        assertEquals(representacionEsperada, representacionGenerada);
        System.out.println(" ");
    }
}