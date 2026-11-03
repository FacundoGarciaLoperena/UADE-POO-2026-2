package modelo;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Inscripcion {
	public enum EstadoInscripcion {
		CONFIRMADA, CANCELADA, ASISTIO, AUSENTE
	}

	private int idInscripcion;
	private Cliente cliente;
	private Clase clase;
	private LocalDate fechaAlta;
	private EstadoInscripcion estado;

	public Inscripcion(int idInscripcion, Cliente cliente, Clase clase, LocalDate fechaAlta,
			EstadoInscripcion estado) {
		this.idInscripcion = idInscripcion;
		this.cliente = cliente;
		this.clase = clase;
		this.fechaAlta = fechaAlta;
		this.estado = estado;
	}
}
