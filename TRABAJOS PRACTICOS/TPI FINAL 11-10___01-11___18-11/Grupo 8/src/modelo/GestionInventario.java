package modelo;

import java.util.HashSet;
import java.util.Set;

public class GestionInventario {
	private Set<Maquina> maquinas;
	private Set<Mantenimiento> mantenimientos;

	public GestionInventario() {
		this.maquinas = new HashSet<>();
		this.mantenimientos = new HashSet<>();
	}

	public void crearMaquina(Maquina maquina) {
		maquinas.add(maquina);
	}

	public Maquina buscarMaquina(int idMaquina) {
		for (Maquina m : maquinas) {
			if (m.getIdMaquina() == idMaquina)
				return m;
		}
		return null;
	}

	public void actualizarMaquina(Maquina maquina) {
		eliminarMaquina(maquina.getIdMaquina());
		maquinas.add(maquina);
	}

	public void eliminarMaquina(int idMaquina) {
		Maquina m = buscarMaquina(idMaquina);
		if (m != null)
			maquinas.remove(m);
	}

	public void crearMantenimiento(Mantenimiento mantenimiento) {
		mantenimientos.add(mantenimiento);
	}

	public Mantenimiento buscarMantenimiento(int idMantenimiento) {
		for (Mantenimiento m : mantenimientos) {
			if (m.getIdMantenimiento() == idMantenimiento)
				return m;
		}
		return null;
	}

	public void actualizarMantenimiento(Mantenimiento mantenimiento) {
		eliminarMantenimiento(mantenimiento.getIdMantenimiento());
		mantenimientos.add(mantenimiento);
	}

	public void eliminarMantenimiento(int idMantenimiento) {
		Mantenimiento m = buscarMantenimiento(idMantenimiento);
		if (m != null)
			mantenimientos.remove(m);
	}

	public Set<Maquina> getMaquinas() {
		return maquinas;
	}

	public Set<Mantenimiento> getMantenimientos() {
		return mantenimientos;
	}
}
