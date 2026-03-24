package funciones;
import java.util.Scanner;

public class IniciarSesion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Array con 5 pares usuario y contraseña
        String[] usuarios = {"Juan", "Solazar386","Alejandra", "Caraota","Cassandra", "Limalimon","Julian", "Saturno","Mateo", "1234"};

        boolean accesoConcedido = false;
        int numIntentos = 3;

        while (numIntentos > 0 && !accesoConcedido) {
            
        	System.out.print("Ingrese su nombre de usuario: ");
            String nombre = sc.nextLine();

            System.out.print("Ingrese su contraseña: ");
            String contraseña = sc.nextLine();
            

            // Verificamos si el usuario y contraseña coinciden
            for (int i = 0; i < usuarios.length; i+=2) {
                if (usuarios[i].equals(nombre) && usuarios[i+1].equals(contraseña)) {
                    accesoConcedido = true;
                    break;
                }
            }

            if (accesoConcedido) {
                System.out.println("Bienvenid@, " + nombre);
            } else {
                numIntentos--;
                if (numIntentos > 0) {
                    System.out.println("Usuario o contraseña incorrectos. Intentos restantes: " + numIntentos);
                } else {
                    System.out.println("Sesión bloqueada por falta de intentos.");
                }
            }
        }
        sc.close();
    }
}