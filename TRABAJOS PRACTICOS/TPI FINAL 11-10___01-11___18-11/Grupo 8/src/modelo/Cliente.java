package modelo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Cliente extends Persona {
	private int dni;
	private String telefono;
	private String mail;
	private LocalDate fechaAlta;
	private EstadoCliente estado;
	private Set<Membresia> membresias;
	private Set<Ingreso> ingresos;

	public Cliente(String nombreCompleto, LocalDate fechaNacimiento, Genero genero, int dni, String telefono,
			String mail, LocalDate fechaAlta, EstadoCliente estado) {
		super(nombreCompleto, fechaNacimiento, genero);
		this.dni = dni;
		this.telefono = telefono;
		this.mail = mail;
		this.fechaAlta = fechaAlta;
		this.estado = estado;
		this.membresias = new HashSet<>();
		this.ingresos = new HashSet<>();
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public EstadoCliente getEstado() {
		return estado;
	}

	public void setEstado(EstadoCliente estado) {
		this.estado = estado;
	}

	public Set<Membresia> getMembresias() {
		return membresias;
	}

	public void setMembresias(Set<Membresia> membresias) {
		this.membresias = membresias;
	}

	public Set<Ingreso> getIngresos() {
		return ingresos;
	}

	public void setIngresos(Set<Ingreso> ingresos) {
		this.ingresos = ingresos;
	}
}
