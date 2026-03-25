package log;

import java.io.*;

public class FicheroLog {

	private static File log = new File("log.txt");

	public static File getLog() {
		return log;
	}

	// Se usa para registrar las acciones en el fichero log
	public static void escribir(String texto) throws IOException {

		BufferedWriter bw = new BufferedWriter(new FileWriter(log, true));

		bw.newLine();
		bw.write(texto);
		bw.newLine();

		bw.close();

	}

	// Se encarga de devolver el contenido del fichero log
	public static String leerLog() throws IOException {

		String contenido = "";
		String linea = "";

		BufferedReader br = new BufferedReader(new FileReader(log));

		while ((linea = br.readLine()) != null) {
			contenido += linea + "\n";
		}

		br.close();

		return contenido;

	}

}
