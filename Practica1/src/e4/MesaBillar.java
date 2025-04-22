package e4;

import java.util.Collections;
import java.util.List;

public class MesaBillar {
    private final List<BolaBillar> bolasMesa;
    private final List<BolaBillar> cajetin;
    private boolean inicio = false;
    private String jugadorBola8 = null;

    public MesaBillar(List<BolaBillar> bolasMesa, List<BolaBillar> cajetin) {
        this.bolasMesa = bolasMesa;
        this.cajetin = cajetin;
    }

    public void iniciarPartida() {
        if (!inicio) {
            cajetin.clear();
            Collections.addAll(bolasMesa, BolaBillar.values());
            jugadorBola8 = null;
            inicio = true;
        }
    }

    public void meterBola(BolaBillar bola, String jugador) {
        if (!inicio || bola == null) {
            throw new IllegalArgumentException("Comprube si la Partida esta Iniciada o si la Bola es Valida");
        }
        if (bola.getNumero() != 0) {
            bolasMesa.remove(bola);
            cajetin.add(bola);
        }
        if (bola.getNumero() == 8) {
            jugadorBola8 = jugador;
            inicio = false;
        }
    }

    public List<BolaBillar> bolasMesa() {  //public int bolasMesa { return bolasMesa.size() }
        return bolasMesa;
    }

    public List<BolaBillar> bolasCajetin() {
        return cajetin;
    }

    public boolean esPartidaIniciada() {
        return inicio;
    }

    //obtenerGanador
    public String obtenerGanador() {

        int lisas = 0;
        int rayadas = 0;
        for (BolaBillar bola : cajetin) {
            if (bola.getNumero() >= 1 && bola.getNumero() <= 7) {
                lisas++;
            } else if (bola.getNumero() >= 9 && bola.getNumero() <= 15) {
                rayadas++;
            }
        }

        if (lisas == 7 && jugadorBola8 != null && jugadorBola8.equals("lisas")) {
            return "Ha ganado el jugador de las bolas lisas";
        } else if (rayadas == 7 && jugadorBola8 != null && jugadorBola8.equals("rayadas")) {
            return "Ha ganado el jugador de las bolas rayadas";
        } else if (jugadorBola8 != null && jugadorBola8.equals("lisas")) {
            return "Ha ganado el jugador de las bolas rayadas";
        } else if (jugadorBola8 != null && jugadorBola8.equals("rayadas")) {
            return "Ha ganado el jugador de las bolas lisas";
        } else if (lisas > rayadas) {
            return "Va ganando el jugador de las bolas lisas";
        } else if (rayadas > lisas) {
            return "Va ganando el jugador de las bolas rayadas";
        } else {
            return "Van empate";
        }
    }
}