package interfaz.contenido.clientes;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import excepciones.ClienteException;
import interfaz.componentes.Boton;
import interfaz.componentes.PanelAcciones;
import interfaz.componentes.TablaDatos;
import interfaz.config.Estilos;
import interfaz.contenido.PanelBase;
import interfaz.contenido.dashboard.PanelTablaDashboard;
import modelo.Cliente;
import modelo.GestionClientes;
import modelo.Gimnasio;

public class ClientesPanel extends PanelBase {
	
	static final long serialVersionUID = 1L;
	
	private GestionClientes gestionClientes;
	private TablaDatos tabla = new TablaDatos(new String[] { "DNI", "Nombre", "Correo", "Teléfono", "Estado" }, 4);
	private JTextField campoBusqueda = new JTextField();
	private JLabel labelCantidad = new JLabel();
	private String filtroActual = "TODOS";

	public ClientesPanel(Gimnasio gimnasio) {
		super("Clientes");
		this.gestionClientes = gimnasio.getGestionClientes();
		
		JPanel contenido = new JPanel(new GridLayout(1, 2, 12, 0));
		add(contenido, BorderLayout.CENTER);
		
		//Mitad izquierda: planilla de clientes
		int[] anchos = { 80, 150, 180, 95, 90 };
		for (int i = 0; i < anchos.length; i++) {
			tabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
		}
		PanelTablaDashboard panelTabla = new PanelTablaDashboard("Listado de clientes", tabla);
		labelCantidad.setFont(Estilos.FUENTE_PEQUENA);
		labelCantidad.setForeground(Estilos.TEXTO_SECUNDARIO);
		panelTabla.add(labelCantidad, BorderLayout.SOUTH);
		contenido.add(panelTabla);
		
		//Mitad derecha: botones de gestión y filtros
		PanelAcciones acciones = new PanelAcciones();
		acciones.agregarSeccion("Gestión");
		acciones.agregarBoton("Agregar cliente", Estilos.BOTON_MENU, e -> agregarCliente());
		acciones.agregarBoton("Modificar seleccionado", Estilos.BOTON_MENU, e -> modificarCliente());
		acciones.agregarBoton("Marcar como moroso", Estilos.BOTON_MENU, e -> cambiarEstado("SUSPENDER"));
		acciones.agregarBoton("Reactivar cliente", Estilos.BOTON_MENU, e -> cambiarEstado("REACTIVAR"));
		acciones.agregarBoton("Dar de baja", Estilos.BOTON_MENU, e -> cambiarEstado("BAJA"));
		acciones.agregarBoton("Eliminar cliente", Estilos.BOTON_MENU, e -> eliminarCliente());
		
		acciones.agregarSeccion("Filtros");
		campoBusqueda.setFont(Estilos.FUENTE_NORMAL);
		campoBusqueda.setToolTipText("Buscar por nombre o DNI");
		campoBusqueda.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Estilos.BORDE_COMPONENTE),
				BorderFactory.createEmptyBorder(6, 8, 6, 8)));
		campoBusqueda.addActionListener(e -> aplicarFiltro("BUSQUEDA"));
		acciones.agregarComponente(campoBusqueda);
		acciones.agregarBoton("Buscar por nombre o DNI", Estilos.AZUL, e -> aplicarFiltro("BUSQUEDA"));
		
		JPanel filtros = new JPanel(new GridLayout(1, 3, 8, 0));
		filtros.setBackground(Estilos.BLANCO);
		Boton todos = new Boton("Todos", Estilos.MENU);
		todos.addActionListener(e -> aplicarFiltro("TODOS"));
		Boton activos = new Boton("Activos", Estilos.VERDE);
		activos.addActionListener(e -> aplicarFiltro("ACTIVOS"));
		Boton morosos = new Boton("Morosos", Estilos.ROJO);
		morosos.addActionListener(e -> aplicarFiltro("MOROSOS"));
		filtros.add(todos);
		filtros.add(activos);
		filtros.add(morosos);
		acciones.agregarComponente(filtros);
		
		contenido.add(acciones);
		
		actualizarTabla();
	}
	
	private void aplicarFiltro(String filtro) {
		filtroActual = filtro;
		actualizarTabla();
	}
	
	private void actualizarTabla() {
		List<Cliente> lista;
		switch (filtroActual) {
		case "ACTIVOS" -> lista = gestionClientes.listarClientesActivos();
		case "MOROSOS" -> lista = gestionClientes.listarClientesMorosos();
		case "BUSQUEDA" -> lista = gestionClientes.buscarClientes(campoBusqueda.getText());
		default -> lista = gestionClientes.listarClientes();
		}
		
		tabla.limpiar();
		for (Cliente c : lista) {
			tabla.agregarFila(new Object[] { c.getDni(), c.getNombreCompleto(), c.getMail(), c.getTelefono(), c.getEstado() });
		}
		labelCantidad.setText("Mostrando " + lista.size() + " de " + gestionClientes.getClientes().size()
				+ " clientes  |  Activos: " + gestionClientes.contarClientesActivos()
				+ "  |  Morosos: " + gestionClientes.contarClientesMorosos());
	}
	
	//Devuelve el dni seleccionado o -1 avisando al usuario
	private int dniSeleccionado() {
		Object clave = tabla.getClaveSeleccionada();
		if (clave == null) {
			JOptionPane.showMessageDialog(this, "Primero seleccioná un cliente de la tabla", "Sin selección",
					JOptionPane.INFORMATION_MESSAGE);
			return -1;
		}
		return (int) clave;
	}
	
	private void agregarCliente() {
		Cliente nuevo = new FormularioCliente(SwingUtilities.getWindowAncestor(this), null).mostrar();
		if (nuevo == null) return;
		try {
			gestionClientes.agregarCliente(nuevo);
			actualizarTabla();
		} catch (ClienteException e) {
			mostrarError(e.getMessage());
		} catch (IOException e) {
			mostrarError("No se pudo guardar el archivo de clientes: " + e.getMessage());
		}
	}
	
	private void modificarCliente() {
		int dni = dniSeleccionado();
		if (dni == -1) return;
		try {
			Cliente cliente = gestionClientes.buscarCliente(dni);
			Cliente modificado = new FormularioCliente(SwingUtilities.getWindowAncestor(this), cliente).mostrar();
			if (modificado == null) return;
			gestionClientes.actualizarCliente(modificado);
			actualizarTabla();
		} catch (ClienteException e) {
			mostrarError(e.getMessage());
		} catch (IOException e) {
			mostrarError("No se pudo guardar el archivo de clientes: " + e.getMessage());
		}
	}
	
	private void cambiarEstado(String accion) {
		int dni = dniSeleccionado();
		if (dni == -1) return;
		try {
			switch (accion) {
			case "SUSPENDER" -> gestionClientes.suspenderCliente(dni);
			case "REACTIVAR" -> gestionClientes.reactivarCliente(dni);
			case "BAJA" -> gestionClientes.darDeBajaCliente(dni);
			}
			actualizarTabla();
		} catch (ClienteException e) {
			mostrarError(e.getMessage());
		} catch (IOException e) {
			mostrarError("No se pudo guardar el archivo de clientes: " + e.getMessage());
		}
	}
	
	private void eliminarCliente() {
		int dni = dniSeleccionado();
		if (dni == -1) return;
		int respuesta = JOptionPane.showConfirmDialog(this, "¿Eliminar definitivamente al cliente con DNI " + dni + "?",
				"Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (respuesta != JOptionPane.YES_OPTION) return;
		try {
			gestionClientes.eliminarCliente(dni);
			actualizarTabla();
		} catch (ClienteException e) {
			mostrarError(e.getMessage());
		} catch (IOException e) {
			mostrarError("No se pudo guardar el archivo de clientes: " + e.getMessage());
		}
	}
	
	private void mostrarError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
