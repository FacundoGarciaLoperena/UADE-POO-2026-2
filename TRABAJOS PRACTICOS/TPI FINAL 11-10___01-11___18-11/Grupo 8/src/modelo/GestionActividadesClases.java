package modelo;

import java.util.HashSet;
import java.util.Set;

public class GestionActividadesClases {
	private Set<Actividad> actividades;
	private Set<Clase> clases;
	private Set<Inscripcion> inscripciones;

	public GestionActividadesClases() {
		this.actividades = new HashSet<>();
		this.clases = new HashSet<>();
		this.inscripciones = new HashSet<>();
	}

	public void crearActividad(Actividad actividad) {
		actividades.add(actividad);
	}

	public Actividad buscarActividad(String nombre) {
		for (Actividad a : actividades) {
			if (a.getNombre().equals(nombre))
				return a;
		}
		return null;
	}

	public void actualizarActividad(Actividad actividad) {
		eliminarActividad(actividad.getNombre());
		actividades.add(actividad);
	}

	public void eliminarActividad(String nombre) {
		Actividad a = buscarActividad(nombre);
		if (a != null)
			actividades.remove(a);
	}

	public void crearClase(Clase clase) {
		clases.add(clase);
	}

	public Clase buscarClase(int idClase) {
		for (Clase c : clases) {
			if (c.getIdClase() == idClase)
				return c;
		}
		return null;
	}

	public void actualizarClase(Clase clase) {
		eliminarClase(clase.getIdClase());
		clases.add(clase);
	}

	public void eliminarClase(int idClase) {
		Clase c = buscarClase(idClase);
		if (c != null)
			clases.remove(c);
	}

	public void crearInscripcion(Inscripcion inscripcion) {
		inscripciones.add(inscripcion);
	}

	public Inscripcion buscarInscripcion(int idInscripcion) {
		for (Inscripcion i : inscripciones) {
			if (i.getIdInscripcion() == idInscripcion)
				return i;
		}
		return null;
	}

	public void actualizarInscripcion(Inscripcion inscripcion) {
		eliminarInscripcion(inscripcion.getIdInscripcion());
		inscripciones.add(inscripcion);
	}

	public void eliminarInscripcion(int idInscripcion) {
		Inscripcion i = buscarInscripcion(idInscripcion);
		if (i != null)
			inscripciones.remove(i);
	}

	public Set<Actividad> getActividades() {
		return actividades;
	}

	public Set<Clase> getClases() {
		return clases;
	}

	public Set<Inscripcion> getInscripciones() {
		return inscripciones;
	}
}
