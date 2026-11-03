package modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Gimnasio {
	@Setter
	private String nombre;
	@Setter
	private String dueno;
	@Setter
	private String direccion;
	@Setter
	private String telefono;
	@Setter
	private int capacidadMaxima;
	private GestionClientes gestionClientes;
	private GestionEmpleados gestionEmpleados;
	private GestionPlanesYMembresias gestionPlanesYMembresias;
	private GestionPagos gestionPagos;
	private GestionActividadesClases gestionActividadesClases;
	private GestionInventario gestionInventario;

	public Gimnasio(String nombre, String dueno, String direccion, String telefono, int capacidadMaxima) {
		this.nombre = nombre;
		this.dueno = dueno;
		this.direccion = direccion;
		this.telefono = telefono;
		this.capacidadMaxima = capacidadMaxima;
		this.gestionClientes = new GestionClientes();
		this.gestionEmpleados = new GestionEmpleados();
		this.gestionPlanesYMembresias = new GestionPlanesYMembresias();
		this.gestionPagos = new GestionPagos();
		this.gestionActividadesClases = new GestionActividadesClases();
		this.gestionInventario = new GestionInventario();
	}
}
