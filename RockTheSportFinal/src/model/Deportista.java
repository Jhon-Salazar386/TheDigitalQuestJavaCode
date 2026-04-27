package model;

import java.sql.Date;
import java.util.Objects;

/**
 * Clase que crea un objeto deportista de la web
 */
public class Deportista {
	private String dni;
	private String nombre;
	private String apellido;
	private String genero;
	private Date fechaNac;
	private String ciudadNac;
	private String email;
	private String telefono;
	public static int contadorDeportistas;

	public Deportista() {
		contadorDeportistas++;
	}

	public Deportista(String dni, String nombre, String apellido, String genero, Date fechaNac, String ciudadNac,
			String email, String telefono) {
		setDni(dni);
		setNombre(nombre);
		setApellido(apellido);
		setGenero(genero);
		setFechaNac(fechaNac);
		setCiudadNac(ciudadNac);
		setEmail(email);
		setTelefono(telefono);
		contadorDeportistas++;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {

		if (dni.isBlank()) {
			throw new IllegalArgumentException("El DNI no puede estar vacio");
		}

		if (dni.length() != 9) {
			throw new IllegalArgumentException("El DNI debe tener 9 caracteres");
		}

		if (dni == null || !dni.matches("^\\d{8}[A-Za-z]$")) {
		    throw new IllegalArgumentException("Formato de DNI inválido");
		}

		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {

		if (nombre.isBlank()) {
			throw new IllegalArgumentException("El nombre no puede estar vacio");
		}

		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {

		if (apellido.isBlank()) {
			throw new IllegalArgumentException("El apellido no puede estar vacio");
		}

		this.apellido = apellido;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {

		if (genero == null || genero.isBlank()) {
			throw new IllegalArgumentException("Debes ingresar un género");
		}

		this.genero = genero;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {

		if (fechaNac == null) {
			throw new IllegalArgumentException("Se debe de ingresar tu fecha de nacimiento");
		}

		this.fechaNac = fechaNac;
	}

	public String getCiudadNac() {
		return ciudadNac;
	}

	public void setCiudadNac(String ciudadNac) {

		if (!ciudadNac.matches("^[a-zA-Z0-9 ]+$")) {
			throw new IllegalArgumentException("El nombre de la ciudad no puede tener caracteres especiales");
		}

		this.ciudadNac = ciudadNac;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {

		if (email == null || email.isBlank()) {
			throw new IllegalArgumentException("El email no puede estar vacío");
		}

		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {

		if (telefono == null || telefono.isBlank()) {
			throw new IllegalArgumentException("El teléfono no puede estar vacío");
		}

		this.telefono = telefono;
	}

	public String toString() {
		return "\n Dni=" + dni +
				"\n Nombre=" + nombre +
				"\n Apellido=" + apellido +
				"\n Genero=" + genero +
				"\n FechaNac=" + fechaNac +
				"\n CiudadNac=" + ciudadNac +
				"\n Email=" + email +
				"\n Telefono=" + telefono;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
			
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
			
		Deportista other = (Deportista) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}
}