package ar.edu.unlam.pb2.cuentasBancarias;

public class NoPoseeDineroSuficienteEnCuentaException extends Exception {
	private static final long serialVersionUID = 1L;

	public NoPoseeDineroSuficienteEnCuentaException(String mensaje) {
		super(mensaje);
	}


}
