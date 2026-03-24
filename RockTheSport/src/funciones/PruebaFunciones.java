package funciones;
/*
import entidades.Deportista;
import java.util.Scanner;
import entidades.Inscripcion;
import java.util.ArrayList;

public class PruebaFunciones {
	static Scanner sc = new Scanner(System.in);
	public static void test(String[]args) {
		
		MenuPrueba();
	
	}
	public static void MenuPrueba() {
		int opcion = 0;
		do {
			System.out.println("\nMenu de prueba de funciones" +
					"\n1-Crear nuevo deportista" +
					"\n2-Inscribirse a una edicion" +
					"\n3-VerInscripcion" +
					"\n4-Eliminar" +
					"\n5-Salir");
			
			opcion = sc.nextInt();
			sc.nextLine();
			
			switch(opcion) {
			case 1:
				ArrayList<Deportista> deportistas = new ArrayList<Deportista>();
				
				Deportista deportista = new Deportista();
				
				System.out.println("DNI");
				String dni = sc.nextLine();
				deportista.setDni(dni);
				
				System.out.println("Nombre");
				String nombre = sc.nextLine();
				deportista.setNombre(nombre);
				
				System.out.println("Apellido");
				String apellido = sc.nextLine();
				deportista.setApellido(apellido);
				
				System.out.println("Genero");
				String genero = sc.nextLine();
				deportista.setGenero(genero);
				
				System.out.println("fechaNac");
				String fechaNac = sc.nextLine();
				deportista.setFechaNac(fechaNac);
				
				System.out.println("ciudadNac");
				String ciudadNac = sc.nextLine();
				deportista.setCiudadNac(ciudadNac);
				
				System.out.println("email");
				String email = sc.nextLine();
				deportista.setEmail(email);
				
				System.out.println("telefono");
				String telefono = sc.nextLine();
				deportista.setTelefono(telefono);
				
				deportistas.add(deportista);
				
				
				break;
				
			case 2:
				
				ArrayList<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
				
				System.out.println("Ingresa id inscripcion");
				String idInscripcion = sc.nextLine();
				System.out.println("ingresa fecha");
				String fecha = sc.nextLine();
				System.out.println("ingresa el dni del deportista");
				String dniDeportista = sc.nextLine();
				System.out.println("id de la edicion");
				int idEdicion = sc.nextInt();
				
				Inscripcion inscripcion = new Inscripcion(idInscripcion, fecha, dniDeportista, idEdicion);
				
				inscripciones.add(inscripcion);

				System.out.println(inscripcion.toString());

				break;
			
			case 3:
				
				break;
				
			case 4:
				
				break;
			}
		} while (opcion != 5);

	}
}
*/
