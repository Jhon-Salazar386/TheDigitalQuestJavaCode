package users;
import java.util.Scanner;

 class GestionDeportistas {
	static Scanner org = new Scanner (System.in);
    public static void deportistas(String[]args) {
    	
    	MostrarMenuD();
    	
    	Gestion.main(args);

        org.close();
    	}
    
 	private static void MostrarMenuD() {
 		String dni = "5368546a";
        String nombre = "Julian";
        String apellidos = "Giraldo";
        String genero = "Hombre";
        String fechaNacimiento = "28/06/1990";
        String ciudadNacimiento = "Yucatan";
   
        boolean desicion;
        
 		int option = 0;
 		// Menú de gestión de participantes
        do {
            System.out.println("--- GESTION DE DEPORTISTAS ---");
            System.out.println("1 - Añadir participante");
            System.out.println("2 - Ver participante");
            System.out.println("3 - Editar participante");
            System.out.println("4 - Eliminar participante");
            System.out.println("5 - Volver al menú principal");
            
            option = org.nextInt();
            org.nextLine();
            
            switch (option) {
            case 1:
            	
                // Añade a un nuevo deportista en la base de datos
                System.out.println("--- AÑADIR PARTICIPANTE ---");
                System.out.print("Nombre: ");
                nombre = org.nextLine();
                System.out.print("Ciudad: ");
                ciudadNacimiento = org.nextLine();

                desicion = Gestion.Confirm();
                
                if (desicion) {
                    System.out.println("Deportista agregado.");
                } else {
                    System.out.println("Operacion cancelada.");
                }

                break;

            case 2:

                // Muestra detalles acerca de un deportista
                System.out.println("--- VER PARTICIPANTE ---");
                System.out.println("DNI" + dni);
                System.out.println("Nombre" + nombre);
                System.out.println("Apellidos" + apellidos);
                System.out.println("Genero" + genero);
                System.out.println("Ciudad de nacimiento" +  ciudadNacimiento);
                System.out.println("Fecha de nacimiento" + fechaNacimiento);
                break;

            case 3:
                //Modifica informacion acerca de un deportista
                System.out.println("--- EDITAR DEPORTISTA ---");
                System.out.print("Nuevo nombre: ");
                nombre = org.nextLine();
                System.out.print("Nueva ciudad: ");
                ciudadNacimiento = org.nextLine();

                desicion = Gestion.Confirm();
                
                if (desicion) {
                    System.out.println("Deportista actualizado");
                } else {
                    System.out.println("Operacion cancelada");
                }
                break;
            	
            case 4:
                // Elimina deportistas de la base de datos
                System.out.println("--- ELIMINAR PARTICIPANTE ---");
                System.out.print("Nombre del participante: ");
                nombre = org.nextLine();

                desicion = Gestion.Confirm();
                
                if (desicion) {
                    System.out.println("Deportista eliminado");
                } else {
                    System.out.println("Eliminación cancelada");
                }
                break;
                
            case 5:
                // Vuelve al menu principal de gestion
                System.out.println("Volviendo al menú principal...");                
                break;

            default:
                // Cualquier otra opcion ingresada por teclado
                System.out.println("Opción no válida.");
                break;
                
            }
        } while (option != 5);
 	}		
}