package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import dao.EdicionDao;
import dao.InscripcionDao;
import model.Inscripcion;
import model.UserSession;
import view.MisInscripcionesView;
import view.UserView;

public class MisInscripcionesViewController {
	
	private MisInscripcionesView misInscripcionesView;
	private InscripcionDao gestorInscripciones;
	
	public MisInscripcionesViewController(MisInscripcionesView misInscripcionesView, InscripcionDao gestorInscripcion) throws SQLException, IOException {
		this.misInscripcionesView = misInscripcionesView;
		this.gestorInscripciones = gestorInscripcion;
		
		misInscripcionesView.getBotonDetalles().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarDetalles();
			}
		});
		
		misInscripcionesView.getBotonEliminar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					eliminarInscripcion();
				} catch (SQLException | IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		misInscripcionesView.getBotonVolver().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					UserViewController userViewContoller = new UserViewController(new UserView(), new EdicionDao(), new InscripcionDao());
					userViewContoller.iniciar();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				misInscripcionesView.dispose();
			}
		});
		
		SwingUtilities.invokeLater(() -> {
			try {
				obtenerInscripciones();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
		
		
	}
	
	public void obtenerInscripciones() throws SQLException, IOException {
		
		ArrayList<Inscripcion> inscripciones = gestorInscripciones.mostrarInscripcionesPorDni(UserSession.getDni());
		
		cargarInscripciones(inscripciones);
		
	}
	
	public void cargarInscripciones(ArrayList<Inscripcion> inscripciones) {
		
		for(Inscripcion insc : inscripciones) {
			misInscripcionesView.getInscripcionListModel().addElement(insc);
		}
	}
	
	public void mostrarDetalles() {
		
		int index = misInscripcionesView.getInscripcionList().getSelectedIndex();
		
		if(index != -1) {
			Inscripcion inscripcion = misInscripcionesView.getInscripcionList().getSelectedValue();
			JOptionPane.showMessageDialog(misInscripcionesView, inscripcion);
		} else {
			JOptionPane.showMessageDialog(misInscripcionesView, "Debes seleccionar alguna de las opciones");
		}
		
	}
	
	public void eliminarInscripcion() throws SQLException, IOException {
		
		int index = misInscripcionesView.getInscripcionList().getSelectedIndex();
		Inscripcion inscripcion = misInscripcionesView.getInscripcionList().getSelectedValue();
		
		if(index != -1) {
			misInscripcionesView.getInscripcionListModel().remove(index);
			gestorInscripciones.eliminar(inscripcion.getIdInscripcion());
			JOptionPane.showMessageDialog(misInscripcionesView, "Se ha eliminado correctamente");
		} else {
			JOptionPane.showMessageDialog(misInscripcionesView, "Debes seleccionar una inscripcion");
		}
		
	}
	
	public void iniciar() {
		misInscripcionesView.setVisible(true);
	}

}
