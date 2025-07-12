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
	void retirar(Double monto) {
		if(this.dineroEnCuenta > monto) {
			this.dineroEnCuenta -= monto;			
		}
	}

}
