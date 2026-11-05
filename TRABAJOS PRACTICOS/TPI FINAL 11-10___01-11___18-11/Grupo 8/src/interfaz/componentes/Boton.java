package interfaz.componentes;

import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import interfaz.config.Estilos;

public class Boton extends JButton {

	private static final long serialVersionUID = 1L;

	public Boton(String texto, java.awt.Color color) {
		super(texto);
		setFont(Estilos.FUENTE_NORMAL);
		setForeground(Estilos.BLANCO);
		setBackground(color);
		setFocusPainted(false);
		setOpaque(true);
		setBorderPainted(false);
		setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setMaximumSize(new Dimension(Integer.MAX_VALUE, 38));
		setAlignmentX(LEFT_ALIGNMENT);
	}
}
