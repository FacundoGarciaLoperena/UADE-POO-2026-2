package modelo;

public class Perk {
	private int idPerk;
	private String nombre;
	private String descripcion;

	public Perk(int idPerk, String nombre, String descripcion) {
		this.idPerk = idPerk;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getIdPerk() {
		return idPerk;
	}

	public void setIdPerk(int idPerk) {
		this.idPerk = idPerk;
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
}
