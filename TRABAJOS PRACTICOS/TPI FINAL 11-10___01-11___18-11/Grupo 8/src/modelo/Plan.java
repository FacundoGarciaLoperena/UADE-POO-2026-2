package modelo;

import java.util.HashSet;
import java.util.Set;

public class Plan {
	private String nombre;
	private String descripcion;
	private Set<Perk> perks;
	private int duracionDias;
	private double precio;

	public Plan(String nombre, String descripcion, int duracionDias, double precio) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracionDias = duracionDias;
		this.precio = precio;
		this.perks = new HashSet<>();
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

	public Set<Perk> getPerks() {
		return perks;
	}

	public void setPerks(Set<Perk> perks) {
		this.perks = perks;
	}

	public int getDuracionDias() {
		return duracionDias;
	}

	public void setDuracionDias(int duracionDias) {
		this.duracionDias = duracionDias;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
