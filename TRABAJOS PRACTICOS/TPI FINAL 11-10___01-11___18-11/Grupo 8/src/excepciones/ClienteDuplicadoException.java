package excepciones;

public class ClienteDuplicadoException extends ClienteException {

	private static final long serialVersionUID = 1L;

	public ClienteDuplicadoException(String mensaje) {
		super(mensaje);
	}
}
