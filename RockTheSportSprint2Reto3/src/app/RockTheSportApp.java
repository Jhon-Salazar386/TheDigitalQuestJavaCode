package app;
import db.Conector;
import view.VistaGeneral;

import java.io.IOException;
import java.sql.SQLException;

public class RockTheSportApp {

	public static void main(String[]args) throws SQLException, IOException {

		VistaGeneral generalView = new VistaGeneral();

		Conector.conectar();
		
		generalView.menuGeneral();
		
        Conector.cerrarConexion();
		
	}

}
