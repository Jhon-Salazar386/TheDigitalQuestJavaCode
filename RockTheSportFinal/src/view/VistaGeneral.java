package view;

import java.io.IOException;
import java.sql.SQLException;

import controller.*;
import dao.GestionCiudades;
import dao.GestionDeportistas;
import dao.GestionEventoDeportivo;
import dao.GestionInscripcion;

public class VistaGeneral {

	private VistaOrganizador vistaOrganizador = new VistaOrganizador();
	private VistaUsuario VistaUsuario = new VistaUsuario(new GestionEventoDeportivo(), new GestionDeportistas(),
			new GestionInscripcion(), new GestionCiudades());

	public void menuGeneral() throws SQLException, IOException {

		boolean exit = false;
		int opcion = -1;

		do {

			mostrarMenu();

			opcion = EntradaDatos.leerEntero();

			switch (opcion) {
			case 1:
				VistaUsuario.menuUsuarios();
				break;
			case 2:
				vistaOrganizador.menuOrganizador();
				break;
			case 0:
				exit = true;
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opcion no valida");
			}

		} while (!exit);
	}

	private void mostrarMenu() {
		System.out.println("--- MENU GENERAL ---");
		System.out.println("1 - Usuario");
		System.out.println("2 - Organizador");
		System.out.println("0 - Salir");
		System.out.println("Elige una opcion: ");
	}
}
