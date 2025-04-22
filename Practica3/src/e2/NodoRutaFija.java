package e2;

//Segundo tipo de nodo. Nodos que tiene un único hijo (puede ser de dos tipos)
public abstract class NodoRutaFija implements NodoFlota { //clase abstracta
    protected NodoFlota hijo;  //hijo del nodo de ruta fija
    protected String nombre;  //nombre del nodo de ruta fija


    //constructor
    public NodoRutaFija(NodoFlota hijo, String nombre) {
        this.hijo = hijo;
        this.nombre = nombre;
    }

    //Getters y setters
    public NodoFlota getHijo() {
        return hijo;
    }

    public String nombre() {
        return nombre;
    }

}
