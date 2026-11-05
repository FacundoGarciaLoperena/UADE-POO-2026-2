package excepciones;

public class EmpleadoNoEncontradoException extends EmpleadoException {

	private static final long serialVersionUID = 1L;

	public EmpleadoNoEncontradoException(String mensaje) {
		super(mensaje);
	}
}
