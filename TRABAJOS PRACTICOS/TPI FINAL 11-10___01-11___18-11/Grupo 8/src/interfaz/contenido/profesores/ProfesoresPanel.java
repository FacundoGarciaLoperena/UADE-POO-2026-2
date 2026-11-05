package interfaz.contenido.profesores;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import excepciones.DatosInvalidosException;
import excepciones.EmpleadoException;
import interfaz.componentes.PanelAcciones;
import interfaz.componentes.TablaDatos;
import interfaz.config.Estilos;
import interfaz.contenido.PanelBase;
import interfaz.contenido.dashboard.PanelTablaDashboard;
import interfaz.utilidades.Normalizador;
import modelo.GestionActividadesClases;
import modelo.GestionEmpleados;
import modelo.Gimnasio;
import modelo.Profesor;

public class ProfesoresPanel extends PanelBase {

	private static final long serialVersionUID = 1L;

	private GestionEmpleados gestionEmpleados;
	private GestionActividadesClases gestionClases;
	private TablaDatos tabla = new TablaDatos(
			new String[] { "Nº", "Nombre", "Género", "Salario", "Contratación", "Certificaciones" }, -1);
	private JLabel labelCantidad = new JLabel();

	public ProfesoresPanel(Gimnasio gimnasio) {
		super("Profesores");
		this.gestionEmpleados = gimnasio.getGestionEmpleados();
		this.gestionClases = gimnasio.getGestionActividadesClases();

		JPanel contenido = new JPanel(new GridLayout(1, 2, 12, 0));
		add(contenido, BorderLayout.CENTER);

		//Mitad izquierda: tabla
		tabla.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabla.getColumnModel().getColumn(1).setPreferredWidth(140);
		PanelTablaDashboard panelTabla = new PanelTablaDashboard("Plantel de profesores", tabla);
		labelCantidad.setFont(Estilos.FUENTE_PEQUENA);
		labelCantidad.setForeground(Estilos.TEXTO_SECUNDARIO);
		panelTabla.add(labelCantidad, BorderLayout.SOUTH);
		contenido.add(panelTabla);

		//Mitad derecha: acciones
		PanelAcciones acciones = new PanelAcciones();
		acciones.agregarSeccion("Gestión");
		acciones.agregarBoton("Agregar profesor", Estilos.AZUL, e -> agregarProfesor());
		acciones.agregarBoton("Agregar certificación", Estilos.VERDE, e -> agregarCertificacion());
		acciones.agregarBoton("Actualizar salario", Estilos.NARANJA, e -> actualizarSalario());
		acciones.agregarBoton("Eliminar profesor", Estilos.ROJO, e -> eliminarProfesor());
		contenido.add(acciones);

		actualizarTabla();
	}

	public void actualizarTabla() {
		tabla.limpiar();
		for (Profesor p : gestionEmpleados.listarProfesores()) {
			tabla.agregarFila(new Object[] { p.getNmroEmpleado(), p.getNombreCompleto(), p.getGenero(),
					String.format("$ %,.0f", p.getSalario()),
					p.getFechaContratacion().format(Normalizador.FORMATO_FECHA),
					String.join(", ", p.getCertificaciones()) });
		}
		labelCantidad.setText(gestionEmpleados.listarProfesores().size() + " profesores");
	}

	private Profesor profesorSeleccionado() throws EmpleadoException {
		Object clave = tabla.getClaveSeleccionada();
		if (clave == null) {
			JOptionPane.showMessageDialog(this, "Primero seleccioná un profesor de la tabla", "Sin selección",
					JOptionPane.INFORMATION_MESSAGE);
			return null;
		}
		return (Profesor) gestionEmpleados.buscarEmpleado((int) clave);
	}

	private void agregarProfesor() {
		Profesor nuevo = new FormularioProfesor(SwingUtilities.getWindowAncestor(this),
				gestionEmpleados.siguienteNmroEmpleado()).mostrar();
		if (nuevo == null) return;
		try {
			gestionEmpleados.crearEmpleado(nuevo);
			actualizarTabla();
		} catch (EmpleadoException e) {
			mostrarError(e.getMessage());
		}
	}

	private void agregarCertificacion() {
		try {
			Profesor profesor = profesorSeleccionado();
			if (profesor == null) return;
			String certificacion = JOptionPane.showInputDialog(this, "Nueva certificación para " + profesor.getNombreCompleto());
			if (certificacion == null || certificacion.isBlank()) return;
			profesor.getCertificaciones().add(certificacion.trim().toUpperCase());
			actualizarTabla();
		} catch (EmpleadoException e) {
			mostrarError(e.getMessage());
		}
	}

	private void actualizarSalario() {
		try {
			Profesor profesor = profesorSeleccionado();
			if (profesor == null) return;
			String salario = JOptionPane.showInputDialog(this, "Nuevo salario para " + profesor.getNombreCompleto(),
					String.format("%.0f", profesor.getSalario()));
			if (salario == null) return;
			profesor.setSalario(Normalizador.normalizarMonto(salario, "salario"));
			actualizarTabla();
		} catch (EmpleadoException e) {
			mostrarError(e.getMessage());
		} catch (DatosInvalidosException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Datos inválidos", JOptionPane.WARNING_MESSAGE);
		}
	}

	private void eliminarProfesor() {
		try {
			Profesor profesor = profesorSeleccionado();
			if (profesor == null) return;
			if (gestionClases.profesorTieneClases(profesor)) {
				mostrarError("No se puede eliminar a " + profesor.getNombreCompleto()
						+ " porque tiene clases asignadas. Eliminá o reasigná sus clases primero.");
				return;
			}
			int respuesta = JOptionPane.showConfirmDialog(this, "¿Eliminar a " + profesor.getNombreCompleto() + "?",
					"Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (respuesta != JOptionPane.YES_OPTION) return;
			gestionEmpleados.eliminarEmpleado(profesor.getNmroEmpleado());
			actualizarTabla();
		} catch (EmpleadoException e) {
			mostrarError(e.getMessage());
		}
	}

	private void mostrarError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
