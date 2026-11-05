package interfaz.utilidades;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import excepciones.DatosInvalidosException;

//Limpia y valida lo que se escribe en los formularios antes de pasarlo al modelo
public final class Normalizador {

	public static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public static final DateTimeFormatter FORMATO_HORA = DateTimeFormatter.ofPattern("HH:mm");

	private Normalizador() {
	}

	private static String texto(String valor, String campo) throws DatosInvalidosException {
		if (valor == null || valor.isBlank()) {
			throw new DatosInvalidosException("El campo " + campo + " es obligatorio");
		}
		return valor.trim();
	}

	//"  juan   perez " -> "JUAN PEREZ"
	public static String normalizarNombre(String nombre) throws DatosInvalidosException {
		String limpio = texto(nombre, "nombre").replaceAll("\\s+", " ").toUpperCase();
		if (!limpio.matches("[\\p{L} '.-]+")) {
			throw new DatosInvalidosException("El nombre solo puede tener letras y espacios");
		}
		if (limpio.length() < 3) {
			throw new DatosInvalidosException("El nombre es demasiado corto");
		}
		return limpio;
	}

	//"40.123.456" -> 40123456
	public static int normalizarDni(String dni) throws DatosInvalidosException {
		String limpio = texto(dni, "DNI").replaceAll("[.\\s-]", "");
		if (!limpio.matches("\\d{7,8}")) {
			throw new DatosInvalidosException("El DNI debe tener 7 u 8 números");
		}
		return Integer.parseInt(limpio);
	}

	//"11 2345-6789" -> "1123456789"
	public static String normalizarTelefono(String telefono) throws DatosInvalidosException {
		String limpio = texto(telefono, "teléfono").replaceAll("[\\s()-]", "");
		if (!limpio.matches("\\+?\\d{8,15}")) {
			throw new DatosInvalidosException("El teléfono debe tener entre 8 y 15 números");
		}
		return limpio;
	}

	//" Juan.Perez@Mail.com " -> "juan.perez@mail.com"
	public static String normalizarMail(String mail) throws DatosInvalidosException {
		String limpio = texto(mail, "correo").toLowerCase();
		if (!limpio.matches("[\\w.+-]+@[\\w-]+(\\.[\\w-]+)+")) {
			throw new DatosInvalidosException("El correo no tiene un formato válido (ej: nombre@mail.com)");
		}
		return limpio;
	}

	public static LocalDate normalizarFecha(String fecha, String campo) throws DatosInvalidosException {
		try {
			return LocalDate.parse(texto(fecha, campo), FORMATO_FECHA);
		} catch (DateTimeParseException e) {
			throw new DatosInvalidosException("La " + campo + " debe tener el formato dd/mm/aaaa");
		}
	}

	public static LocalDate normalizarFechaNacimiento(String fecha) throws DatosInvalidosException {
		LocalDate nacimiento = normalizarFecha(fecha, "fecha de nacimiento");
		if (nacimiento.isAfter(LocalDate.now().minusYears(12))) {
			throw new DatosInvalidosException("La persona debe tener al menos 12 años");
		}
		if (nacimiento.isBefore(LocalDate.now().minusYears(110))) {
			throw new DatosInvalidosException("La fecha de nacimiento no es válida");
		}
		return nacimiento;
	}

	public static LocalTime normalizarHora(String hora) throws DatosInvalidosException {
		try {
			return LocalTime.parse(texto(hora, "hora"), FORMATO_HORA);
		} catch (DateTimeParseException e) {
			throw new DatosInvalidosException("La hora debe tener el formato hh:mm");
		}
	}

	public static int normalizarEnteroPositivo(String numero, String campo) throws DatosInvalidosException {
		try {
			int valor = Integer.parseInt(texto(numero, campo));
			if (valor <= 0) {
				throw new DatosInvalidosException("El campo " + campo + " debe ser mayor a 0");
			}
			return valor;
		} catch (NumberFormatException e) {
			throw new DatosInvalidosException("El campo " + campo + " debe ser un número entero");
		}
	}

	//Acepta "350000", "350.000" o "350000,50"
	public static double normalizarMonto(String monto, String campo) throws DatosInvalidosException {
		String limpio = texto(monto, campo).replace("$", "").replace(" ", "");
		if (limpio.contains(",")) {
			limpio = limpio.replace(".", "").replace(",", ".");
		} else if (limpio.matches("\\d{1,3}(\\.\\d{3})+")) {
			limpio = limpio.replace(".", "");
		}
		try {
			double valor = Double.parseDouble(limpio);
			if (valor <= 0) {
				throw new DatosInvalidosException("El campo " + campo + " debe ser mayor a 0");
			}
			return valor;
		} catch (NumberFormatException e) {
			throw new DatosInvalidosException("El campo " + campo + " debe ser un número");
		}
	}
}
