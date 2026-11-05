package interfaz.menu;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import interfaz.config.Estilos;

public class MenuIzq extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JButton dashboard;
	private JButton clientes;
	private JButton profesores;
	private JButton clases;
	private JButton planes;

	public MenuIzq(CardLayout cardLayout, JPanel contenido) {

		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(200, 400));
		setBackground(Color.DARK_GRAY);

		JLabel tituloMenu = new JLabel("Menu");
		tituloMenu.setForeground(Color.WHITE);
		tituloMenu.setHorizontalAlignment(SwingConstants.CENTER);
		tituloMenu.setVerticalAlignment(SwingConstants.CENTER);
		tituloMenu.setPreferredSize(new Dimension(200, Estilos.ALTURA_TITULOS));
		add(tituloMenu, BorderLayout.NORTH);

		JPanel menuAdmin = new JPanel();
		menuAdmin.setLayout(new GridLayout(5, 1));
		add(menuAdmin, BorderLayout.CENTER);
		menuAdmin.setPreferredSize(new Dimension(200, 300));
		menuAdmin.setBackground(Color.WHITE);

		dashboard = new JButton("Dashboard");
		clientes = new JButton("Clientes");
		profesores = new JButton("Profesores");
		clases = new JButton("Clases");
		planes = new JButton("Planes");
		JButton[] botones = { dashboard, clientes, profesores, clases, planes };

		for (JButton boton : botones) {
			boton.setForeground(Color.WHITE);
			boton.setFocusPainted(false);
			boton.setBackground(new Color(35, 48, 70));
			boton.setFont(new Font("Arial", Font.PLAIN, 14));

			menuAdmin.add(boton);
		}
		
		//Cada botón muestra su pestaña en el CardLayout de la ventana
		dashboard.addActionListener(e -> cardLayout.show(contenido, "DASHBOARD"));
		clientes.addActionListener(e -> cardLayout.show(contenido, "CLIENTES"));
		profesores.addActionListener(e -> cardLayout.show(contenido, "PROFESORES"));
		clases.addActionListener(e -> cardLayout.show(contenido, "CLASES"));
		planes.setEnabled(false);
	}
}
