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
	public void dadaUnaCuentaCorriente_RealizoUnDepositoEIntentoRetirarUnImporteMayorAlQueTengoEnCuenta() throws NoPoseeDineroSuficienteEnCuentaException {
		cuenta.depositar(2000.0);
		cuenta.retirar(1000.0);
	}

}
