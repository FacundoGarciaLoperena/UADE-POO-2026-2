package modelo;

import java.time.LocalDate;

public class Inscripcion {
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

	public int getIdInscripcion() {
		return idInscripcion;
	}

	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public EstadoInscripcion getEstado() {
		return estado;
	}

	public void setEstado(EstadoInscripcion estado) {
		this.estado = estado;
	}
}
