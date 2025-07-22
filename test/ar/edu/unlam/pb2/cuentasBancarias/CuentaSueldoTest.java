package ar.edu.unlam.pb2.cuentasBancarias;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CuentaSueldoTest {
	private Cuenta cuentaSueldo;
	
	@Before
	public void setUp() throws Exception {
		cuentaSueldo = new CuentaSueldo(1234);
	}

	@Test
	public void abroUnaCuentaSueldoConSaldoEn0() {
		Double esperado = 0.0;
		assertEquals(esperado, cuentaSueldo.getSaldo());
	}
	
	@Test
	public void realizoUnDepositoDe2_000EnLaCuentaSueldoYSeAcreditaCorrectamente() {
		cuentaSueldo.depositar(2000.0);
		Double esperado = 2000.0;
		assertEquals(esperado, cuentaSueldo.getSaldo());
	}
	
	@Test
	public void realizoUnDepositoDe2_000EnLaCuentaSueldoYRetiro1_000() throws NoPoseeDineroSuficienteEnCuentaException {
		cuentaSueldo.depositar(2000.0);
		cuentaSueldo.retirar(1000.0);
		Double esperado = 1000.0;
		assertEquals(esperado, cuentaSueldo.getSaldo());
	}
	
	@Test
	public void realizoUnDepositoDe2_000EnLaCuentaSueldoYRetiro2_000ParaQueQuedeLaCuentaEn0() throws NoPoseeDineroSuficienteEnCuentaException {
		cuentaSueldo.depositar(2000.0);
		cuentaSueldo.retirar(2000.0);
		Double esperado = 0.0;
		assertEquals(esperado, cuentaSueldo.getSaldo());
	}
	
	@Test (expected = NoPoseeDineroSuficienteEnCuentaException.class)
	public void realizoUnDepositoDe2_000EnLaCuentaSueldoEIntentoRetirarMasDineroDelQueTengo() throws NoPoseeDineroSuficienteEnCuentaException {
		cuentaSueldo.depositar(2000.0);
		cuentaSueldo.retirar(2001.0);
		Double esperado = 1000.0;
		assertEquals(esperado, cuentaSueldo.getSaldo());
	}

}
