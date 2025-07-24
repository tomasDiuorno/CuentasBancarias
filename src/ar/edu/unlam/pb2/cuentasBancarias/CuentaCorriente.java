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
		Double limite = this.dineroEnCuenta + this.descubierto;

		if (limite < monto) {
			throw new NoPoseeDineroSuficienteEnCuentaException(
					"El dinero que desea retirar es mayor al que posee en cuenta");
		} else if (monto < this.dineroEnCuenta) {
			this.dineroEnCuenta -= monto;
		} else if (monto > this.dineroEnCuenta && monto < limite) {
			Double dineroAPrestar = monto - this.dineroEnCuenta;

			this.dineroEnCuenta = 0.0;
			this.deuda += dineroAPrestar * 1.05;
			this.descubierto -= this.deuda;
		}
	}

}
