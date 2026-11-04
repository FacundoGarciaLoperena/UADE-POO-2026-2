package modelo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import excepciones.ClienteEstadoException;
import excepciones.ClienteNoEncontradoException;
import lombok.Getter;
import modelo.Cliente.EstadoCliente;
import persistencia.Repository;

@Getter
public class GestionClientes {
	private Map<Integer, Cliente> clientes = new HashMap<Integer, Cliente>();
	private final Repository<Cliente, Integer> repo;
	
	public GestionClientes(Repository<Cliente, Integer> repo) throws IOException {
		this.repo = repo;
		this.clientes = repo.cargarTodos(); 
	}

	public void agregarCliente(Cliente cliente) throws IOException {
		clientes.put(cliente.getDni(), cliente);
		repo.guardarTodos(clientes);
	}

	public Cliente buscarCliente(int dni) throws ClienteNoEncontradoException {
		Cliente cliente = clientes.get(dni);
		if (cliente == null) {
			throw new ClienteNoEncontradoException("No se ha encontrado al cliente con dni: " + dni);
		}
		return cliente;
	}

	public void actualizarCliente(Cliente cliente) throws ClienteNoEncontradoException, IOException {
		if (!clientes.containsKey(cliente.getDni())) {
		    throw new ClienteNoEncontradoException("No se ha encontrado al cliente con dni: " + cliente.getDni());
		}
		clientes.put(cliente.getDni(), cliente);
		repo.guardarTodos(clientes);
	}

	public void eliminarCliente(int dni) throws ClienteNoEncontradoException, IOException {
		if (clientes.remove(dni) == null) {
			throw new ClienteNoEncontradoException("No se ha encontrado al cliente con dni: " + dni);
		}
		repo.guardarTodos(clientes);
		
	}
	
	public void darDeBajaCliente(int dni) throws ClienteNoEncontradoException, IOException, ClienteEstadoException {
		Cliente cliente = clientes.get(dni);
		
		if (cliente == null) {
			throw new ClienteNoEncontradoException("No se ha encontrado al cliente con dni: " + dni);
		}
		
		if (cliente.getEstado() == EstadoCliente.INACTIVO) {
			throw new ClienteEstadoException("El cliente con dni: " + dni + " ya se encontraba dado de baja");
		}
		
		cliente.setEstado(EstadoCliente.INACTIVO);
		repo.guardarTodos(clientes);
	}
	
	
	public long contarClientesActivos() {
	    return clientes.values().stream()
	            .filter(Cliente::isActivo)
	            .count();
	}
}