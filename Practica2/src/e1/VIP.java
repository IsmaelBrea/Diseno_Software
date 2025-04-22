package e1;

public class VIP extends Cliente { //los clientes VIP pueden sacar dinero dejando las cuentas en negativo. En las cuenta ahorro no hay mínimo de ingreso ni comisión
    public VIP(String dni, Cuenta cuenta) {
        super(dni, cuenta);
    }
    @Override
    public void ingresar(long cantidad) {
        if (cantidad > 0) {
            // VIP puede ingresar sin límite en cuenta ahorro y sin comisión
            if (getCuenta() instanceof CuentaAhorro) {
                getCuenta().ingresar(cantidad, 0);
            } else {
                getCuenta().ingresar(cantidad, 0);
            }
        }
    }
    @Override
    public void retirar(long cantidad) { //retirar para VIP es igual en ambas cuentas, ya que se quita la comisión y no hay mímimo de deuda
        if (cantidad > 0) {
            // VIP puede retirar sin límite de saldos negativos y sin comisión en todas las cuentas
            getCuenta().retirar(cantidad, 0, 0, Long.MIN_VALUE);
        }
    }
}