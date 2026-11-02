package modelo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Profesor extends Empleado {
	private Set<String> certificaciones;

	public Profesor(String nombreCompleto, LocalDate fechaNacimiento, Genero genero, int nmroEmpleado,
			double salario, LocalDate fechaContratacion) {
		super(nombreCompleto, fechaNacimiento, genero, nmroEmpleado, salario, fechaContratacion);
		this.certificaciones = new HashSet<>();
	}

	public Set<String> getCertificaciones() {
		return certificaciones;
	}

	public void setCertificaciones(Set<String> certificaciones) {
		this.certificaciones = certificaciones;
	}
}
