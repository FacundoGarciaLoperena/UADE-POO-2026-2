package interfaz.contenido.clases;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import excepciones.ClaseException;
import excepciones.DatosInvalidosException;
import interfaz.componentes.PanelAcciones;
import interfaz.componentes.TablaDatos;
import interfaz.config.Estilos;
import interfaz.contenido.PanelBase;
import interfaz.contenido.dashboard.PanelTablaDashboard;
import interfaz.utilidades.Normalizador;
import modelo.Clase;
import modelo.GestionActividadesClases;
import modelo.GestionEmpleados;
import modelo.Gimnasio;
import modelo.Profesor;

public class ClasesPanel extends PanelBase{

	private static final long serialVersionUID = 1L;

	private GestionActividadesClases gestionClases;
	private GestionEmpleados gestionEmpleados;
	private TablaDatos tabla = new TablaDatos(
			new String[] { "ID", "Actividad", "Profesor", "Fecha", "Horario", "Cupo" }, -1);
	private JLabel labelCantidad = new JLabel();
	private boolean soloHoy = false;

	public ClasesPanel(Gimnasio gimnasio) {
		super("Clases");
		this.gestionClases = gimnasio.getGestionActividadesClases();
		this.gestionEmpleados = gimnasio.getGestionEmpleados();

		JPanel contenido = new JPanel(new GridLayout(1, 2, 12, 0));
		add(contenido, BorderLayout.CENTER);

		//Mitad izquierda: tabla
		int[] anchos = { 30, 90, 120, 85, 105, 45 };
		for (int i = 0; i < anchos.length; i++) {
			tabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
		}
		PanelTablaDashboard panelTabla = new PanelTablaDashboard("Clases programadas", tabla);
		labelCantidad.setFont(Estilos.FUENTE_PEQUENA);
		labelCantidad.setForeground(Estilos.TEXTO_SECUNDARIO);
		panelTabla.add(labelCantidad, BorderLayout.SOUTH);
		contenido.add(panelTabla);

		//Mitad derecha: acciones
		PanelAcciones acciones = new PanelAcciones();
		acciones.agregarSeccion("Gestión");
		acciones.agregarBoton("Agregar clase", Estilos.AZUL, e -> agregarClase());
		acciones.agregarBoton("Cambiar cupo", Estilos.NARANJA, e -> cambiarCupo());
		acciones.agregarBoton("Eliminar clase", Estilos.ROJO, e -> eliminarClase());
		acciones.agregarSeccion("Filtros");
		acciones.agregarBoton("Todas las clases", Estilos.MENU, e -> filtrar(false));
		acciones.agregarBoton("Solo clases de hoy", Estilos.VERDE, e -> filtrar(true));
		contenido.add(acciones);

		actualizarTabla();
	}

	private void filtrar(boolean hoy) {
		soloHoy = hoy;
		actualizarTabla();
	}

	public void actualizarTabla() {
		List<Clase> lista = new ArrayList<Clase>();
		for (Clase c : gestionClases.listarClases()) {
			if (!soloHoy || c.getHoraInicio().toLocalDate().equals(LocalDate.now()))
				lista.add(c);
		}

		tabla.limpiar();
		for (Clase c : lista) {
			tabla.agregarFila(new Object[] { c.getIdClase(), c.getActividad().getNombre(),
					c.getProfesor().getNombreCompleto(),
					c.getHoraInicio().format(Normalizador.FORMATO_FECHA),
					c.getHoraInicio().format(Normalizador.FORMATO_HORA) + " - "
							+ c.getHoraFin().format(Normalizador.FORMATO_HORA),
					c.getCapacidadMaxima() });
		}
		labelCantidad.setText("Mostrando " + lista.size() + " de " + gestionClases.getClases().size() + " clases");
	}

	private Clase claseSeleccionada() throws ClaseException {
		Object clave = tabla.getClaveSeleccionada();
		if (clave == null) {
			JOptionPane.showMessageDialog(this, "Primero seleccioná una clase de la tabla", "Sin selección",
					JOptionPane.INFORMATION_MESSAGE);
			return null;
		}
		return gestionClases.buscarClase((int) clave);
	}

	private void agregarClase() {
		List<Profesor> profesores = gestionEmpleados.listarProfesores();
		if (profesores.isEmpty() || gestionClases.getActividades().isEmpty()) {
			mostrarError("Para crear una clase tiene que haber al menos un profesor y una actividad cargados");
			return;
		}
		Clase nueva = new FormularioClase(SwingUtilities.getWindowAncestor(this), gestionClases.siguienteIdClase(),
				gestionClases.listarActividades(), profesores).mostrar();
		if (nueva == null) return;
		try {
			gestionClases.crearClase(nueva);
			actualizarTabla();
		} catch (ClaseException e) {
			mostrarError(e.getMessage());
		}
	}

	private void cambiarCupo() {
		try {
			Clase clase = claseSeleccionada();
			if (clase == null) return;
			String cupo = JOptionPane.showInputDialog(this, "Nuevo cupo máximo", clase.getCapacidadMaxima());
			if (cupo == null) return;
			clase.setCapacidadMaxima(Normalizador.normalizarEnteroPositivo(cupo, "cupo"));
			actualizarTabla();
		} catch (ClaseException e) {
			mostrarError(e.getMessage());
		} catch (DatosInvalidosException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Datos inválidos", JOptionPane.WARNING_MESSAGE);
		}
	}

	private void eliminarClase() {
		try {
			Clase clase = claseSeleccionada();
			if (clase == null) return;
			int respuesta = JOptionPane.showConfirmDialog(this,
					"¿Eliminar la clase de " + clase.getActividad().getNombre() + "?", "Confirmar",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (respuesta != JOptionPane.YES_OPTION) return;
			gestionClases.eliminarClase(clase.getIdClase());
			actualizarTabla();
		} catch (ClaseException e) {
			mostrarError(e.getMessage());
		}
	}

	private void mostrarError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
