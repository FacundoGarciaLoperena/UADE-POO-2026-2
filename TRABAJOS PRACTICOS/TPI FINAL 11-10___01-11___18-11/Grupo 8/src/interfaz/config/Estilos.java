package interfaz.config;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public final class Estilos {

	private Estilos() {
	}

	//COLORES
	public static final Color FONDO = new Color(245, 247, 250);
	public static final Color BLANCO = Color.WHITE;

	public static final Color MENU = new Color(25, 35, 55);
	public static final Color MENU_HOVER = new Color(40, 55, 80);

	public static final Color AZUL = new Color(45, 115, 210);
	public static final Color AZUL_CLARO = new Color(225, 238, 255);
	
	public static final Color COLOR_TITULO = new Color(30, 41, 59);
	
	public static final Color TEXTO = new Color(40, 48, 60);
	public static final Color TEXTO_SECUNDARIO = new Color(120, 130, 145);

	public static final Color BORDE = new Color(225, 229, 235);

	public static final Color VERDE = new Color(35, 155, 100);
	public static final Color ROJO = new Color(210, 65, 65);
	public static final Color NARANJA = new Color(230, 150, 45);
	
	//FUENTES
	public static final Font FUENTE_TITULO = new Font("Segoe UI", Font.BOLD, 26);

	public static final Font FUENTE_SUBTITULO = new Font("Segoe UI", Font.BOLD, 16);

	public static final Font FUENTE_NORMAL = new Font("Segoe UI", Font.PLAIN, 13);

	public static final Font FUENTE_PEQUENA = new Font("Segoe UI", Font.PLAIN, 11);

	public static final Font FUENTE_VALOR = new Font("Segoe UI", Font.BOLD, 28);

	// DIMENSIONES
	public static final int ANCHO_MENU = 210;
	public static final int ALTURA_TITULOS = 55;

	// BORDES
	public static final Border BORDE_PANEL = BorderFactory.createLineBorder(BORDE);
	
	public static final Color BORDE_COMPONENTE = new Color(210, 220, 233);

	public static final Border MARGEN_PANEL = BorderFactory.createEmptyBorder(20, 25, 20, 25);

	public static final Border MARGEN_TARJETA = BorderFactory.createEmptyBorder(15, 15, 15, 15);

}
