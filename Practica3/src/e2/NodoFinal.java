package e2;

//Primer tipo de nodo. Aquí finaliza siempre la incursión e indicará si la flota ha fracasado o ha salido exitosa
public record NodoFinal(String nombre) implements NodoFlota {
    @Override
    public void simular(Flota flota) {
        if (flota.getHp() > 0) {
            System.out.println("La incursión ha sido exitosa.\n");
        } else {
            System.out.println("La incursión ha fracasado.\n");
        }
    }
}
