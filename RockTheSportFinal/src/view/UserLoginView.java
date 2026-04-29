package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class UserLoginView extends JFrame {

	private JTextField textFieldDni;
	private JButton botonIniciar;
	private JButton botonSalir;

	public UserLoginView() {

		// Configuración del JFrame
		setTitle("RockTheSport login pane");
		setSize(606, 368);
		setResizable(false);
		getContentPane().setLayout(null);
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));

		// Panel lateral
		JPanel panelBanner = new JPanel();
		panelBanner.setBounds(0, 0, 156, 329);
		panelBanner.setBackground(new Color(34, 162, 210));
		panelBanner.setLayout(new BorderLayout());
		getContentPane().add(panelBanner);

		JLabel labelTituloApp = new JLabel("RockTheSport");
		labelTituloApp.setForeground(Color.WHITE);
		labelTituloApp.setFont(new Font("Arial", Font.BOLD, 18));
		labelTituloApp.setHorizontalAlignment(SwingConstants.CENTER);
		panelBanner.add(labelTituloApp, BorderLayout.CENTER);

		// Título del formulario
		JLabel labelTituloForm = new JLabel("Inicio de sesion");
		labelTituloForm.setBounds(292, 95, 179, 30);
		labelTituloForm.setFont(new Font("Arial", Font.BOLD, 21));
		labelTituloForm.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(labelTituloForm);

		// Label DNI
		JLabel labelDni = new JLabel("Ingrese su DNI");
		labelDni.setBounds(292, 136, 179, 14);
		labelDni.setFont(new Font("Arial", Font.BOLD, 14));
		labelDni.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(labelDni);

		// Campo DNI
		textFieldDni = new JTextField();
		textFieldDni.setBounds(292, 163, 179, 20);
		textFieldDni.setColumns(10);
		getContentPane().add(textFieldDni);
		labelDni.setLabelFor(textFieldDni);

		// Botónes
		botonIniciar = new JButton("Iniciar sesion");
		botonIniciar.setFont(new Font("Arial", Font.BOLD, 11));
		botonIniciar.setBounds(323, 205, 114, 30);
		getContentPane().add(botonIniciar);
		
		botonSalir = new JButton("Volver");
		botonSalir.setFont(new Font("Arial", Font.BOLD, 11));
		botonSalir.setBounds(337, 246, 89, 23);
		getContentPane().add(botonSalir);
	}

	public JTextField getTextFieldDni() {
		return textFieldDni;
	}

	public JButton getBotonIniciar() {
		return botonIniciar;
	}

	public JButton getBotonSalir() {
		return botonSalir;
	}
	
}