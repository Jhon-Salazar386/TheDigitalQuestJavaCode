package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.DeportistaDao;
import dao.EdicionDao;
import dao.InscripcionDao;
import model.Edicion;
import model.Inscripcion;
import view.MisInscripcionesView;
import view.UserRegistrationView;
import view.UserLoginView;
import view.UserView;

public class UserViewController {

	private UserView userView;
	private EdicionDao gestorEdiciones;
	private InscripcionDao gestorInscripcion;

	public UserViewController(UserView userView, EdicionDao gestorEdiciones, InscripcionDao gestorInscripcion) throws SQLException, IOException {
		this.userView = userView;
		this.gestorEdiciones = gestorEdiciones;
		this.gestorInscripcion = gestorInscripcion;

		userView.getListaEdiciones().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					Edicion edicion = userView.getListaEdiciones().getSelectedValue();

					String[] opciones = {"Inscribirse", "Cerrar"};

					int opcion = JOptionPane.showOptionDialog(null, edicion, "Detalle de la edición",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

					if (opcion == 0) {
						try {
							crearInscripcion(edicion);
						} catch (SQLException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});

		userView.getBotonBuscar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String nombre = JOptionPane.showInputDialog("Ingresa el nombre del evento");

				if (nombre != null && !nombre.isBlank()) {
					try {
						filtrarDatos(nombre);
					} catch (SQLException | IOException e1) {
						e1.printStackTrace();
					}
				} else {
					try {
						datosEdiciones();
					} catch (SQLException | IOException e1) {
						e1.printStackTrace();
					}
				}

			}
		});

		userView.getBotonRegistrarse().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				
				UserRegistrationView userRegistrationView = new UserRegistrationView();
				UserRegistrationController registerFormViewController = new UserRegistrationController(userRegistrationView, new DeportistaDao());
				registerFormViewController.iniciar();
				
				userView.dispose();

			}
		});

		userView.getBotonMisInscripciones().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				UserLoginViewController loginViewController = new UserLoginViewController(new UserLoginView(), new DeportistaDao());
				loginViewController.iniciar();
				
				userView.dispose();
			}
		});

		userView.getBotonSalir().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userView.dispose();
			}
		});

		SwingUtilities.invokeLater(() -> {
			try {
				datosEdiciones();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
	}

	public ArrayList<Edicion> datosEdiciones() throws SQLException, IOException {

		ArrayList<Edicion> ediciones = gestorEdiciones.mostrarEdiciones();

		cargarEdiciones(ediciones);

		return ediciones;

	}

	/*
	 * public ArrayList<Edicion> datosDePrueba() {
	 * 
	 * ArrayList<Edicion> ediciones = new ArrayList<>();
	 * 
	 * ediciones.add(new Edicion(1, "Boxeo", Date.valueOf("2024-03-10"),
	 * Date.valueOf("2024-03-13"), 11, "MXC")); ediciones.add(new Edicion(2,
	 * "Futbol", Date.valueOf("2024-04-01"), Date.valueOf("2024-04-10"), 16,
	 * "ESP")); ediciones.add(new Edicion(3, "Tenis", Date.valueOf("2024-05-05"),
	 * Date.valueOf("2024-05-15"), 8, "USA")); ediciones.add(new Edicion(4,
	 * "Natacion", Date.valueOf("2024-06-01"), Date.valueOf("2024-06-07"), 12,
	 * "ARG"));
	 * 
	 * cargarEdiciones(ediciones);
	 * 
	 * return ediciones;
	 * 
	 * }
	 */

	public void filtrarDatos(String nombre) throws SQLException, IOException {

		ArrayList<Edicion> edicionesFiltradas = gestorEdiciones.mostrarEdicionesPorNombre(nombre);

		if (edicionesFiltradas.size() < 1) {
			JOptionPane.showMessageDialog(userView, "No hay ninguna edicion con ese id");
			return;
		}

		cargarEdiciones(edicionesFiltradas);
	}

	public void cargarEdiciones(ArrayList<Edicion> ediciones) {

		userView.getModeloEdicion().removeAllElements();;

		for (Edicion e : ediciones) {
			userView.getModeloEdicion().addElement(e);
		}

	}

	public void crearInscripcion(Edicion edicion) throws SQLException, IOException {
		
		String dni = JOptionPane.showInputDialog("Ingrese su dni");
		
		if(dni == null || dni.isBlank()) {
			JOptionPane.showMessageDialog(userView, "Se ha cancelado");
			return;
		}
		
		Inscripcion inscripcion = new Inscripcion(dni, edicion.getId());
		
		gestorInscripcion.insertar(inscripcion);
		
	}
	
	public void iniciar() {
		userView.setVisible(true);
	}

}
