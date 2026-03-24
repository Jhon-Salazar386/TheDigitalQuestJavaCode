package funciones;
import java.util.Scanner;

public class GestionEventos {
    public static void eventos(String[]args) {
        Scanner org = new Scanner (System.in);
    	
        String evento = "Triatlon";
        String ciudad = "Donosti";
        String ubicacion = "La concha";
        String fecha = "27/01/2026";
        
        int eventoOption = 0;

        // Menú de gestión de eventos
        while (eventoOption != 5) {
            System.out.println("\n--- GESTIÓN DE EVENTOS ---");
            System.out.println("1 - Añadir evento");
            System.out.println("2 - Ver evento");
            System.out.println("3 - Editar evento");
            System.out.println("4 - Eliminar evento");
            System.out.println("5 - Volver al menú principal");
            System.out.print("Opción: ");
           
            eventoOption = org.nextInt();
            org.nextLine();

            switch (eventoOption) {
                case 1:
                    // Añade un nuevo evento
                    System.out.println("--- AÑADIR EVENTO ---");
                    System.out.print("Nombre del evento: ");
                    evento = org.nextLine();
                    System.out.print("Ciudad del evento: ");
                    ciudad = org.nextLine();
                    System.out.print("Fecha del evento: ");
                    fecha = org.nextLine();

                    //Pregunta si quiere realizar la operacion
                    System.out.print("¿Añadir este evento? (Si/No): ");
                    String add = org.nextLine();
                    if (add.equalsIgnoreCase("Si")) {
                        System.out.println("Evento agregado correctamente.");
                    } else {
                        System.out.println("Operación cancelada.");
                    }
                    break;

                case 2:

                    //Muestra informacion acerca de los eventos
                    System.out.println("--- VER EVENTO ---");
                    System.out.println("Nombre: " + evento);
                    System.out.println("Ciudad: " + ciudad + ", " + ubicacion);
                    System.out.println("Fecha: " + fecha);
                    break;
                case 3:
                	
                	//Modificar informacion acerca de un evento
                    System.out.println("--- EDITAR EVENTO ---");
                    System.out.print("Nuevo nombre: ");
                    evento = org.nextLine();
                    System.out.print("Nueva ciudad: ");
                    ciudad = org.nextLine();
                    System.out.print("Nueva fecha: ");
                    fecha = org.nextLine();

                    System.out.print("¿Modificar este evento? (Si/No): ");
                    String modi = org.nextLine();
                    if (modi.equalsIgnoreCase("Si")) {
                        System.out.println("Evento modificado correctamente.");
                    } else {
                        System.out.println("Modificación cancelada.");
                    }
                    break;
                    

                case 4:
                	
                	//Eliminar evento
                    System.out.println("--- ELIMINAR EVENTO ---");
                    System.out.print("Nombre del evento a eliminar: ");
                    evento = org.nextLine();
                    
                    if (evento.equalsIgnoreCase("Triatlon")){
                        System.out.print("¿Eliminar este evento? (Si/No): ");
                        String delete = org.nextLine();
                        if (delete.equalsIgnoreCase("Si")) {
                            System.out.println("Evento eliminado.");
                        } else {
                            System.out.println("Eliminación cancelada.");
                        break;
                        } 
                    
                    } else {
                    	System.out.println("Evento no encontrado");
                    }

                    break;

                case 5:
                	
                    //Volver al menu de gestion
                    System.out.println("Volviendo al menú principal...");
                    Gestion.main(args);
                    break;

                default:
                	
                    // Opción incorrecta
                    System.out.println("Opción no válida.");
            }
        }
    org.close();
    }
}