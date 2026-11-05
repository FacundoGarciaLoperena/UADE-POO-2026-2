package interfaz.contenido.clases;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import excepciones.DatosInvalidosException;
import interfaz.componentes.Boton;
import interfaz.config.Estilos;
import interfaz.utilidades.Normalizador;
import modelo.Actividad;
import modelo.Clase;
import modelo.Profesor;

//Alta de una clase. La hora de fin se calcula con la duración de la actividad
public class FormularioClase extends JDialog {

	private static final long serialVersionUID = 1L;

	private JComboBox<Actividad> comboActividad;
	private JComboBox<Profesor> comboProfesor;
	private JTextField campoFecha = new JTextField(LocalDate.now().format(Normalizador.FORMATO_FECHA));
	private JTextField campoHora = new JTextField("18:00");
	private JTextField campoCupo = new JTextField("20");

	private int idClase;
	private Clase resultado;

	public FormularioClase(Window padre, int idClase, List<Actividad> actividades, List<Profesor> profesores) {
		super(padre, "Nueva clase", ModalityType.APPLICATION_MODAL);
		this.idClase = idClase;
		comboActividad = new JComboBox<Actividad>(actividades.toArray(new Actividad[0]));
		comboProfesor = new JComboBox<Profesor>(profesores.toArray(new Profesor[0]));

		JPanel campos = new JPanel(new GridLayout(5, 2, 10, 10));
		campos.setBorder(Estilos.MARGEN_TARJETA);
		agregarCampo(campos, "Actividad", comboActividad);
		agregarCampo(campos, "Profesor", comboProfesor);
		agregarCampo(campos, "Fecha (dd/mm/aaaa)", campoFecha);
		agregarCampo(campos, "Hora de inicio (hh:mm)", campoHora);
		agregarCampo(campos, "Cupo máximo", campoCupo);

		JPanel botones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		Boton cancelar = new Boton("Cancelar", Estilos.TEXTO_SECUNDARIO);
		cancelar.addActionListener(e -> dispose());
		Boton guardar = new Boton("Guardar", Estilos.AZUL);
		guardar.addActionListener(e -> guardar());
		botones.add(cancelar);
		botones.add(guardar);

		setLayout(new BorderLayout());
		add(campos, BorderLayout.CENTER);
		add(botones, BorderLayout.SOUTH);
		getRootPane().setDefaultButton(guardar);
		pack();
		setSize(Math.max(getWidth(), 460), getHeight());
		setLocationRelativeTo(padre);
	}

	private void agregarCampo(JPanel panel, String texto, java.awt.Component campo) {
		JLabel label = new JLabel(texto);
		label.setFont(Estilos.FUENTE_NORMAL);
		label.setForeground(Estilos.TEXTO);
		campo.setFont(Estilos.FUENTE_NORMAL);
		if (campo instanceof JTextField t) {
			t.setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createLineBorder(Estilos.BORDE_COMPONENTE),
					BorderFactory.createEmptyBorder(4, 6, 4, 6)));
		}
		panel.add(label);
		panel.add(campo);
	}

	private void guardar() {
		try {
			Actividad actividad = (Actividad) comboActividad.getSelectedItem();
			Profesor profesor = (Profesor) comboProfesor.getSelectedItem();
			if (actividad == null || profesor == null) {
				throw new DatosInvalidosException("Tiene que haber al menos una actividad y un profesor cargados");
			}
			LocalDate fecha = Normalizador.normalizarFecha(campoFecha.getText(), "fecha");
			LocalTime hora = Normalizador.normalizarHora(campoHora.getText());
			int cupo = Normalizador.normalizarEnteroPositivo(campoCupo.getText(), "cupo");

			LocalDateTime inicio = LocalDateTime.of(fecha, hora);
			if (inicio.isBefore(LocalDateTime.now())) {
				throw new DatosInvalidosException("No se puede crear una clase en el pasado");
			}
			LocalDateTime fin = inicio.plusMinutes(actividad.getDuracionMins());

			resultado = new Clase(idClase, inicio, fin, profesor, actividad, cupo);
			dispose();
		} catch (DatosInvalidosException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Datos inválidos", JOptionPane.WARNING_MESSAGE);
		}
	}

	public Clase mostrar() {
		setVisible(true);
		return resultado;
	}
}
