package view;
import util.EntradaDatos;
import util.GestionInscripcion;
import model.Inscripcion;
import java.util.ArrayList;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class VistaInscripcion {

    private GestionInscripcion gi;

    public VistaInscripcion(GestionInscripcion gestionInscripcion) {
        this.gi = gestionInscripcion;
    }

    public void menuInscripcion() {

        int opcion;
        boolean exit = false;

        do {
            System.out.println("--- GESTIÓN INSCRIPCIONES ---");
            System.out.println("1 - Insertar inscripción");
            System.out.println("2 - Mostrar inscripciones");
            System.out.println("3 - Eliminar inscripción");
            System.out.println("4 - Contador de inscripciones");
            System.out.println("0 - Salir");
            System.out.print("Elige una opción: ");

            opcion = EntradaDatos.leerEntero();

            switch (opcion) {
                case 1:
                    insertarInscripcion();
                    break;
                case 2:
                    mostrarInscripciones();
                    break;
                case 3:
                    eliminarInscripcion();
                    break;
                case 4:
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

    public void insertarInscripcion() {
        try {

            System.out.print("Fecha inscripción (YYYY-MM-DD): ");
            Date fecha = Date.valueOf(EntradaDatos.leerTexto());

            System.out.print("DNI del deportista: ");
            String dni = EntradaDatos.leerTexto();

            System.out.print("ID de la edición: ");
            int idEdicion = EntradaDatos.leerEntero();
            
            Inscripcion ins = new Inscripcion(fecha, dni, idEdicion);

            gi.insertar(ins);

            System.out.println("Inscripcion insertada correctamente");

        } catch (SQLException e) {
            System.out.println("Error SQL al insertar inscripción: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Formato de fecha inválido");
        }
    }

    public void mostrarInscripciones() {
        try {

            ArrayList<Inscripcion> lista = gi.mostrarTodasLasInscripciones();

            for (Inscripcion ins : lista) {
                System.out.println(ins);
            }

        } catch (SQLException e) {
            System.out.println("Error SQL al mostrar inscripciones: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void eliminarInscripcion() {
        try {

            System.out.print("ID de la inscripción a eliminar: ");
            int id = EntradaDatos.leerEntero();

            if (gi.eliminar(id)) {
                System.out.println("Inscripción eliminada correctamente");
            } else {
                System.out.println("No se encontró la inscripción");
            }

        } catch (SQLException e) {
            System.out.println("Error SQL al eliminar inscripción: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void contadorInscripciones() {
        try {

        	System.out.println("Inscripciones ingresadas: " + gi.contadorInscripciones());

        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}