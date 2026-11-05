package modelo;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Empleado extends Persona {
	private int nmroEmpleado;
	private double salario;
	private LocalDate fechaContratacion;

	public Empleado(String nombreCompleto, LocalDate fechaNacimiento, Genero genero, int nmroEmpleado,
			double salario, LocalDate fechaContratacion) {
		super(nombreCompleto, fechaNacimiento, genero);
		this.nmroEmpleado = nmroEmpleado;
		this.salario = salario;
		this.fechaContratacion = fechaContratacion;
	}

	@Override
	public String toString() {
		return getNombreCompleto();
	}
}
