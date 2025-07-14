package ar.edu.unlam.pb2.cuentasBancarias;

public class NoPoseeDineroSuficienteEnCuentaException extends Exception {

	public NoPoseeDineroSuficienteEnCuentaException(String mensaje) {
		super(mensaje);
	}

	private static final long serialVersionUID = 1L;

}
