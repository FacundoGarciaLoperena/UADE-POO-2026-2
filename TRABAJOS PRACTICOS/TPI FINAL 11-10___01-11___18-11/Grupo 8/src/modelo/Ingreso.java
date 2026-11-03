package modelo;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ingreso {
	public enum EstadoIngreso {
		DENTRO, FUERA, RECHAZADO
	}

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
}
