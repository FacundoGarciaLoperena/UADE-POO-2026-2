package interfaz.contenido.dashboard;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;

import java.awt.Color;
import java.awt.Font;


public class TarjetaDashboard extends JPanel {

	private static final long serialVersionUID = 1L;

	private static final Color FONDO = new Color(248, 250, 252);
	private static final Color COLOR_TITULO = new Color(90, 105, 125);
	private static final Color COLOR_INFO = new Color(38, 61, 89);
	private static final Color COLOR_SECUNDARIO = new Color(120, 130, 145);
	private static final Color BORDE = new Color(220, 226, 234);

	public TarjetaDashboard(String titulo, String info, String infoSecundaria) {
		setLayout(new BorderLayout(0, 8));
		setBackground(FONDO);
		setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(BORDE),
				BorderFactory.createEmptyBorder(15, 15, 15, 15)));
		
		JLabel tituloLabel = new JLabel(titulo);
		tituloLabel.setFont(new Font("Arial", Font.BOLD, 13));
		tituloLabel.setForeground(COLOR_TITULO);
		tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel cantidadInfo = new JLabel(info);
		cantidadInfo.setFont(new Font("Arial", Font.BOLD, 30));
		cantidadInfo.setForeground(COLOR_INFO);
		cantidadInfo.setHorizontalAlignment(SwingConstants.CENTER);
		cantidadInfo.setVerticalAlignment(SwingConstants.CENTER);

		add(tituloLabel, BorderLayout.NORTH);
		add(cantidadInfo, BorderLayout.CENTER);

		if (infoSecundaria != null && !infoSecundaria.isBlank()) {
			JLabel infoSecLabel = new JLabel(infoSecundaria);
			infoSecLabel.setFont(new Font("Arial", Font.PLAIN, 11));
			infoSecLabel.setForeground(COLOR_SECUNDARIO);
			infoSecLabel.setHorizontalAlignment(SwingConstants.CENTER);

			add(infoSecLabel, BorderLayout.SOUTH);
		}
	}

	public TarjetaDashboard(String titulo, String info) {
		this(titulo, info, null);
	}
}
