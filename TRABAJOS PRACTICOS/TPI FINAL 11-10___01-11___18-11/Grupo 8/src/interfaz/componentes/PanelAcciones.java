package interfaz.componentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaz.config.Estilos;

//Columna de botones con secciones, se usa en la mitad derecha de cada pestaña
public class PanelAcciones extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelAcciones() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Estilos.BLANCO);
		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Estilos.BORDE_COMPONENTE, 1, true),
				Estilos.MARGEN_TARJETA));
	}

	public void agregarSeccion(String titulo) {
		if (getComponentCount() > 0) {
			add(Box.createVerticalStrut(18));
		}
		JLabel tituloLabel = new JLabel(titulo);
		tituloLabel.setFont(Estilos.FUENTE_SUBTITULO);
		tituloLabel.setForeground(Estilos.COLOR_TITULO);
		tituloLabel.setAlignmentX(LEFT_ALIGNMENT);
		add(tituloLabel);
		add(Box.createVerticalStrut(10));
	}

	public Boton agregarBoton(String texto, Color color, ActionListener accion) {
		Boton boton = new Boton(texto, color);
		boton.addActionListener(accion);
		agregarComponente(boton);
		return boton;
	}

	public void agregarComponente(Component componente) {
		if (componente instanceof javax.swing.JComponent c) {
			c.setAlignmentX(LEFT_ALIGNMENT);
			c.setMaximumSize(new Dimension(Integer.MAX_VALUE, Math.max(c.getPreferredSize().height, 34)));
		}
		add(componente);
		add(Box.createVerticalStrut(8));
	}
}
