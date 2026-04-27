package dao;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import db.Conector;
import log.FicheroLog;
import model.Edicion;

public class GestionEdiciones {

	// Se encarga de agregar una nueva edicion a la base de datos
	public void agregarEdicion(Edicion edicion) throws SQLException, IOException {

		String query = "insert into edicion(nombre, fecha_inicio, fecha_fin, id_evento, codigo_ciudad) values(?, ?, ?, ?, ?)";

		PreparedStatement ps = Conector.getConexion().prepareStatement(query);

		ps.setString(1, edicion.getNombreEdicion());
		ps.setDate(2, edicion.getFechaInicio());
		ps.setDate(3, edicion.getFechaFin());
		ps.setInt(4, edicion.getIdEvento());
		ps.setString(5, edicion.getIdCiudad());

		ps.executeUpdate();

		FicheroLog.escribir("Se ha insertado una nueva edicion en la base de datos: " + edicion.getNombreEdicion());

		ps.close();
	}

	// Muestra un listado de todas las ediciones
	public ArrayList<Edicion> mostrarEdiciones() throws SQLException, IOException {

		ArrayList<Edicion> ediciones = new ArrayList<>();

		String query = "select * from edicion";

		PreparedStatement ps = Conector.getConexion().prepareStatement(query);

		ResultSet result = ps.executeQuery();

		while (result.next()) {

			Edicion e = new Edicion(result.getInt(1), result.getString(2), result.getDate(3), result.getDate(4),
					result.getInt(5), result.getString(6));

			ediciones.add(e);
		}

		result.close();
		ps.close();

		FicheroLog.escribir("Se ha consultado la base de datos de ediciones");

		return ediciones;
	}

	// Busca una edicion mediante su ID
	public ArrayList<Edicion> mostrarEdicionesPorId(int id) throws SQLException, IOException {

		ArrayList<Edicion> ediciones = new ArrayList<>();

		String query = "select * from edicion where id = ?";

		PreparedStatement ps = Conector.getConexion().prepareStatement(query);

		ps.setInt(1, id);

		ResultSet result = ps.executeQuery();

		while (result.next()) {

			Edicion e = new Edicion(result.getInt(1), result.getString(2), result.getDate(3), result.getDate(4),
					result.getInt(5), result.getString(6));

			ediciones.add(e);
		}

		result.close();
		ps.close();

		FicheroLog.escribir("Se ha consultado la edicion con ID " + id);

		return ediciones;
	}

	public ArrayList<Edicion> mostrarEdicionesPorNombre(String nombre) throws SQLException, IOException {

		ArrayList<Edicion> ediciones = new ArrayList<>();

		String query = "select * from edicion where nombre like ?";

		PreparedStatement ps = Conector.getConexion().prepareStatement(query);

		ps.setString(1, "%" + nombre + "%");

		ResultSet result = ps.executeQuery();

		while (result.next()) {

			Edicion e = new Edicion(result.getInt(1),
					result.getString(2),
					result.getDate(3),
					result.getDate(4),
					result.getInt(5),
					result.getString(6));

			ediciones.add(e);
		}

		result.close();
		ps.close();

		FicheroLog.escribir("Se han filtrado ediciones por nombre: " + nombre);

		return ediciones;
	}

	// Actualiza las fechas de una edicion
	public void actualizarEdicion(int id, Date fechaInicio, Date fechaFin) throws SQLException, IOException {

		String query = "update edicion set fecha_inicio = ?, fecha_fin = ? where id = ?";

		PreparedStatement ps = Conector.getConexion().prepareStatement(query);

		ps.setDate(1, fechaInicio);
		ps.setDate(2, fechaFin);
		ps.setInt(3, id);

		ps.executeUpdate();

		FicheroLog.escribir("Se actualizo la edicion con ID " + id + " correctamente");

		ps.close();
	}

	// Elimina una edicion de la base de datos
	public boolean eliminarEdicion(int id) throws SQLException, IOException {

		String query = "delete from edicion where id = ?";

		PreparedStatement ps = Conector.getConexion().prepareStatement(query);

		ps.setInt(1, id);

		int resultado = ps.executeUpdate();

		ps.close();

		if (resultado > 0) {

			FicheroLog.escribir("Se ha eliminado la edicion con ID " + id + " correctamente");
			return true;

		} else {

			FicheroLog.escribir("Se ha intentado eliminar una edicion pero no tuvo efecto");
			return false;
		}
	}

	// Devuelve la cantidad de ediciones
	public int contadorEdiciones() throws SQLException, IOException {

		int numeroEdiciones = 0;

		String query = "select count(*) from edicion";

		PreparedStatement ps = Conector.getConexion().prepareStatement(query);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			numeroEdiciones = rs.getInt(1);
		}

		rs.close();
		ps.close();

		FicheroLog.escribir("Se ha consultado el numero de ediciones de la base de datos");

		return numeroEdiciones;
	}
}