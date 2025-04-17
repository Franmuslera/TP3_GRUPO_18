package Ejercicio1;

import java.util.Objects;

public class Persona implements Comparable <Persona> {

    private int dni;
    private String nombre;
    private String apellido;
    
 
    public Persona() {
        this.nombre = "sin nombre";
        this.apellido = "sin apellido";
        this.dni = 00;
    }
    
    public Persona(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }    
    
    
    
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return dni == other.dni;
	}

	@Override
	public int compareTo(Persona o) {
		// TODO Auto-generated method stub
		return this.apellido.compareToIgnoreCase(o.apellido);
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return nombre + " " + apellido + " - DNI: " + dni;
	}
	
	
}
