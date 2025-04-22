package e2;

public class NodoAtaqueAereo extends NodoRutaFija { //primer caso de nodo de ruta fija
    private final int poderAereoEnemigo;

    //constructor
    public NodoAtaqueAereo(NodoFlota hijo, String nombre, int poderAereoEnemigo) {
        super(hijo, nombre);
        this.poderAereoEnemigo = poderAereoEnemigo;
    }

    //getter
    public int getPoderAereoEnemigo() {
        return poderAereoEnemigo;
    }

    @Override
    public void simular(Flota flota) {
        int dano = poderAereoEnemigo - (2 * flota.getAntiaereo() + flota.getBlindaje());
        flota.recibirDano(dano);
    }
}

