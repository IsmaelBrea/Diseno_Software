package e1;

public abstract class Cliente {
    //Atributos
    private final String dni; //un cliente tiene un dni
    private Cuenta cuenta; //una cuenta de banco pertenece a un solo cliente

    //método constructor
    public Cliente(String dni, Cuenta cuenta) {
        this.dni = dni;
        this.cuenta = cuenta;
    }


    //getters y setters
    public String getDni() {
        return dni;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }


    //métodos abstractos para las subclases
    public abstract void ingresar(long cantidad);

    public abstract void retirar(long cantidad);
}