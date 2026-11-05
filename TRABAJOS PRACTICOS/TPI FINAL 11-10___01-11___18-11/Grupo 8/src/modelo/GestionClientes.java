package modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import excepciones.ClienteDuplicadoException;
import excepciones.ClienteEstadoException;
import excepciones.ClienteNoEncontradoException;
import lombok.Getter;
import modelo.Cliente.EstadoCliente;
import persistencia.Repository;

@Getter
public class GestionClientes {
	private Map<Integer, Cliente> clientes = new HashMap<Integer, Cliente>();
	private final Repository<Integer, Cliente> repo;
	
	public GestionClientes(Repository<Integer, Cliente> repo) throws IOException {
		this.repo = repo;
		this.clientes = repo.cargarTodos(); 
	}

	public void agregarCliente(Cliente cliente) throws IOException, ClienteDuplicadoException {
		if (clientes.containsKey(cliente.getDni())) {
			throw new ClienteDuplicadoException("Ya existe un cliente con dni: " + cliente.getDni());
		}
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
		Cliente cliente = buscarCliente(dni);
		
		if (cliente.getEstado() == EstadoCliente.INACTIVO) {
			throw new ClienteEstadoException("El cliente con dni: " + dni + " ya se encontraba dado de baja");
		}
		
		cliente.setEstado(EstadoCliente.INACTIVO);
		repo.guardarTodos(clientes);
	}
	
	public void suspenderCliente(int dni) throws ClienteNoEncontradoException, IOException, ClienteEstadoException {
		Cliente cliente = buscarCliente(dni);
		
		if (cliente.getEstado() == EstadoCliente.SUSPENDIDO) {
			throw new ClienteEstadoException("El cliente con dni: " + dni + " ya se encontraba suspendido");
		}
		if (cliente.getEstado() == EstadoCliente.INACTIVO) {
			throw new ClienteEstadoException("No se puede suspender al cliente con dni: " + dni + " porque está dado de baja");
		}
		
		cliente.setEstado(EstadoCliente.SUSPENDIDO);
		repo.guardarTodos(clientes);
	}
	
	public void reactivarCliente(int dni) throws ClienteNoEncontradoException, IOException, ClienteEstadoException {
		Cliente cliente = buscarCliente(dni);
		
		if (cliente.getEstado() == EstadoCliente.ACTIVO) {
			throw new ClienteEstadoException("El cliente con dni: " + dni + " ya se encontraba activo");
		}
		
		cliente.setEstado(EstadoCliente.ACTIVO);
		repo.guardarTodos(clientes);
	}
	
	//Listados ordenados por nombre
	public List<Cliente> listarClientes() {
		List<Cliente> lista = new ArrayList<Cliente>(clientes.values());
		lista.sort(Comparator.comparing(Cliente::getNombreCompleto));
		return lista;
	}
	
	public List<Cliente> listarClientesActivos() {
		List<Cliente> lista = new ArrayList<Cliente>();
		for (Cliente c : listarClientes()) {
			if (c.isActivo())
				lista.add(c);
		}
		return lista;
	}
	
	public List<Cliente> listarClientesMorosos() {
		List<Cliente> lista = new ArrayList<Cliente>();
		for (Cliente c : listarClientes()) {
			if (c.isMoroso())
				lista.add(c);
		}
		return lista;
	}
	
	//Busca por parte del nombre o del dni
	public List<Cliente> buscarClientes(String texto) {
		String busqueda = texto.trim().toUpperCase();
		List<Cliente> lista = new ArrayList<Cliente>();
		for (Cliente c : listarClientes()) {
			if (c.getNombreCompleto().toUpperCase().contains(busqueda)
					|| String.valueOf(c.getDni()).contains(busqueda))
				lista.add(c);
		}
		return lista;
	}
	
	public long contarClientesActivos() {
	    return clientes.values().stream()
	            .filter(Cliente::isActivo)
	            .count();
	}
	
	public long contarClientesMorosos() {
	    return clientes.values().stream()
	            .filter(Cliente::isMoroso)
	            .count();
	}
}
