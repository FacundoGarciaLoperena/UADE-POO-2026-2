package interfaz;

import java.awt.*;

import javax.swing.*;

import interfaz.contenido.dashboard.DashboardPanel;
import interfaz.menu.MenuIzq;

public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;

	public VentanaPrincipal() {

		setTitle("Gym Manager");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		setLayout(new BorderLayout());

		add(new MenuIzq(), BorderLayout.WEST);
		
		CardLayout cardLayout = new CardLayout();
		JPanel contenido = new JPanel(cardLayout);
		
		
		DashboardPanel dashboard = new DashboardPanel();

		contenido.add(dashboard, "DASHBOARD");
		cardLayout.show(contenido,"DASHBOARD");
		
		add(contenido,BorderLayout.CENTER);
		setVisible(true);
		
	}

}
