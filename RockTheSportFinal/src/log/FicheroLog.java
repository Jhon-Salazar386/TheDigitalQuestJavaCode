package log;

import java.io.*;

public class FicheroLog {

    private static File log = new File("log.txt");
    private static BufferedWriter bw;

    public static File getLog() {
        return log;
    }

    // Abre el BufferedWriter en modo append
    public static void abrirBufferedWriter() throws IOException {
        bw = new BufferedWriter(new FileWriter(log, true));
    }

    // Escribe en el log
    public static void escribir(String texto) throws IOException {

        if (bw == null) {
            throw new IOException("El BufferedWriter no está abierto");
        }

        bw.newLine();
        bw.write(texto);
    }

    // Cierra el BufferedWriter
    public static void cerrarBufferedWriter() throws IOException {

        if (bw != null) {
            bw.close();
        }
    }

    // Lee todo el contenido del log
    public static String leerLog() throws IOException {

        String contenido = "";
        String linea;

        BufferedReader br = new BufferedReader(new FileReader(log));

        while ((linea = br.readLine()) != null) {
            contenido = linea + "\n";
        }

        br.close();

        return contenido;
    }
}