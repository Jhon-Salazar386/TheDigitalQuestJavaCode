package funciones;
import java.util.Scanner;

public class GestionInscripciones {
    public static void inscripciones(String[]args) {
        Scanner org = new Scanner (System.in);
        
        //Datos que se usaran de ejemplo
    	String deportista = "Julian";
        String evento = "Triatlon";
        String emision = "21/07/2025" ;
        String cod = "2312678at";
        
        int inscripcionOption = 0;

        // Menú de gestión de inscripciones
        while (inscripcionOption != 4) {
            System.out.println("--- GESTIÓN DE INSCRIPCIONES ---");
            System.out.println("1 - Inscribir participante a evento");
            System.out.println("2 - Ver inscripciones");
            System.out.println("3 - Modificar incripcion");
            System.out.println("4 - Eliminar inscripción");
            System.out.println("5 - Volver al menú principal");
            System.out.print("Opción: ");
            
            inscripcionOption = org.nextInt();
            org.nextLine();

            switch (inscripcionOption) {
                case 1:
                    // --- INSCRIBIR PARTICIPANTE ---
                    System.out.println("--- NUEVA INSCRIPCIÓN ---");
                    System.out.print("Nombre del participante: ");
                    deportista = org.nextLine();
                    System.out.print("Nombre del evento: ");
                    evento = org.nextLine();
                    System.out.println("Participante inscrito correctamente.");
                    break;

                case 2:
                    // --- VER INSCRIPCIONES ---
                    System.out.println("--- LISTADO DE INSCRIPCIONES ---");
                    System.out.println("Participante: " + deportista);
                    System.out.println("Evento: " + evento);
                    System.out.println("Codigo: " + cod);
                    System.out.println("Fecha de emision: " + emision);
                    break;
                case 3:
                    //Elimina inscripciones de la base de datos
                    System.out.println("--- ELIMINAR INSCRIPCIÓN ---");
                    System.out.print("Nombre del participante: ");
                    deportista = org.nextLine();
                    System.out.print("Evento: ");
                    evento = org.nextLine();
                    System.out.println("Inscripción eliminada.");
                    break;
                case 4:
                    // --- MODIFICAR INSCRIPCIÓN ---
                    System.out.println("--- ELIMINAR INSCRIPCIÓN ---");
                    System.out.print("Nombre del participante: ");
                    deportista = org.nextLine();
                    System.out.print("Evento: ");
                    evento = org.nextLine();
                    System.out.println("Inscripción eliminada.");
                    break;
                case 5:
                    // --- VOLVER AL MENÚ ---
                    System.out.println("Volviendo al menú principal...");
                    Gestion.main(args);
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    org.close();
    }
}