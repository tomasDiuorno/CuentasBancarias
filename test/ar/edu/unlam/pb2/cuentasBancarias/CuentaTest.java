package ar.edu.unlam.pb2.cuentasBancarias;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CuentaTest {
	
	@Test
	public void abroUnaCuentaSueldoConSaldoEn0() {
		Cuenta cuentaSueldo = new CuentaSueldo(1234);
		Double esperado = 0.0;
		assertEquals(esperado, cuentaSueldo.getSaldo());
	}
	
	@Test
	public void realizoUnDepositoDe2_000EnLaCuentaSueldoYSeAcreditaCorrectamente() {
		Cuenta cuentaSueldo = new CuentaSueldo(1234);
		cuentaSueldo.depositar(2000.0);
		Double esperado = 2000.0;
		assertEquals(esperado, cuentaSueldo.getSaldo());
	}
	
	@Test
	public void realizoUnDepositoDe2_000EnLaCuentaSueldoYRetiro1_000() throws NoPoseeDineroSuficienteEnCuentaException {
		Cuenta cuentaSueldo = new CuentaSueldo(1234);
		cuentaSueldo.depositar(2000.0);
		cuentaSueldo.retirar(1000.0);
		Double esperado = 1000.0;
		assertEquals(esperado, cuentaSueldo.getSaldo());
	}
	
	@Test
	public void realizoUnDepositoDe2_000EnLaCuentaSueldoYRetiro2_000ParaQueQuedeLaCuentaEn0() throws NoPoseeDineroSuficienteEnCuentaException {
		Cuenta cuentaSueldo = new CuentaSueldo(1234);
		cuentaSueldo.depositar(2000.0);
		cuentaSueldo.retirar(2000.0);
		Double esperado = 0.0;
		assertEquals(esperado, cuentaSueldo.getSaldo());
	}
	
	@Test (expected = NoPoseeDineroSuficienteEnCuentaException.class)
	public void realizoUnDepositoDe2_000EnLaCuentaSueldoEIntentoRetirarMasDineroDelQueTengo() throws NoPoseeDineroSuficienteEnCuentaException {
		Cuenta cuentaSueldo = new CuentaSueldo(1234);
		cuentaSueldo.depositar(2000.0);
		cuentaSueldo.retirar(2001.0);
		Double esperado = 1000.0;
		assertEquals(esperado, cuentaSueldo.getSaldo());
	}
	
	@Test
	public void test() throws NoPoseeDineroSuficienteEnCuentaException {
		Cuenta caja = new CajaDeAhorro(1234);

	}
}
