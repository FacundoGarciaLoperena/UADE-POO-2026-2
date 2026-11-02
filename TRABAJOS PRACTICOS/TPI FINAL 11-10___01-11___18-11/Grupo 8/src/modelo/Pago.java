package modelo;

import java.time.LocalDateTime;

public class Pago {
	private int idPago;
	private LocalDateTime fechaHora;
	private double monto;
	private Cliente cliente;
	private Membresia membresia;
	private MetodoDePago metodo;

	public Pago(int idPago, LocalDateTime fechaHora, double monto, Cliente cliente, Membresia membresia,
			MetodoDePago metodo) {
		this.idPago = idPago;
		this.fechaHora = fechaHora;
		this.monto = monto;
		this.cliente = cliente;
		this.membresia = membresia;
		this.metodo = metodo;
	}

	public int getIdPago() {
		return idPago;
	}

	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Membresia getMembresia() {
		return membresia;
	}

	public void setMembresia(Membresia membresia) {
		this.membresia = membresia;
	}

	public MetodoDePago getMetodo() {
		return metodo;
	}

	public void setMetodo(MetodoDePago metodo) {
		this.metodo = metodo;
	}
	
	
}
