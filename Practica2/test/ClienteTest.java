import e1.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {
    //Normal: ningun privilegio
    //Preferente: puede sacar dinero dejando la cuenta en negativo siempre que no supere los 1000 euros de deuda. En las
    //cuentas ahorro el mínimo son 500 euros y la comisión de retirada es del 2% con un mínimo de 1 euro
    //VIP: pueden sacar dinero dejando las cuentas en negativo. En las cuenta ahorro no hay mínimo de ingreso ni comisión

    @Test
    public void testRetirarEIngresarClienteNormalCC() { //retirar e ingresar cliente Normal en cuenta corriente
        Cuenta cuenta1 = new CuentaCorriente("ES2320381234987654321090", 500000);
        Cliente clienteNormal1 = new Normal("12345678A", cuenta1);
        System.out.println("El cliente con DNI: " + clienteNormal1.getDni() + " tiene un saldo en la cuenta1 de" + cuenta1.getSaldo());

        // Retirar e ingresar dinero en cuenta corriente
        clienteNormal1.retirar(200000);
        assertEquals(300000, cuenta1.consultarSaldo());
        clienteNormal1.ingresar(400000);
        assertEquals(700000, cuenta1.consultarSaldo());
    }

    @Test
    public void testRetirarEIngresarClienteNormalCA() {  //retirar e ingresar cliente Normal en cuenta ahorro
        Cuenta cuenta2 = new CuentaAhorro("ES3630123456789012345678", 200000);
        Cliente clienteNormal1 = new Normal("123456789A", cuenta2);
        System.out.println("El cliente con DNI: " + clienteNormal1.getDni() + " tiene un saldo en la cuenta2 de" + cuenta2.getSaldo());

        clienteNormal1.retirar(50000);
        assertEquals(148000, cuenta2.consultarSaldo());  //comisión del 4% de cuenta ahorro

        clienteNormal1.ingresar(200000); //ingreso mínimo de 1000 euros
        assertEquals(348000, cuenta2.consultarSaldo());
    }

    //los casos  en los que se retira o se ingresa mal para ClienteNormal ya se comprueban en CuentaTest ya que Normal no tiene restricciones



    @Test
    public void testRetirarEIngresarClientePreferenteCC() { //retirar e ingresar cliente Preferente en cuenta corriente
        Cuenta cuenta3 = new CuentaCorriente("ES7620381234987654321090", 600000);
        Cliente clientePreferente1 = new Preferente("87654321A", cuenta3);
        System.out.println("El cliente con DNI: " + clientePreferente1.getDni() + " tiene un saldo en la cuenta3 de" + cuenta3.getSaldo());

        // Retirar e ingresar dinero en Cliente Preferente
        clientePreferente1.retirar(300000);  //retiro de dinero sin comisión al ser cuenta corriente y con deuda mínima de 1000 euros
        assertEquals(300000, cuenta3.consultarSaldo());

        clientePreferente1.ingresar(100000); //ingreso sin un mínimo
        assertEquals(400000, cuenta3.consultarSaldo());
    }


    @Test
    public void testRetirarEIngresarClientePreferenteCA() {//retirar e ingresar cliente Preferente en cuenta ahorro
        Cuenta cuenta4 = new CuentaAhorro("ES6730123456789012345678", 200000);
        Cliente clientePreferente1 = new Preferente("87654321A", cuenta4);
        System.out.println("El cliente con DNI: " + clientePreferente1.getDni() + " tiene un saldo en la cuenta4 de" + cuenta4.getSaldo());

        // Retirar e ingresar dinero en Cliente Preferente
        clientePreferente1.retirar(180000);  //retiro de dinero con comisión del 2% y mínimo de 1 euro y con deuda mínima de 1000 euros
        assertEquals(16400, cuenta4.consultarSaldo());

        clientePreferente1.ingresar(100000); //ingreso con un mínimo de 500 euros
        assertEquals(116400, cuenta4.consultarSaldo());
    }

    @Test
    public void testRetirarConDeudaSuperadaClientePreferenteCA() { //retiro fallido de dinero al superar la deuda mínima de 1000 euros en Cliente Preferente
        Cuenta cuenta4 = new CuentaAhorro("ES6730123456789012345678", 200000);
        Cliente clientePreferente1 = new Preferente("87654321A", cuenta4);
        System.out.println("El cliente con DNI: " + clientePreferente1.getDni() + " tiene un saldo en la cuenta4 de" + cuenta4.getSaldo());

        // Retirar dinero que supera la deuda mínima permitida
        try {
            clientePreferente1.retirar(1500000); // Intento de retiro que supera la deuda mínima de 1000 euros
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }


    @Test
    public void testIngresarMenosDelMinimoClientePreferenteCA() { //ingresar dinero por debajo del mínimo exigido en Cliente Preferente
        Cuenta cuenta4 = new CuentaAhorro("ES6730123456789012345678", 200000);
        Cliente clientePreferente1 = new Preferente("87654321A", cuenta4);
        System.out.println("El cliente con DNI: " + clientePreferente1.getDni() + " tiene un saldo en la cuenta4 de" + cuenta4.getSaldo());

        try {
            clientePreferente1.ingresar(49900); //Intento de ingreso con menos del mínimo exigido (mínimo de 500 euros)
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertEquals(200000, cuenta4.consultarSaldo()); //El saldo no debería haber cambiado después del ingreso fallido
    }

    @Test
    public void testRetirarConComisionMinimaClientePreferenteCA() { //retirar dinero con comisión mínima Cliente Preferente en Cuenta Ahorro
        Cuenta cuenta4 = new CuentaAhorro("ES3630123456789012345678", 200000);
        Cliente clientePreferente1 = new Preferente("87654321A", cuenta4);
        System.out.println("El cliente con DNI: " + clientePreferente1.getDni() + " tiene un saldo en la cuenta4 de" + cuenta4.getSaldo());

        clientePreferente1.retirar(4000); //retiramos 40 euros,del saldo y la comisión será de 1 euro
        assertEquals(195900, cuenta4.consultarSaldo());
    }


    @Test
    public void testRetirarEIngresarClienteVIPCC() {   //retirar e ingresar cliente VIP en cuenta corriente
        Cuenta cuenta5 = new CuentaCorriente("ES5530123456789012345678", 600000);
        Cliente clienteVIP1 = new VIP("11122334C", cuenta5);
        System.out.println("El cliente con DNI: " + clienteVIP1.getDni() + " tiene un saldo en la cuenta5 de" + cuenta5.getSaldo());

        // Retirar e ingresar dinero en Cliente VIP
        clienteVIP1.retirar(100000);
        assertEquals(500000, cuenta5.consultarSaldo());

        clienteVIP1.ingresar(50000);
        assertEquals(550000, cuenta5.consultarSaldo());
    }


    @Test
    public void testRetirarEIngresarClienteVIPCA() {   //retirar e ingresar cliente VIP en cuenta ahorro
        Cuenta cuenta6 = new CuentaAhorro("ES5730123456789012345678", 400000);
        Cliente clienteVIP1 = new VIP("11122334C", cuenta6);
        System.out.println("El cliente con DNI: " + clienteVIP1.getDni() + " tiene un saldo en la cuenta6 de" + cuenta6.getSaldo());

        // Retirar e ingresar dinero en Cliente VIP
        clienteVIP1.retirar(300000);
        assertEquals(100000, cuenta6.consultarSaldo());

        clienteVIP1.ingresar(250000);
        assertEquals(350000, cuenta6.consultarSaldo());
    }


    @Test
    public void testRetirarEIngresarClienteVIPSaldoNegativoCC() {   //retirar e ingresar cliente VIP en cuenta corriente y cuenta ahorro dejando las cuentas en negativo
        Cuenta cuenta5 = new CuentaCorriente("ES5530123456789012345678", 600000);
        Cliente clienteVIP1 = new VIP("11122334C", cuenta5);
        System.out.println("El cliente con DNI: " + clienteVIP1.getDni() + " tiene un saldo en la cuenta5 de" + cuenta5.getSaldo());

        clienteVIP1.retirar(800000);
        assertEquals(-200000, cuenta5.consultarSaldo());

        clienteVIP1.ingresar(10000);
        assertEquals(-190000, cuenta5.consultarSaldo());

    }

    @Test
    public void testRetirarEIngresarClienteVIPSaldoNegativoCA() {  //retirar e ingresar cliente VIP en cuenta ahorro y cuenta ahorro dejando las cuentas en negativo
        Cuenta cuenta = new CuentaAhorro("ES5730123456789012345678", 400000);
        Cliente clienteVIP = new VIP("11122334C", cuenta);
        System.out.println("El cliente con DNI: " + clienteVIP.getDni() + " tiene un saldo en la cuenta de " + cuenta.getSaldo());

        // Retirar más de lo que hay en la cuenta
        clienteVIP.retirar(800000);
        assertEquals(-400000, cuenta.consultarSaldo());

        // Ingresar dinero para dejar la cuenta en negativo
        clienteVIP.ingresar(100000);
        assertEquals(-300000, cuenta.consultarSaldo());
    }

}