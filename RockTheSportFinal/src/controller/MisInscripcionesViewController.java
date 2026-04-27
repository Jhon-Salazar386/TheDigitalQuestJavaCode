package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.GestionInscripcion;
import model.Inscripcion;
import view.MisInscripcionesView;

public class MisInscripcionesViewController {
	
	private MisInscripcionesView misInscripcionesView;
	private GestionInscripcion gestorInscripciones;
	
	public MisInscripcionesViewController(MisInscripcionesView misInscripcionesView, GestionInscripcion gestorInscripcion) throws SQLException, IOException {
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
		
		misInscripcionesView.getBotonSalir().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				misInscripcionesView.dispose();
			}
		});
		
		obtenerInscripciones();
		
	}
	
	public void obtenerInscripciones() throws SQLException, IOException {
		
		ArrayList<Inscripcion> inscripciones = gestorInscripciones.mostrarInscripcionesPorDni("40000003C");
		
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

}
