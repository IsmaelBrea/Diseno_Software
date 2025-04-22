package e2;

//Ataque
public class FireBall implements Ataque {
    //Atributos
    private final int poderAtaque=8;
    private final int usoMana=2;
    private int usos=2;
    private final String codename="FireBall";

    //Metodos
    public int obtenerDano() {
        if (usos == 1) {
            return poderAtaque - 1;
        } else {
            return poderAtaque;
        }
    }

    public String getCodename() {
        return codename;
    }

    public int obtenerMana() {
        return usoMana;
    }

    public int obtenerUsos() {
        return usos;
    }
    public void setUsos(int usos) {
        this.usos = usos;
    }
    public String obtenerNombre(){ return getCodename(); }
}
