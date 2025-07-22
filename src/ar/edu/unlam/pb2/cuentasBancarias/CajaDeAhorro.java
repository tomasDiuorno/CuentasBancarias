package ar.edu.unlam.pb2.cuentasBancarias;

public class CajaDeAhorro extends Cuenta {
	private Integer cantidadDeExtracciones = 0;
	
	public CajaDeAhorro(Integer cbu) {
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
		
		if(this.cantidadDeExtracciones == 5) {
			Double comision = monto + 6.0;
			this.dineroEnCuenta -= comision;
		}else {
			this.dineroEnCuenta -= monto;
			this.cantidadDeExtracciones ++;			
		}
	}

}
