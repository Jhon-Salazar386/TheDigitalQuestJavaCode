package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import model.Edicion;

public class UserView extends JFrame {

	private DefaultListModel<Edicion> modeloEdicion;
	private JList<Edicion> listaEdiciones;
	private JButton botonBuscar;
	private JButton botonMisInscripciones;
	private JButton botonRegistrarse;
	private JButton botonSalir;

	public UserView() {

		setTitle("RockTheSport user");
		setSize(606, 368);
		setResizable(false);
		getContentPane().setLayout(null);

		// Header
		JPanel header = new JPanel();
		header.setBounds(0, 0, 590, 29);
		header.setBackground(new Color(34, 162, 210));
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		getContentPane().add(header);

		JLabel headerTitle = new JLabel(" RockTheSport user manager");
		headerTitle.setForeground(Color.WHITE);
		headerTitle.setFont(new Font("Arial", Font.BOLD, 15));
		header.add(headerTitle);

		// Panel de botones
		JPanel userButtonsPanel = new JPanel();
		userButtonsPanel.setBounds(439, 28, 151, 301);
		userButtonsPanel.setBackground(new Color(251, 253, 255));
		userButtonsPanel.setLayout(null);
		getContentPane().add(userButtonsPanel);

		JLabel buttonsPaneLabel = new JLabel("Opciones");
		buttonsPaneLabel.setBounds(10, 11, 132, 14);
		buttonsPaneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		buttonsPaneLabel.setFont(new Font("Arial", Font.BOLD, 15));
		userButtonsPanel.add(buttonsPaneLabel);

		// Botones
		botonBuscar = new JButton("Buscar edicion");
		botonBuscar.setFont(new Font("Arial", Font.BOLD, 13));
		botonBuscar.setBounds(10, 36, 132, 25);
		userButtonsPanel.add(botonBuscar);

		botonMisInscripciones = new JButton("Mis Inscripciones");
		botonMisInscripciones.setFont(new Font("Arial", Font.BOLD, 11));
		botonMisInscripciones.setBounds(10, 72, 132, 25);
		userButtonsPanel.add(botonMisInscripciones);

		botonRegistrarse = new JButton("Crear cuenta");
		botonRegistrarse.setFont(new Font("Arial", Font.BOLD, 13));
		botonRegistrarse.setBounds(10, 108, 132, 25);
		userButtonsPanel.add(botonRegistrarse);

		botonSalir = new JButton("Salir");
		botonSalir.setFont(new Font("Arial", Font.BOLD, 13));
		botonSalir.setBounds(20, 265, 112, 25);
		userButtonsPanel.add(botonSalir);

		// Listado de ediciones
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 417, 278);
		getContentPane().add(scrollPane);

		// Encabezado para la lista
		JLabel listLabel = new JLabel("Ediciones");
		listLabel.setHorizontalAlignment(SwingConstants.CENTER);
		listLabel.setFont(new Font("Arial", Font.BOLD, 14));
		scrollPane.setColumnHeaderView(listLabel);

		modeloEdicion = new DefaultListModel<>();

		listaEdiciones = new JList<>(modeloEdicion);
		listaEdiciones.setBackground(new Color(251, 253, 255));
		listaEdiciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listaEdiciones);

	}

	public DefaultListModel<Edicion> getModeloEdicion() {
		return modeloEdicion;
	}

	public JList<Edicion> getListaEdiciones() {
		return listaEdiciones;
	}

	public JButton getBotonBuscar() {
		return botonBuscar;
	}

	public JButton getBotonMisInscripciones() {
		return botonMisInscripciones;
	}

	public JButton getBotonRegistrarse() {
		return botonRegistrarse;
	}

	public JButton getBotonSalir() {
		return botonSalir;
	}
}