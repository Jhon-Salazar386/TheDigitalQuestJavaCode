package dao;

import java.io.*;
import model.Inscripcion;
import java.util.ArrayList;
import java.sql.*;
import db.Conector;
import log.FicheroLog;

public class InscripcionDao {

	// Procedimiento que crea una nueva inscripcion, el cual controla si existe
	// ciudad, el deportista o la edicion
	public String insertar(Inscripcion inscripcion) throws SQLException, IOException {

		String resultado = "";
		String query = "CALL CREARINSCRIPCION(?, ?, ?);";

		CallableStatement ps = Conector.getConexion().prepareCall(query);

		ps.setString(1, inscripcion.getDniDeportista());

		ps.setInt(2, inscripcion.getIdEdicion());

		ps.execute();

		resultado = ps.getString(3);

		ps.close();

		FicheroLog.escribir(resultado);

		return resultado;
	}

	/*
	 * // Crea una nueva inscripcion y la agrega a la base de datos() public void
	 * insertar(Inscripcion inscripcion) throws SQLException, IOException {
	 * 
	 * String query =
	 * "INSERT INTO Inscripcion (Fecha_Insc, DNI_Deportista, ID_Edicion) VALUES (?, ?, ?)"
	 * ;
	 * 
	 * PreparedStatement ps = Conector.getConexion().prepareStatement(query);
	 * 
	 * ps.setDate(1, inscripcion.getFechaInsc()); ps.setString(2,
	 * inscripcion.getDniDeportista()); ps.setInt(3, inscripcion.getIdEdicion());
	 * 
	 * ps.executeUpdate();
	 * 
	 * ps.close();
	 * 
	 * FicheroLog.escribir("Nueva inscripción a la edicion " +
	 * inscripcion.getIdEdicion()); }
	 */
	// Muestra todas las inscripciones insertadas
	
	public ArrayList<Inscripcion> mostrarTodasLasInscripciones() throws SQLException, IOException {

		ArrayList<Inscripcion> inscripciones = new ArrayList<>();

		String query = "select * from inscripcion";

		PreparedStatement ps = Conector.getConexion().prepareStatement(query);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Inscripcion ins = new Inscripcion(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getInt(4));

			inscripciones.add(ins);
		}

		rs.close();
		ps.close();

		FicheroLog.escribir("Se ha consultado las inscripciones de la base de datos");

		return inscripciones;
	}
	
	public ArrayList<Inscripcion> mostrarInscripcionesPorDni(String dni) throws SQLException, IOException {

		ArrayList<Inscripcion> inscripciones = new ArrayList<>();

		String query = "select * from inscripcion where dni_deportista = ?";

		PreparedStatement ps = Conector.getConexion().prepareStatement(query);
		
		ps.setString(1, dni);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			
			Inscripcion ins = new Inscripcion(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getInt(4));

			inscripciones.add(ins);
		}

		rs.close();
		ps.close();

		FicheroLog.escribir("Se ha consultado las inscripciones de la base de datos");

		return inscripciones;
	}

	public String mostrarEstadoInscripciones() throws SQLException, IOException {

		String contenido = "";

		String query = "CALL ESTADOINSCRIPCIONES()";

		CallableStatement cs = Conector.getConexion().prepareCall(query);

		ResultSet rs = cs.executeQuery();

		while (rs.next()) {
			contenido += "ID Inscripcion: " + rs.getInt(1) + "\n" + "Nombre Deportista: " + rs.getString(2) + "\n"
					+ "Apellidos Deportista: " + rs.getString(3) + "\n" + "Nombre Edicion: " + rs.getString(4) + "\n"
					+ "Fecha Finalizacion: " + rs.getDate(5) + "\n" + "Fecha Inscripcion: " + rs.getDate(6) + "\n"
					+ "Estado: " + rs.getString(7) + "\n\n";
		}

		FicheroLog.escribir("Se ha consultado el estado de las inscripciones");

		return contenido;
	}

	// Elimina una inscripcion de la base de datos mediante su identificador
	public boolean eliminar(int id) throws SQLException, IOException {

		String query = "DELETE FROM Inscripcion WHERE ID_Inscripcion = ?";

		PreparedStatement ps = Conector.getConexion().prepareStatement(query);
		ps.setInt(1, id);

		int resultado = ps.executeUpdate();

		ps.close();

		FicheroLog.escribir("Inscripción eliminada ID: " + id);

		if (resultado > 0) {

			FicheroLog.escribir("Se ha eliminado la inscripcion con el id " + id + " correctamente");
			return true;

		} else {

			FicheroLog.escribir("Se ha intentado eliminar una inscripcion pero no tuvo efecto");
			return false;
		}
	}

	// Retorna el numero de inscripciones registrada en la base de datos
	public int contadorTotalInscripciones() throws SQLException, IOException {

		int numeroInscripciones = 0;

		String query = "select count(*) from inscripcion";

		PreparedStatement ps = Conector.getConexion().prepareStatement(query);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			numeroInscripciones = rs.getInt(1);
		}

		rs.close();
		ps.close();

		return numeroInscripciones;

	}

}
