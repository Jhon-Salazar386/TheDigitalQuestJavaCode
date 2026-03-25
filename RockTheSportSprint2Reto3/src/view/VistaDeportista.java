package view;

import util.EntradaDatos;
import util.GestionDeportistas;
import model.Deportista;
import java.util.ArrayList;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class VistaDeportista {

	private GestionDeportistas gestionDeportistas;

	public VistaDeportista(GestionDeportistas gestionDeportistas) {
		this.gestionDeportistas = gestionDeportistas;
	}

	public void menuDeportistas() {

		int opcion;
		boolean exit = false;

		do {

			mostrarMenu();

			opcion = EntradaDatos.leerEntero();

			switch (opcion) {
			case 1:
				insertarDeportista();
				break;
			case 2:
				listarDeportistas();
				break;
			case 3:
				buscarDeportista();
				break;
			case 4:
				actualizarEmail();
				break;
			case 5:
				actualizarTelefono();
				break;
			case 6:
				eliminarDeportista();
				break;
			case 7:
				contarDeportistas();
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
		System.out.println("--- MENU DEPORTISTAS ---");
		System.out.println("1 - Insertar deportista");
		System.out.println("2 - Listar deportistas");
		System.out.println("3 - Buscar deportista por dni");
		System.out.println("4 - Actualizar email");
		System.out.println("5 - Actualizar teléfono");
		System.out.println("6 - Eliminar deportista");
		System.out.println("7 - Contar deportistas");
		System.out.println("0 - Salir");
		System.out.print("Elige una opcion: ");
	}

	public void insertarDeportista() {
		try {

			System.out.print("DNI: ");
			String dni = EntradaDatos.leerTexto();

			System.out.print("Nombre: ");
			String nombre = EntradaDatos.leerTexto();

			System.out.print("Apellido: ");
			String apellido = EntradaDatos.leerTexto();

			System.out.print("Género: ");
			String genero = EntradaDatos.leerTexto();

			System.out.print("Fecha nacimiento (YYYY-MM-DD): ");
			Date fecha = Date.valueOf(EntradaDatos.leerTexto());

			System.out.print("Ciudad nacimiento: ");
			String ciudad = EntradaDatos.leerTexto();

			System.out.print("Email: ");
			String email = EntradaDatos.leerTexto();

			System.out.print("Teléfono: ");
			String telefono = EntradaDatos.leerTexto();

			Deportista d = new Deportista(dni, nombre, apellido, genero, fecha, ciudad, email, telefono);

			gestionDeportistas.insertar(d);

			System.out.println("Deportista insertado correctamente");

		} catch (SQLException e) {
			System.out.println("Error SQL al insertar deportista: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error de entrada/salida: " + e.getMessage());
		}
	}

	public void listarDeportistas() {
		try {

			ArrayList<Deportista> lista = gestionDeportistas.listar();

			for (Deportista dep : lista) {
				System.out.println(dep);
			}

		} catch (SQLException e) {
			System.out.println("Error SQL al listar deportistas: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error de entrada/salida: " + e.getMessage());
		}
	}

	public void buscarDeportista() {

		String dni;

		try {

			System.out.println("Ingresa el dni del deportista que quieres buscar");
			dni = EntradaDatos.leerTexto();

			ArrayList<Deportista> lista = gestionDeportistas.buscarPorDni(dni);

			for (Deportista dep : lista) {
				System.out.println(dep);
			}

		} catch (SQLException e) {
			System.out.println("Error SQL al buscar deportista: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void actualizarEmail() {
		try {

			System.out.print("DNI: ");
			String dni = EntradaDatos.leerTexto();

			System.out.print("Nuevo email: ");
			String email = EntradaDatos.leerTexto();

			gestionDeportistas.actualizarEmail(dni, email);

			System.out.println("Email actualizado");

		} catch (SQLException e) {
			System.out.println("Error SQL al actualizar email: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error de entrada/salida: " + e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println("Error de validación: " + e.getMessage());
		}
	}

	public void actualizarTelefono() {
		try {

			System.out.print("DNI: ");
			String dni = EntradaDatos.leerTexto();

			System.out.print("Nuevo teléfono: ");
			String telefono = EntradaDatos.leerTexto();

			gestionDeportistas.actualizarTelefono(dni, telefono);

			System.out.println("Teléfono actualizado");

		} catch (SQLException e) {
			System.out.println("Error SQL al actualizar teléfono: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error de entrada/salida: " + e.getMessage());
		}
	}

	public void eliminarDeportista() {
		try {

			System.out.print("DNI: ");
			String dni = EntradaDatos.leerTexto();

			if (gestionDeportistas.eliminar(dni)) {
				System.out.println("Eliminado correctamente");
			} else {
				System.out.println("No se encontró el deportista");
			}

		} catch (SQLException e) {
			System.out.println("Error SQL al eliminar deportista: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error de entrada/salida: " + e.getMessage());
		}
	}

	public void contarDeportistas() {
		try {

			int total = gestionDeportistas.contadorDeportistas();

			System.out.println("Número de deportistas: " + total);

		} catch (SQLException e) {
			System.out.println("Error SQL al contar deportistas: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error de entrada/salida: " + e.getMessage());
		}
	}
}