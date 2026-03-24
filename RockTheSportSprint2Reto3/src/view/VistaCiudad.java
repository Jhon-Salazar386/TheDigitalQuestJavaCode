package view;

import model.Ciudad;

import java.io.*;
import java.sql.*;

import util.EntradaDatos;
import util.GestionCiudades;

public class VistaCiudad {
    
    private GestionCiudades gc;
    
    public VistaCiudad(GestionCiudades gestionCiudades) {
    	this.gc = gestionCiudades;
    }
    
    public void menuCiudad() {
        
        int opcion;
        boolean exit = false;
        
        do {
            System.out.println("--- GESTION CIUDADES ---");
            System.out.println("1 - Insertar ciudad");
            System.out.println("2 - Mostrar ciudades");
            System.out.println("3 - Buscar ciudad por codigo");
            System.out.println("4 - Modificar ciudad");
            System.out.println("5 - Eliminar ciudad");
            System.out.println("6 - Contador de ciudades");
            System.out.println("0 - Salir");
            System.out.print("Elige una opción: ");
            
            opcion = EntradaDatos.leerEntero();
            
            switch(opcion){
                case 1:
                    insertarCiudad();
                    break;
                case 2:
                    mostrarCiudades();
                    break;
                case 3:
                    buscarCiudad();
                    break;
                case 4:
                    modificarCiudad();
                    break;
                case 5:
                    eliminarCiudad();
                    break;
                case 6:
                	contadorCiudades();
                	break;
                case 0:
                    exit = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
            
        } while(!exit);
    }

    public void insertarCiudad() {
        try {
            
            System.out.println("Ingresa un codigo identificador para esta ciudad");
            String codigo = EntradaDatos.leerTexto();
            System.out.println("Ingresa el codigo");
            String nombre = EntradaDatos.leerTexto();
            System.out.println("Ingresa ubicacion");
            String ubicacion = EntradaDatos.leerTexto();
            
            Ciudad c = new Ciudad(codigo, nombre, ubicacion);
            
            gc.agregarCiudad(c);
            
        } catch (SQLException e) {
            System.out.println("Error SQL al insertar la ciudad: " + e.getMessage());
        } catch (IOException ie) {
            System.out.println("Error: " + ie.getMessage());
        }
    }

    public void mostrarCiudades() {
        try {
            
            System.out.println(gc.mostrarCiudades());
            
        } catch (SQLException e) {
            System.out.println("Error SQL al mostrar las ciudades: " + e.getMessage());
        } catch (IOException ie) {
            System.out.println("Error: " + ie.getMessage());
        }
    }

    public void buscarCiudad() {
        try {
            
        	System.out.println("Ingresa el codigo de la ciudad que quieres buscar");
        	String codigo = EntradaDatos.leerTexto();
        	
        	System.out.println(gc.mostrarCiudadesPorCodigo(codigo));
            
        } catch (SQLException e) {
            System.out.println("Error SQL al buscar la ciudad: " + e.getMessage());
        } catch (IOException ie) {
            System.out.println("Error: " + ie.getMessage());
        }
    }

    public void modificarCiudad() {
        try {
            
            System.out.println("Ingresa el codigo de la ciudad");
            String codigo = EntradaDatos.leerTexto();
            System.out.println("Ingresa el nombre");
            String nombre = EntradaDatos.leerTexto();
            System.out.println("Ingresa la nueva ubicacion");
            String nuevaUbicacion = EntradaDatos.leerTexto();
            
            gc.actualizarCiudad(codigo, nombre, nuevaUbicacion);
            
            System.out.println("La ciudad se actualizo correctamente");
            
        } catch (SQLException e) {
            System.out.println("Error SQL al modificar la ciudad: " + e.getMessage());
        } catch (IOException ie) {
            System.out.println("Error: " + ie.getMessage());
        }
    }

    public void eliminarCiudad() {
        try {
            
            System.out.println("Ingresa el codigo de la ciudad a eliminar");
            String codigo = EntradaDatos.leerTexto();
            
            System.out.println("Ingresa el nombre de la ciudad");
            String nombre = EntradaDatos.leerTexto();
            
            if(gc.eliminarCiudad(codigo, nombre)) {
            	System.out.println("La ciudad " + nombre + " se elimino correctamente");
            } else {
            	System.out.println("Algo ha salido mal");
            }
            
        } catch (SQLException e) {
            System.out.println("Error SQL al eliminar la ciudad: " + e.getMessage());
        } catch (IOException ie) {
            System.out.println("Error: " + ie.getMessage());
        }
    }
    
    public void contadorCiudades() {
    	
    	try {
    		
    		System.out.println("Ciudades ingresadas en la base de datos: " + gc.contadorCiudades());
    		
        } catch (SQLException e) {
            System.out.println("Error SQL al consultar: " + e.getMessage());
        } catch (IOException ie) {
            System.out.println("Error: " + ie.getMessage());
        }
    	
    }
    
}