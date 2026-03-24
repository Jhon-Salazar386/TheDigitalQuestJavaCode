package view;

import java.util.ArrayList;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Date;

import model.*;
import util.*;

public class VistaUsuario {
	
	private GestionEventoDeportivo eventos;
	private GestionDeportistas deportistas;
	private GestionInscripcion inscripciones;
	private GestionCiudades ciudades;
	
	public VistaUsuario(GestionEventoDeportivo eventos, GestionDeportistas deportistas, GestionInscripcion inscripciones, GestionCiudades ciudades) {
		this.eventos = eventos;
		this.deportistas = deportistas;
		this.inscripciones = inscripciones;
		this.ciudades = ciudades;
	}

    public void menuUsuarios() {

        int opcion = 0;
        
        Deportista usuario = null;
        
        ArrayList<Inscripcion> misInscripciones = new ArrayList<>();

        while (opcion != 6) {

            mostrarMenu();
            opcion = EntradaDatos.leerEntero();

            switch (opcion) {
                case 1:
                    listarEventos();
                    break;
                case 2:
                    buscarEvento();
                    break;
                case 3:
                    verDetallesEvento();
                    break;
                case 4:
                	registrarse(usuario);
                	break;
                case 5:
                    inscribirseEnEvento(usuario, misInscripciones);
                    break;
                case 6:
                    verMisInscripciones(misInscripciones);
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("--- MENÚ DE USUARIO ---");
        System.out.println("1 - Listar eventos");
        System.out.println("2 - Buscar evento por tipo");
        System.out.println("3 - Ver detalles de un evento");
        System.out.println("4 - Registrarse como deportista");
        System.out.println("5 - Inscribirse en un evento");
        System.out.println("6 - Ver mis inscripciones");
        System.out.println("0 - Salir");
        System.out.print("Opcion: ");
    }

    public void listarEventos() {
        try {
            ArrayList<EventoDeportivo> lista = eventos.listar();

            if (lista.isEmpty()) {
                System.out.println("No hay eventos disponibles.");
                return;
            }

            for (EventoDeportivo e : lista) {
                System.out.println(e.getId() + " - " + e.getTipoEvento() + " / " + e.getModalidad());
            }

        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void buscarEvento() {
        try {
            System.out.print("Ingrese tipo de evento: ");
            String tipo = EntradaDatos.leerTexto();

            ArrayList<EventoDeportivo> lista = eventos.buscarEventoPorTipo(tipo);

            if (lista.isEmpty()) {
                System.out.println("No se encontraron eventos.");
                return;
            }

            for (EventoDeportivo e : lista) {
                System.out.println(e);
            }

        } catch (SQLException | IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void verDetallesEvento() {
        try {
            System.out.print("Ingrese ID del evento: ");
            int id = EntradaDatos.leerEntero();

            for (EventoDeportivo e : eventos.listar()) {
                if (e.getId() == id) {
                    System.out.println("Detalles:");
                    System.out.println(e);
                    return;
                }
            }

            System.out.println("Evento no encontrado.");

        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void registrarse(Deportista usuario) {
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

            usuario = new Deportista(dni, nombre, apellido, genero, fecha, ciudad, email, telefono);

            deportistas.insertar(usuario);

            System.out.println("Registrado correctamente");

        } catch (SQLException e) {
            System.out.println("Error SQL al insertar deportista: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        }
    }

    public void inscribirseEnEvento(Deportista usuario, ArrayList<Inscripcion> misInscripciones) {

        try {

            if (usuario == null) {
                System.out.print("Ingrese su DNI: ");
                String dni = EntradaDatos.leerTexto();

                ArrayList<Deportista> lista = deportistas.buscarPorDni(dni);

                if (lista.isEmpty()) {
                    System.out.println("Usuario no encontrado.");
                    return;
                }

                usuario = lista.get(0);
            }

            System.out.print("Ingrese ID del evento: ");
            int idEvento = EntradaDatos.leerEntero();

            boolean existe = false;

            for (EventoDeportivo e : eventos.listar()) {
                if (e.getId() == idEvento) {
                    System.out.println(e);
                    existe = true;
                    break;
                }
            }

            if (!existe) {
                System.out.println("Evento no encontrado.");
                return;
            }

            System.out.print("¿Confirmar inscripción? (s/n): ");
            String confirm = EntradaDatos.leerTexto();

            if (confirm.equalsIgnoreCase("s")) {

                Date fecha = new Date(System.currentTimeMillis());

                Inscripcion ins = new Inscripcion(fecha, usuario.getDni(), idEvento);
                
                inscripciones.insertar(ins);
                
                misInscripciones.add(ins);

                System.out.println("Inscripción realizada correctamente.");
            }

        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void verMisInscripciones(ArrayList<Inscripcion> misInscripciones) {

        if (misInscripciones.isEmpty()) {
            System.out.println("No tienes inscripciones.");
            return;
        }

        for (Inscripcion i : misInscripciones) {
            System.out.println(i);
        }
    }
    
    public void mostrarCiudadesDisponibles() {
    	try {
  
    		System.out.println(ciudades.mostrarCiudades());
    		
    	} catch (SQLException sq) {
    		System.out.println("Error al realizar la consulta: " + sq.getMessage());
    	} catch (IOException io) {
    		System.out.println("Error: " + io.getMessage());
    	}
    }
}