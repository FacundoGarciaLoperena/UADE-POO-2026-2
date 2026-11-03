package modelo;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Maquina {
	public enum Estado {
		OPERATIVA, EN_MANTENIMIENTO, FUERA_DE_SERVICIO
	}

	public enum Tipo {
		CARDIO, MUSCULACION, PESO_LIBRE, FUNCIONAL
	}

	private int idMaquina;
	private String nombre;
	private String marca;
	private Estado estado;
	private LocalDate fechaAdquisicion;
	private Tipo tipo;

	public Maquina(int idMaquina, String nombre, String marca, Estado estado, LocalDate fechaAdquisicion,
			Tipo tipo) {
		this.idMaquina = idMaquina;
		this.nombre = nombre;
		this.marca = marca;
		this.estado = estado;
		this.fechaAdquisicion = fechaAdquisicion;
		this.tipo = tipo;
	}
}
