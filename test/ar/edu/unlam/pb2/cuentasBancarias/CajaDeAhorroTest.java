package ar.edu.unlam.pb2.cuentasBancarias;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CajaDeAhorroTest {
	private Cuenta caja;

	@Before
	public void setUp() throws Exception {
		caja = new CajaDeAhorro(1234);
	}

	@Test
	public void dadaUnaCajaDeAhorroSeDepositan2000_LuegoRealizo7RetirosYMeCobranRecargoAPartirDeLaQuintaExtraccion()
			throws NoPoseeDineroSuficienteEnCuentaException {
		Double esperado = 1288.0;
		caja.depositar(2000.0);
		caja.retirar(100.0);
		caja.retirar(100.0);
		caja.retirar(100.0);
		caja.retirar(100.0);
		caja.retirar(100.0);
		caja.retirar(100.0);
		caja.retirar(100.0);
		assertEquals(esperado, caja.getSaldo());
	}
}
