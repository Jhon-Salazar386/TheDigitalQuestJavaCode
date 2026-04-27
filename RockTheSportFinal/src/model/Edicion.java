package model;

import java.sql.Date;
import java.util.Objects;

public class Edicion {

	private int id;
	private String nombreEdicion;
	private Date fechaInicio;
	private Date fechaFin;
	private int idEvento;
	private String idCiudad;
	public static int contadorEdiciones;

	// Contructor para metodos de select
	public Edicion(int id, String nombreEdicion, Date fechaInicio, Date fechaFin, int idEvento, String idCiudad) {
		setId(idEvento);
		setNombreEdicion(nombreEdicion);
		setFechaInicio(fechaInicio);
		setFechaFin(fechaFin);
		setIdEvento(idEvento);
		setIdCiudad(idCiudad);
	}

	// Constructor que se usara para los metodos de insert
	public Edicion(String nombreEdicion, Date fechaInicio, Date fechaFin, int idEvento, String idCiudad) {
		setNombreEdicion(nombreEdicion);
		setFechaInicio(fechaInicio);
		setFechaFin(fechaFin);
		setIdEvento(idEvento);
		setIdCiudad(idCiudad);
		contadorEdiciones++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreEdicion() {
		return nombreEdicion;
	}

	public void setNombreEdicion(String nombreEdicion) {
		this.nombreEdicion = nombreEdicion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(String idCiudad) {
		this.idCiudad = idCiudad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(idEvento), nombreEdicion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		Edicion other = (Edicion) obj;
		return idEvento == other.idEvento && Objects.equals(nombreEdicion, other.nombreEdicion);
	}

	@Override
	public String toString() {
		return "Edicion" + "\n id: " + id + "\n nombreEdicion: " + nombreEdicion + "\n fechaInicio: " + fechaInicio
				+ "\n fechaFin: " + fechaFin + "\n idEvento: " + idEvento + "\n idCiudad: " + idCiudad;
	}

}
