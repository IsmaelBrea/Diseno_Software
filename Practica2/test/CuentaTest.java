import e1.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CuentaTest {
    //Cuenta Corriente: sin restricciones para ingresar ni retirar dinero
    //Cuenta Ahorro : mínimo de 1000 euros para ingresar dinero, y comisión del 4% con un mínimo de 3 euros para retirar dinero
    //Ninguna cuenta puede retirar más dinero del que tiene


    @Test
    public void testConsultarSaldo() {    //consultar saldo de las cuentas

        Cuenta cuenta1 = new CuentaCorriente("ES2320381234987654321090", 500000);
        assertEquals(500000, cuenta1.consultarSaldo());

        Cuenta cuenta2 = new CuentaAhorro("ES3630123456789012345678", 200000);
        assertEquals(200000, cuenta2.consultarSaldo());

    }

    @Test
    public void testIngresar() {   //ingresar dinero correctamente en las cuentas
        Cuenta cuenta1 = new CuentaCorriente("ES2320381234987654321090", 500000);
        cuenta1.ingresar(3000000, 0);
        assertEquals(3500000, cuenta1.consultarSaldo());
        cuenta1.ingresar(2000000, 0);
        assertEquals(5500000, cuenta1.consultarSaldo());

        Cuenta cuenta2 = new CuentaAhorro("ES3630123456789012345678", 200000);
        cuenta2.ingresar(3000000, 100000);
        assertEquals(3200000, cuenta2.consultarSaldo());
        cuenta2.ingresar(2000000, 100000);
        assertEquals(5200000, cuenta2.consultarSaldo());
    }

    @Test
    public void testIngresarMal() {  //no se pueden ni ingresar cantidades negativas ni menos del mínimo establecido
        Cuenta cuenta1 = new CuentaCorriente("ES2320381234987654321090", 500000);
        try {
            cuenta1.ingresar(-100000, 0);
        } catch (IllegalArgumentException excepcion) {
            // Imprimir el mensaje de la excepción
            System.out.println(excepcion.getMessage());
        }

        Cuenta cuenta2 = new CuentaAhorro("ES3630123456789012345678", 200000);
        try {
            cuenta2.ingresar(500, 100000);
        } catch (IllegalArgumentException excepcion) {
            // Imprimir el mensaje de la excepción
            System.out.println(excepcion.getMessage());
        }

    }

    @Test
    public void testRetirarBien() {   //retirar dinero correctamente en las cuentas
        //Retirar dinero en cuenta corriente (no hay restricciones)
        Cuenta cuenta1 = new CuentaCorriente("ES2320381234987654321090", 500000);
        cuenta1.retirar(100000, 0, 0, 0);
        assertEquals(400000, cuenta1.consultarSaldo());

        //Retirar dinero en cuenta ahorro con mínimo mayor que 3 euros
        Cuenta cuenta2 = new CuentaAhorro("ES3630123456789012345678", 100000);
        cuenta2.retirar(40000, 0.04f, 300, 0);
        assertEquals(58400, cuenta2.consultarSaldo());

        //Retirar dinero en cuenta ahorro con mínimo menor de 3 euros
        Cuenta cuenta3 = new CuentaAhorro("ES3630123456789012345678", 100000);
        cuenta3.retirar(5000, 0.04f, 300, 0);
        assertEquals(94700, cuenta3.consultarSaldo());

    }

    @Test
    public void testRetirarMal() { //retirar una cantidad negativa
        Cuenta cuenta1 = new CuentaCorriente("ES2320381234987654321090", 500000);
        try {
            cuenta1.retirar(-400000,0,0,0);
        } catch (IllegalArgumentException excepcion) {
            // Imprimir el mensaje de la excepción
            System.out.println("Error: " +excepcion.getMessage());
        }

        Cuenta cuenta2 = new CuentaAhorro("ES3630123456789012345678", 200000);
        try {
            cuenta2.retirar(-100000,0.04f,300,0);
        } catch (IllegalArgumentException excepcion) {
            // Imprimir el mensaje de la excepción
            System.out.println("Error: " + excepcion.getMessage());
        }

    }


    @Test
    public void testRetirarMasDelSaldo() {
        //Retirar más dinero de que se tiene en cuenta corriente
        Cuenta cuenta1 = new CuentaCorriente("ES2320381234987654321090", 500000);
        try {
            cuenta1.retirar(650000,0,0,0);
        } catch (IllegalArgumentException excepcion) {
            // Imprimir el mensaje de la excepción
            System.out.println("Error: " +excepcion.getMessage());
        }

        //Retirar más dinero del que se tiene en cuenta ahorro
        Cuenta cuenta2 = new CuentaCorriente("ES3630123456789012345678", 200000);
        try {
            cuenta2.retirar(300000,0.04f,300,0);
        } catch (IllegalArgumentException excepcion) {
            // Imprimir el mensaje de la excepción
            System.out.println("Error: " + excepcion.getMessage());
        }

    }



    @Test
    public void testRetiroConDeuda() { //retirar dinero coreectamente en las cuentas con deuda
        Cuenta cuenta1 = new CuentaCorriente("ES2320381234987654321090", 500000);
        try {
            cuenta1.retirar(800000, 0, 0, -200000);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        Cuenta cuenta2 = new CuentaAhorro("ES3630123456789012345678", 200000);
        try {
            cuenta2.retirar(300000, 0.04f, 300, -50000);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    @Test
    public void testRetirarEIngresar() {
        //retirar e ingresar  dinero en cuenta corriente
        Cuenta cuenta1 = new CuentaCorriente("ES2320381234987654321090", 500000);
        cuenta1.retirar(300000, 0, 0, 0);
        assertEquals(200000, cuenta1.consultarSaldo());
        cuenta1.ingresar(200000,0);
        assertEquals(400000, cuenta1.consultarSaldo());

        //retirar e ingresar dinero en cuenta ahorro
        Cuenta cuenta2 = new CuentaAhorro("ES3630123456789012345678", 200000);
        cuenta2.ingresar(200000, 100000);  //mínimo de 1000 euros
        assertEquals(400000, cuenta2.consultarSaldo());
        cuenta2.retirar(350000,0.04f,300,0);
        assertEquals(36000,cuenta2.consultarSaldo());

    }

}