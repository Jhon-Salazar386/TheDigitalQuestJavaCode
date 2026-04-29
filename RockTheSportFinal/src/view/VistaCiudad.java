package view;

import model.Ciudad;
import util.EntradaDatos;

import java.io.*;
import java.sql.*;

import dao.CiudadDao;

public class VistaCiudad {

	private CiudadDao gc;

	public VistaCiudad(CiudadDao gestionCiudades) {
		this.gc = gestionCiudades;
	}

	public void menuCiudad() throws SQLException, IOException {

		int opcion;
		boolean exit = false;

		do {

			mostrarMenu();

			opcion = EntradaDatos.leerEntero();

			switch (opcion) {
			case 1:
				insertarCiudad();
				break;
			case 2:
				mostrarCiudades();
				break;
			case 3:
				buscarCiudad();
				break;
			case 4:
				consultarEdicionesPorCiudad();
				break;
			case 5:
				modificarCiudad();
				break;
			case 6:
				eliminarCiudad();
				break;
			case 7:
				contadorCiudades();
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

	private void mostrarMenu() throws SQLException, IOException {
		System.out.println("--- GESTION CIUDADES ---");
		System.out.println("1 - Insertar ciudad");
		System.out.println("2 - Mostrar ciudades");
		System.out.println("3 - Buscar ciudad por codigo");
		System.out.println("4 - Consultar ediciones en una ciudad");
		System.out.println("5 - Modificar ciudad");
		System.out.println("6 - Eliminar ciudad");
		System.out.println("7 - Contador de ciudades");
		System.out.println("0 - Salir");
		System.out.print("Elige una opción: ");
	}

	public void insertarCiudad() throws SQLException, IOException {

		System.out.println("Ingresa un codigo identificador para esta ciudad");
		String codigo = EntradaDatos.leerTexto();
		System.out.println("Ingresa el codigo");
		String nombre = EntradaDatos.leerTexto();
		System.out.println("Ingresa ubicacion");
		String ubicacion = EntradaDatos.leerTexto();

		Ciudad c = new Ciudad(codigo, nombre, ubicacion);

		gc.agregarCiudad(c);

	}

	public void mostrarCiudades() throws SQLException, IOException {

		System.out.println(gc.mostrarCiudades());

	}

	public void buscarCiudad() throws SQLException, IOException {

		System.out.println("Ingresa el codigo de la ciudad que quieres buscar");
		String codigo = EntradaDatos.leerTexto();

		System.out.println(gc.mostrarCiudadesPorCodigo(codigo));

	}

	public void modificarCiudad() throws SQLException, IOException {

		System.out.println("Ingresa el codigo de la ciudad");
		String codigo = EntradaDatos.leerTexto();
		System.out.println("Ingresa el nombre");
		String nombre = EntradaDatos.leerTexto();
		System.out.println("Ingresa la nueva ubicacion");
		String nuevaUbicacion = EntradaDatos.leerTexto();

		gc.actualizarCiudad(codigo, nombre, nuevaUbicacion);

		System.out.println("La ciudad se actualizo correctamente");
	}

	public void eliminarCiudad() throws SQLException, IOException {

		System.out.println("Ingresa el codigo de la ciudad a eliminar");
		String codigo = EntradaDatos.leerTexto();

		System.out.println("Ingresa el nombre de la ciudad");
		String nombre = EntradaDatos.leerTexto();

		if (gc.eliminarCiudad(codigo, nombre)) {
			System.out.println("La ciudad " + nombre + " se elimino correctamente");
		} else {
			System.out.println("Algo ha salido mal");
		}
	}

	public void consultarEdicionesPorCiudad() throws SQLException, IOException {

		System.out.println("Ingresa el codigo de la ciudad");
		String codigoC = EntradaDatos.leerTexto();

		System.out.println(gc.mostrarEdicionesPorCiudad(codigoC));

	}

	public void contadorCiudades() throws SQLException, IOException {

		System.out.println("Ciudades ingresadas en la base de datos: " + gc.contadorCiudades());

	}

}