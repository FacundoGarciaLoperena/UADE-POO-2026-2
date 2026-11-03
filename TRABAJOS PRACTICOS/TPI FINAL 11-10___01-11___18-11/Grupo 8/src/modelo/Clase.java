package modelo;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Clase {
	private int idClase;
	private LocalDateTime horaInicio;
	private LocalDateTime horaFin;
	private Profesor profesor;
	private Actividad actividad;
	private int capacidadMaxima;

	public Clase(int idClase, LocalDateTime horaInicio, LocalDateTime horaFin, Profesor profesor,
			Actividad actividad, int capacidadMaxima) {
		this.idClase = idClase;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.profesor = profesor;
		this.actividad = actividad;
		this.capacidadMaxima = capacidadMaxima;
	}
}
