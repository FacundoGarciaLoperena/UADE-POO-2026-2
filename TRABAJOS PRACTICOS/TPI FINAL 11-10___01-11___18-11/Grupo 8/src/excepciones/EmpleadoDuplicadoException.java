package excepciones;

public class EmpleadoDuplicadoException extends EmpleadoException {

	private static final long serialVersionUID = 1L;

	public EmpleadoDuplicadoException(String mensaje) {
		super(mensaje);
	}
}
