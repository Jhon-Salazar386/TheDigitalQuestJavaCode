package users;
import java.util.Scanner;

public class GestionCiudad {
    public static void ciudad(String[]args) {
        Scanner org = new Scanner (System.in);
    	
        //se definen 2 constantes como ejemplos y 2 variables que pueden cambiar segun queramos
        String ciudad1 = "Donosti";
    	String ciudad2 = "Tobago";
    	String permiso1 = "Permitido";
    	String permiso2 = "Sin permiso";
    	
    	boolean desicion;
    	
    	int ciudadOption = 0;

        // Menú de gestión de ciudades
        while (ciudadOption != 5) {
            System.out.println("\n--- GESTIÓN DE CIUDADES ---");
            System.out.println("1 - Añadir ciudad");
            System.out.println("2 - Ver ciudad");
            System.out.println("3 - Editar ciudad");
            System.out.println("4 - Eliminar ciudad");
   
            System.out.println("5 - Volver al menú principal");
            System.out.print("Opción: ");
            
            ciudadOption = org.nextInt();
            org.nextLine();

            switch (ciudadOption) {
                case 1:
                    //Registra ciudades y su disponibilidad para futuros eventos
                    System.out.println("--- AÑADIR CIUDAD ---");
                    System.out.print("Nombre de la ciudad: ");
                    ciudad2 = org.nextLine();
                    System.out.print("¿Permiso otorgado para eventos? (Si/No): ");
                    desicion = Gestion.Confirm();

                    if (desicion) {
                        System.out.println("Ciudad registrada con permiso.");
                    } else {
                        System.out.println("Ciudad registrada sin permiso.");
                    }
                    break;

                case 2:
                    // Revisa detalles acerca de las ciudades
                    System.out.println("--- VER CIUDAD ---");
                    System.out.println("Ciudad: " + ciudad1);
                    System.out.println("Permiso de evento: " + permiso1);
                    System.out.println("--------------------");
                    System.out.println("Ciudad: " + ciudad2);
                    System.out.println("Permiso de evento: " + permiso2);
                    break;
                case 3:

                    //Edita informacion acerca de una ciudad como su localizacion y su permiso
                    System.out.println("--- EDITAR CIUDAD ---");
                    System.out.print("Nuevo nombre: ");
                    ciudad2 = org.nextLine();
                    System.out.print("¿Permiso para eventos? (Si/No): ");
                    
                    desicion = Gestion.Confirm();
                    
                    if (desicion) {
                    	permiso2 = "permitido";
                    } else if (permiso2.equalsIgnoreCase("No")) {
                    	permiso2 = "No permitido";
                    } else {
                    	permiso2 = "No confirmado o no reconocido";
                    }
                    System.out.println("Ciudad actualizada correctamente.");
                    break;

                case 4:

                    // Elimina las ciudades
                    System.out.println("--- ELIMINAR CIUDAD ---");
                    System.out.print("Nombre de la ciudad a eliminar: ");
                    ciudad2 = org.nextLine();

                    System.out.print("¿Eliminar esta ciudad? (Si/No): ");
                    String deleteC = org.nextLine();
                    if (deleteC.equalsIgnoreCase("Si")) {
                        System.out.println("Ciudad eliminada.");
                    } else {
                        System.out.println("Eliminación cancelada.");
                    }
                    break;
                case 5:
                    //Vuelve al menu de gestion
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