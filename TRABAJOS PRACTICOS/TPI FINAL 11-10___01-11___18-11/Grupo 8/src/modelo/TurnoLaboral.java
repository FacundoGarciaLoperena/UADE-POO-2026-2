package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TurnoLaboral {
	private int idTurno;
	private LocalDate fecha;
	private LocalDateTime horaInicio;
	private LocalDateTime horaFin;
	private Empleado empleado;

	public TurnoLaboral(int idTurno, LocalDate fecha, LocalDateTime horaInicio, LocalDateTime horaFin,
			Empleado empleado) {
		this.idTurno = idTurno;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.empleado = empleado;
	}
}
