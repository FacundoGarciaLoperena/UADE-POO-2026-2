package interfaz.contenido.dashboard;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTable;


import interfaz.contenido.PanelBase;
import modelo.GestionClientes;
import modelo.Gimnasio;

public class DashboardPanel extends PanelBase{
	
	
	private static final long serialVersionUID = 1L;

	public DashboardPanel(Gimnasio gimnasio){
		
		super("Dashboard");
		
		//Separador 
		JPanel contenido = new JPanel(new BorderLayout(0, 15));
		add(contenido,BorderLayout.CENTER);
		
		JPanel contenidoTop = new JPanel(new GridLayout(1, 3, 12, 0));
		contenidoTop.setPreferredSize(new Dimension(0, 160));
		contenido.add(contenidoTop, BorderLayout.NORTH);
		
		contenidoTop.add(new TarjetaDashboard(
		    "Miembros activos", String.valueOf(gimnasio.getGestionClientes().contarClientesActivos()), "Socios con membresía"
		));

		contenidoTop.add(new TarjetaDashboard(
		    "Cupos libres hoy", "25", "20% de capacidad libre"
		));

		contenidoTop.add(new TarjetaDashboard(
		    "Requieren atención", "4", "Situaciones pendientes"
		));
			
		//Fila de abajo			
		JPanel contenidoBottom = new JPanel(new GridLayout(1,2,12,0));
		contenido.add(contenidoBottom, BorderLayout.CENTER);
			
			//Tabla Act reciente
			JTable actividadReciente = new JTable();
			PanelTablaDashboard ActReciente = new PanelTablaDashboard("Actividad Reciente",actividadReciente);
			contenidoBottom.add(ActReciente);
			
			//Tabla Clases hoy
			JTable tablaClases = new JTable();
			PanelTablaDashboard clasesHoy = new PanelTablaDashboard("Clases Hoy",tablaClases);
			contenidoBottom.add(clasesHoy);
			
			
			
			
			
	}
}
