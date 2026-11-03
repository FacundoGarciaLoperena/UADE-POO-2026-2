package modelo;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;

@Getter
public class GestionClientes {
	private Set<Cliente> clientes;

	public GestionClientes() {
		this.clientes = new HashSet<>();
	}

	public void crearCliente(Cliente cliente) {
		clientes.add(cliente);
	}

	public Cliente buscarCliente(int dni) {
		for (Cliente c : clientes) {
			if (c.getDni() == dni)
				return c;
		}
		return null;
	}

	public void actualizarCliente(Cliente cliente) {
		eliminarCliente(cliente.getDni());
		clientes.add(cliente);
	}

	public void eliminarCliente(int dni) {
		Cliente c = buscarCliente(dni);
		if (c != null)
			clientes.remove(c);
	}
}
