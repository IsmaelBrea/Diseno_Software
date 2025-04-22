package e1;

public class Preferente extends Cliente {  //el clientePreferente puede sacar dinero dejando la cuenta en
    // negativo siempre que no supere los 1000 euros de deuda. En las cuenta ahorro el mínimo de ingreso es de 500
    //euros y la la comisión de retirada es del 2% con un mínimo de 1 euro

    public Preferente(String dni, Cuenta cuenta) {
        super(dni, cuenta);
    }


    @Override
    public void ingresar(long cantidad) {
        if (cantidad > 0) {
            if (getCuenta() instanceof CuentaAhorro) {
                //condiciones específicas de cuenta ahorro
                getCuenta().ingresar( cantidad, 50000);  //el límite de ingreso en las cuentas ahorro se rebaja a 500 euros
            } else {
                //condiciones de cuenta corriente
                getCuenta().ingresar(cantidad, 0);
            }
        }
    }

    @Override
    public void retirar(long cantidad) {
        if (cantidad > 0) {
            if (getCuenta() instanceof CuentaAhorro) {
                //condiciones específicas de cuenta ahorro
                getCuenta().retirar(cantidad, 0.02f, 100, 100000); //la comisión se baja al 2% y mínimo de 1 euro.
                //La deuda no puede superar los 1000 euros
            } else {
                //condiciones de cuenta corriente
                getCuenta().retirar(cantidad, 0, 0, 100000);  //La deuda tampoco puede superar los 1000 euros en cuentaCorriente
            }
        }
    }

}