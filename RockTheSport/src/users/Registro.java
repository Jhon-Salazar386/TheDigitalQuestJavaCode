package users;
import java.util.Scanner;

public class Registro{
	public static void main(String[]args) {
		Scanner registros = new Scanner(System.in);
		
		String usuariosReg[] = {"Juan","Solazar386","Alejandra", "Caraota","Cassandra","Limalimon","Julian","Saturno"};
		
		String newUserReg[] = new String[usuariosReg.length+2];
		
		for (int i = 0; i < usuariosReg.length; i++) {
			newUserReg[i] = usuariosReg[i];
		}
		
		System.out.println("Ingresa un nombre de usuario");
		String nombre = registros.nextLine();
		
		boolean existe = false;
		
		for (int i = 0; i < usuariosReg.length; i++) {
			if (usuariosReg[i].equalsIgnoreCase(nombre)) {
				existe = true;
				break;
			}
		}
		
		if(existe) {
			System.out.println("esta cuenta ya fue registrada");
			
		} else {
			
			System.out.println("Ingresa tu email");
			String email = registros.nextLine();
			
			System.out.println("Ingresa una contraseña");
			String contraseña = registros.nextLine();
			
			System.out.println("Confirma la contraseña");
			String confirmContraseña = registros.nextLine();
			
			while (!contraseña.equals(confirmContraseña)) {
				System.out.println("Las contraseñas no son iguales, vuelve a intentarlo");
				confirmContraseña = registros.nextLine();
			}
			
			newUserReg[newUserReg.length - 1] = contraseña;
			newUserReg[newUserReg.length - 2] = nombre;
			
			System.out.println("----------------------");
			for (int i = 0; i < newUserReg.length; i+=2) {
				System.out.println(newUserReg[i] + "  " + newUserReg[i+1]);
			}
			System.out.println("Cuenta creada sactisfactoriamente");
		}
	registros.close();
	}
}