package modelo;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Persona {
	public enum Genero {
		MASCULINO, FEMENINO, OTRO
	}

	private String nombreCompleto;
	private LocalDate fechaNacimiento;
	private Genero genero;

	public Persona(String nombreCompleto, LocalDate fechaNacimiento, Genero genero) {
		this.nombreCompleto = nombreCompleto;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
	}
}
