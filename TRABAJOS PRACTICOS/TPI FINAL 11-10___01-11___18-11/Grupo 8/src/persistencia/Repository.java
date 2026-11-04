package persistencia;

import java.io.IOException;
import java.util.Map;

public interface Repository<ID, T> {

	Map<ID, T> cargarTodos() throws IOException;

	void guardarTodos(Map<ID, T> entidades) throws IOException;
	
}
