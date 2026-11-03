package modelo;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;

@Getter
public class GestionPlanesYMembresias {
	private Set<Plan> planes;
	private Set<Membresia> membresias;

	public GestionPlanesYMembresias() {
		this.planes = new HashSet<>();
		this.membresias = new HashSet<>();
	}

	public void crearPlan(Plan plan) {
		planes.add(plan);
	}

	public Plan buscarPlan(String nombre) {
		for (Plan p : planes) {
			if (p.getNombre().equals(nombre))
				return p;
		}
		return null;
	}

	public void actualizarPlan(Plan plan) {
		eliminarPlan(plan.getNombre());
		planes.add(plan);
	}

	public void eliminarPlan(String nombre) {
		Plan p = buscarPlan(nombre);
		if (p != null)
			planes.remove(p);
	}

	public void crearMembresia(Membresia membresia) {
		membresias.add(membresia);
	}

	public Membresia buscarMembresia(int idMembresia) {
		for (Membresia m : membresias) {
			if (m.getIdMembresia() == idMembresia)
				return m;
		}
		return null;
	}

	public void actualizarMembresia(Membresia membresia) {
		eliminarMembresia(membresia.getIdMembresia());
		membresias.add(membresia);
	}

	public void eliminarMembresia(int idMembresia) {
		Membresia m = buscarMembresia(idMembresia);
		if (m != null)
			membresias.remove(m);
	}
}
