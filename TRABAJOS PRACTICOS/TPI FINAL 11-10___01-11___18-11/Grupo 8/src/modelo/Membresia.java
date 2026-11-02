package modelo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Membresia {
	private int idMembresia;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private EstadoMembresia estado;
	private Plan plan;
	private Cliente cliente;
	private Set<Pago> pagos;

	public Membresia(int idMembresia, LocalDate fechaInicio, LocalDate fechaFin, EstadoMembresia estado, Plan plan,
			Cliente cliente) {
		this.idMembresia = idMembresia;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
		this.plan = plan;
		this.cliente = cliente;
		this.pagos = new HashSet<>();
	}

	public int getIdMembresia() {
		return idMembresia;
	}

	public void setIdMembresia(int idMembresia) {
		this.idMembresia = idMembresia;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public EstadoMembresia getEstado() {
		return estado;
	}

	public void setEstado(EstadoMembresia estado) {
		this.estado = estado;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(Set<Pago> pagos) {
		this.pagos = pagos;
	}
}
