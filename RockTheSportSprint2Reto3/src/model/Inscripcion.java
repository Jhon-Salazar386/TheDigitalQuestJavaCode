package model;
import java.sql.Date;
import java.util.Objects;

/**
* Crea una nueva inscripcion que esta relacionada tanto con una edicion como con un deportista
*/
public class Inscripcion {
	
	private int idInscripcion;
	private Date fechaInsc;
	private String dniDeportista;
	private int idEdicion;
	public static int contadorInscripciones;
	
	public Inscripcion() {
	}

	public Inscripcion(int idInscripcion, Date fechaInsc, String dniDeportista, int idEdicion){
		setIdInscripcion(idInscripcion);
		setFechaInsc(fechaInsc);
		setDniDeportista(dniDeportista);
		setIdEdicion(idEdicion);
	}
		
	public Inscripcion(Date fechaInsc, String dniDeportista, int idEdicion){
		setFechaInsc(fechaInsc);
		setDniDeportista(dniDeportista);
		setIdEdicion(idEdicion);
		contadorInscripciones++;
	}
	
	public int getIdInscripcion() {
		return idInscripcion;
	}
	public void setIdInscripcion(int idInscripcion) {
		if (idInscripcion <= 0) {
			throw new IllegalArgumentException("El ID de la inscripcion no puede ser cero o negativo");
		}
		this.idInscripcion = idInscripcion;
	}
	public Date getFechaInsc() {
		return fechaInsc;
	}
	public void setFechaInsc(Date fechaInsc) {
		if (fechaInsc == null) {
			throw new IllegalArgumentException("El campo de la fecha de inscripción no puede estar vacio");
		}
		this.fechaInsc = fechaInsc;
	}
	public String getDniDeportista() {
		return dniDeportista;
	}
	public void setDniDeportista(String dniDeportista) {
		
		
		if(dniDeportista.trim().isEmpty()) {
			throw new IllegalArgumentException("El DNI no puede estar vacio");
		}
		
		if(dniDeportista.length() > 9) {
			throw new IllegalArgumentException("El DNI no puede superar los 9 caracteres");
		}
		this.dniDeportista = dniDeportista;
	}
	public int getIdEdicion() {
		return idEdicion;
	}
	public void setIdEdicion(int edicion) {
		if (edicion <= 0) {
			throw new IllegalArgumentException("El ID de la edicion no puede ser cero o negativo");
		}
		this.idEdicion = edicion;
	}
	/*
	 * @override
	 */
	public String toString() {
		return "\nID de inscripcion: " + idInscripcion +
				"\nFecha de inscripcion: " + fechaInsc +
				"\nDNI del deportista: " + dniDeportista +
				"\nID de edicion: " + idEdicion;
	}
	
	/**
	 * @Override
	 */
	public boolean equals(Object obj) {
	    if (this == obj) {
	    	return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	    	return false;
	    }

	    Inscripcion other = (Inscripcion) obj;
	    return Objects.equals(idInscripcion, other.idInscripcion)
	            && Objects.equals(dniDeportista, other.dniDeportista);
	}
	
	/**
	 * @override
	 */
	public int hashCode() {
		return Objects.hash(idInscripcion, dniDeportista);
	}
	
}
