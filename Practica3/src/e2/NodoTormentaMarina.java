package e2;

public class NodoTormentaMarina extends NodoRutaFija {  //segundo caso de nodo de ruta fija
        private final int fuerza;

        // Constructor
        public NodoTormentaMarina(NodoFlota hijo, String nombre, int fuerza) {
            super(hijo, nombre);
            this.fuerza = fuerza;
        }

        // Getter
        public int getFuerza() {
            return fuerza;
        }

        @Override
        public void simular(Flota flota) {
            if (flota.getLineaVision() < fuerza) {
                flota.recibirDano(10);
            }
        }
    }


