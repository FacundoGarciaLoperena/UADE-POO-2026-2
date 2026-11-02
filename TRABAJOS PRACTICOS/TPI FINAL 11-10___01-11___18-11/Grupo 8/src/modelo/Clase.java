package modelo;

import java.time.LocalDateTime;

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

	public int getIdClase() {
		return idClase;
	}

	public void setIdClase(int idClase) {
		this.idClase = idClase;
	}

	public LocalDateTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalDateTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalDateTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalDateTime horaFin) {
		this.horaFin = horaFin;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public void setCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}
}
