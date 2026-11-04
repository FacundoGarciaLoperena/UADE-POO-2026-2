package modelo;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Plan {
	private String nombre;
	private String descripcion;
	private Map<Integer,Perk> perks = new HashMap<Integer,Perk>();
	private int duracionDias;
	private double precio;

	public Plan(String nombre, String descripcion, int duracionDias, double precio) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracionDias = duracionDias;
		this.precio = precio;
		
	}
}
