package view;

import java.awt.Font;

import javax.swing.*;
import java.awt.Color;

public class RegisterView extends JFrame {
	
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtFechaNac;
	private JTextField txtCiudadNac;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private JTextField txtContrasena;
	private JTextField txtConfirmContrasena;
	
	public RegisterView() {
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));
		setTitle("RockTheSport user");
		setSize(528, 307);
		getContentPane().setLayout(null);
		setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 107, 215));
		panel.setBounds(0, 0, 147, 268);
		getContentPane().add(panel);
		
		txtDni = new JTextField();
		txtDni.setText("DNI");
		txtDni.setToolTipText("");
		txtDni.setBounds(168, 35, 124, 20);
		getContentPane().add(txtDni);
		txtDni.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setText("Nombre");
		txtNombre.setColumns(10);
		txtNombre.setBounds(168, 80, 124, 20);
		getContentPane().add(txtNombre);
		
		txtApellidos = new JTextField();
		txtApellidos.setText("Apellidos");
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(168, 120, 124, 20);
		getContentPane().add(txtApellidos);
		
		txtFechaNac = new JTextField();
		txtFechaNac.setText("Fecha de nacimiento");
		txtFechaNac.setColumns(10);
		txtFechaNac.setBounds(168, 160, 124, 20);
		getContentPane().add(txtFechaNac);
		
		txtCiudadNac = new JTextField();
		txtCiudadNac.setText("Ciudad de nacimiento");
		txtCiudadNac.setColumns(10);
		txtCiudadNac.setBounds(168, 203, 124, 20);
		getContentPane().add(txtCiudadNac);
		
		txtEmail = new JTextField();
		txtEmail.setText("Email");
		txtEmail.setColumns(10);
		txtEmail.setBounds(358, 35, 124, 20);
		getContentPane().add(txtEmail);
		
		txtTelefono = new JTextField();
		txtTelefono.setText("Telefono");
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(358, 80, 124, 20);
		getContentPane().add(txtTelefono);
		
		txtContrasena = new JTextField();
		txtContrasena.setText("Contraseña");
		txtContrasena.setColumns(10);
		txtContrasena.setBounds(358, 120, 124, 20);
		getContentPane().add(txtContrasena);
		
		txtConfirmContrasena = new JTextField();
		txtConfirmContrasena.setText(" Confirmar contrasena");
		txtConfirmContrasena.setColumns(10);
		txtConfirmContrasena.setBounds(358, 160, 124, 20);
		getContentPane().add(txtConfirmContrasena);
		
		JButton botonRegistrarse = new JButton("Registrarse");
		botonRegistrarse.setBounds(374, 202, 89, 23);
		getContentPane().add(botonRegistrarse);
		
		setVisible(true);
		

	}
}
