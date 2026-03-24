package funciones;
import java.util.Scanner;

public class BajaUsuario {
	public static void main(String[]args) {
		Scanner registro = new Scanner (System.in);
		
		String[] usuarios = {"Juan", "colacao","Alejandra", "Caraota","Cassandra", "Limalimon","Julian", "Saturno","Mateo", "1234"};
		
		String [] usuariosBajas = new String[2];
		
		System.out.println("Ingrese nombre de usuario");
		String nombre = registro.nextLine();

		
		boolean encontrado = false;
		
		for (int i = 0; i < usuarios.length; i+=2) {
			if(nombre.equalsIgnoreCase(usuarios[i])){
				usuariosBajas[0]= usuarios[i];
				usuariosBajas[1] = usuarios[i+1];
				usuarios[i] = "";
				usuarios[i+1] = "";
				encontrado = true;
			}
		}
		
		String [] usuariosAct = new String [usuarios.length-2];
		
		for (int i = 0; i < usuariosAct.length; i+=2) {
			if(usuarios[i].equals("")) {
				System.out.println("Campo vacio");
			} else {
				usuariosAct[i] = usuarios[i];
				usuariosAct[i+1] = usuarios[i+1];
			}
		}
		
		if (encontrado) {
			System.out.println("Dado de baja exitosamente");
		} else {
			System.out.println("Cuenta no encontrada");
		}
		
		System.out.println("---- lista de usuarios de baja ----");
		for (int i = 0; i < usuariosBajas.length; i++) {
			System.out.println(usuariosBajas[i] + " ");
				
		}
		System.out.println("---- lista de usuarios de baja ----");
		for (int i = 0; i < usuariosAct.length; i++) {
			System.out.println(usuariosAct[i] + " ");
				
		}
	}
}
