package view;

import java.io.IOException;
import log.FicheroLog;
import util.*;

public class VistaOrganizador {

	private VistaCiudad vc = new VistaCiudad(new GestionCiudades());
	private VistaDeportista vd = new VistaDeportista(new GestionDeportistas());
	private VistaInscripcion vi = new VistaInscripcion(new GestionInscripcion());
	private VistaEventoDeportivo vde = new VistaEventoDeportivo(new GestionEventoDeportivo());

	public void menuOrganizador() throws IOException {

		boolean exit = false;
		int opcion = -1;

		do {
			
			mostrarMenu();

			opcion = EntradaDatos.leerEntero();

			switch (opcion) {
			case 1:
				vd.menuDeportistas();
				break;
			case 2:
				vde.menuEvento();
				break;
			case 3:
				vi.menuInscripcion();
				break;
			case 4:
				vc.menuCiudad();
				break;
			case 5:
				mostrarRegistro();
				break;
			case 0:
				exit = true;
				System.out.println("Saliendo");
				break;
			default:
				System.out.println("Opcion no valida");
			}

		} while (!exit);
	}
	
	private void mostrarMenu() {
		System.out.println("--- MENU DE ORGANIZADOR ---");
		System.out.println("1 - Deportistas");
		System.out.println("2 - Eventos deportivos");
		System.out.println("3 - Inscripciones");
		System.out.println("4 - Ciudad");
		System.out.println("5 - Leer registros");
		System.out.println("0 - Salir");
		System.out.println("Elige una opcion: ");
	}

	private static void mostrarRegistro() throws IOException {

		String contenido = FicheroLog.leerLog();

		if (contenido == null || contenido == "") {
			System.out.println("No hay registros en el log");
		}

		System.out.println(contenido);

	}

}
