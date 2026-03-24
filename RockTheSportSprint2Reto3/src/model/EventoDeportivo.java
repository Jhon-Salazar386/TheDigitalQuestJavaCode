package model;

import java.util.Objects;

public class EventoDeportivo {
	
	private int id;
	private String tipoEvento;
	private String modalidad;
	private String descripcion;
	private int edadReq;
	private String requisitos;
	public static int contadorEventos;
	
	public EventoDeportivo() {
		
	}

	public EventoDeportivo(int id, String tipoEvento, String modalidad, String descripcion, int edadReq, String requisitos) {
		setId(id);
		setTipoEvento(tipoEvento);
		setModalidad(modalidad);
		setDescripcion(descripcion);
		setEdadReq(edadReq);
		setRequisitos(requisitos);
	}
		
	public EventoDeportivo(String tipoEvento, String modalidad, String descripcion, int edadReq, String requisitos) {
		setTipoEvento(tipoEvento);
		setModalidad(modalidad);
		setDescripcion(descripcion);
		setEdadReq(edadReq);
		setRequisitos(requisitos);
		contadorEventos++;
	}
	
	public String iniciarEvento() {
		return "El evento esta comenzando";
	}
	
	public void setId(int id) {
		
		if (id <= 0) {
			throw new IllegalArgumentException("El ID no puede ser cero o negativo");
		}
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setTipoEvento(String tipoEvento) {
		if (tipoEvento.isBlank()) {
			throw new IllegalArgumentException("El tipo de evento no puede ser vacio");
		}
		this.tipoEvento = tipoEvento;
	}
	
	public String getTipoEvento() {
		return tipoEvento;
	}
	
	public void setModalidad(String modalidad) {
		
		this.modalidad = modalidad;
	}
	
	public String getModalidad() {
		return modalidad;
	}
	
	public void setDescripcion(String descripcion) {
		if (descripcion.isBlank()) {
			throw new IllegalArgumentException("El campo de la descripción no puede estar vacio");
		}
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setRequisitos(String requisitos) {
		if (requisitos.isBlank()) {
			throw new IllegalArgumentException("El campo de los requisitos no puede estar vacio");
		}
		this.requisitos = requisitos;
	}
	
	public String getRequisitos() {
		return requisitos;
	}
	
	public void setEdadReq(int edadReq) {
		
		if(edadReq < 0) {
			throw new IllegalArgumentException("La edad requerida no puede ser negativa");
		}
	    
		this.edadReq = edadReq;
	}
	
	public int getEdadReq() {
		return edadReq;
	}
	
	
	
	/*
	 * @Override
	 */
	public String toString() {
	    return "\n ID: " + id +
	           "\n Tipo de evento: " + tipoEvento +
	           "\n Modalidad: " + modalidad +
	           "\n Descripción: " + descripcion +
	           "\n Requisitos: " + requisitos +
	           "\n Edad requerida: " + edadReq;
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

	    EventoDeportivo other = (EventoDeportivo) obj;
	    return Objects.equals(id, other.id)
	            && Objects.equals(tipoEvento, other.tipoEvento);
	}
	
	/**
	 * @override
	 */
	public int hashCode() {
		return Objects.hash(id, tipoEvento);
	}	
	
}
