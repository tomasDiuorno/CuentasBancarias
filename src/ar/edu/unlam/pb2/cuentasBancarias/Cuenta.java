package ar.edu.unlam.pb2.cuentasBancarias;

public abstract class Cuenta {
	protected Integer cbu;
	protected Double dineroEnCuenta;
	protected Double deuda;

	public Cuenta(Integer cbu) {
		this.cbu = cbu;
		this.dineroEnCuenta = 0.0;
		this.deuda = 0.0;
	}

	abstract void depositar(Double monto);

	abstract void retirar(Double monto) throws NoPoseeDineroSuficienteEnCuentaException;

	public Object getSaldo() {
		return this.dineroEnCuenta;
	}

	public Double getDeuda() {
		return deuda;
	}
	
}
