package model;

import java.util.Objects;

public class Ciudad {
	private String codigo;
	private String nombre;
	private String ubicacion;
	public static int contadorCiudades;

	public Ciudad() {
		contadorCiudades++;
	}

	public Ciudad(String codigo, String nombre, String ubicacion) {
		setCodigo(codigo);
		setNombre(nombre);
		setUbicacion(ubicacion);
		contadorCiudades++;
	}

	public void setCodigo(String codigo) {

		if (codigo.isBlank()) {
			throw new IllegalArgumentException("El codigo de la ciudad no puede estar vacio");
		}

		if (codigo.length() > 10) {
			throw new IllegalArgumentException("El codigo no puede tener mas de 10 caracteres");
		}

		if (!codigo.matches("^[a-zA-Z0-9 ]+$")) {
			throw new IllegalArgumentException("El codigo de la ciudad no puede tener caracteres especiales");
		}

		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setNombre(String nombre) {

		if (nombre.isBlank()) {
			throw new IllegalArgumentException("El nombre no puede estar vacio");
		}

		if (nombre.length() > 50) {
			throw new IllegalArgumentException("El nombre debe tener un maximo de 50 caracteres");
		}

		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setUbicacion(String ubicacion) {

		if (ubicacion.isBlank()) {
			throw new IllegalArgumentException("Debes ingresar una ubicacion");
		}

		this.ubicacion = ubicacion;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	/**
	 * @Override
	 */
	public String toString() {
		return "Ciudad: " +
				"\n codigo=" + codigo +
				"\n nombre=" + nombre +
				"\n ubicacion=" + ubicacion + "\n";
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

		Ciudad other = (Ciudad) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(nombre, other.nombre);
	}

	/**
	 * @override
	 */
	public int hashCode() {
		return Objects.hash(codigo, nombre);
	}

}
