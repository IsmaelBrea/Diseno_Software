package e2;

public class NodoAvistamiento extends NodoBifurcacion { //segundo caso de nodo de bifurcación
    private final int distancia;

    // Constructor
    public NodoAvistamiento(NodoFlota hijoIzquierdo, NodoFlota hijoDerecho, String nombre, int distancia) {
        super(hijoIzquierdo, hijoDerecho, nombre);
        this.distancia = distancia;
    }

    // Getter
    public int getDistancia() {
        return distancia;
    }

    @Override
    protected NodoFlota decidirCamino(Flota flota) {
        return flota.getLineaVision() >= distancia ? getHijo() : getHijoDerecho();
    }

    @Override
    public void simular(Flota flota) {
        super.simular(flota);
    }
}
