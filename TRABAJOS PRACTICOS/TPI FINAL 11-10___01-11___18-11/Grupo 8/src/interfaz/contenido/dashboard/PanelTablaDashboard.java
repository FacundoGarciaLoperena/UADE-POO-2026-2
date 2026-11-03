package interfaz.contenido.dashboard;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import interfaz.config.Estilos;

public class PanelTablaDashboard extends JPanel {
	

	    private static final long serialVersionUID = 1L;

	    public PanelTablaDashboard(String titulo, JTable tabla) {
	        setLayout(new BorderLayout(0, 10));

	        setBackground(Estilos.BLANCO);

	        setBorder(BorderFactory.createCompoundBorder(
	            BorderFactory.createLineBorder(Estilos.BORDE_COMPONENTE,1,true),
	            BorderFactory.createEmptyBorder(15, 15, 15, 15)
	        ));

	        JLabel tituloLabel = new JLabel(titulo);
	        tituloLabel.setFont(Estilos.FUENTE_SUBTITULO);
	        tituloLabel.setForeground(Estilos.COLOR_TITULO);

	        add(tituloLabel, BorderLayout.NORTH);
	        add(new JScrollPane(tabla), BorderLayout.CENTER);
	    }
	}


