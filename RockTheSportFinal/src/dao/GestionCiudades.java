package dao;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import db.Conector;
import log.FicheroLog;
import model.Ciudad;

public class GestionCiudades {

	// Se encarga de agregar una nueva ciudad a la base de datos
	public void agregarCiudad(Ciudad ciudad) throws SQLException, IOException {

		String query = "insert into ciudad(codigo, nombre, ubicacion) values(?, ?, ?)";

		PreparedStatement ps = Conector.getConexion().prepareStatement(query);

		ps.setString(1, ciudad.getCodigo());
		ps.setString(2, ciudad.getNombre());
		ps.setString(3, ciudad.getUbicacion());

		ps.executeUpdate();

		FicheroLog.escribir("Se ha insertado una nueva ciudad en la base de datos: " + ciudad.getCodigo());

		ps.close();

	}

	// Muestra un listado de todas las ciudades ingresadas en la base de datos
	public ArrayList<Ciudad> mostrarCiudades() throws SQLException, IOException {

		ArrayList<Ciudad> ciudades = new ArrayList<>();

		String query = "select * from ciudad";

		PreparedStatement ps = Conector.getConexion().prepareStatement(query);

		ResultSet result = ps.executeQuery();

		while (result.next()) {

			Ciudad c = new Ciudad(result.getString(1), result.getString(2), result.getString(3));

			ciudades.add(c);

		}

		result.close();
		ps.close();

		FicheroLog.escribir("Se ha consultado la base de datos");

		return ciudades;
	}

	// Busca una ciudad mediante su codigo
	public ArrayList<Ciudad> mostrarCiudadesPorCodigo(String codigo) throws SQLException, IOException {

		ArrayList<Ciudad> ciudades = new ArrayList<>();

		String query = "select * from ciudad where codigo = ?";

		PreparedStatement ps = Conector.getConexion().prepareStatement(query);

		ps.setString(1, codigo);

		ResultSet result = ps.executeQuery();

		while (result.next()) {

			Ciudad c = new Ciudad(result.getString(1), result.getString(2), result.getString(3));

			ciudades.add(c);

		}

		result.close();
		ps.close();

		FicheroLog.escribir("Se ha consultado la base de datos las ciudades con el codigo " + codigo);

		return ciudades;
	}

	// Actualiza la ubicacion de una cuidad
	public void actualizarCiudad(String codigo, String nombre, String ubicacion) throws SQLException, IOException {

		String query = "update ciudad set ubicacion = ?" + " where codigo = ? and nombre = ?";

		PreparedStatement ps = Conector.getConexion().prepareStatement(query);

		ps.setString(1, ubicacion);
		ps.setString(2, codigo);
		ps.setString(3, nombre);

		ps.executeUpdate();

		FicheroLog.escribir("Se actualizo la informacion de la ciudad " + nombre + " correctamente");

		ps.close();

	}

	// Elimina una ciudad de la base de datos
	public boolean eliminarCiudad(String codigo, String nombre) throws SQLException, IOException {

		String query = "delete from ciudad where codigo = ? and nombre = ?";

		PreparedStatement ps = Conector.getConexion().prepareStatement(query);

		ps.setString(1, codigo);
		ps.setString(2, nombre);

		int resultado = ps.executeUpdate();

		ps.close();

		if (resultado > 0) {

			FicheroLog.escribir("Se ha eliminado la ciudad " + nombre + " correctamente");
			return true;

		} else {

			FicheroLog.escribir("Se ha intentado eliminar una ciudad pero no tuvo efecto");
			return false;
		}

	}

	// Devuelve la cantidad de ciudades ingresadas en la base de datos
	public int contadorCiudades() throws SQLException, IOException {
		int numeroCiudades = 0;

		String query = "select count(*) from ciudad";

		PreparedStatement ps = Conector.getConexion().prepareStatement(query);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			numeroCiudades = rs.getInt(1);
		}

		rs.close();
		ps.close();

		FicheroLog.escribir("Se ha consultado el numero de ciudades de la base de datos");

		return numeroCiudades;

	}
	
	// Consulta las ediciones que se daran a cabo en una ciudad, requiere pasar el codigo de la ciudad como parametro para mostrar la informacion
	public String mostrarEdicionesPorCiudad(String codigoCiudad) throws SQLException, IOException{
		
		
		String contenido = "";
		
		String query = "CALL EVENTOSPORCIUDAD(?)";
		
		CallableStatement ps = Conector.getConexion().prepareCall(query);
		
		ps.setString(1, codigoCiudad);
	
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			contenido += ("Edicion: " + rs.getString(1) + "\n" +
					"Fecha de inicio: " + rs.getDate(2) + "\n" +
					"Fecha de finalizacion: " + rs.getDate(3) + "\n" );
			
		}
		
		rs.close();
		ps.close();
		
		FicheroLog.escribir("Se ha consultado las ediciones que se daran acabo en la ciudad con el codigo " + codigoCiudad);
		
		return contenido;
		
		
	}

}
