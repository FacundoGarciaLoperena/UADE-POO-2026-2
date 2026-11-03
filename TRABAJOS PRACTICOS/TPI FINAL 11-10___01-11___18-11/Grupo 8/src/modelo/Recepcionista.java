package modelo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Recepcionista extends Empleado {
	private Set<String> idiomas;

	public Recepcionista(String nombreCompleto, LocalDate fechaNacimiento, Genero genero, int nmroEmpleado,
			double salario, LocalDate fechaContratacion) {
		super(nombreCompleto, fechaNacimiento, genero, nmroEmpleado, salario, fechaContratacion);
		this.idiomas = new HashSet<>();
	}
}
