package ar.edu.unlam.pb2.cuentasBancarias;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CuentaCorrienteTest {
	private Cuenta cuenta;

	@Before
	public void setUp() throws Exception {
		cuenta = new CuentaCorriente(1234, 1500.0);
	}

	@Test
	public void dadaUnaCuentaCorriente_RealizoUnDepositoYRetirarUnImporteMayorAlQueTengoEnCuenta() throws NoPoseeDineroSuficienteEnCuentaException {
		cuenta.depositar(2000.0);
		cuenta.retirar(3000.0);
		
		Double saldoEsperado = 0.0;
		Double deudaGenerada = 1050.0;
		
		assertEquals(saldoEsperado, cuenta.getSaldo());
		assertEquals(deudaGenerada, cuenta.getDeuda());
	}
	
	@Test
	public void dadaUnaCuentaCorriente_RealizoUnDepositoYRetirarUnImporteMenorAlQueTengoEnCuenta() throws NoPoseeDineroSuficienteEnCuentaException {
		cuenta.depositar(2000.0);
		cuenta.retirar(1500.0);
		
		Double saldoEsperado = 500.0;
		Double deudaGenerada = 0.0;
		
		assertEquals(saldoEsperado, cuenta.getSaldo());
		assertEquals(deudaGenerada, cuenta.getDeuda());
	}

	@Test (expected = NoPoseeDineroSuficienteEnCuentaException.class)
	public void dadaUnaCuentaCorriente_RealizoUnDepositoYRetirarUnImporteMayorAlPermitidoPeroArrojaExcepcion() throws NoPoseeDineroSuficienteEnCuentaException {
		cuenta.depositar(2000.0);
		cuenta.retirar(3501.0);
	}
}
