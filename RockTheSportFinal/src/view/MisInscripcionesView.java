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
	private JButton botonSalir;

	public MisInscripcionesView() {
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));
		setTitle("RockTheSport user");
		setSize(528, 307);
		getContentPane().setLayout(null);
		setResizable(false);

		JPanel header = new JPanel();
		header.setBounds(0, 0, 511, 29);
		header.setBackground(new Color(34, 162, 210));
		getContentPane().add(header);
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

		JLabel rockTheSportIcon = new JLabel("");
		header.add(rockTheSportIcon);
		rockTheSportIcon.setIcon(new ImageIcon("C:\\Users\\Jhond\\Downloads\\LogoRTS (1).png"));

		JLabel headerTitle = new JLabel("RockTheSport user manager");
		header.add(headerTitle);
		headerTitle.setForeground(new Color(255, 255, 255));
		headerTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(109, 40, 381, 210);
		getContentPane().add(scrollPane);

		inscripcionListModel = new DefaultListModel<>();
		inscripcionList = new JList<>(inscripcionListModel);
		inscripcionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(inscripcionList);

		JLabel listLabel = new JLabel("Mis inscripciones");
		listLabel.setHorizontalAlignment(SwingConstants.CENTER);
		listLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollPane.setColumnHeaderView(listLabel);

		botonDetalles = new JButton("Ver detalles");
		botonDetalles.setBounds(10, 46, 89, 25);
		getContentPane().add(botonDetalles);

		botonEliminar = new JButton("Eliminar");
		botonEliminar.setBounds(10, 82, 89, 25);
		getContentPane().add(botonEliminar);

		botonSalir = new JButton("Salir");
		botonSalir.setBounds(10, 225, 89, 25);
		getContentPane().add(botonSalir);

		setVisible(true);
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

	public JButton getBotonSalir() {
		return botonSalir;
	}

}
