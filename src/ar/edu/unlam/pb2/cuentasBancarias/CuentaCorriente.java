package ar.edu.unlam.pb2.cuentasBancarias;

public class CuentaCorriente extends Cuenta {
	private Double descubierto;

	public CuentaCorriente(Integer cbu, Double descubierto) {
		super(cbu);
		this.descubierto = descubierto;
	}

	@Override
	void depositar(Double monto) {
		this.dineroEnCuenta += monto;
	}

	@Override
	void retirar(Double monto) throws NoPoseeDineroSuficienteEnCuentaException {
		if (this.dineroEnCuenta + this.descubierto < monto) {
			throw new NoPoseeDineroSuficienteEnCuentaException(
					"El dinero que desea retirar es mayor al que posee en cuenta");
		}

		if (monto < this.dineroEnCuenta) {
			this.dineroEnCuenta -= monto;
		}

		if (monto > this.dineroEnCuenta && monto < this.dineroEnCuenta + this.descubierto) {
			Double diferencia = monto - this.dineroEnCuenta;
			Double prestado = this.descubierto - diferencia;
			
			this.dineroEnCuenta = 0.0;
			this.descubierto -= prestado * 1.05;
		}
	}

}
