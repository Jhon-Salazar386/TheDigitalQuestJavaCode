package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import model.Inscripcion;

public class MisInscripcionesView extends JFrame {

	private DefaultListModel<Inscripcion> inscripcionListModel;
	private JList<Inscripcion> inscripcionList;
	private JButton botonDetalles;
	private JButton botonEliminar;
	private JButton botonVolver;

	public MisInscripcionesView() {

		setTitle("RockTheSport user");
		setSize(606, 368);
		setResizable(false);
		getContentPane().setLayout(null);
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));

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

		// Lista de inscripciones
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(132, 40, 448, 278);
		getContentPane().add(scrollPane);

		JLabel listLabel = new JLabel("Mis inscripciones");
		listLabel.setHorizontalAlignment(SwingConstants.CENTER);
		listLabel.setFont(new Font("Arial", Font.BOLD, 14));
		scrollPane.setColumnHeaderView(listLabel);

		inscripcionListModel = new DefaultListModel<>();

		inscripcionList = new JList<>(inscripcionListModel);
		inscripcionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(inscripcionList);

		// Botones
		botonDetalles = new JButton("Ver detalles");
		botonDetalles.setFont(new Font("Arial", Font.BOLD, 12));
		botonDetalles.setBounds(16, 46, 102, 25);
		getContentPane().add(botonDetalles);

		botonEliminar = new JButton("Eliminar");
		botonEliminar.setFont(new Font("Arial", Font.BOLD, 13));
		botonEliminar.setBounds(16, 82, 102, 25);
		getContentPane().add(botonEliminar);

		botonVolver = new JButton("Volver");
		botonVolver.setFont(new Font("Arial", Font.BOLD, 13));
		botonVolver.setBounds(16, 293, 101, 25);
		getContentPane().add(botonVolver);

	}

	public DefaultListModel<Inscripcion> getInscripcionListModel() {
		return inscripcionListModel;
	}

	public JList<Inscripcion> getInscripcionList() {
		return inscripcionList;
	}

	public JButton getBotonDetalles() {
		return botonDetalles;
	}

	public JButton getBotonEliminar() {
		return botonEliminar;
	}

	public JButton getBotonVolver() {
		return botonVolver;
	}
}