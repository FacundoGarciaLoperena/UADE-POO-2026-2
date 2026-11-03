package modelo;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pago {
	public enum MetodoDePago {
		EFECTIVO, DEBITO, CREDITO, TRANSFERENCIA
	}

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
}
