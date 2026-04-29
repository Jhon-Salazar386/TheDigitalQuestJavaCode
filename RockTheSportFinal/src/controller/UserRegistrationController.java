package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.*;

import dao.DeportistaDao;
import dao.EdicionDao;
import dao.InscripcionDao;
import model.Deportista;
import util.Validaciones;
import view.UserRegistrationView;
import view.UserView;

public class UserRegistrationController {

	private UserRegistrationView userRegistrationView;
	private DeportistaDao gestorDeportista;

	public UserRegistrationController(UserRegistrationView userRegistrationView, DeportistaDao gestorDeportista) {
		this.userRegistrationView = userRegistrationView;
		this.gestorDeportista = gestorDeportista;
		
		
		userRegistrationView.getBotonRegistrarse().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				crearCuenta();
			}
		});

		userRegistrationView.getBotonVolver().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				volver();
			}
		});

	}

	public void crearCuenta() {

		String dni = userRegistrationView.getTxtDni().getText();
		String nombre = userRegistrationView.getTxtNombre().getText();
		String apellidos = userRegistrationView.getTxtApellidos().getText();
		String genero = userRegistrationView.getTxtGenero().getText();
		String fecha = userRegistrationView.getTxtFecha().getText();
		String ciudad = userRegistrationView.getTxtCiudad().getText();
		String email = userRegistrationView.getTxtEmail().getText();
		String telefono = userRegistrationView.getTxtTelefono().getText();

		if (!Validaciones.validarDNI(dni)) {
			JOptionPane.showMessageDialog(null, "DNI inválido. Debe tener 8 números y 1 letra.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (!Validaciones.validarFecha(fecha)) {
			JOptionPane.showMessageDialog(null, "Fecha inválida. Formato correcto: yyyy-MM-dd", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (!Validaciones.validarGenero(genero)) {
			JOptionPane.showMessageDialog(null, "Género inválido. Solo: hombre, mujer u otros.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (!Validaciones.validarEmail(email)) {
			JOptionPane.showMessageDialog(null, "Email inválido.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (!Validaciones.validarTelefono(telefono)) {
			JOptionPane.showMessageDialog(null, "Teléfono inválido. Debe tener entre 9 y 15 dígitos.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(nombre.isBlank() || apellidos.isBlank()) {
			JOptionPane.showMessageDialog(null, "No puede haber campos vacios(Excepto ciudad)", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		try {
			Deportista deportista = new Deportista(dni, nombre, apellidos, genero, Date.valueOf(fecha), ciudad, email, telefono);
			
			gestorDeportista.insertar(deportista);
			
			JOptionPane.showMessageDialog(userRegistrationView, "Registro completado");
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		volver();

	}
	
	public void volver() {
		UserView userView = new UserView();
		try {
			UserViewController userViewController = new UserViewController(userView, new EdicionDao(),
					new InscripcionDao());

			userViewController.iniciar();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		userRegistrationView.dispose();
	}

	public void iniciar() {
		userRegistrationView.setVisible(true);
	}

}
