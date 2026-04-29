package main;

import db.Conector;
import log.FicheroLog;
import view.UserView;
import view.VistaGeneral;

import java.io.IOException;
import java.sql.SQLException;

import controller.UserViewController;
import dao.EdicionDao;
import dao.InscripcionDao;

public class RockTheSportApp {

	public static void main(String[] args) throws SQLException, IOException {

		
		VistaGeneral generalView = new VistaGeneral();
		
		try {

			FicheroLog.abrirBufferedWriter();

			Conector.conectar();
			
			UserView userView = new UserView();
			
			UserViewController controller = new UserViewController(userView, new EdicionDao(), new InscripcionDao());
			controller.iniciar();
						
			/*Conector.cerrarConexion();

			FicheroLog.cerrarBufferedWriter();*/

		} catch (IOException io) {
			System.out.println("Error en la entrada/salida de datos" + io.getMessage());
		} catch (SQLException sq) {
			System.out.println("Error sql" + sq.getMessage());
		} catch (Exception e) {
			System.out.println("Error inesperado " + e.getMessage());
		}

	}

}
