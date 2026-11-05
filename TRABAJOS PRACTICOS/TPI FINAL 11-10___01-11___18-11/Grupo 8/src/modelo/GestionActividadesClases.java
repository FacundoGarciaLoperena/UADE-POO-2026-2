package modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import excepciones.ClaseDuplicadaException;
import excepciones.ClaseNoEncontradaException;
import lombok.Getter;

@Getter
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

	public List<Actividad> listarActividades() {
		List<Actividad> lista = new ArrayList<Actividad>(actividades);
		lista.sort(Comparator.comparing(Actividad::getNombre));
		return lista;
	}

	public void crearClase(Clase clase) throws ClaseDuplicadaException {
		for (Clase c : clases) {
			if (c.getIdClase() == clase.getIdClase())
				throw new ClaseDuplicadaException("Ya existe una clase con id: " + clase.getIdClase());
		}
		clases.add(clase);
	}

	public Clase buscarClase(int idClase) throws ClaseNoEncontradaException {
		for (Clase c : clases) {
			if (c.getIdClase() == idClase)
				return c;
		}
		throw new ClaseNoEncontradaException("No se ha encontrado la clase con id: " + idClase);
	}

	public void actualizarClase(Clase clase) throws ClaseNoEncontradaException {
		eliminarClase(clase.getIdClase());
		clases.add(clase);
	}

	public void eliminarClase(int idClase) throws ClaseNoEncontradaException {
		Clase c = buscarClase(idClase);
		clases.remove(c);
	}
	
	//Ordenadas por fecha y hora de inicio
	public List<Clase> listarClases() {
		List<Clase> lista = new ArrayList<Clase>(clases);
		lista.sort(Comparator.comparing(Clase::getHoraInicio));
		return lista;
	}
	
	public boolean profesorTieneClases(Profesor profesor) {
		for (Clase c : clases) {
			if (c.getProfesor() == profesor)
				return true;
		}
		return false;
	}
	
	public int siguienteIdClase() {
		int max = 0;
		for (Clase c : clases) {
			if (c.getIdClase() > max)
				max = c.getIdClase();
		}
		return max + 1;
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
}
