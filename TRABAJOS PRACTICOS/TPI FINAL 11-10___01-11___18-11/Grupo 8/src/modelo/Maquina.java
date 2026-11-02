package modelo;

import java.time.LocalDate;

public class Maquina {
	public enum Estado {
		OPERATIVA, EN_MANTENIMIENTO, FUERA_DE_SERVICIO
	}

	public enum Tipo {
		CARDIO, MUSCULACION, PESO_LIBRE, FUNCIONAL
	}

	private int idMaquina;
	private String nombre;
	private String marca;
	private Estado estado;
	private LocalDate fechaAdquisicion;
	private Tipo tipo;

	public Maquina(int idMaquina, String nombre, String marca, Estado estado, LocalDate fechaAdquisicion,
			Tipo tipo) {
		this.idMaquina = idMaquina;
		this.nombre = nombre;
		this.marca = marca;
		this.estado = estado;
		this.fechaAdquisicion = fechaAdquisicion;
		this.tipo = tipo;
	}

	public int getIdMaquina() {
		return idMaquina;
	}

	public void setIdMaquina(int idMaquina) {
		this.idMaquina = idMaquina;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public LocalDate getFechaAdquisicion() {
		return fechaAdquisicion;
	}

	public void setFechaAdquisicion(LocalDate fechaAdquisicion) {
		this.fechaAdquisicion = fechaAdquisicion;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
}
