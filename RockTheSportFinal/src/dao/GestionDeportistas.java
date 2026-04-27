package dao;

import model.Deportista;
import java.util.ArrayList;
import java.sql.*;
import java.io.*;
import db.Conector;
import log.FicheroLog;

public class GestionDeportistas {

	// Inserta un deportista en la base de datos
	public void insertar(Deportista d) throws SQLException, IOException {

		String query = "INSERT INTO Deportista(dni, nombre, apellidos, genero, fechaNac, ciudadNac, email, telefono) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement ps = Conector.getConexion().prepareStatement(query);

		ps.setString(1, d.getDni());
		ps.setString(2, d.getNombre());
		ps.setString(3, d.getApellido());
		ps.setString(4, d.getGenero());
		ps.setDate(5, d.getFechaNac());
		ps.setString(6, d.getCiudadNac());
		ps.setString(7, d.getEmail());
		ps.setString(8, d.getTelefono());

		ps.executeUpdate();

		FicheroLog.escribir("Insertado deportista con ID " + d.getDni());
	}

	// Devuelve un arrayList que contiene todos los deportistas de la base de datos
	public ArrayList<Deportista> listar() throws SQLException, IOException {

		ArrayList<Deportista> lista = new ArrayList<>();

		String query = "SELECT * FROM Deportista";

		PreparedStatement ps = Conector.getConexion().prepareStatement(query);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			lista.add(new Deportista(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
					rs.getString(6), rs.getString(7), rs.getString(8)));
		}

		FicheroLog.escribir("Se ha consultado el listado de deportistas");

		rs.close();
		ps.close();

		return lista;
	}

	// Se encarga de buscar a un deportista en especifico mediante su dni
	public ArrayList<Deportista> buscarPorDni(String dni) throws SQLException, IOException {

		ArrayList<Deportista> lista = new ArrayList<>();

		String query = "SELECT * FROM Deportista where dni = ?";

		PreparedStatement ps = Conector.getConexion().prepareStatement(query);

		ps.setString(1, dni);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			lista.add(new Deportista(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
					rs.getString(6), rs.getString(7), rs.getString(8)));
		}

		FicheroLog.escribir("Se ha buscado al deportista con el dni " + dni);

		rs.close();
		ps.close();

		return lista;
	}

	// Actualiza el email de un deportista registrado
	public void actualizarEmail(String dni, String email) throws SQLException, IOException {

		if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
			throw new IllegalArgumentException("El email no es válido");
		}

		String query = "update deportista set email = ?" + " where dni = ?";

		PreparedStatement ps = Conector.getConexion().prepareStatement(query);

		ps.setString(1, email);
		ps.setString(2, dni);

		ps.executeUpdate();

		ps.close();

		FicheroLog.escribir("Se actualizo el email del deportista con el dni " + dni + " a " + email);

	}

	// Actualiza el numero de telefono
	public void actualizarTelefono(String dni, String telefono) throws SQLException, IOException {

		String query = "update deportista set Telefono = ?" + " where dni = ?";

		PreparedStatement ps = Conector.getConexion().prepareStatement(query);

		ps.setString(1, telefono);
		ps.setString(2, dni);

		ps.executeUpdate();

		ps.close();

		FicheroLog.escribir("Se actualizo el numero de telefono del deportista con el dni " + dni + " a " + telefono);

	}
	
	// Elimina un deportista de la base de datos
	public String eliminar(String dni) throws SQLException, IOException {

		String mensaje = "";
		String query = "CALL BAJADEPORTISTA(?, ?)";

		CallableStatement ps = Conector.getConexion().prepareCall(query);

		ps.setString(1, dni);

		ps.executeUpdate();

		mensaje = ps.getString(2);
		
		ps.close();

		return mensaje;

	}
	/*
	// Elimina un deportista de la base de datos
	public boolean eliminar(String dni) throws SQLException, IOException {

		String query = "DELETE FROM Deportista WHERE DNI = ?";

		PreparedStatement ps = Conector.getConexion().prepareStatement(query);

		ps.setString(1, dni);

		int resultado = ps.executeUpdate();

		ps.close();

		if (resultado > 0) {

			FicheroLog.escribir("Se ha eliminado al deportista con el dni " + dni + " correctamente");
			return true;

		} else {

			FicheroLog.escribir("Se ha intentado eliminar un deportista pero no tuvo efecto");
			return false;
		}

	}
	*/
	// Devuelve el numero de deportistas registrados en la base de datos
	public int contadorDeportistas() throws SQLException, IOException {

		int numeroDeportistas = 0;

		String query = "select count(*) from deportista";

		PreparedStatement ps = Conector.getConexion().prepareStatement(query);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			numeroDeportistas = rs.getInt(1);
		}

		rs.close();
		ps.close();

		FicheroLog.escribir("Se ha consultado el numero de deportistas en la base de datos");

		return numeroDeportistas;

	}
	
	public String mejorTiempoDeportista(String dni) throws SQLException, IOException{
		
		String contenido = "";
		
		String query = "SELECT MEJORTIEMPODEPORTISTA(?)";

		CallableStatement ps = Conector.getConexion().prepareCall(query);
		
		ps.setString(1, dni);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			contenido += rs.getString(1);
			
		}

		FicheroLog.escribir("Se ha consultado el mejor tiempo del deportistas " + dni);

		rs.close();
		ps.close();

		return contenido;
		
		
	}

}
