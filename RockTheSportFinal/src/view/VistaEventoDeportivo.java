package view;

import model.*;
import util.EntradaDatos;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.EventoDeportivoDao;

public class VistaEventoDeportivo {

	private EventoDeportivoDao ge;

	public VistaEventoDeportivo(EventoDeportivoDao gestionEvento) {
		this.ge = gestionEvento;
	}

	public void menuEvento() throws SQLException, IOException {

		int opcion;
		boolean exit = false;

		do {

			mostrarMenu();

			opcion = EntradaDatos.leerEntero();

			switch (opcion) {
			case 1:
				insertarEventoIndividual();
				break;
			case 2:
				insertarEventoGrupal();
				break;
			case 3:
				mostrarEventos();
				break;
			case 4:
				mostrarEventosPorTipo();
				break;
			case 5:
				modificarEvento();
				break;
			case 6:
				eliminarEvento();
				break;
			case 7:
				contadorEventos();
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
		System.out.println("--- GESTION EVENTOS DEPORTIVOS ---");
		System.out.println("1 - Insertar evento individual");
		System.out.println("2 - Insertar evento grupal");
		System.out.println("3 - Mostrar eventos");
		System.out.println("4 - Buscar evento por tipo");
		System.out.println("5 - Modificar descripcion");
		System.out.println("6 - Eliminar evento");
		System.out.println("7 - Contador de eventos");
		System.out.println("0 - Salir");
		System.out.print("Elige una opción: ");

	}

	public void insertarEventoIndividual() throws SQLException, IOException {

		System.out.println("Tipo de evento:");
		String tipo = EntradaDatos.leerTexto();

		System.out.println("Descripcion:");
		String descripcion = EntradaDatos.leerTexto();

		System.out.println("Edad requerida:");
		int edadReq = EntradaDatos.leerEntero();

		System.out.println("Requisitos:");
		String requisitos = EntradaDatos.leerTexto();

		System.out.println("Nivel:");
		String nivel = EntradaDatos.leerTexto();

		System.out.println("Numero de participantes en el evento");
		int numParticipantes = EntradaDatos.leerEntero();

		EventoIndividual ei = new EventoIndividual(tipo, descripcion, edadReq, requisitos, nivel, numParticipantes);

		ge.insertarEventoIndividual(ei);

		System.out.println("Evento individual insertado correctamente");

	}

	public void insertarEventoGrupal() throws SQLException, IOException {

		System.out.println("Tipo de evento:");
		String tipoEvento = EntradaDatos.leerTexto();

		System.out.println("Descripcion:");
		String descripcion = EntradaDatos.leerTexto();

		System.out.println("Edad requerida:");
		int edadReq = EntradaDatos.leerEntero();

		System.out.println("Requisitos:");
		String requisitos = EntradaDatos.leerTexto();

		System.out.println("Nombre del equipo:");
		String nombreEquipo = EntradaDatos.leerTexto();

		System.out.println("Numero de participantes:");
		int numeroParticipantes = EntradaDatos.leerEntero();

		EventoGrupal eg = new EventoGrupal(tipoEvento, descripcion, edadReq, requisitos, nombreEquipo,
				numeroParticipantes);

		ge.insertarEventoGrupal(eg);

		System.out.println("Evento grupal insertado correctamente");

	}

	public void mostrarEventos() throws SQLException, IOException {

		ArrayList<EventoDeportivo> lista = ge.listar();

		for (EventoDeportivo e : lista) {
			System.out.println(e);
		}

	}

	public void mostrarEventosPorTipo() throws SQLException, IOException {

		String tipo = "";

		System.out.println("Ingresa el nombre del evento que quieres buscar");
		tipo = EntradaDatos.leerTexto();

		ArrayList<EventoDeportivo> lista = ge.buscarEventoPorTipo(tipo);

		for (EventoDeportivo e : lista) {
			System.out.println(e);
		}

	}

	public void modificarEvento() throws SQLException, IOException {

		System.out.println("ID del evento:");
		int id = EntradaDatos.leerEntero();

		System.out.println("Nueva descripcion:");
		String descr = EntradaDatos.leerTexto();

		ge.actualizar(id, descr);

		System.out.println("Evento actualizado correctamente");

	}

	public void eliminarEvento() throws SQLException, IOException {

		System.out.println("ID del evento a eliminar:");
		int id = EntradaDatos.leerEntero();

		if (ge.eliminar(id)) {
			System.out.println("Evento eliminado correctamente");
		} else {
			System.out.println("No se pudo eliminar el evento");
		}

	}

	public void contadorEventos() throws SQLException, IOException {

		System.out.println("Numero de eventos: " + ge.contadorEventos());

	}
}
