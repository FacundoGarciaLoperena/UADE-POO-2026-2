package interfaz.contenido.profesores;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.time.LocalDate;

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
import modelo.Persona.Genero;
import modelo.Profesor;

//Alta de un profesor nuevo, el número de empleado lo asigna la gestión
public class FormularioProfesor extends JDialog {

	private static final long serialVersionUID = 1L;

	private JTextField campoNombre = new JTextField();
	private JTextField campoNacimiento = new JTextField();
	private JComboBox<Genero> comboGenero = new JComboBox<Genero>(Genero.values());
	private JTextField campoSalario = new JTextField();
	private JTextField campoCertificaciones = new JTextField();

	private int nmroEmpleado;
	private Profesor resultado;

	public FormularioProfesor(Window padre, int nmroEmpleado) {
		super(padre, "Nuevo profesor", ModalityType.APPLICATION_MODAL);
		this.nmroEmpleado = nmroEmpleado;

		JPanel campos = new JPanel(new GridLayout(5, 2, 10, 10));
		campos.setBorder(Estilos.MARGEN_TARJETA);
		agregarCampo(campos, "Nombre completo", campoNombre);
		agregarCampo(campos, "Nacimiento (dd/mm/aaaa)", campoNacimiento);
		agregarCampo(campos, "Género", comboGenero);
		agregarCampo(campos, "Salario", campoSalario);
		agregarCampo(campos, "Certificaciones (separadas por coma)", campoCertificaciones);

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
		setSize(Math.max(getWidth(), 520), getHeight());
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
			String nombre = Normalizador.normalizarNombre(campoNombre.getText());
			LocalDate nacimiento = Normalizador.normalizarFechaNacimiento(campoNacimiento.getText());
			double salario = Normalizador.normalizarMonto(campoSalario.getText(), "salario");
			Genero genero = (Genero) comboGenero.getSelectedItem();

			resultado = new Profesor(nombre, nacimiento, genero, nmroEmpleado, salario, LocalDate.now());
			for (String certificacion : campoCertificaciones.getText().split(",")) {
				if (!certificacion.isBlank())
					resultado.getCertificaciones().add(certificacion.trim().toUpperCase());
			}
			dispose();
		} catch (DatosInvalidosException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Datos inválidos", JOptionPane.WARNING_MESSAGE);
		}
	}

	public Profesor mostrar() {
		setVisible(true);
		return resultado;
	}
}
