package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.BorderLayout;

public class UserRegistrationView extends JFrame {
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtGenero;
	private JTextField txtFecha;
	private JTextField txtCiudad;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	
	private JButton botonVolver;
	private JButton botonRegistrarse;
	private JLabel labelTituloApp;

	public UserRegistrationView() {

		// Configuracion
		setTitle("RockTheSport user");
		setSize(606, 368);
		setResizable(false);
		getContentPane().setLayout(null);
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));

		// Panel lateral
		JPanel panelLateral = new JPanel();
		panelLateral.setBounds(0, 0, 165, 329);
		panelLateral.setBackground(new Color(34, 162, 210));
		getContentPane().add(panelLateral);
		panelLateral.setLayout(new BorderLayout(0, 0));
		
		labelTituloApp = new JLabel("RockTheSport");
		labelTituloApp.setHorizontalAlignment(SwingConstants.CENTER);
		labelTituloApp.setForeground(new Color(255, 255, 255));
		labelTituloApp.setFont(new Font("Arial", Font.BOLD, 18));
		panelLateral.add(labelTituloApp, BorderLayout.CENTER);
		
		// Labels para campos de texto
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Arial", Font.BOLD, 11));
		lblDni.setBounds(208, 20, 105, 14);
		getContentPane().add(lblDni);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 11));
		lblNombre.setBounds(208, 88, 105, 14);
		getContentPane().add(lblNombre);

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Arial", Font.BOLD, 11));
		lblApellidos.setBounds(208, 151, 105, 14);
		getContentPane().add(lblApellidos);

		JLabel lblGenero = new JLabel("Género");
		lblGenero.setFont(new Font("Arial", Font.BOLD, 11));
		lblGenero.setBounds(208, 218, 105, 14);
		getContentPane().add(lblGenero);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Arial", Font.BOLD, 11));
		lblFecha.setBounds(426, 20, 105, 14);
		getContentPane().add(lblFecha);

		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setFont(new Font("Arial", Font.BOLD, 11));
		lblCiudad.setBounds(426, 88, 105, 14);
		getContentPane().add(lblCiudad);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 11));
		lblEmail.setBounds(426, 151, 105, 14);
		getContentPane().add(lblEmail);

		JLabel lblTelefono = new JLabel("Teléfono");
		lblTelefono.setFont(new Font("Arial", Font.BOLD, 11));
		lblTelefono.setBounds(426, 218, 105, 14);
		getContentPane().add(lblTelefono);

		// Campo de texto
		txtDni = new JTextField();
		txtDni.setBounds(208, 45, 105, 20);
		getContentPane().add(txtDni);
		txtDni.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setBounds(208, 113, 105, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		txtApellidos = new JTextField();
		txtApellidos.setBounds(208, 176, 105, 20);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);

		txtGenero = new JTextField();
		txtGenero.setBounds(208, 243, 105, 20);
		getContentPane().add(txtGenero);
		txtGenero.setColumns(10);

		txtFecha = new JTextField();
		txtFecha.setText("yyyy-MM-dd");
		txtFecha.setBounds(426, 45, 105, 20);
		getContentPane().add(txtFecha);
		txtFecha.setColumns(10);

		txtCiudad = new JTextField();
		txtCiudad.setBounds(426, 113, 105, 20);
		getContentPane().add(txtCiudad);
		txtCiudad.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(426, 176, 105, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(426, 243, 105, 20);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		// Panel para guardar los botones
		JPanel Botones = new JPanel();
		Botones.setBounds(269, 286, 222, 32);
		getContentPane().add(Botones);

		// Botones
		botonVolver = new JButton("Volver");
		botonVolver.setFont(new Font("Arial", Font.BOLD, 11));
		Botones.add(botonVolver);

		botonRegistrarse = new JButton("Registrarse");
		botonRegistrarse.setFont(new Font("Arial", Font.BOLD, 11));
		Botones.add(botonRegistrarse);
		
	}

	public JTextField getTxtDni() {
		return txtDni;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtApellidos() {
		return txtApellidos;
	}

	public JTextField getTxtGenero() {
		return txtGenero;
	}

	public JTextField getTxtFecha() {
		return txtFecha;
	}

	public JTextField getTxtCiudad() {
		return txtCiudad;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public JButton getBotonVolver() {
		return botonVolver;
	}

	public JButton getBotonRegistrarse() {
		return botonRegistrarse;
	}
	
}