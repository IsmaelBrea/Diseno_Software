package e1;

//Subclases
public class Normal extends Cliente {  //los clientes normales no tiene ningún privilegio
    public Normal(String dni, Cuenta cuenta) {
        super(dni, cuenta);
    }

    @Override
    public void ingresar(long cantidad) {
        if (cantidad > 0) {
            if (getCuenta() instanceof CuentaAhorro) {
                //condiciones específicas de cuenta ahorro
                getCuenta().ingresar( cantidad, 1000);
            } else {
                // condiciones de cuenta corriente
                getCuenta().ingresar( cantidad, 0);
            }
        }
    }

    @Override
    public void retirar(long cantidad) {
        if (cantidad > 0) {
            if (getCuenta() instanceof CuentaAhorro) {
                //condiciones específicas de cuenta ahorro
                getCuenta().retirar(cantidad, 0.04f, 300, 0);
            } else {
                // condiciones de cuenta corriente
                getCuenta().retirar(cantidad, 0, 0, 0);
            }
        }
    }
}