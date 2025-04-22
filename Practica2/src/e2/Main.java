package e2;

import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        Personaje wizard = new Personaje("Jugador1", Tipo.WIZARD, 20, 10, 8);
        Personaje warrior = new Personaje("Jugador2", Tipo.WARRIOR, 20, 8, 10);
        Ataque ataque = null;
        Defensa defensa = null;
        char atacar;
        char defender;
        boolean terminar = false;

        while (!terminar) {
            System.out.println("a) Probar Ataque");
            System.out.println("b) Lucha");
            System.out.println("c) Salir");
            System.out.println("Elija una opcion:");
            char opcion = scanner.next().charAt(0);

            switch (opcion) {
                case 'a':
                case 'A':
                    System.out.println(wizard.getNombre() + " seleccione un ataque:");
                    System.out.println("a) FireBall");
                    System.out.println("b) Sword");
                    System.out.println("c) Wand");
                    atacar = scanner.next().charAt(0);
                    if (atacar == 'a' || atacar == 'A') {
                        ataque = new FireBall();
                    }
                    if (atacar == 'b' || atacar == 'B') {
                        ataque = new Sword();
                    }
                    if (atacar == 'c' || atacar == 'C') {
                        ataque = new Wand();
                    }
                    wizard.agregarAtaque(ataque);

                    for (int i = 0; i < 5; i++) {
                        do {
                            System.out.println(warrior.getNombre() + " seleccione el objeto de defensa " + (i + 1) + ":");
                            System.out.println("a) Armor");
                            System.out.println("b) Sword");
                            System.out.println("c) Wand");
                            defender = scanner.next().charAt(0);

                            switch (defender) {
                                case 'a':
                                case 'A':
                                    defensa = new Armor();
                                    break;
                                case 'b':
                                case 'B':
                                    defensa = new Sword();
                                    break;
                                case 'c':
                                case 'C':
                                    defensa = new Wand();
                                    break;
                                default:
                                    System.out.println("Introduzca una opcion valida");
                            }
                        } while (defender != 'a' && defender != 'A' && defender != 'b' && defender != 'B' && defender != 'c' && defender != 'C');

                        if (defensa.obtenerFuerzaMin() < warrior.getFuerza()) {
                            warrior.setProteccionTotal(warrior.getProteccionTotal() + defensa.obtenerProteccion());
                        }
                    }

                    wizard.atacar(warrior);

                    break;
                case 'b':
                case 'B':
                    //Elije Jugador1
                    for (int i = 0; i < 5; i++) {
                        do {
                            System.out.println(wizard.getNombre() + " seleccione el objeto de ataque " + (i + 1) + ":");
                            System.out.println("a) FireBall");
                            System.out.println("b) Sword");
                            System.out.println("c) Wand");
                            atacar = scanner.next().charAt(0);

                            switch (atacar) {
                                case 'a':
                                case 'A':
                                    ataque = new FireBall();
                                    break;
                                case 'b':
                                case 'B':
                                    ataque = new Sword();
                                    break;
                                case 'c':
                                case 'C':
                                    ataque = new Wand();
                                    break;
                                default:
                                    System.out.println("Introduzca una opcion valida");
                            }
                        } while (atacar != 'a' && atacar != 'A' && atacar != 'b' && atacar != 'B' && atacar != 'c' && atacar != 'C');
                        wizard.agregarAtaque(ataque);
                    }

                    for (int i = 0; i < 5; i++) {
                        do {
                            System.out.println(wizard.getNombre() + " seleccione el objeto de defensa " + (i + 1) + ":");
                            System.out.println("a) Armor");
                            System.out.println("b) Sword");
                            System.out.println("c) Wand");
                            defender = scanner.next().charAt(0);

                            switch (defender) {
                                case 'a':
                                case 'A':
                                    defensa = new Armor();
                                    break;
                                case 'b':
                                case 'B':
                                    defensa = new Sword();
                                    break;
                                case 'c':
                                case 'C':
                                    defensa = new Wand();
                                    break;
                                default:
                                    System.out.println("Introduzca una opcion valida");
                            }
                        } while (defender != 'a' && defender != 'A' && defender != 'b' && defender != 'B' && defender != 'c' && defender != 'C');

                        if (defensa.obtenerFuerzaMin() < wizard.getFuerza()) {
                            wizard.setProteccionTotal(wizard.getProteccionTotal() + defensa.obtenerProteccion());
                        }
                    }

                    //Elije Jugador2
                    for (int i = 0; i < 5; i++) {
                        do {
                            System.out.println(warrior.getNombre() + " seleccione el objeto de ataque " + (i + 1) + ":");
                            System.out.println("a) FireBall");
                            System.out.println("b) Sword");
                            System.out.println("c) Wand");
                            atacar = scanner.next().charAt(0);

                            switch (atacar) {
                                case 'a':
                                case 'A':
                                    ataque = new FireBall();
                                    break;
                                case 'b':
                                case 'B':
                                    ataque = new Sword();
                                    break;
                                case 'c':
                                case 'C':
                                    ataque = new Wand();
                                    break;
                                default:
                                    System.out.println("Introduzca una opcion valida");
                            }
                        } while (atacar != 'a' && atacar != 'A' && atacar != 'b' && atacar != 'B' && atacar != 'c' && atacar != 'C');
                        warrior.agregarAtaque(ataque);
                    }

                    for (int i = 0; i < 5; i++) {
                        do {
                            System.out.println(warrior.getNombre() + " seleccione el objeto de defensa " + (i + 1) + ":");
                            System.out.println("a) Armor");
                            System.out.println("b) Sword");
                            System.out.println("c) Wand");
                            defender = scanner.next().charAt(0);

                            switch (defender) {
                                case 'a':
                                case 'A':
                                    defensa = new Armor();
                                    break;
                                case 'b':
                                case 'B':
                                    defensa = new Sword();
                                    break;
                                case 'c':
                                case 'C':
                                    defensa = new Wand();
                                    break;
                                default:
                                    System.out.println("Introduzca una opcion valida");
                            }
                        } while (defender != 'a' && defender != 'A' && defender != 'b' && defender != 'B' && defender != 'c' && defender != 'C');

                        if (defensa.obtenerFuerzaMin() < warrior.getFuerza()) {
                            warrior.setProteccionTotal(warrior.getProteccionTotal() + defensa.obtenerProteccion());
                        }
                    }

                    int count=0;    //turnos maximos
                    while (wizard.getVida() > 0 && (!wizard.ataquesVacia() || !warrior.ataquesVacia()) && count<10) {
                        System.out.println("Ronda " + (count+1));
                        if(!wizard.ataquesVacia()){
                            wizard.atacar(warrior);
                        }
                        if (warrior.getVida() <= 0) {
                            break;
                        }
                        if(!warrior.ataquesVacia()){
                            warrior.atacar(wizard);
                        }
                        count++;
                    }

                    if (wizard.getVida() <= 0) {
                        System.out.println("Victoria de " + wizard.getNombre());
                    } else if (warrior.getVida() <= 0) {
                        System.out.println("Victoria de " + warrior.getNombre());
                    } else {
                        System.out.println("Empate");
                    }

                    break;

                case 'c':
                case 'C':
                    System.out.println("Gracias por jugar");
                    terminar = true;

                    break;

                default:
                    System.out.println("Introduzca una opcion valida");
            }
        }

    }
}
