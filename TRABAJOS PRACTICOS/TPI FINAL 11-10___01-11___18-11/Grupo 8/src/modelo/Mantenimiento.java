package modelo;

import java.time.LocalDate;

public class Mantenimiento {
	private int idMantenimiento;
	private LocalDate fecha;
	private String descripcion;
	private Maquina maquina;
	private Empleado responsable;
	private double costo;

	public Mantenimiento(int idMantenimiento, LocalDate fecha, String descripcion, Maquina maquina,
			Empleado responsable, double costo) {
		this.idMantenimiento = idMantenimiento;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.maquina = maquina;
		this.responsable = responsable;
		this.costo = costo;
	}

	public int getIdMantenimiento() {
		return idMantenimiento;
	}

	public void setIdMantenimiento(int idMantenimiento) {
		this.idMantenimiento = idMantenimiento;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Maquina getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

	public Empleado getResponsable() {
		return responsable;
	}

	public void setResponsable(Empleado responsable) {
		this.responsable = responsable;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}
}
