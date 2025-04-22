package e1;

//subclase que hereda de la clase abstracta Cuenta
public class CuentaAhorro extends Cuenta {

    //método constructor
    public CuentaAhorro(String iban, long saldo) {
        super(iban, saldo);
    }


    //métodos
    @Override
    public void ingresar(long dinero, int min) {
        if (dinero > min) {
            setSaldo(getSaldo() + dinero);
            System.out.println("Dinero ingresado: " + dinero + " centimos");
        } else {
            throw new IllegalArgumentException("La cantidad a ingresar no es válida");
        }
    }

    @Override
    public void retirar(long dinero, float comision, int min, long deuda) {
        if (getSaldo() - dinero >= -deuda) {
            if (dinero > 0) {
                long comisionCalculada = Math.max((long) (dinero * comision), min);
                long nuevoSaldo = getSaldo() - dinero - comisionCalculada;

                setSaldo(Math.max(nuevoSaldo, -deuda));

                System.out.println("Dinero retirado: " + dinero + " centimos");
            } else {
                throw new IllegalArgumentException("La cantidad a retirar no es válida");
            }
        } else {
            throw new IllegalArgumentException("No le queda suficiente dinero en la cuenta para cubrir la deuda");
        }
    }
}