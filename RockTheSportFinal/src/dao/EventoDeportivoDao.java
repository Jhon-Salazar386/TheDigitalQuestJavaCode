package dao;

import java.sql.*;
import java.io.*;
import java.util.ArrayList;
import db.Conector;
import log.FicheroLog;
import model.*;

public class EventoDeportivoDao {

	// Inserta el evento base(clase padre)
	public int insertarEventoDeportivo(EventoDeportivo e) throws SQLException, IOException {

		String query = "INSERT INTO Evento_Deportivo (Modalidad, Tipo_Evento, Descr, Edad_Req, Requisitos) VALUES (?, ?, ?, ?, ?)";
		int idEvento = 0;

		PreparedStatement ps = Conector.getConexion().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

		ps.setString(1, e.getModalidad());
		ps.setString(2, e.getTipoEvento());
		ps.setString(3, e.getDescripcion());
		ps.setInt(4, e.getEdadReq());
		ps.setString(5, e.getRequisitos());

		ps.executeUpdate();

		ResultSet rs = ps.getGeneratedKeys();

		if (rs.next()) {
			idEvento = rs.getInt(1);
		}

		rs.close();
		ps.close();

		return idEvento;
	}

	// Se encarga de agregar un evento individual a la base de datos
	public void insertarEventoIndividual(EventoIndividual ei) throws SQLException, IOException {

		int idEvento = insertarEventoDeportivo(ei);

		String query = "INSERT INTO Eventos_Individuales (ID_Evento, nivel, NumeroParticipantes) VALUES (?, ?, ?)";

		PreparedStatement ps = Conector.getConexion().prepareStatement(query);

		ps.setInt(1, idEvento);
		ps.setString(2, ei.getNivel());
		ps.setInt(3, ei.getMaxParticipantes());

		ps.executeUpdate();

		ps.close();

		FicheroLog.escribir("Se ha insertado un nuevo evento individual de tipo " + ei.getTipoEvento());
	}

	// Se encarga de insertar un evento grupal a la base de datos
	public void insertarEventoGrupal(EventoGrupal eg) throws SQLException, IOException {

		int idEvento = insertarEventoDeportivo(eg);

		String query = "INSERT INTO Eventos_Grupales (ID_Evento, Nombre_Equipo, Num_Participantes) VALUES (?, ?, ?)";

		PreparedStatement ps = Conector.getConexion().prepareStatement(query);

		ps.setInt(1, idEvento);
		ps.setString(2, eg.getNombreEquipo());
		ps.setInt(3, eg.getNumeroParticipantes());

		ps.executeUpdate();

		FicheroLog.escribir("Insertado evento grupal con ID " + idEvento);
	}

	// Muestra un listado de todos los eventos de la base de datos
	public ArrayList<EventoDeportivo> listar() throws SQLException, IOException {

		ArrayList<EventoDeportivo> lista = new ArrayList<>();

		String query = "SELECT * FROM Evento_Deportivo";

		PreparedStatement ps = Conector.getConexion().prepareStatement(query);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			EventoDeportivo e = new EventoDeportivo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getInt(5), rs.getString(6)

			);

			lista.add(e);
		}

		rs.close();
		ps.close();

		FicheroLog.escribir("Listado de eventos deportivos");

		return lista;
	}

	// Busca un evento mediante su tipo(Futball, Maraton, Boxeo, entre otros)
	public ArrayList<EventoDeportivo> buscarEventoPorTipo(String tipo) throws SQLException, IOException {

		ArrayList<EventoDeportivo> lista = new ArrayList<>();

		String query = "SELECT * FROM Evento_Deportivo where Tipo_Evento = ?";

		PreparedStatement ps = Conector.getConexion().prepareStatement(query);

		ps.setString(1, tipo);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			EventoDeportivo e = new EventoDeportivo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getInt(5), rs.getString(6)

			);

			lista.add(e);
		}

		rs.close();
		ps.close();

		FicheroLog.escribir("Se a realizado una busqueda del evento " + tipo);

		return lista;
	}

	// Actualiza la descripcion de un evento deportivo
	public void actualizar(int id, String descr) throws SQLException, IOException {

		String query = "UPDATE Evento_Deportivo SET Descr = ? WHERE ID = ?";

		PreparedStatement ps = Conector.getConexion().prepareStatement(query);

		ps.setString(1, descr);
		ps.setInt(2, id);

		ps.executeUpdate();

		FicheroLog.escribir("Evento actualizado ID: " + id);
	}

	// Elimina un evento de la base de datos
	public boolean eliminar(int id) throws SQLException, IOException {

		String query = "DELETE FROM Evento_Deportivo WHERE ID = ?";

		PreparedStatement ps = Conector.getConexion().prepareStatement(query);

		ps.setInt(1, id);

		int resultado = ps.executeUpdate();

		ps.close();

		if (resultado > 0) {

			FicheroLog.escribir("Se ha eliminado el evento con el id " + id + " correctamente");
			return true;

		} else {

			FicheroLog.escribir("Se ha intentado eliminar un evento deportivo pero no tuvo efecto");
			return false;
		}
	}

	// Contador de eventos ingresados en la base de datos
	public int contadorEventos() throws SQLException, IOException {
		int numeroEventos = 0;

		String query = "select count(*) from Evento_Deportivo";

		PreparedStatement ps = Conector.getConexion().prepareStatement(query);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			numeroEventos = rs.getInt(1);
		}

		rs.close();
		ps.close();

		FicheroLog.escribir("Se ha consultado el numero de eventos de la base de datos");

		return numeroEventos;

	}

}