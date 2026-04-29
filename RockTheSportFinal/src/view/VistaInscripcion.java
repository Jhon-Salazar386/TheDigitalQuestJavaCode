package view;

import model.Inscripcion;
import util.EntradaDatos;

import java.util.ArrayList;

import dao.InscripcionDao;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class VistaInscripcion {

	private InscripcionDao gi;

	public VistaInscripcion(InscripcionDao gestionInscripcion) {
		this.gi = gestionInscripcion;
	}

	public void menuInscripcion() throws SQLException, IOException {

		int opcion;
		boolean exit = false;

		do {

			mostrarMenu();

			opcion = EntradaDatos.leerEntero();

			switch (opcion) {
			case 1:
				insertarInscripcion();
				break;
			case 2:
				mostrarInscripciones();
				break;
			case 3:
				mostrarEstadoInscripciones();
				break;
			case 4:
				eliminarInscripcion();
				break;
			case 5:
				contadorInscripciones();
				break;
			case 0:
				exit = true;
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción no válida");
			}

		} while (!exit);
	}

	private void mostrarMenu() {
		System.out.println("--- GESTIÓN INSCRIPCIONES ---");
		System.out.println("1 - Insertar inscripción");
		System.out.println("2 - Mostrar inscripciones");
		System.out.println("3 - Mostrar estado de inscripciones");
		System.out.println("4 - Eliminar inscripción");
		System.out.println("5 - Contador de inscripciones");
		System.out.println("0 - Salir");
		System.out.print("Elige una opción: ");
	}

	public void insertarInscripcion() throws SQLException, IOException {

		System.out.print("DNI del deportista: ");
		String dni = EntradaDatos.leerTexto();

		System.out.print("ID de la edición: ");
		int idEdicion = EntradaDatos.leerEntero();

		Inscripcion ins = new Inscripcion(new Date(System.currentTimeMillis()), dni, idEdicion);

		String mensaje = gi.insertar(ins);

		System.out.println(mensaje);

	}

	public void mostrarInscripciones() throws SQLException, IOException {

		ArrayList<Inscripcion> lista = gi.mostrarTodasLasInscripciones();

		for (Inscripcion ins : lista) {
			System.out.println(ins);
		}

	}

	public void mostrarEstadoInscripciones() throws SQLException, IOException {

		System.out.println(gi.mostrarEstadoInscripciones());

	}

	public void eliminarInscripcion() throws SQLException, IOException {

		System.out.print("ID de la inscripción a eliminar: ");
		int id = EntradaDatos.leerEntero();

		if (gi.eliminar(id)) {
			System.out.println("Inscripción eliminada correctamente");
		} else {
			System.out.println("No se encontró la inscripción");
		}

	}

	public void contadorInscripciones() throws SQLException, IOException {

		System.out.println("Inscripciones ingresadas: " + gi.contadorTotalInscripciones());

	}
}