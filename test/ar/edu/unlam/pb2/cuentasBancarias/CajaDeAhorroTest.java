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
	public void dadaUnaCajaDeAhorroSeDepositan2000Exitosamente() throws NoPoseeDineroSuficienteEnCuentaException {
		Double esperado = 2000.0;
		caja.depositar(2000.0);
		assertEquals(esperado, caja.getSaldo());
	}

	@Test
	public void dadaUnaCajaDeAhorroSeDepositan2000_LuegoRealizo5RetirosSinCostoExtra()
			throws NoPoseeDineroSuficienteEnCuentaException {
		Double esperado = 1500.0;
		caja.depositar(2000.0);
		caja.retirar(100.0);
		caja.retirar(100.0);
		caja.retirar(100.0);
		caja.retirar(100.0);
		caja.retirar(100.0);
		assertEquals(esperado, caja.getSaldo());
	}

	@Test
	public void dadaUnaCajaDeAhorroSeDepositan2000_LuegoRealizo6RetirosYMeCobran6PesosExtra()
			throws NoPoseeDineroSuficienteEnCuentaException {
		Double esperado = 1394.0;
		caja.depositar(2000.0);
		caja.retirar(100.0);
		caja.retirar(100.0);
		caja.retirar(100.0);
		caja.retirar(100.0);
		caja.retirar(100.0);
		caja.retirar(100.0);
		assertEquals(esperado, caja.getSaldo());
	}

	@Test (expected = NoPoseeDineroSuficienteEnCuentaException.class)
	public void dadaUnaCajaDeAhorroSeDepositan2000_RealizoVariasExtraxionesParaQueSumadoAlMontoExtraArrojeUnaNoPoseeDineroSuficienteEnCuentaException()
			throws NoPoseeDineroSuficienteEnCuentaException {
		caja.depositar(2000.0);
		caja.retirar(200.0);
		caja.retirar(200.0);
		caja.retirar(200.0);
		caja.retirar(200.0);
		caja.retirar(200.0);
		caja.retirar(200.0);
		caja.retirar(200.0);
		caja.retirar(200.0);
		caja.retirar(200.0);
		caja.retirar(200.0);
	}

}
