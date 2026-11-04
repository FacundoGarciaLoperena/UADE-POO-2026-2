package excepciones;

public class ClienteEstadoException extends ClienteException{
	private static final long serialVersionUID = 1L;
	public ClienteEstadoException(String mensaje) {
		super(mensaje);
	}
}
