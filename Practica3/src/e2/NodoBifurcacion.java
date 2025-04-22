package e2;

//Tercer y último tipo de nodo. Nodos que tiene un único hijo (puede ser de dos tipos)
public abstract class NodoBifurcacion extends NodoRutaFija {
    protected NodoFlota hijoDerecho;

    // Constructor
    public NodoBifurcacion(NodoFlota hijoIzquierdo, NodoFlota hijoDerecho, String nombre) {
        super(hijoIzquierdo, nombre);
        this.hijoDerecho = hijoDerecho;
    }

    // Getter
    public NodoFlota getHijoDerecho() {
        return hijoDerecho;
    }

    // Método abstracto para decidir el camino
    protected abstract NodoFlota decidirCamino(Flota flota);
    @Override
    public void simular(Flota flota) {
        NodoFlota siguienteNodo = decidirCamino(flota);
        siguienteNodo.simular(flota);
    }
}