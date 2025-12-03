package users;
import java.util.Scanner;


public class Gestion {
	static Scanner org = new Scanner(System.in);
    public static void main(String[]args) {
    	
        int option = 0;

        // El menú se repite hasta que el usuario elija la opción 5 (salir)
        while (option != 5) {
            System.out.println("--- MENÚ DE GESTIÓN ---");
            System.out.println("1 - Gestión de eventos");
            System.out.println("2 - Gestión de participantes");
            System.out.println("3 - Gestión de inscripciones");
            System.out.println("4 - Gestión de ciudades");
            System.out.println("5 - Cerrar sesión");
            System.out.print("Opción: ");

            option = org.nextInt();
            org.nextLine(); // Limpieza del buffer

            // Según la opción elegida, se llama a la clase correspondiente
            switch (option) {
                case 1:
                    // Abre el submenú de gestión de eventos
                	GestionEventos.eventos(args);
                    break;
                case 2:
                    // Abre el submenú de gestión de participantes
                	GestionDeportistas.deportistas(args);
                    break;
                case 3:
                    // Abre el submenú de gestión de inscripciones
                	GestionInscripciones.inscripciones(args);        	
                    break;
                case 4:
                    // Abre el submenú de gestión de ciudades
                	GestionCiudad.ciudad(args);
                    break;
                case 5:
                    // Finaliza el programa
                    System.out.println("Cerrando sesión. ¡Hasta luego!");
                    break;
                default:
                    // Opción no válida
                    System.out.println("Opción no válida, intenta de nuevo.");
            
                }
            }

    }
    public static boolean Confirm() {
        String answer;
        do {
            System.out.println("¿Quieres realizar esta acción? (Si/No)");
            answer = org.nextLine();
            if (answer.equalsIgnoreCase("Si")) {
                return true;
            } else if (answer.equalsIgnoreCase("No")) {
                return false;
            } else {
                System.out.println("Opción no válida");
            }
        } while (true);
    }
    public static boolean ConfirmExist(String nombre[][], String ingresado) {
    	boolean paso = false;
    	
    	for (int i = 0; i < nombre.length; i++) {
			if(nombre[i][0].equalsIgnoreCase(ingresado)) {
				paso = true;
			} else {
				System.out.println("Nombre ingresado no existe");
			}
		}
    	
    	return paso;
    }
}