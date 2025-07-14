package ar.edu.unlam.pb2.cuentasBancarias;

public class CuentaSueldo extends Cuenta {

	public CuentaSueldo(Integer cbu) {
		super(cbu);
	}

	@Override
	void depositar(Double monto) {
		this.dineroEnCuenta += monto;
	}

	@Override
	void retirar(Double monto) throws NoPoseeDineroSuficienteEnCuentaException {
		if(this.dineroEnCuenta < monto) {
			throw new NoPoseeDineroSuficienteEnCuentaException("El dinero que desea retirar es mayor al que posee en cuenta");
		}
		this.dineroEnCuenta -= monto;
	}

}
