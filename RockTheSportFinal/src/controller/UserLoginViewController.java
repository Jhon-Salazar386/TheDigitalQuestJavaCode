package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.DeportistaDao;
import dao.EdicionDao;
import dao.InscripcionDao;
import model.Deportista;
import model.UserSession;
import view.MisInscripcionesView;
import view.UserLoginView;
import view.UserView;

public class UserLoginViewController {

	private UserLoginView vistaLogin;
	private DeportistaDao gestorDeportista;
	
	public UserLoginViewController(UserLoginView vistaLogin, DeportistaDao gestorDeportista) {
		this.vistaLogin = vistaLogin;
		this.gestorDeportista = gestorDeportista;
		
		vistaLogin.getBotonIniciar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					iniciarSesion();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
		vistaLogin.getBotonSalir().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				UserView userView = new UserView();
				try {
					UserViewController userViewController = new UserViewController(userView, new EdicionDao(), new InscripcionDao());
					userViewController.iniciar();
					vistaLogin.dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
	}
	
	public void iniciarSesion() throws SQLException, IOException {
		
		String dni = vistaLogin.getTextFieldDni().getText();
		
		if(dni == null || dni.isBlank()) {
			JOptionPane.showMessageDialog(vistaLogin, "Ingrese su DNI");
			return;
		}
		
		ArrayList<Deportista> deportista = gestorDeportista.buscarPorDni(dni);
		
		if(deportista.isEmpty()) {
			JOptionPane.showMessageDialog(vistaLogin, "No encontrado");
			return;
		}
		
		UserSession.setDni(dni);
		
		MisInscripcionesViewController misInscripcionesViewController = new MisInscripcionesViewController(new MisInscripcionesView(), new InscripcionDao());
		misInscripcionesViewController.iniciar();
		
		vistaLogin.dispose();
		
	}
	
	public void iniciar() {
		vistaLogin.setVisible(true);
	}
	
}
