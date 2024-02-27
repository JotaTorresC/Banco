package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.Transferencias;
import com.example.RegistroUsuario;
import com.example.CrearCuenta;

public class BancoTest {

    @Test
    public void testActualizarDatosUsuario() {
        Banco banco = new Banco();
        RegistroUsuario usuario = new RegistroUsuario("Juan", "casa 10", "juan1234", "123456");
        banco.agregarUsuario(usuario);

        banco.actualizarDatosUsuario("joel", "casa 11", "joel2222", "654321");

        assertEquals("casa 11", usuario.getDireccion());
        assertEquals("joel2222", usuario.getCorreo());
        assertEquals("654321", usuario.getClave());
    }

    @Test
    public void testBorrarUsuario() {
        Banco banco = new Banco();
        RegistroUsuario usuario = new RegistroUsuario("jason", "avenida 2", "jotaellindo", "7411");
        banco.agregarUsuario(usuario);

        banco.borrarUsuario("jason");

        assertTrue(banco.getUsuarios().isEmpty());
    }

    @Test
    public void testVerificarCuenta() {
        Banco banco = new Banco();
        CrearCuenta cuenta = new CrearCuenta(1000, "4944884454845"); // Cuenta con saldo inicial de 1000
        banco.agregarCuenta(cuenta);

        // Intentar agregar una cuenta con el mismo número debería fallar
        banco.verificarCuenta("4944884454845");
        assertFalse(banco.getCuentas().isEmpty());

        // Intentar agregar una cuenta con un número nuevo debería tener éxito
        banco.verificarCuenta("4944884598845");
        assertFalse(banco.getCuentas().isEmpty());
    }

    @Test
    public void testRealizarTransaccion_SaldoSuficiente() {
        Banco banco = new Banco();
        CrearCuenta cuenta = new CrearCuenta(1000, "98989562284818"); // Cuenta con saldo inicial de 1000
        banco.agregarCuenta(cuenta);

        banco.realizarTransaccion(500, "8489468878787", "juan", "21/02/2024", "viajes", "09:00");

        assertEquals(300, cuenta.getSaldo());
    }

    @Test
    public void testRealizarTransaccion_SaldoInsuficiente() {
        Banco banco = new Banco();
        CrearCuenta cuenta = new CrearCuenta(100, "89989998339255"); // Cuenta con saldo inicial de 100
        banco.agregarCuenta(cuenta);

        banco.realizarTransaccion(500, "978989494", "danilo", "26/02/2024", "ropa", "10:00");

        assertEquals(100, cuenta.getSaldo()); // El saldo no debería cambiar
    }

    @Test
    public void testColsultaSaldo() {
        Banco banco = new Banco();
        RegistroUsuario usuario = new RegistroUsuario("david", "calle 50", "david1145@gmail.com", "clave11234455");
        banco.agregarUsuario(usuario);
        CrearCuenta cuenta = new CrearCuenta(1000, "694643131");
        banco.agregarCuenta(cuenta);
        Transferencias transferencia = new Transferencias(500, "Maria", "25/02/2024", "ropa", "11:12");
        banco.guardarTranferencia(transferencia);

        banco.colsultaSaldo(usuario.getNumeroIdentificacion(), usuario.getClave());
    }
}
