package modelo;

public class Actividad {
	private String nombre;
	private String descripcion;
	private int duracionMins;

	public Actividad(String nombre, String descripcion, int duracionMins) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracionMins = duracionMins;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDuracionMins() {
		return duracionMins;
	}

	public void setDuracionMins(int duracionMins) {
		this.duracionMins = duracionMins;
	}
}
