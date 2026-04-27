package view;

import java.awt.Color;
import java.awt.Font;
import model.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class UserView extends JFrame {
	
	private DefaultListModel<Edicion> modeloEdicion;
	private JList<Edicion> listaEdiciones;
	private JButton botonBuscar;
	private JButton botonMisInscripciones;
	private JButton botonRegistrarse;
	private JButton botonSalir;

	public UserView() {

		setTitle("RockTheSport user");
		setSize(528, 307);
		getContentPane().setLayout(null);
		setResizable(false);

		JPanel header = new JPanel();
		header.setBounds(0, 0, 511, 29);
		header.setBackground(new Color(34, 162, 210));
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		getContentPane().add(header);

		JLabel rockTheSportIcon = new JLabel("");
		rockTheSportIcon.setIcon(new ImageIcon("C:\\Users\\Jhond\\Downloads\\LogoRTS (1).png"));
		header.add(rockTheSportIcon);

		JLabel headerTitle = new JLabel("RockTheSport user manager");
		headerTitle.setForeground(new Color(255, 255, 255));
		headerTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		header.add(headerTitle);

		JPanel userButtonsPanel = new JPanel();
		userButtonsPanel.setBackground(new Color(251, 253, 255));
		userButtonsPanel.setBounds(397, 28, 114, 234);
		userButtonsPanel.setLayout(null);
		getContentPane().add(userButtonsPanel);

		JLabel buttonsPaneLabel = new JLabel("Opciones");
		buttonsPaneLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonsPaneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		buttonsPaneLabel.setBounds(6, 11, 101, 14);
		userButtonsPanel.add(buttonsPaneLabel);

		botonBuscar = new JButton("Buscar edicion");
		botonBuscar.setBounds(6, 36, 101, 25);
		userButtonsPanel.add(botonBuscar);

		botonMisInscripciones = new JButton("Inscripciones");
		botonMisInscripciones.setBounds(6, 70, 101, 25);
		userButtonsPanel.add(botonMisInscripciones);

		botonRegistrarse = new JButton("Registrarse");
		botonRegistrarse.setBounds(6, 104, 101, 25);
		userButtonsPanel.add(botonRegistrarse);

		botonSalir = new JButton("Salir");
		botonSalir.setBounds(6, 199, 101, 25);
		userButtonsPanel.add(botonSalir);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 377, 222);
		getContentPane().add(scrollPane);

		JLabel listLabel = new JLabel("Ediciones");
		listLabel.setHorizontalAlignment(SwingConstants.CENTER);
		listLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollPane.setColumnHeaderView(listLabel);
		
		modeloEdicion = new DefaultListModel<>();

		listaEdiciones = new JList<>(modeloEdicion);
		listaEdiciones.setBackground(new Color(251, 253, 255));
		listaEdiciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listaEdiciones);
		
		setVisible(true);
		
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