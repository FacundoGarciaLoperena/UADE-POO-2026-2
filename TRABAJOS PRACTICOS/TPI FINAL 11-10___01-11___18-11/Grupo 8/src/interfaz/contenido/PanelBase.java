package interfaz.contenido;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaz.config.Estilos;

public abstract class PanelBase extends JPanel {

    private static final long serialVersionUID = 1L;

    public PanelBase(String titulo) {
        setLayout(new BorderLayout(0, 20));

        setBorder(BorderFactory.createEmptyBorder(0, 25, 20, 25));

        JLabel tituloLabel = new JLabel(titulo);
        tituloLabel.setFont(Estilos.FUENTE_TITULO);
        tituloLabel.setForeground(Estilos.COLOR_TITULO);
        tituloLabel.setPreferredSize(new Dimension(200,Estilos.ALTURA_TITULOS));
        tituloLabel.setBorder(
        	    BorderFactory.createCompoundBorder(
        	        BorderFactory.createMatteBorder(
        	            0, 0, 2, 0,
        	            Estilos.BORDE
        	        ),
        	        BorderFactory.createEmptyBorder(0, 0, 12, 0)
        	    )
        	);

        add(tituloLabel, BorderLayout.NORTH);
    }
}