package view;

import model.Deportista;
import java.util.ArrayList;

import controller.EntradaDatos;
import dao.GestionDeportistas;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class VistaDeportista {

	private GestionDeportistas gestionDeportistas;

	public VistaDeportista(GestionDeportistas gestionDeportistas) {
		this.gestionDeportistas = gestionDeportistas;
	}

	public void menuDeportistas() throws SQLException, IOException {

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
				mejorTiempoDeportista();
				break;
			case 8:
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
		System.out.println("7 - Mostrar mejor tiempo de deportista");
		System.out.println("8 - Contar deportistas");
		System.out.println("0 - Salir");
		System.out.print("Elige una opcion: ");
	}

	public void insertarDeportista() throws SQLException, IOException {

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

	}

	public void listarDeportistas() throws SQLException, IOException {

		ArrayList<Deportista> lista = gestionDeportistas.listar();

		for (Deportista dep : lista) {
			System.out.println(dep);
		}

	}

	public void buscarDeportista() throws SQLException, IOException {

		String dni;

		System.out.println("Ingresa el dni del deportista que quieres buscar");
		dni = EntradaDatos.leerTexto();

		ArrayList<Deportista> lista = gestionDeportistas.buscarPorDni(dni);

		for (Deportista dep : lista) {
			System.out.println(dep);
		}

	}

	public void actualizarEmail() throws SQLException, IOException {

		System.out.print("DNI: ");
		String dni = EntradaDatos.leerTexto();

		System.out.print("Nuevo email: ");
		String email = EntradaDatos.leerTexto();

		gestionDeportistas.actualizarEmail(dni, email);

		System.out.println("Email actualizado");

	}

	public void actualizarTelefono() throws SQLException, IOException {

		System.out.print("DNI: ");
		String dni = EntradaDatos.leerTexto();

		System.out.print("Nuevo teléfono: ");
		String telefono = EntradaDatos.leerTexto();

		gestionDeportistas.actualizarTelefono(dni, telefono);

		System.out.println("Teléfono actualizado");

	}

	public void eliminarDeportista() throws SQLException, IOException {

		System.out.print("DNI: ");
		String dni = EntradaDatos.leerTexto();

		String mensaje = gestionDeportistas.eliminar(dni);

		System.out.println(mensaje);

	}

	public void contarDeportistas() throws SQLException, IOException {

		int total = gestionDeportistas.contadorDeportistas();

		System.out.println("Número de deportistas: " + total);

	}

	public void mejorTiempoDeportista() throws SQLException, IOException {

		String dni = "";

		System.out.println("Ingresa el dni del deportista a buscar");
		dni = EntradaDatos.leerTexto();

		System.out.println(gestionDeportistas.mejorTiempoDeportista(dni));

	}

}