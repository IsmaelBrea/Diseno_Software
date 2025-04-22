package e2;

//Defensa
public class Armor implements Defensa{
    //Atributos
    private final int proteccion=2;
    private final int fuerzaMin=6;
    private final String codename="Armor";

    //Metodos
    public int getProteccion() {
        return proteccion;
    }
    public int getFuerzaMin() {
        return fuerzaMin;
    }
    public String getCodename() {
        return codename;
    }
    @Override
    public int obtenerProteccion() {
        return getProteccion();
    }
    @Override
    public int obtenerFuerzaMin() {
        return getFuerzaMin();
    }

    public String obtenerNombre(){ return getCodename(); }
}
