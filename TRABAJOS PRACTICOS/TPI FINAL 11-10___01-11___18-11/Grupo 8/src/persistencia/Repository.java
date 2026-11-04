package persistencia;

import java.io.IOException;
import java.util.Map;

public interface Repository<T, ID> {

	Map<ID, T> cargarTodos() throws IOException;

	void guardarTodos(Map<ID, T> entidades) throws IOException;
	
}
