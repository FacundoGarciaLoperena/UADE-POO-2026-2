package modelo;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente extends Persona {
	public enum EstadoCliente {
		ACTIVO, INACTIVO, SUSPENDIDO
	}

	private int dni;
	private String telefono;
	private String mail;
	private LocalDate fechaAlta;
	private EstadoCliente estado;
	private Map<Integer,Membresia> membresias = new HashMap<Integer,Membresia>();
	private Map<Integer,Ingreso> ingresos = new HashMap<Integer,Ingreso>();

	public Cliente(String nombreCompleto, LocalDate fechaNacimiento, Genero genero, int dni, String telefono,
			String mail, LocalDate fechaAlta, EstadoCliente estado) {
		super(nombreCompleto, fechaNacimiento, genero);
		this.dni = dni;
		this.telefono = telefono;
		this.mail = mail;
		this.fechaAlta = fechaAlta;
		this.estado = estado;
	}
	

	@JsonIgnore
	public boolean isActivo()
	{
		return this.estado.equals(EstadoCliente.ACTIVO);
	}
	
	@JsonIgnore
	public boolean isMoroso()
	{
		return this.estado.equals(EstadoCliente.SUSPENDIDO);
	}
	
	    
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Cliente)) return false;
		
		Cliente otro = (Cliente) obj;
		return dni == otro.dni;
	}
	
	@Override
	public int hashCode() {
		return Integer.hashCode(dni);
	}
}
