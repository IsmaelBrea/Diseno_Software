package e1;

public abstract class Cuenta {
    //Atributos
    private final String iban;
    private long saldo;  //en centimos

    //Método constructor
    public Cuenta(String iban, long saldo) {
        this.iban = iban;
        this.saldo = saldo;
    }

    //getters y setters
    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    public  String getIban() {
        return iban;
    }


    //métodos abstractos para las subclases para consultar y modificar el saldo
    public long consultarSaldo() {
        System.out.println("El saldo actual de la cuenta "+getIban()+ " es de : " + getSaldo() + " centimos");
        return getSaldo();
    }

    public abstract void ingresar (long dinero, int min);
    public abstract void retirar (long dinero, float comision, int min, long deuda);

}

