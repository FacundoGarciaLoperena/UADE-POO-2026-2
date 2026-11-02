package modelo;

import java.time.LocalDateTime;

public class Ingreso {
	private int idIngreso;
	private LocalDateTime horaIngreso;
	private LocalDateTime horaEgreso;
	private Cliente cliente;
	private EstadoIngreso estado;

	public Ingreso(int idIngreso, LocalDateTime horaIngreso, LocalDateTime horaEgreso, Cliente cliente,
			EstadoIngreso estado) {
		this.idIngreso = idIngreso;
		this.horaIngreso = horaIngreso;
		this.horaEgreso = horaEgreso;
		this.cliente = cliente;
		this.estado = estado;
	}

	public int getIdIngreso() {
		return idIngreso;
	}

	public void setIdIngreso(int idIngreso) {
		this.idIngreso = idIngreso;
	}

	public LocalDateTime getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(LocalDateTime horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	public LocalDateTime getHoraEgreso() {
		return horaEgreso;
	}

	public void setHoraEgreso(LocalDateTime horaEgreso) {
		this.horaEgreso = horaEgreso;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public EstadoIngreso getEstado() {
		return estado;
	}

	public void setEstado(EstadoIngreso estado) {
		this.estado = estado;
	}
}
