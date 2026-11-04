package interfaz;

import java.awt.*;

import javax.swing.*;

import interfaz.contenido.clases.ClasesPanel;
import interfaz.contenido.clientes.ClientesPanel;
import interfaz.contenido.dashboard.DashboardPanel;
import interfaz.menu.MenuIzq;
import modelo.Clase;
import modelo.Gimnasio;

public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private Gimnasio gimnasio;

	public VentanaPrincipal(Gimnasio gimnasio) {
		this.gimnasio = gimnasio;
		
		setTitle("Gym Manager");
		setSize(1000, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		setLayout(new BorderLayout());

		add(new MenuIzq(), BorderLayout.WEST);
		
		CardLayout cardLayout = new CardLayout();
		JPanel contenido = new JPanel(cardLayout);
		contenido.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));
		
	
		DashboardPanel dashboard = new DashboardPanel(gimnasio);
		ClasesPanel clases = new ClasesPanel();
		ClientesPanel clientes = new ClientesPanel();
		

		contenido.add(dashboard, "DASHBOARD");
		contenido.add(clases, "CLASES");
		contenido.add(clientes,"CLIENTES");
		cardLayout.show(contenido,"CLIENTES");
		
		add(contenido,BorderLayout.CENTER);
		setVisible(true);
		
	}

}
