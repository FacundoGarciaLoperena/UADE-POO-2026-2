package interfaz;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import excepciones.ClaseException;
import excepciones.ClienteException;
import excepciones.EmpleadoException;
import modelo.*;
import modelo.Cliente.EstadoCliente;
import modelo.Persona.Genero;
import persistencia.*;
import persistencia.implementaciones.*;

public class Main {

	public static void main(String[] args) {
		try {
			Repository<Integer, Cliente> repoClientes = new ClienteRepositoryJson();

			Gimnasio miGimnasio = new Gimnasio("Power Gym", "Facundo", "Av. Corrientes 1234", "1122334455", 100,
					repoClientes);

			cargarDatosDePrueba(miGimnasio);

			new VentanaPrincipal(miGimnasio);

		} catch (IOException e) {
			System.err.println("Error al iniciar los datos del gimnasio: " + e.getMessage());
			e.printStackTrace();
		} catch (ClienteException | EmpleadoException | ClaseException e) {
			System.err.println("Error al cargar los datos de prueba: " + e.getMessage());
		}

	}

	//Clientes de prueba solo si el json está vacío. Profesores y clases todavía no se persisten
	private static void cargarDatosDePrueba(Gimnasio gimnasio)
			throws IOException, ClienteException, EmpleadoException, ClaseException {
		GestionClientes gc = gimnasio.getGestionClientes();
		if (gc.getClientes().isEmpty()) {
			gc.agregarCliente(new Cliente("NICOLAS RODRIGUEZ", LocalDate.of(1998, 3, 14), Genero.MASCULINO, 40123456,
					"1134567890", "nicolas.rodriguez@mail.com", LocalDate.of(2025, 2, 1), EstadoCliente.ACTIVO));
			gc.agregarCliente(new Cliente("SOFIA GOMEZ", LocalDate.of(2001, 7, 22), Genero.FEMENINO, 43234567,
					"1145678901", "sofia.gomez@mail.com", LocalDate.of(2025, 5, 10), EstadoCliente.ACTIVO));
			gc.agregarCliente(new Cliente("MARTIN FERNANDEZ", LocalDate.of(1990, 11, 5), Genero.MASCULINO, 35345678,
					"1156789012", "martin.fernandez@mail.com", LocalDate.of(2024, 9, 3), EstadoCliente.SUSPENDIDO));
			gc.agregarCliente(new Cliente("LUCIA MARTINEZ", LocalDate.of(1995, 1, 30), Genero.FEMENINO, 38456789,
					"1167890123", "lucia.martinez@mail.com", LocalDate.of(2025, 1, 15), EstadoCliente.ACTIVO));
			gc.agregarCliente(new Cliente("JUAN PEREZ", LocalDate.of(1987, 6, 18), Genero.MASCULINO, 32567890,
					"1178901234", "juan.perez@mail.com", LocalDate.of(2023, 3, 20), EstadoCliente.INACTIVO));
			gc.agregarCliente(new Cliente("VALENTINA LOPEZ", LocalDate.of(2003, 9, 9), Genero.FEMENINO, 44678901,
					"1189012345", "valentina.lopez@mail.com", LocalDate.of(2025, 8, 1), EstadoCliente.SUSPENDIDO));
			gc.agregarCliente(new Cliente("TOMAS DIAZ", LocalDate.of(1999, 12, 2), Genero.MASCULINO, 41789012,
					"1190123456", "tomas.diaz@mail.com", LocalDate.of(2025, 10, 5), EstadoCliente.ACTIVO));
		}

		GestionEmpleados ge = gimnasio.getGestionEmpleados();
		Profesor laura = new Profesor("LAURA SANCHEZ", LocalDate.of(1992, 4, 12), Genero.FEMENINO, 1, 850000,
				LocalDate.of(2023, 2, 1));
		laura.getCertificaciones().add("YOGA");
		laura.getCertificaciones().add("PILATES");
		Profesor diego = new Profesor("DIEGO ALVAREZ", LocalDate.of(1988, 8, 25), Genero.MASCULINO, 2, 900000,
				LocalDate.of(2022, 6, 15));
		diego.getCertificaciones().add("CROSSFIT");
		Profesor carla = new Profesor("CARLA ROMERO", LocalDate.of(1996, 2, 3), Genero.FEMENINO, 3, 780000,
				LocalDate.of(2024, 3, 10));
		carla.getCertificaciones().add("SPINNING");
		ge.crearEmpleado(laura);
		ge.crearEmpleado(diego);
		ge.crearEmpleado(carla);

		GestionActividadesClases gac = gimnasio.getGestionActividadesClases();
		Actividad yoga = new Actividad("YOGA", "Clase de yoga para todos los niveles", 60);
		Actividad crossfit = new Actividad("CROSSFIT", "Entrenamiento funcional de alta intensidad", 50);
		Actividad spinning = new Actividad("SPINNING", "Ciclismo indoor", 45);
		gac.crearActividad(yoga);
		gac.crearActividad(crossfit);
		gac.crearActividad(spinning);

		LocalDate hoy = LocalDate.now();
		gac.crearClase(crearClase(1, hoy, LocalTime.of(9, 0), laura, yoga, 15));
		gac.crearClase(crearClase(2, hoy, LocalTime.of(19, 0), diego, crossfit, 20));
		gac.crearClase(crearClase(3, hoy.plusDays(1), LocalTime.of(18, 0), carla, spinning, 25));
		gac.crearClase(crearClase(4, hoy.plusDays(2), LocalTime.of(10, 0), laura, yoga, 15));
	}

	private static Clase crearClase(int id, LocalDate dia, LocalTime hora, Profesor profesor, Actividad actividad,
			int cupo) {
		LocalDateTime inicio = LocalDateTime.of(dia, hora);
		return new Clase(id, inicio, inicio.plusMinutes(actividad.getDuracionMins()), profesor, actividad, cupo);
	}
}
