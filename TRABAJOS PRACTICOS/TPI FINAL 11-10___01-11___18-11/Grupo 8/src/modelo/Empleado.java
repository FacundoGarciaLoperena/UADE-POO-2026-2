package modelo;

import java.time.LocalDate;

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

	public int getNmroEmpleado() {
		return nmroEmpleado;
	}

	public void setNmroEmpleado(int nmroEmpleado) {
		this.nmroEmpleado = nmroEmpleado;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public LocalDate getFechaContratacion() {
		return fechaContratacion;
	}

	public void setFechaContratacion(LocalDate fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}
}
