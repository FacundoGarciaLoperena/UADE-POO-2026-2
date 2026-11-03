package modelo;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
