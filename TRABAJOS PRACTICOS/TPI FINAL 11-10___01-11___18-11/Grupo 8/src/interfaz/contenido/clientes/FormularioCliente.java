package interfaz.contenido.clientes;

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
import modelo.Cliente;
import modelo.Cliente.EstadoCliente;
import modelo.Persona.Genero;

//Ventana para dar de alta o modificar un cliente. Si clienteExistente es null es un alta
public class FormularioCliente extends JDialog {

	private static final long serialVersionUID = 1L;

	private JTextField campoNombre = new JTextField();
	private JTextField campoDni = new JTextField();
	private JTextField campoNacimiento = new JTextField();
	private JComboBox<Genero> comboGenero = new JComboBox<Genero>(Genero.values());
	private JTextField campoTelefono = new JTextField();
	private JTextField campoMail = new JTextField();
	private JComboBox<EstadoCliente> comboEstado = new JComboBox<EstadoCliente>(EstadoCliente.values());

	private Cliente clienteExistente;
	private Cliente resultado;

	public FormularioCliente(Window padre, Cliente clienteExistente) {
		super(padre, clienteExistente == null ? "Nuevo cliente" : "Modificar cliente", ModalityType.APPLICATION_MODAL);
		this.clienteExistente = clienteExistente;

		JPanel campos = new JPanel(new GridLayout(7, 2, 10, 10));
		campos.setBorder(Estilos.MARGEN_TARJETA);
		agregarCampo(campos, "Nombre completo", campoNombre);
		agregarCampo(campos, "DNI", campoDni);
		agregarCampo(campos, "Nacimiento (dd/mm/aaaa)", campoNacimiento);
		agregarCampo(campos, "Género", comboGenero);
		agregarCampo(campos, "Teléfono", campoTelefono);
		agregarCampo(campos, "Correo", campoMail);
		agregarCampo(campos, "Estado", comboEstado);

		if (clienteExistente != null) {
			campoNombre.setText(clienteExistente.getNombreCompleto());
			campoDni.setText(String.valueOf(clienteExistente.getDni()));
			campoDni.setEditable(false);
			if (clienteExistente.getFechaNacimiento() != null)
				campoNacimiento.setText(clienteExistente.getFechaNacimiento().format(Normalizador.FORMATO_FECHA));
			comboGenero.setSelectedItem(clienteExistente.getGenero());
			campoTelefono.setText(clienteExistente.getTelefono());
			campoMail.setText(clienteExistente.getMail());
			comboEstado.setSelectedItem(clienteExistente.getEstado());
		}

		//Botones de abajo
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
			String nombre = Normalizador.normalizarNombre(campoNombre.getText());
			int dni = Normalizador.normalizarDni(campoDni.getText());
			LocalDate nacimiento = Normalizador.normalizarFechaNacimiento(campoNacimiento.getText());
			String telefono = Normalizador.normalizarTelefono(campoTelefono.getText());
			String mail = Normalizador.normalizarMail(campoMail.getText());
			Genero genero = (Genero) comboGenero.getSelectedItem();
			EstadoCliente estado = (EstadoCliente) comboEstado.getSelectedItem();

			if (clienteExistente == null) {
				resultado = new Cliente(nombre, nacimiento, genero, dni, telefono, mail, LocalDate.now(), estado);
			} else {
				clienteExistente.setNombreCompleto(nombre);
				clienteExistente.setFechaNacimiento(nacimiento);
				clienteExistente.setGenero(genero);
				clienteExistente.setTelefono(telefono);
				clienteExistente.setMail(mail);
				clienteExistente.setEstado(estado);
				resultado = clienteExistente;
			}
			dispose();
		} catch (DatosInvalidosException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Datos inválidos", JOptionPane.WARNING_MESSAGE);
		}
	}

	//Devuelve el cliente cargado, o null si se canceló
	public Cliente mostrar() {
		setVisible(true);
		return resultado;
	}
}
