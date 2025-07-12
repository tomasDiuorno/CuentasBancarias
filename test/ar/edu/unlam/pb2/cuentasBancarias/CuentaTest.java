package ar.edu.unlam.pb2.cuentasBancarias;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CuentaTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void abroUnaCuentaSueldoConSaldoEn0() {
		Cuenta cuenta = new CuentaSueldo(1234);
		Double esperado = 0.0;
		assertEquals(esperado, cuenta.getSaldo());
	}
	
	@Test
	public void realizoUnDepositoDe2_000EnLaCuentaSueldoYSeAcreditaCorrectamente() {
		Cuenta cuenta = new CuentaSueldo(1234);
		cuenta.depositar(2000.0);
		Double esperado = 2000.0;
		assertEquals(esperado, cuenta.getSaldo());
	}
	
	@Test
	public void realizoUnDepositoDe2_000EnLaCuentaSueldoYRetiro1_000() {
		Cuenta cuenta = new CuentaSueldo(1234);
		cuenta.depositar(2000.0);
		cuenta.retirar(1000.0);
		Double esperado = 1000.0;
		assertEquals(esperado, cuenta.getSaldo());
	}
	
	
}
