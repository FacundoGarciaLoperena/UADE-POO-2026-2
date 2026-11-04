package interfaz;

import java.io.*;

import modelo.*;
import persistencia.*;
import persistencia.implementaciones.*;

public class Main {

	public static void main(String[] args) {
		try {
			Repository<Integer, Cliente> repoClientes = new ClienteRepositoryJson();

			Gimnasio miGimnasio = new Gimnasio("Power Gym", "Facundo", "Av. Corrientes 1234", "1122334455", 100,
					repoClientes);

			new VentanaPrincipal(miGimnasio);

		} catch (IOException e) {
			System.err.println("Error al iniciar los datos del gimnasio: " + e.getMessage());
			e.printStackTrace();
		}

	}
}