package persistencia.implementaciones;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import excepciones.ClienteNoEncontradoException;
import modelo.Cliente;
import persistencia.ClienteRepository;

public class ClienteRepositoryJson implements ClienteRepository {

	private String rutaArchivo = "Clientes.json"; 

	
	private List<Cliente> cargarClientesDesdeJson() {
		
		return null; 
	}

	@Override
	public Cliente obtenerPorId(int id) throws ClienteNoEncontradoException {
		List<Cliente> clientes = cargarClientesDesdeJson();

		return clientes.stream().filter(c -> c.getDni() == id).findFirst()
				.orElseThrow(() -> new ClienteNoEncontradoException("Cliente no encontrado"));
	}

	@Override
	public Map<Integer, Cliente> obtenerClientesActivos() {
		List<Cliente> clientes = cargarClientesDesdeJson();

		return clientes.stream().filter(Cliente::isActivo)
				.collect(Collectors.toMap(Cliente::getDni, cliente -> cliente));
	}

	@Override
	public Map<Integer, Cliente> obtenerClientesMorosos() {
		List<Cliente> clientes = cargarClientesDesdeJson();

		return clientes.stream().filter(Cliente::isMoroso)
				.collect(Collectors.toMap(Cliente::getDni, cliente -> cliente));
	}

}
