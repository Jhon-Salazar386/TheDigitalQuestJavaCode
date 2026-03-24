package funciones;
import java.util.Scanner;

public class GestionDeportistas {
    static Scanner org = new Scanner(System.in);

    public static void deportistas(String[] args) {

        //Menú de gestión de participantes
        menuDeportistas();

        Gestion.main(args);

    }

    public static void menuDeportistas() {
        //Deportista inicial
        String user[][] = {{"Alejandra", "Valdez", "Mujer"}};

        String users[][] = RellenarArray(user);

        int opcionParticipante = 0;

        while (opcionParticipante != 5) {

            System.out.println("--- GESTIÓN DE PARTICIPANTES ---");
            System.out.println("1 - Añadir");
            System.out.println("2 - Ver");
            System.out.println("3 - Editar");
            System.out.println("4 - Eliminar");
            System.out.println("5 - Volver al menú principal");

            opcionParticipante = org.nextInt();
            org.nextLine();

            switch (opcionParticipante) {
                case 1:

                    //Añade a un nuevo deportista en la "base de datos"
                    System.out.println("--- AÑADIR PARTICIPANTE ---");
                    users = InsertDeportista(users);

                    break;

                case 2:

                    //Muestra detalles acerca de un deportista
                    for (int i = 0; i < users.length; i++) {
                        if (users[i][0] != null) {
                        	System.out.println("-------------------------");
                            System.out.println("Nombre: " + users[i][0]);
                            System.out.println("Apellido: " + users[i][1]);
                            System.out.println("Genero: " + users[i][2]);
                        }
                    }

                    break;

                case 3:
                    System.out.println("--- EDITAR DEPORTISTA ---");
                    System.out.print("Nombre actual a editar: ");
                    String buscarNombre = org.nextLine();

                    for (int i = 0; i < users.length; i++) {
                        if (Gestion.ConfirmExist(users, buscarNombre)) {
                            System.out.print("Nuevo nombre: ");
                            users[i][0] = org.nextLine();

                            System.out.print("Nuevo apellido: ");
                            users[i][1] = org.nextLine();

                            System.out.print("Nuevo género: ");
                            users[i][2] = org.nextLine();

                            if (Gestion.Confirm()) {
                                System.out.println("Deportista actualizado.");
                            } else {
                                System.out.println("Operación cancelada.");
                            }

                            break;
                        } else {
                            System.out.println("Deportista no encontrado.");
                        }
                    }

                    break;

                case 4:
                    System.out.println("--- ELIMINAR PARTICICIPANTE ---");
                    System.out.print("Nombre del participante a eliminar: ");
                    String eliminar = org.nextLine();

                    for (int i = 0; i < users.length; i++) {
                        if (Gestion.ConfirmExist(users, eliminar)) {

                            System.out.print("¿Eliminar este deportista? (Si/No): ");
                            if (Gestion.Confirm() && users[i] != null) {
                                users[i][0] = null;
                                users[i][1] = null;
                                users[i][2] = null;

                                System.out.println("Deportista eliminado.");
                            } else {
                                System.out.println("Eliminación cancelada.");
                            }
                            break;
                        }
                    }
                    break;

                case 5:
                    //Vuelve al menu principal de gestion
                    System.out.println("Volviendo al menú principal...");
                    break;

                default:
                    //Cualquier otra opcion ingresada por teclado
                    System.out.println("Opción no válida.");
            }
        }
    }

    public static String[][] RellenarArray(String[][] user) {

        String array[][] = new String[user.length + 3][3];

        array[0][0] = user[0][0];
        array[0][1] = user[0][1];
        array[0][2] = user[0][2];

        return array;
    }

    public static String[][] InsertDeportista(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i][0] == null) {
                System.out.print("Ingresa tu nombre: ");
                String nombre = org.nextLine();
                System.out.print("Ingresa tu apellido: ");
                String apellido = org.nextLine();
                System.out.print("Ingresa tu género: ");
                String genero = org.nextLine();

                if (Gestion.Confirm()) {
                    array[i][0] = nombre;
                    array[i][1] = apellido;
                    array[i][2] = genero;
                    System.out.println("Deportista agregado.");
                } else {
                    System.out.println("Operación cancelada.");
                }
                break;
            }
        }
        return array;
    }
}