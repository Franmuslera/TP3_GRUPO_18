package Ejercicio1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Archivo {
	
	private String ruta;
	
	public void lee_lineas() {
		FileReader entrada;
		try {
			entrada = new FileReader(ruta);
			BufferedReader miBuffer = new BufferedReader(entrada);
			
		   String linea = "";
			while (linea != null) {
				System.out.println(linea);
				linea = miBuffer.readLine();
			}
			miBuffer.close();
			entrada.close();

		} catch (IOException e) {
			System.out.println("No se encontro el archivo");
		}
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
	public Set<Persona> leePersonas() {
		Set<Persona> personas = new HashSet<>();

		try (BufferedReader miBuffer = new BufferedReader(new FileReader(ruta))) {
			String linea;

			while ((linea = miBuffer.readLine()) != null) {
				String[] datos = linea.split("-");

				if (datos.length == 3) {
					String nombre = datos[0].trim();
					String apellido = datos[1].trim();
					String dniStr = datos[2].trim();

					try {
						DniInvalido.verificarDniInvalido(dniStr); 
						int dni = Integer.parseInt(dniStr);
						Persona persona = new Persona(nombre, apellido, dni);
						personas.add(persona); 
					} catch (DniInvalido | NumberFormatException e) {
						System.out.println("DNI inválido en línea: " + linea + " -> " + e.getMessage());
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}

		return personas;
	}
	}
