package e2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Personaje {
    private final String nombre;
    private int vida;         //0-20
    private final int fuerza; //0-10
    private int mana;         //0-10
    private int proteccionTotal = 0;
    private List<Ataque> ataques = new ArrayList<>();
    private Tipo tipo;

    public Personaje(String nombre, Tipo tipo, int vida, int fuerza, int mana) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.vida = vida;
        this.fuerza = fuerza;
        this.mana = mana;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getProteccionTotal() {
        return proteccionTotal;
    }

    public void setProteccionTotal(int proteccionTotal) {
        this.proteccionTotal = proteccionTotal;
    }

    public void agregarAtaque(Ataque nuevoAtaque) {
        ataques.add(nuevoAtaque);
    }
    public boolean ataquesVacia() {
        return ataques.isEmpty();
    }

    public void atacar(Personaje objetivo) {
        Ataque a = ataques.get(0);

        System.out.println(getNombre());
        if (getMana() >= a.obtenerMana()) {
                if(a.obtenerDano() - objetivo.getProteccionTotal() > 0){
                    objetivo.setVida(objetivo.getVida() - ( a.obtenerDano() - objetivo.getProteccionTotal()));
                }
                setMana(getMana() - a.obtenerMana());

                System.out.println("Ataque: " + a.obtenerNombre());
                System.out.println("Dano: " + a.obtenerDano());
                System.out.println("Proteccion: " + objetivo.getProteccionTotal());
                System.out.println("Usos: " + (a.obtenerUsos()-1));
                System.out.println("Mana " + getNombre() + ": " + getMana());
                System.out.println("Vida " + objetivo.getNombre() + ": " + objetivo.getVida());
                a.setUsos(a.obtenerUsos()-1);

                if (a.obtenerUsos() <= 0) {
                    ataques.remove(0);
                }
        }else{
            ataques.remove(0);
            System.out.println("No tiene suficiente mana para usar " + a.obtenerNombre());
        }
        System.out.println();
    }
}