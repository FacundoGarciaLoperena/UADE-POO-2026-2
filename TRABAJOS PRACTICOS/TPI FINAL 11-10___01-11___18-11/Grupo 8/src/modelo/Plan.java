package modelo;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
