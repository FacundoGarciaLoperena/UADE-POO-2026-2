package modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Perk {
	private int idPerk;
	private String nombre;
	private String descripcion;

	public Perk(int idPerk, String nombre, String descripcion) {
		this.idPerk = idPerk;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
}
