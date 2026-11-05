package excepciones;

public class ClaseNoEncontradaException extends ClaseException {

	private static final long serialVersionUID = 1L;

	public ClaseNoEncontradaException(String mensaje) {
		super(mensaje);
	}
}
