package interfaz.contenido.dashboard;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaz.config.Estilos;

public class DashboardPanel extends JPanel{
	
	
	private static final long serialVersionUID = 1L;

	public DashboardPanel(){
		
		setLayout(new GridLayout(2,1));
		JLabel titulo = new JLabel("Dashboard");
		titulo.setPreferredSize(new Dimension(800,Estilos.ALTURA_TITULOS));
		
		add(titulo);
		
		JPanel contenido = new JPanel(new GridLayout(2,1));
		add(contenido);
		
		JPanel contenidoTop = new JPanel(new GridLayout(1,3));
		contenido.add(contenidoTop);
		JPanel miembrosActivos = new JPanel(new BorderLayout());
		contenidoTop.add(miembrosActivos);
		JLabel tituloMiembros = new JLabel("Miembros Activos");
		miembrosActivos.add(tituloMiembros);
		JPanel contenidoBottom = new JPanel(new GridLayout(1,2));
		
	}
}
