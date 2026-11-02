package modelo;

public class Gimnasio {
	private String nombre;
	private String dueño;
	private String direccion;
	private String telefono;
	private int capacidadMaxima;
	private GestionClientes gestionClientes;
	private GestionEmpleados gestionEmpleados;
	private GestionPlanesYMembresias gestionPlanesYMembresias;
	private GestionPagos gestionPagos;
	private GestionActividadesClases gestionActividadesClases;
	private GestionInventario gestionInventario;

	public Gimnasio(String nombre, String dueño, String direccion, String telefono, int capacidadMaxima) {
		this.nombre = nombre;
		this.dueño = dueño;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDueño() {
		return dueño;
	}

	public void setDueño(String dueño) {
		this.dueño = dueño;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public void setCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}

	public GestionClientes getGestionClientes() {
		return gestionClientes;
	}

	public GestionEmpleados getGestionEmpleados() {
		return gestionEmpleados;
	}

	public GestionPlanesYMembresias getGestionPlanesYMembresias() {
		return gestionPlanesYMembresias;
	}

	public GestionPagos getGestionPagos() {
		return gestionPagos;
	}

	public GestionActividadesClases getGestionActividadesClases() {
		return gestionActividadesClases;
	}

	public GestionInventario getGestionInventario() {
		return gestionInventario;
	}
}
