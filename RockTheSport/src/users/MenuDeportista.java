package users;
import java.util.Scanner;

public class MenuDeportista {
    public static void main(String[]args) {
        Scanner deportista = new Scanner(System.in);
        
        int opcion = 0;
        
        String arrayEvent[][] = new String[5][3]; 
        
        String evento1 = "natacion";
        String ciudad1 = "Madrid";
        String fecha1 = "20/04/2026";

        String evento2 = "Carrera 10Km";
        String ciudad2 = "Bidasoa";
        String fecha2 = "10/03/2026";

        String evento3 = "Triatlón";
        String ciudad3 = "Donosti";
        String fecha3 = "28/06/2026";
        
        String PasoOrganizador[] = {"Jhon", "Salazar"};

        // Variable para guardar la inscripción del usuario
        String miInscripcion = "";

        while (opcion != 6) {
            System.out.println("\n=== Sistema de Gestión de Eventos Deportivos ===");
            System.out.println("1. Listar eventos");
            System.out.println("2. Buscar evento");
            System.out.println("3. Ver detalles de un evento");
            System.out.println("4. Inscribirse en un evento");
            System.out.println("5. Ver mi inscripción");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = deportista.nextInt();
            deportista.nextLine();

            switch (opcion) {
                case 1:
                	//muestra un listado completo de los eventos
                    System.out.println("Listado de eventos disponibles: ");
                    System.out.println("1. " + evento1 + " - " + ciudad1 + " (" + fecha1 + ")");
                    System.out.println("2. " + evento2 + " - " + ciudad2 + " (" + fecha2 + ")");
                    System.out.println("3. " + evento3 + " - " + ciudad3 + " (" + fecha3 + ")");
                    break;

                case 2:
                	//busca un evento basandose por el nombre
                    System.out.print("Ingrese una palabra clave para buscar: ");
                    String busqueda = deportista.nextLine();

                    System.out.println("Resultados de búsqueda:");

                    if (evento1.equalsIgnoreCase(busqueda)){                   
                    	System.out.println(evento1);
                        System.out.println(ciudad1);
                        System.out.println(fecha1);
                    }
                    else if (evento2.equalsIgnoreCase(busqueda)) {
                        System.out.println(evento2);
                        System.out.println(ciudad2);
                        System.out.println(fecha2);
                    }
                    else if (evento3.equalsIgnoreCase(busqueda)) {
                        System.out.println(evento3);
                        System.out.println(ciudad3);
                        System.out.println(fecha3);
                    } else {
                        System.out.println("No se encontraron eventos con ese criterio.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el número del evento (1-3): ");
                    int ver = deportista.nextInt();
                    switch (ver) {
                        case 1: 
                        	System.out.println(evento1 + " Ciudad: " + ciudad1 + " Fecha: " + fecha1);
                        case 2: 
                        	System.out.println(evento2 + " Ciudad: " + ciudad2 + " Fecha: " + fecha2);
                        case 3:
                        	System.out.println(evento3 + " Ciudad: " + ciudad3 + " Fecha: " + fecha3);
                        default:
                        	System.out.println("Evento no valido.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el número del evento para inscribirse (1-3): ");
                    int inscripcion = deportista.nextInt();
                    switch (inscripcion) {
                        case 1: 
                        	miInscripcion = evento1;
                        case 2 :
                        	miInscripcion = evento2;
                        case 5:
                        	miInscripcion = evento3;
                        default:
                        	System.out.println("Número inválido.");
                    }
                    break;

                case 5:
                    if (miInscripcion.isEmpty()) {
                        System.out.println("Aún no te has inscrito en ningún evento");
                    } else {
                        System.out.println("Estás inscrito en: " + miInscripcion);
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del sistema");
                    break;

                default:
                    System.out.println("Opción no válida");
            }

        }

        deportista.close();
    }
}