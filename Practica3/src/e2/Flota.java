package e2;


public class Flota {
    //atributos que puede tener una flota
    private int hp;
    private final int blindaje;
    private final int poderFuego;
    private final int antiaereo;
    private final int lineaVision;


    //constructor
    public Flota(int hp, int blindaje, int poderFuego, int antiaereo, int lineaVision) {
        this.hp = hp;
        this.blindaje = blindaje;
        this.poderFuego = poderFuego;
        this.antiaereo = antiaereo;
        this.lineaVision = lineaVision;
    }

    //Getters y setters para los atributos de la flota
    public int getHp() {
        return hp;
    }

    public int getBlindaje() {
        return blindaje;
    }

    public int getPoderFuego() {
        return poderFuego;
    }

    public int getAntiaereo() {
        return antiaereo;
    }

    public int getLineaVision() {
        return lineaVision;
    }

    //método adicional para disminuir el hp de la flota en caso de que le ataquen
    public void recibirDano(int dano) {
        this.hp -= dano;
    }

    //método adicional para comprobar si la flota tiene HP
    public boolean estaViva() {
        return this.hp > 0;
    }
}
