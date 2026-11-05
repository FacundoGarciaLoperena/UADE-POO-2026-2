package interfaz;

import java.awt.*;

import javax.swing.*;

import interfaz.contenido.clases.ClasesPanel;
import interfaz.contenido.clientes.ClientesPanel;
import interfaz.contenido.dashboard.DashboardPanel;
import interfaz.contenido.profesores.ProfesoresPanel;
import interfaz.menu.MenuIzq;
import modelo.Gimnasio;

public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private Gimnasio gimnasio;

	public VentanaPrincipal(Gimnasio gimnasio) {
		this.gimnasio = gimnasio;
		
		setTitle("Gym Manager");
		setSize(1280, 760);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		setLayout(new BorderLayout());

		CardLayout cardLayout = new CardLayout();
		JPanel contenido = new JPanel(cardLayout);
		
		add(new MenuIzq(cardLayout, contenido), BorderLayout.WEST);
		contenido.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));
		
	
		DashboardPanel dashboard = new DashboardPanel(gimnasio);
		ClasesPanel clases = new ClasesPanel(gimnasio);
		ClientesPanel clientes = new ClientesPanel(gimnasio);
		ProfesoresPanel profesores = new ProfesoresPanel(gimnasio);
		

		contenido.add(dashboard, "DASHBOARD");
		contenido.add(clases, "CLASES");
		contenido.add(clientes,"CLIENTES");
		contenido.add(profesores, "PROFESORES");
		cardLayout.show(contenido,"CLIENTES");
		
		add(contenido,BorderLayout.CENTER);
		setVisible(true);
		
	}

}
