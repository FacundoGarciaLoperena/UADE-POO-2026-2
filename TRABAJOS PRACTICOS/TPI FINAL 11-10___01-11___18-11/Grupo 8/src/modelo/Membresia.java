package modelo;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Membresia {
	public enum EstadoMembresia {
		VIGENTE, VENCIDA, CANCELADA
	}
	
	private int idMembresia;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private EstadoMembresia estado;
	private Plan plan;
	@JsonIgnore
	private Cliente cliente;
	private Map<Integer,Pago> pagos = new HashMap<Integer,Pago>();

	public Membresia(int idMembresia, LocalDate fechaInicio, LocalDate fechaFin, EstadoMembresia estado, Plan plan,
			Cliente cliente) {
		this.idMembresia = idMembresia;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
		this.plan = plan;
		this.cliente = cliente;
	}
	
	
}
