package modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Actividad {
	private String nombre;
	private String descripcion;
	private int duracionMins;

	public Actividad(String nombre, String descripcion, int duracionMins) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracionMins = duracionMins;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Actividad otro)) return false;
		
		return nombre == otro.nombre;
		
	}
}
