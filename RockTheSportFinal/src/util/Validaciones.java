package util;

public class Validaciones {

	public static boolean validarDNI(String dni) {
		return dni.matches("\\d{8}[A-Za-z]");
	}

	public static boolean validarFecha(String fecha) {
		try {
			java.sql.Date.valueOf(fecha); // formato yyyy-MM-dd
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	public static boolean validarGenero(String genero) {
		return genero.equalsIgnoreCase("hombre") || genero.equalsIgnoreCase("mujer")
				|| genero.equalsIgnoreCase("otros");
	}

	public static boolean validarEmail(String email) {
		return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
	}

	public static boolean validarTelefono(String telefono) {
		return telefono.matches("\\d{9,15}");
	}

}
