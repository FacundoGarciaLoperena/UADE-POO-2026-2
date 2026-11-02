package modelo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Recepcionista extends Empleado {
	private Set<String> idiomas;

	public Recepcionista(String nombreCompleto, LocalDate fechaNacimiento, Genero genero, int nmroEmpleado,
			double salario, LocalDate fechaContratacion) {
		super(nombreCompleto, fechaNacimiento, genero, nmroEmpleado, salario, fechaContratacion);
		this.idiomas = new HashSet<>();
	}

	public Set<String> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(Set<String> idiomas) {
		this.idiomas = idiomas;
	}
}
