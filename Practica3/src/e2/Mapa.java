package e2;

//clase que crea el mapa a partir de los nodos
public class Mapa {
    private final NodoFlota nodoInicial;
    private String sortieResult;
    private NodoFlota lastVisitedNode;

    // Constructor
    public Mapa(NodoFlota nodoInicial) {
        this.nodoInicial = nodoInicial;
    }


    public NodoFlota getNodoInicial() {
        return nodoInicial;
    }

    //devuelve SUCCESS si la incursión ha sido exitosa o FAIL si ha fracasado
    public String getSortieResult() {
        return sortieResult;
    }

    //devuelve el último nodo visitado
    public NodoFlota getLastVisitedNode() {
        return lastVisitedNode;
    }

    //devuelve el número mínimo de nodos que hay que recorrer hasta llegar al primer nodo final
    public int getSmallestNodeCountToEnd() {
        return getDepth(nodoInicial);
    }


    public void simularIncursion(Flota flota) {
        NodoFlota nodoActual = nodoInicial;

        while (flota.estaViva() && !(nodoActual instanceof NodoFinal)) {
            nodoActual.simular(flota);
            if (nodoActual instanceof NodoBifurcacion) {
                nodoActual = ((NodoBifurcacion) nodoActual).decidirCamino(flota);
            } else {
                nodoActual = ((NodoRutaFija) nodoActual).getHijo();
            }
        }

        if (nodoActual instanceof NodoFinal) {
            nodoActual.simular(flota);
        }

        sortieResult = flota.estaViva() ? "SUCCESS" : "FAIL";
        //SUCCES (hp>0, la incursión ha sido un éxito)
        //FAIL (hp<=0, la incursión ha fracasado)
        lastVisitedNode = nodoActual;

        System.out.println("Sortie Result: \n"+ "\t" +sortieResult);
        System.out.println("\tLast Visited Node: " + nodoActual.nombre());
        System.out.println("\tFinal HP: " + flota.getHp());
        System.out.println("\n");
        System.out.println("\tSmallest Node Count to End: " + (getSmallestNodeCountToEnd() ));

    }

    public String representacionEnNewick() {
        StringBuilder sb = new StringBuilder();
        construirRepresentacionEnNewick(nodoInicial, sb);
        return sb.toString();
    }

    private void construirRepresentacionEnNewick(NodoFlota nodo, StringBuilder sb) {
        if (nodo == null) {
            return;
        }

        sb.append("(");
        sb.append(nodo.nombre());

        if (nodo instanceof NodoBifurcacion bifurcacion) {
            construirRepresentacionEnNewick(bifurcacion.getHijo(), sb.append(", "));
            construirRepresentacionEnNewick(bifurcacion.getHijoDerecho(), sb.append(", "));
        } else if (nodo instanceof NodoRutaFija rutaFija) {
            construirRepresentacionEnNewick(rutaFija.getHijo(), sb.append(", "));
        }

        sb.append(")");
    }


    // Método para obtener el número mínimo de nodos necesarios  para alcanzar un nodo final en el mapa de manera recursiva
    private int getDepth(NodoFlota nodo) {
        if (nodo instanceof NodoFinal) {
            return 1;
        } else if (nodo instanceof NodoBifurcacion bifurcacion) {
            return 1 + Math.min(getDepth(bifurcacion.getHijo()), getDepth(bifurcacion.getHijoDerecho()));
        } else if (nodo instanceof NodoRutaFija rutaFija) {
            return 1 + getDepth(rutaFija.getHijo());
        }
        return Integer.MAX_VALUE;
    }
}
