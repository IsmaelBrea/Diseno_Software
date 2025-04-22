package e2;

//Ataque y Defensa
public class Wand implements Ataque, Defensa {
    //Atributos
    private final int poderAtaque=5;
    private final int usoMana=1;
    private int usos=2;
    private boolean usado = false;
    private final String codename="Wand";
    private final int proteccion=1;
    private final int fuerzaMin=3;

    //Ataque
    public int getPoderAtaque() {
        return poderAtaque;
    }

    public int getUsoMana() {
        return usoMana;
    }


    public void setUsos(int usos) {
        if (!isUsado()) {
            setUsado(true);
        }
        this.usos = usos;
    }

    public boolean isUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }

    public String getCodename() {
        return codename;
    }

    @Override
    public int obtenerDano() {
        if (!isUsado()) {
            return 2 * getPoderAtaque();
        } else {
            return getPoderAtaque();
        }

    }

    @Override
    public int obtenerMana() { return getUsoMana(); }
    @Override
    public int obtenerUsos() { return usos; }
    @Override
    public String obtenerNombre() { return getCodename(); }

    //Defensa
    public int getProteccion() {
        return proteccion;
    }

    public int getFuerzaMin() {
        return fuerzaMin;
    }

    @Override
    public int obtenerProteccion() {
        return getProteccion();
    }

    @Override
    public int obtenerFuerzaMin() { return getFuerzaMin(); }
}
