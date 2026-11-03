package modelo;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;

@Getter
public class GestionEmpleados {
	private Set<Empleado> empleados;
	private Set<TurnoLaboral> turnos;

	public GestionEmpleados() {
		this.empleados = new HashSet<>();
		this.turnos = new HashSet<>();
	}

	public void crearEmpleado(Empleado empleado) {
		empleados.add(empleado);
	}

	public Empleado buscarEmpleado(int nmroEmpleado) {
		for (Empleado e : empleados) {
			if (e.getNmroEmpleado() == nmroEmpleado)
				return e;
		}
		return null;
	}

	public void actualizarEmpleado(Empleado empleado) {
		eliminarEmpleado(empleado.getNmroEmpleado());
		empleados.add(empleado);
	}

	public void eliminarEmpleado(int nmroEmpleado) {
		Empleado e = buscarEmpleado(nmroEmpleado);
		if (e != null)
			empleados.remove(e);
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
