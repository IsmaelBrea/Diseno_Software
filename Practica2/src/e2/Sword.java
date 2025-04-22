package e2;

//Ataque y Defensa
public class Sword implements Ataque, Defensa{
    //Atributos
    private final int poderAtaque=6;
    private final int usoMana=1;
    private int usos=2;
    private final String codename="Sword";
    private final int proteccion=1;
    private final int fuerzaMin=8;

    //Metodos

    public int getPoderAtaque() {
        return poderAtaque;
    }

    public int getUsoMana() {
        return usoMana;
    }

    public void setUsos(int usos) {
        this.usos = usos;
    }

    public String getCodename() {
        return codename;
    }

    public int getProteccion() { return proteccion; }

    public int getFuerzaMin() {
        return fuerzaMin;
    }

    @Override
    public int obtenerDano() {
        return getPoderAtaque();
    }

    @Override
    public int obtenerMana() {
        return getUsoMana();
    }

    @Override
    public int obtenerUsos() {
        return usos;
    }

    @Override
    public String obtenerNombre() { return getCodename(); }

    @Override
    public int obtenerProteccion() {
        return getProteccion();
    }

    @Override
    public int obtenerFuerzaMin() {
        return getFuerzaMin();
    }
}
