package db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import log.FicheroLog;

public class Conector {

	private static Connection conexion;

	public static Connection getConexion() {
		return conexion;
	}

	public static void setConexion(Connection conexion) {
		Conector.conexion = conexion;
	}

	public static void conectar() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/rockthesport", "root", "1DAW3_BBDD");

			FicheroLog.escribir("Se ha conectado el programa con la base de datos correctamente");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException cf) {
			cf.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	public static void cerrarConexion() throws SQLException {
		conexion.close();
	}
}
