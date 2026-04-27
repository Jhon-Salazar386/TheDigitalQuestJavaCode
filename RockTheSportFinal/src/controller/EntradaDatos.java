package controller;

import java.util.Scanner;

public class EntradaDatos {

	private static final Scanner org = new Scanner(System.in);

	/**
	 * Entrada de datos para numeros enteros, se asegura de que sea valido
	 * 
	 * @return
	 */
	public static int leerEntero() {
		int numero;

		while (true) {
			try {
				numero = org.nextInt();
				org.nextLine();

				return numero;
			} catch (Exception e) {
				org.nextLine();
			}
		}
	}

	/**
	 * Entrada de datos que almacena texto y previene que lo que se ingrese no este
	 * en blanco o sea nulo
	 * 
	 * @param mensaje
	 * @return
	 */
	public static String leerTexto() {
		String texto;

		while (true) {

			texto = org.nextLine();

			if (texto != null && !texto.isBlank()) {
				return texto;
			}
		}
	}
}