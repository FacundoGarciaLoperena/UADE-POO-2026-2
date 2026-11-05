package modelo;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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

	//JsonCreator para que Jackson pueda leer los clientes del json
	@JsonCreator
	public Cliente(@JsonProperty("nombreCompleto") String nombreCompleto,
			@JsonProperty("fechaNacimiento") LocalDate fechaNacimiento, @JsonProperty("genero") Genero genero,
			@JsonProperty("dni") int dni, @JsonProperty("telefono") String telefono, @JsonProperty("mail") String mail,
			@JsonProperty("fechaAlta") LocalDate fechaAlta, @JsonProperty("estado") EstadoCliente estado) {
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
		if (!(obj instanceof Cliente otro)) return false;
		
		return dni == otro.dni;
	}
	
	@Override
	public int hashCode() {
		return Integer.hashCode(dni);
	}
}
