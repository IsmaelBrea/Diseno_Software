package e2;

public class NodoBatalla extends NodoBifurcacion { //primer caso de nodo de bifurcación
    //atributos de una flota enemiga
    private int hpEnemigo;
    private final int blindajeEnemigo;
    private final int poderDeFuegoEnemigo;

    // Constructor
    public NodoBatalla(NodoFlota hijoIzquierdo, NodoFlota hijoDerecho, String nombre, int hpEnemigo, int blindajeEnemigo, int poderDeFuegoEnemigo) {
        super(hijoIzquierdo, hijoDerecho, nombre);
        this.hpEnemigo = hpEnemigo;
        this.blindajeEnemigo = blindajeEnemigo;
        this.poderDeFuegoEnemigo = poderDeFuegoEnemigo;
    }

    // Getters
    public int getHpEnemigo() {
        return hpEnemigo;
    }

    public int getBlindajeEnemigo() {
        return blindajeEnemigo;
    }

    public int getPoderDeFuegoEnemigo() {
        return poderDeFuegoEnemigo;
    }

    //método para decidir que camino toma un nodo de batalla
    @Override
    protected NodoFlota decidirCamino(Flota flota) {
        return hpEnemigo <= 0 ? getHijo() : getHijoDerecho();
    }

    @Override
    public void simular(Flota flota) {
        int danoAFlota = poderDeFuegoEnemigo - flota.getBlindaje();
        int danoAEnemigo = flota.getPoderFuego() - blindajeEnemigo;
        flota.recibirDano(danoAFlota);
        hpEnemigo -= danoAEnemigo;
        super.simular(flota);
    }
}
