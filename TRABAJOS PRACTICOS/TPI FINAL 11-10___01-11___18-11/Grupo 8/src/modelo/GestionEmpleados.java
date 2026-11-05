package modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import excepciones.EmpleadoDuplicadoException;
import excepciones.EmpleadoNoEncontradoException;
import lombok.Getter;

@Getter
public class GestionEmpleados {
	private Set<Empleado> empleados;
	private Set<TurnoLaboral> turnos;

	public GestionEmpleados() {
		this.empleados = new HashSet<>();
		this.turnos = new HashSet<>();
	}

	public void crearEmpleado(Empleado empleado) throws EmpleadoDuplicadoException {
		for (Empleado e : empleados) {
			if (e.getNmroEmpleado() == empleado.getNmroEmpleado())
				throw new EmpleadoDuplicadoException("Ya existe un empleado con número: " + empleado.getNmroEmpleado());
		}
		empleados.add(empleado);
	}

	public Empleado buscarEmpleado(int nmroEmpleado) throws EmpleadoNoEncontradoException {
		for (Empleado e : empleados) {
			if (e.getNmroEmpleado() == nmroEmpleado)
				return e;
		}
		throw new EmpleadoNoEncontradoException("No se ha encontrado al empleado con número: " + nmroEmpleado);
	}

	public void actualizarEmpleado(Empleado empleado) throws EmpleadoNoEncontradoException {
		eliminarEmpleado(empleado.getNmroEmpleado());
		empleados.add(empleado);
	}

	public void eliminarEmpleado(int nmroEmpleado) throws EmpleadoNoEncontradoException {
		Empleado e = buscarEmpleado(nmroEmpleado);
		empleados.remove(e);
	}
	
	public List<Profesor> listarProfesores() {
		List<Profesor> lista = new ArrayList<Profesor>();
		for (Empleado e : empleados) {
			if (e instanceof Profesor p)
				lista.add(p);
		}
		lista.sort(Comparator.comparingInt(Profesor::getNmroEmpleado));
		return lista;
	}
	
	public int siguienteNmroEmpleado() {
		int max = 0;
		for (Empleado e : empleados) {
			if (e.getNmroEmpleado() > max)
				max = e.getNmroEmpleado();
		}
		return max + 1;
	}

	public void crearTurnoLaboral(TurnoLaboral turno) {
		turnos.add(turno);
	}

	public TurnoLaboral buscarTurnoLaboral(int idTurno) {
		for (TurnoLaboral t : turnos) {
			if (t.getIdTurno() == idTurno)
				return t;
		}
		return null;
	}

	public void actualizarTurnoLaboral(TurnoLaboral turno) {
		eliminarTurnoLaboral(turno.getIdTurno());
		turnos.add(turno);
	}

	public void eliminarTurnoLaboral(int idTurno) {
		TurnoLaboral t = buscarTurnoLaboral(idTurno);
		if (t != null)
			turnos.remove(t);
	}
}
