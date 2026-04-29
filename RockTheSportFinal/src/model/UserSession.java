package model;

/*
 * Clase usada para login de usuario
 */
public class UserSession {

	private static String dni;

	public static void setDni(String dni) {
		UserSession.dni = dni;
	}

	public static String getDni() {
		return dni;
	}
}
